package org.example.db.factory

import org.example.config.ConfigDatabase

class DatabaseSQLConnectionFactory implements IDatabaseConnectionFactory{
    private final ConfigDatabase config

     DatabaseSQLConnectionFactory(ConfigDatabase config) {
        this.config = config
    }

    @Override
    IDatabaseConnection createConnection() {
        return  DatabaseSQLConnectionSingleton.getInstance(config)
    }
}
