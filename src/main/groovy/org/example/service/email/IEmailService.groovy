package org.example.service.email

import org.example.model.Email

interface IEmailService {
    List<Email> listarEmails()
    Email pegarEmailPorId(Integer id)
    void adicionarEmail(Email email)
    void atualizarEmail(Email email)
    void excluirEmail(Integer id)
}