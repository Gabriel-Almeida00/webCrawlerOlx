package org.example.model

class Email {
    private Integer id
    private String endereco

    Email(Integer id, String endereco) {
        this.id = id
        this.endereco = endereco
    }

    Integer getId() {
        return id
    }

    String getEndereco() {
        return endereco
    }
}
