package com.example.marketlist.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaProvisoria implements Serializable {

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

    public static List<ListaProvisoria> criaLista(){

        List<ListaProvisoria> lista = new ArrayList();

        lista.add(new ListaProvisoria(
                1, "Banana","caturra madura"
        ));
        lista.add(new ListaProvisoria(
                1, "Massa integral","marca Isabela"
        ));
        lista.add(new ListaProvisoria(
                3, "Maçãs","pega as vermelhas"
        ));
        lista.add(new ListaProvisoria(
                1, "Feijão","pega o da marca X"
        ));
        lista.add(new ListaProvisoria(
                1, "Arroz integral",""
        ));
        lista.add(new ListaProvisoria(
                3, "Limão",""
        ));
        lista.add(new ListaProvisoria(
                1, "Amaciante","pega um com desenho de urso"
        ));
        lista.add(new ListaProvisoria(
                1, "Sabão Líquido","Ariel"
        ));
        lista.add(new ListaProvisoria(
                3, "Bolacha Integral","olha o primeiro ingradiente"
        ));

        return lista;
    };

    @Override
    public String toString() {
        return "Item: " + nomeProduto +
                "\nQuantidade: " + quantidade +
                "\nObservacoes: " + observacoes;
    }
}
