package org.example.model

class ProdutoDetalhes {
    private Integer id
    private Integer produtoId
    private String cor
    private String modelo

    ProdutoDetalhes(Integer id,Integer produtoId, String cor, String modelo) {
        this.id = id
        this.produtoId = produtoId
        this.cor = cor
        this.modelo = modelo
    }
}
