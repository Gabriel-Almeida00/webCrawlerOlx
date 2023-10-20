package org.example.model

class Produto {
    private String titulo
    private String valor
    private String endereco
    private String url

    Produto(String titulo, String valor, String endereco, String url) {
        this.titulo = titulo
        this.valor = valor
        this.endereco = endereco
        this.url = url
    }

    String getTitulo() {
        return titulo
    }

    String getValor() {
        return valor
    }


    String getEndereco() {
        return endereco
    }

    String getUrl() {
        return url
    }


    @Override
    String toString() {
        return "titulo: '" + titulo + '\'' + "\n" +
                "valor:'" + valor + '\'' + "\n" +
                "endereco: '" + endereco + '\'' + "\n" +
                "url: '" + url + '\'' + "\n"

    }

}
