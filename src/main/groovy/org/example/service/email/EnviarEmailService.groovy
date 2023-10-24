package org.example.service.email

import org.example.config.ConfigEmail
import org.example.service.tasks.CrawlerOlx

import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeBodyPart
import javax.mail.internet.MimeMessage
import javax.mail.internet.MimeMultipart

class EnviarEmailService implements IEnviarEmailService {
    ConfigEmail configEmail
    CrawlerOlx crawlerOlx

    void enviarEmail(String destinatario) {
        String remetente = configEmail.getEmail()
        String senha = configEmail.getSenha()

        Session session = configurarSessao(remetente, senha)

        try {
            MimeMessage message = new MimeMessage(session)
            message.setFrom(new InternetAddress(remetente))
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(destinatario))
            message.setSubject("Relatório de Arquivos Baixados")

            MimeBodyPart messageBodyPart = criarMensagemCorpo()

            Multipart multipart = new MimeMultipart()
            multipart.addBodyPart(messageBodyPart)

            adicionarAnexos(multipart)

            message.setContent(multipart)

            Transport.send(message)
            println("E-mail enviado para ${destinatario}")
        } catch (MessagingException e) {
            println("Erro ao enviar e-mail: ${e.message} ${e.printStackTrace()}")
        }
    }

    private Session configurarSessao(String remetente, String senha) {
        Properties props = new Properties()
        props.setProperty("mail.smtp.host", "smtp.gmail.com")
        props.setProperty("mail.smtp.port", "587")
        props.setProperty("mail.smtp.auth", "true")
        props.setProperty("mail.smtp.starttls.enable", "true")

        return Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remetente, senha)
            }
        })
    }

    private MimeBodyPart criarMensagemCorpo() {
        MimeBodyPart messageBodyPart = new MimeBodyPart()
        messageBodyPart.setText("Olá,\n\nSegue o relatório com os melhores Preços do IPhone 11:  " +
                "\n\nProduto com maior Preço: " + crawlerOlx.encontrarProdutoDeMaiorValor() +
                "\n\nProduto com menor Preço: " + crawlerOlx.encontrarProdutoDeMenorValor())
        return messageBodyPart
    }

    private void adicionarAnexos(Multipart multipart) {
        ArrayList<String> caminhosDosArquivos = [
                'produtos/produtos.csv'
        ]

        caminhosDosArquivos.each { caminho ->
            MimeBodyPart attachmentPart = new MimeBodyPart()
            attachmentPart.attachFile(new File(caminho))
            multipart.addBodyPart(attachmentPart)
        }
    }
}
