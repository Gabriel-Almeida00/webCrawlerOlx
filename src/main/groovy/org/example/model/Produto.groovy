package org.example.model

class Produto {
    Integer id
    String titulo
    BigDecimal preco
    String url
    Date dataAnuncio
    String descricaoVendedor
    Integer parcelasPossiveis
    BigDecimal valorEntrega
    Integer diasUteisEntrega
    Localizacao localizacao
    ProdutoDetalhes detalhes

    Produto(
            Integer id,
            String titulo,
            BigDecimal preco,
            String url,
            Date dataAnuncio,
            String descricaoVendedor,
            Integer parcelasPossiveis,
            BigDecimal valorEntrega,
            Integer diasUteisEntrega,
            Localizacao localizacao,
            ProdutoDetalhes detalhes
    ) {
        this.id = id
        this.titulo = titulo
        this.preco = preco
        this.url = url
        this.dataAnuncio = dataAnuncio
        this.descricaoVendedor = descricaoVendedor
        this.parcelasPossiveis = parcelasPossiveis
        this.valorEntrega = valorEntrega
        this.diasUteisEntrega = diasUteisEntrega
        this.localizacao = localizacao
        this.detalhes = detalhes
    }
}
