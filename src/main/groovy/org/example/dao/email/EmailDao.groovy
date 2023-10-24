package org.example.dao.email

import org.example.db.factory.IDatabaseConnection
import org.example.exception.DataBaseException
import org.example.exception.EmailNotFoundException
import org.example.model.Email

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class EmailDao implements IEmailDao {
    private IDatabaseConnection databaseConnection

    EmailDao(IDatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection
    }

    @Override
    List<Email> listarEmails() {
        String sql = "SELECT * FROM Emails"
        try {
            Connection connection = this.databaseConnection.getConnection()
            PreparedStatement statement = connection.prepareStatement(sql)
            ResultSet resultSet = statement.executeQuery()
            return this.retornarListEmailsResulSet(resultSet)

        } catch (SQLException e) {
            throw new DataBaseException("Erro ao acessar o banco de dados: " + e.getMessage())
        }
    }

    List<Email> retornarListEmailsResulSet(ResultSet resultSet) {
        List<Email> emails = new ArrayList<>()

        while (resultSet.next()) {
            Integer id = resultSet.getInt("ID")
            String endereco = resultSet.getString("Endereco")

            Email email = new Email(id, endereco)
            emails.add(email)
        }
        return emails
    }

    @Override
    Email pegarEmailPorId(Integer id) {
        String sql = "SELECT * FROM Emails WHERE ID =?"
        try {
            Connection connection = this.databaseConnection.getConnection()
            PreparedStatement statement = connection.prepareStatement(sql)
            statement.setInt(1, id)

            ResultSet resultSet = statement.executeQuery()
            return this.retornarEmailResulSet(resultSet)

        } catch (SQLException e) {
            throw new DataBaseException("Erro ao acessar o banco de dados: " + e.getMessage())
        }
    }

    Email retornarEmailResulSet(ResultSet resultSet) {
        if (resultSet.next()) {
            Email email = new Email(
                resultSet.getInt("ID"),
                resultSet.getString("Endereco")
            )
            return email

        } else {
            throw new EmailNotFoundException("Email não encontrado")
        }
    }

    @Override
    void adicionarEmail(Email email) {
        String sql = "INSERT INTO Emails (Endereco) VALUES(?)"

        try {
            PreparedStatement preparedStatement = this.databaseConnection.prepareStatement(sql)
            preparedStatement.setString(1, email.getEndereco())

        } catch (SQLException e) {
            throw new DataBaseException("Erro ao acessar o banco de dados: " + e.getMessage())
        }
    }

    @Override
    void atualizarEmail(Email email) {
        String sql = "UPDATE Emails SET Endereco=? WHERE ID=?"

        try {
            Connection connection = this.databaseConnection.getConnection()
            PreparedStatement preparedStatement = connection.prepareStatement(sql)
            preparedStatement.setString(1, email.getEndereco())
            preparedStatement.setInt(2, email.getId())
            preparedStatement.executeUpdate()

        } catch (SQLException e) {
            throw new DataBaseException("Erro ao acessar o banco de dados: " + e.getMessage())
        }
    }

    @Override
    void excluirEmail(Integer id) {
        String sql = "DELETE FROM Emails WHERE ID=?"

        try {
            PreparedStatement preparedStatement = this.databaseConnection.prepareStatement(sql)
            preparedStatement.setInt(1, id)
            preparedStatement.executeUpdate()

        } catch (SQLException e) {
            throw new DataBaseException("Erro ao acessar o banco de dados: " + e.getMessage())
        }
    }
}
