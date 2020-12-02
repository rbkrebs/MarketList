package com.example.marketlist.model;


import android.icu.util.LocaleData;

import java.util.List;

public class NotaFiscal {

    private String nomeEstabelecimento;
    private Long cnpj;
    private LocaleData dataEmissao;
    private Long chaveAcesso;
    private Long protocoloAutorizacao;
    List<ItemComprado> itensComprados;

    public NotaFiscal() {
    }

    public NotaFiscal(String nomeEstabelecimento, Long cnpj,
                      LocaleData dataEmissao, Long chaveAcesso,
                      Long protocoloAutorizacao, List<ItemComprado> itensComprados) {
        this.nomeEstabelecimento = nomeEstabelecimento;
        this.cnpj = cnpj;
        this.dataEmissao = dataEmissao;
        this.chaveAcesso = chaveAcesso;
        this.protocoloAutorizacao = protocoloAutorizacao;
        this.itensComprados = itensComprados;
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
