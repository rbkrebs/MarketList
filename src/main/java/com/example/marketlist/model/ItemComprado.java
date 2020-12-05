package com.example.marketlist.model;

import java.io.Serializable;

public class ItemComprado implements Serializable {

    private String id;
    private Long codigo;
    private String descricao;
    private Float quantidade;
    private String unidade;
    private Float valorUnitario;

    public ItemComprado() {
    }

    public ItemComprado(String id, Long codigo, String descricao, Float quantidade, String unidade, Float valorUnitario) {

        this.id = id;
        this.codigo = codigo;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.unidade = unidade;
        this.valorUnitario = valorUnitario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Override
    public String toString() {
        return "ItemComprado{" +
                "id=" + id +
                "codigo=" + codigo +
                ", descricao='" + descricao + '\'' +
                ", quantidade=" + quantidade +
                ", unidade='" + unidade + '\'' +
                ", valorUnitario=" + valorUnitario +
                '}';
    }
}
