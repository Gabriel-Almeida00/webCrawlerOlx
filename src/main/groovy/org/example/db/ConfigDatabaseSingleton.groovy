package org.example.db

import groovy.json.JsonException
import groovy.json.JsonSlurper
import org.example.exception.ConfigDataBaseException

class ConfigDatabaseSingleton {
    private static ConfigDatabaseSingleton instance
    private String urlDB
    private String userDB
    private String senhaDB

    private ConfigDatabaseSingleton() {
        loadConfigFromFile()
    }

    static ConfigDatabaseSingleton getInstance() {
        if (instance == null) {
            instance = new ConfigDatabaseSingleton()
        }
        return instance
    }

    private void loadConfigFromFile() throws ConfigDataBaseException {
        try {
            File configFile = new File("configDatabase.json")
            JsonSlurper jsonSlurper = new JsonSlurper()
            Object configData = jsonSlurper.parse(configFile)

            urlDB = configData.url
            userDB = configData.user
            senhaDB = configData.senha

        } catch (FileNotFoundException e) {
            throw new ConfigDataBaseException("Arquivo de configuração não encontrado", e)
        } catch (IOException e) {
            throw new ConfigDataBaseException("Erro de leitura do arquivo de configuração", e)
        } catch (JsonException e) {
            throw new ConfigDataBaseException("Erro ao analisar o arquivo JSON de configuração", e)
        }
    }

    String getDbType() {
        return dbType
    }

    String getUrlDB() {
        return urlDB
    }

    String getUserDB() {
        return userDB
    }

    String getSenhaDB() {
        return senhaDB
    }
}
