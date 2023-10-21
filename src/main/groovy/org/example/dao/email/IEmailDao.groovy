package org.example.dao.email

import org.example.model.Email

interface IEmailDao {
    List<Email> listarEmails()
    Email pegarEmailPorId(Integer id)
    void adicionarEmail(Email email)
    void atualizarEmail(Email email)
    void excluirEmail(Integer id)

}