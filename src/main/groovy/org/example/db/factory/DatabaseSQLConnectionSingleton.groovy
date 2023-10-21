package org.example.db.factory

import org.example.db.ConfigDatabase
import org.example.exception.DataBaseException

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class DatabaseSQLConnectionSingleton implements IDatabaseConnection{
    private final ConfigDatabase config
    private static DatabaseSQLConnectionSingleton instance
    private Connection connection

    private DatabaseSQLConnectionSingleton(ConfigDatabase config) {
        this.config = config
    }

    static synchronized DatabaseSQLConnectionSingleton getInstance(ConfigDatabase config) {
        if (instance == null) {
            instance = new DatabaseSQLConnectionSingleton(config)
        }
        return instance
    }

    @Override
    Connection getConnection() {
        if (connection == null) {
            try {
                String dbUrl = config.getUrlDB()
                String dbUser = config.getUserDB()
                String dbPassword = config.getSenhaDB()
                connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)
            } catch (SQLException e) {
                throw new DataBaseException("Erro ao obter a conexão com o banco de dados." + e)
            }
        }
        return connection
    }

    @Override
    PreparedStatement prepareStatement(String sql) throws SQLException {
        if (connection == null) {
            throw new DataBaseException("Conexão com o banco de dados não inicializada.")
        }
        return connection.prepareStatement(sql)
    }

    @Override
    ResultSet executeQuery(PreparedStatement statement) throws SQLException {
        if (connection == null) {
            throw new DataBaseException("Conexão com o banco de dados não inicializada.")
        }
        return statement.executeQuery()
    }
}
