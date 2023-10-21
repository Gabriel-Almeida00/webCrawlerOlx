package org.example.service.email

import groovy.json.JsonException
import groovy.json.JsonSlurper
import org.example.exception.ConfigEmailFileException

class ConfigEmail {
    private  String email
    private String senha

    ConfigEmail() {
        this.loadConfigEmailFile()
    }

    private void loadConfigEmailFile(){
        try{
            File configFile = new File("configEmail.json")
            JsonSlurper jsonSlurper = new JsonSlurper()
            Object configData = jsonSlurper.parse(configFile)

            email = configData.email
            senha = configData.senha

        } catch (FileNotFoundException e) {
            throw new ConfigEmailFileException("Arquivo de configuração não encontrado", e)
        } catch (IOException e) {
            throw new ConfigEmailFileException("Erro de leitura do arquivo de configuração", e)
        } catch (JsonException e) {
            throw new ConfigEmailFileException("Erro ao analisar o arquivo JSON de configuração", e)
        }
    }

    String getEmail() {
        return email
    }

    String getSenha() {
        return senha
    }
}
