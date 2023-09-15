package org.example.tasks


import org.jsoup.nodes.Document

import static groovyx.net.http.HttpBuilder.configure

class CrawlerOlx {
    private static final BASE_URL = 'https://www.olx.com.br'
    private static final ESTADO = 'estado-go'
    private static final REGIAO = 'grande-goiania-e-anapolis'
    private static final PRODUTO = '?q=Iphone+11'
    private static final ORDENAR_POR_MENOR_PRECO = '&sp=2'
    private static final PAGINA = '&o='

    private Integer pageCount = 3
    private List<Produto> results = []

    private Document buscarDocumento(String url) {
        return configure {
            request.uri = url
        }.get() as Document
    }

    void crawl() {
        for (int page = 1; page <= pageCount; page++) {
            String url = "$BASE_URL/$ESTADO/$REGIAO$PRODUTO$ORDENAR_POR_MENOR_PRECO$PAGINA$page"
            Document html = buscarDocumento(url)

            html.select('div.sc-bb3a36b6-0.bPPSiI.renderIfVisible').forEach { div ->
                div.select('section[data-ds-component="DS-AdCard"]').forEach { ad ->
                    String title = ad.select('h2[data-ds-component="DS-Text"]').text()
                    String price = ad.select('h3[data-ds-component="DS-Text"].price').first().text()
                    String location = ad.select('div.sc-bBHxTw.bcqhPD p[data-ds-component="DS-Text"].sc-bqiRlB.iLmKRW').first().text()
                    String offerUrl = ad.select('a[data-ds-component="DS-NewAdCard-Link"]').attr('href')

                    Produto produto = new Produto(title, price, location, offerUrl)
                    results << produto
                }
            }
        }
    }


    double calcularValorMedio() {
        double somaDosValores = 0.0
        int count = 0

        for (Produto produto : results) {
            double valor = extrairValorNumerico(produto.getValor())
            somaDosValores += valor
            count++
        }

        if (count > 0) {
            double valorMedio = somaDosValores / count

            return valorMedio
        } else {
            return 0.0
        }
    }

    void removerProdutosAcimaDaMedia() {
        double valorMedio = calcularValorMedio()

        results.removeIf { produto ->
            double valor = extrairValorNumerico(produto.getValor())
            valor > valorMedio
        }
    }

    void salvarListaDeProdutosEmCSV(String caminhoArquivo) {
        File arquivo = new File(caminhoArquivo)
        PrintWriter writer = new PrintWriter(arquivo)

        try {

            writer.println("Título do Anúncio,Valor,Endereço,Complemento,URL do Anúncio")

            results.each { produto ->
                String linha = "${produto.getTitulo()},${produto.getValor()},${produto.getEndereco()},${produto.getUrl()}"
                writer.println(linha)
            }

            println("Produtos exportados para $caminhoArquivo")
        } finally {
            writer.close()
        }
    }

    Produto encontrarProdutoDeMenorValor() {
        crawl()
        removerProdutosAcimaDaMedia()
        if (results.isEmpty()) {
            return null
        }

        Produto produtoDeMenorValor = results[0]
        double menorValor = extrairValorNumerico(produtoDeMenorValor.valor)

        for (Produto produto : results) {
            double valor = extrairValorNumerico(produto.valor)
            if (valor < menorValor) {
                menorValor = valor
                produtoDeMenorValor = produto
            }
        }

        return produtoDeMenorValor
    }

    Produto encontrarProdutoDeMaiorValor() {
        crawl()
        removerProdutosAcimaDaMedia()
        if (results.isEmpty()) {
            return null
        }

        Produto produtoDeMaiorValor = results[0]
        double maiorValor = extrairValorNumerico(produtoDeMaiorValor.getValor())

        for (Produto produto : results) {
            double valor = extrairValorNumerico(produto.getValor())
            if (valor > maiorValor) {
                maiorValor = valor
                produtoDeMaiorValor = produto
            }
        }

        return produtoDeMaiorValor
    }

    private double extrairValorNumerico(String valor) {
        return Double.parseDouble(valor.replaceAll("[^0-9]", "").trim())
    }

    void executarProcessoCompleto() {
        crawl()
        println("Fazendo requisição....")
        removerProdutosAcimaDaMedia()
        println("Calculando o valor média dos produtos")
        String caminhoArquivoCSV = "produtos/produtos.csv"
        salvarListaDeProdutosEmCSV(caminhoArquivoCSV)
        encontrarProdutoDeMenorValor()
        encontrarProdutoDeMaiorValor()

    }

}
