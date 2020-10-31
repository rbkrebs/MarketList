package com.example.marketlist;

public class ListaProvisoria {

    private Integer quantidade;
    private String nomeProduto;
    private String observacoes;

    public ListaProvisoria(){}

    public ListaProvisoria(Integer quantidade, String nomeProduto, String observacoes){

        this.quantidade = quantidade;
        this.nomeProduto = nomeProduto;
        this.observacoes = observacoes;

    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public static ListaProvisoria lista[] = {

            new ListaProvisoria(
                    1, "Banana","caturra madura"
            ),
            new ListaProvisoria(
                    3, "Maçãs","pega as vermelhas"
            ),
            new ListaProvisoria(
                    1, "Ovos","pega os vermelhos"
            ),
            new ListaProvisoria(
                    1, "Massa integral","marca Isabela"
            )
    };

    @Override
    public String toString() {
        return "Item: " + nomeProduto +
                "\nQuantidade: " + quantidade +
                "\nObservacoes: " + observacoes;
    }
}
