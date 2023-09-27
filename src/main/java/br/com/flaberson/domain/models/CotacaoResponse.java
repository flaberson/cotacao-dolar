package br.com.flaberson.domain.models;

import java.io.Serializable;

public class CotacaoResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String cotacaoCompra;
    private String cotacaoVenda;
    private String dataHoraCotacao;

    public CotacaoResponse(){

    }

    public CotacaoResponse(String cotacaoCompra, String cotacaoVenda, String dataHoraCotacao) {
        this.cotacaoCompra = cotacaoCompra;
        this.cotacaoVenda = cotacaoVenda;
        this.dataHoraCotacao = dataHoraCotacao;
    }

    public String getCotacaoCompra() {
        return cotacaoCompra;
    }

    public void setCotacaoCompra(String cotacaoCompra) {
        this.cotacaoCompra = cotacaoCompra;
    }

    public String getCotacaoVenda() {
        return cotacaoVenda;
    }

    public void setCotacaoVenda(String cotacaoVenda) {
        this.cotacaoVenda = cotacaoVenda;
    }

    public String getDataHoraCotacao() {
        return dataHoraCotacao;
    }

    public void setDataHoraCotacao(String dataHoraCotacao) {
        this.dataHoraCotacao = dataHoraCotacao;
    }

    @Override
    public String toString() {
        return "CotacaoResponse{" +
                "cotacaoCompra='" + cotacaoCompra + '\'' +
                ", cotacaoVenda='" + cotacaoVenda + '\'' +
                ", dataHoraCotacao='" + dataHoraCotacao + '\'' +
                '}';
    }

}
