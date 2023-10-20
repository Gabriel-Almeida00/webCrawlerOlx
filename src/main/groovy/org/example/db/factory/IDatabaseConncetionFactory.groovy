package org.example.db.factory

import org.example.db.IDatabaseConnection

interface IDatabaseConncetionFactory {
    IDatabaseConnection createConnection();
}