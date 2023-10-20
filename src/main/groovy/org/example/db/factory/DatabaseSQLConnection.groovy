package org.example.db.factory

import org.example.db.ConfigDatabaseSingleton
import org.example.db.IDatabaseConnection
import org.example.exception.DataBaseException

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class DatabaseSQLConnection implements IDatabaseConnection{
    private final ConfigDatabaseSingleton config

    DatabaseSQLConnection(ConfigDatabaseSingleton config) {
        this.config = config
    }

    @Override
    Connection getConnection() {
        try {
            String dbUrl = config.getUrlDB()
            String dbUser = config.getUserDB()
            String dbPassword = config.getSenhaDB()

            return DriverManager.getConnection(dbUrl, dbUser, dbPassword)
        } catch (SQLException e) {
            throw new DataBaseException("Erro ao obter a conexão com o banco de dados." + e)
        }
    }

    @Override
    PreparedStatement prepareStatement(String sql) throws SQLException {
        return getConnection().prepareStatement(sql)
    }

    @Override
    ResultSet executeQuery(PreparedStatement statement) throws SQLException {
        return statement.executeQuery()
    }
}
