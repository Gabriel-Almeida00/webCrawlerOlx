package org.example.menu.emailMenu

import org.example.email.EmailService

class MenuEmail {
    private EmailService emailService
    private String caminhoArquivo

    MenuEmail() {
        this.emailService = new EmailService()
        this.caminhoArquivo = "emails/emails_interessados.txt"
    }

    void exibir() {
        Scanner scanner = new Scanner(System.in)
        boolean sair = false

        while (!sair) {
            println("Escolha uma opção:")
            println("1 - Listar e-mails")
            println("2 - Adicionar e-mails")
            println("3 - Editar e-mail")
            println("4 - Remover e-mails")
            println("5 - Sair")

            int opcao = scanner.nextInt()

            switch (opcao) {
                case 1:
                   listarEmails()
                    break
                case 2:
                   adicionarEmails()
                    break
                case 3:
                  editarEmail()
                    break
                case 4:
                    removerEmails()
                    break
                case 5:
                    sair = true
                    break
                default:
                    println("Opção inválida. Tente novamente.")
            }
        }
    }

    private void listarEmails() {
        List<String> emails = emailService.lerEmails(caminhoArquivo)
        println("==========")
        println("Lista de e-mails:")
        emails.each {
            println(it)
        }
    }

    void adicionarEmails() {
        print("Digite os e-mails a serem adicionados (separados por vírgula): ")
        String entrada = System.in.newReader().readLine()
        List<String> novosEmails = entrada.split(',').collect { it.trim() }
        emailService.adicionarEmails(caminhoArquivo, novosEmails)
    }

    void editarEmail() {
        print("Digite o e-mail antigo: ")
        String emailAntigo = System.in.newReader().readLine()

        print("Digite o novo e-mail: ")
        String emailNovo = System.in.newReader().readLine()

        emailService.editarEmail(caminhoArquivo, emailAntigo, emailNovo)
    }
    void removerEmails() {
        print("Digite o e-mail a ser removido: ")
        String emailParaRemover = System.in.newReader().readLine()
        emailService.removerEmails(caminhoArquivo, emailParaRemover)
    }
}
