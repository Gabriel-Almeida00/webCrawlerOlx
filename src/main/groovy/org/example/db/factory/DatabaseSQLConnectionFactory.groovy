package org.example.db.factory

import org.example.db.ConfigDatabase
import org.example.db.IDatabaseConnection

class DatabaseSQLConnectionFactory implements IDatabaseConncetionFactory{
    private final ConfigDatabase config

    DatabaseSQLConnectionFactory(ConfigDatabase config) {
        this.config = config
    }

    @Override
    IDatabaseConnection createConnection() {
        return new DatabaseSQLConnectionSingleton(config)
    }
}
