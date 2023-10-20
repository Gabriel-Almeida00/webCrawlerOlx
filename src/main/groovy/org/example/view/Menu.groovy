package org.example.view

import org.example.view.crawlerMenu.MenuCrawler
import org.example.view.emailMenu.MenuEmail
import org.example.view.emailMenu.MenuEnviaEmail

class Menu {
    MenuCrawler menuCrawler
    MenuEmail menuEmail
    MenuEnviaEmail menuEnviaEmail

    Menu() {
        menuCrawler = new MenuCrawler()
        menuEmail = new MenuEmail()
        menuEnviaEmail = new MenuEnviaEmail()
    }

    void exibir() {
        Scanner scanner = new Scanner(System.in)
        boolean sair = false

        while (!sair) {
            println("Escolha uma opção:")
            println("1. Gerenciar Web Crawler")
            println("2. Gerenciar Envio de Email")
            println("3. Gerenciar Emails")
            println("4. Sair")

            int opcao = scanner.nextInt()

            switch (opcao) {
                case 1:
                    menuCrawler.exibir()
                    break
                case 2:
                    menuEnviaEmail.exibir()
                    break
                case 3:
                    menuEmail.exibir()
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
