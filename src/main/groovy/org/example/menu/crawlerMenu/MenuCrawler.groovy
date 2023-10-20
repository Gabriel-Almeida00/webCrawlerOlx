package org.example.menu.crawlerMenu

import org.example.service.tasks.CrawlerOlx
import org.example.service.tasks.Produto

class MenuCrawler {
    CrawlerOlx crawlerOlx

    MenuCrawler() {
        crawlerOlx = new CrawlerOlx()
    }

    void exibir() {
        Scanner scanner = new Scanner(System.in)
        boolean sair = false

        while (!sair) {
            println("Escolha uma opção:")
            println("1. Executar processo completo")
            println("2. Encontrar produto de menor valor")
            println("3. Encontrar produto de maior valor")
            println("4. Sair")

            int opcao = scanner.nextInt()

            switch (opcao) {
                case 1:
                    crawlerOlx.executarProcessoCompleto()
                    break
                case 2:
                    Produto menorValor = crawlerOlx.encontrarProdutoDeMenorValor()
                    println("Produto de Menor Valor:")
                    println(menorValor)
                    break
                case 3:
                    Produto maiorValor = crawlerOlx.encontrarProdutoDeMaiorValor()
                    println("Produto de Maior Valor:")
                    println(maiorValor)
                    break
                case 4:
                    sair = true
                    break
                default:
                    println("Opção inválida. Tente novamente.")
            }
        }

        scanner.close()
    }
}

