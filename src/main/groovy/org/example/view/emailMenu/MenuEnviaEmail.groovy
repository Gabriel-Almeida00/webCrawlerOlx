package org.example.view.emailMenu

import org.example.service.email.ConfigEmail
import org.example.service.email.EnviarEmailService

class MenuEnviaEmail {
    EnviarEmailService enviarEmail

    MenuEnviaEmail() {
        ConfigEmail configEmail = new ConfigEmail()
        enviarEmail = new EnviarEmailService(configEmail)
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
