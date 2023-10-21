package org.example.db.factory

interface IDatabaseConnectionFactory {
    IDatabaseConnection createConnection();
}