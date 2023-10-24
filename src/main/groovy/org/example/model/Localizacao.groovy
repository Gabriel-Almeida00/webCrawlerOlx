package org.example.model

class Localizacao {
    private Integer id
    private Integer produtoId
    private String cep
    private String municipio
    private String bairro

    Localizacao(Integer id, Integer produtoId, String cep, String municipio, String bairro) {
        this.id = id
        this.produtoId = produtoId
        this.cep = cep
        this.municipio = municipio
        this.bairro = bairro
    }
}
