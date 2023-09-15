package org.example.menu.emailMenu

import org.example.email.EnviarEmail

class MenuEnviaEmail {
    EnviarEmail enviarEmail

    MenuEnviaEmail() {
        enviarEmail = new EnviarEmail()
    }

    void exibir() {
        Scanner scanner = new Scanner(System.in)
        boolean sair = false

        while (!sair) {
            println("Menu:")
            println("1 - Enviar e-mail")
            println("2 - Sair")
            print("Escolha uma opção: ")

            int opcao = scanner.nextInt()

            switch (opcao) {
                case 1:
                    enviarEmail()
                    break
                case 2:
                    sair = true
                    break
                    println("Saindo...")
                    break
                default:
                    println("Opção inválida. Tente novamente.")
                    break
            }
        }
    }

    void enviarEmail() {
        println("Enviando email......")
        List<String> listaDeEmails = new File
                ("emails/emails_interessados.txt").readLines()

        listaDeEmails.each { email ->
            enviarEmail.enviarEmail(email)
        }
    }
}
