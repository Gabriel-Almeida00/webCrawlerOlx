package org.example.db.factory

import org.example.db.ConfigDatabaseSingleton
import org.example.db.IDatabaseConnection

class DatabaseSQLConnectionFactory implements IDatabaseConncetionFactory{
    private final ConfigDatabaseSingleton config

    DatabaseSQLConnectionFactory(ConfigDatabaseSingleton config) {
        this.config = config
    }

    @Override
    IDatabaseConnection createConnection() {
        return new DatabaseSQLConnection(config)
    }
}
