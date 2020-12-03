package com.example.marketlist.model;


import android.icu.util.LocaleData;

import java.util.List;

public class NotaFiscal {

    private String nomeEstabelecimento;
    private Long cnpj;
    private Long numeroNotaFiscal;
    private LocaleData dataEmissao;
    private Long chaveAcesso;
    private Long protocoloAutorizacao;
    List<ItemComprado> itensComprados;

    public NotaFiscal() {
    }

    public NotaFiscal(String nomeEstabelecimento, Long cnpj, Long numeroNotaFiscal, LocaleData dataEmissao, Long chaveAcesso, Long protocoloAutorizacao) {
        this.nomeEstabelecimento = nomeEstabelecimento;
        this.cnpj = cnpj;
        this.numeroNotaFiscal = numeroNotaFiscal;
        this.dataEmissao = dataEmissao;
        this.chaveAcesso = chaveAcesso;
        this.protocoloAutorizacao = protocoloAutorizacao;
    }

    public String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }

    public void setNomeEstabelecimento(String nomeEstabelecimento) {
        this.nomeEstabelecimento = nomeEstabelecimento;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public Long getNumeroNotaFiscal() {
        return numeroNotaFiscal;
    }

    public void setNumeroNotaFiscal(Long numeroNotaFiscal) {
        this.numeroNotaFiscal = numeroNotaFiscal;
    }

    public LocaleData getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocaleData dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Long getChaveAcesso() {
        return chaveAcesso;
    }

    public void setChaveAcesso(Long chaveAcesso) {
        this.chaveAcesso = chaveAcesso;
    }

    public Long getProtocoloAutorizacao() {
        return protocoloAutorizacao;
    }

    public void setProtocoloAutorizacao(Long protocoloAutorizacao) {
        this.protocoloAutorizacao = protocoloAutorizacao;
    }

    public List<ItemComprado> getItensComprados() {
        return itensComprados;
    }

    public void setItensComprados(List<ItemComprado> itensComprados) {
        this.itensComprados = itensComprados;
    }
}
