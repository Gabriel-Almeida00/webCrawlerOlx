package org.example.service.email

import org.example.dao.email.IEmailDao
import org.example.model.Email

class EmailService implements IEmailService {
    private IEmailDao emailDao

    EmailService(IEmailDao emailDao) {
        this.emailDao = emailDao
    }

    @Override
    List<Email> listarEmails() {
        return this.emailDao.listarEmails()
    }

    @Override
    Email pegarEmailPorId(Integer id) {
        return this.emailDao.pegarEmailPorId(id)
    }

    @Override
    void adicionarEmail(Email email) {
        this.emailDao.adicionarEmail(email)
    }

    @Override
    void atualizarEmail(Email email) {
        this.atualizarEmail(email)
    }

    @Override
    void excluirEmail(Integer id) {
        this.emailDao.excluirEmail(id)
    }
}
