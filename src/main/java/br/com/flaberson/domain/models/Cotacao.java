package br.com.flaberson.domain.models;

import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "cotacao")
public class Cotacao {

    private String idRequisicao;
    private String timestamp;
    private String cotacaoCompra;
    private String cotacaoVenda;
    private String dataCotacao;
    private String dataCotacaoRequisicao;

    public Cotacao(){

    }

    public Cotacao(String idRequisicao, String timestamp, String cotacaoCompra, String cotacaoVenda, String dataCotacao, String dataCotacaoRequisicao) {
        this.idRequisicao = idRequisicao;
        this.timestamp = timestamp;
        this.cotacaoCompra = cotacaoCompra;
        this.cotacaoVenda = cotacaoVenda;
        this.dataCotacao = dataCotacao;
        this.dataCotacaoRequisicao = dataCotacaoRequisicao;
    }

    public String getIdRequisicao() {
        return idRequisicao;
    }

    public void setIdRequisicao(String idRequisicao) {
        this.idRequisicao = idRequisicao;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
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

    public String getDataCotacao() {
        return dataCotacao;
    }

    public void setDataCotacao(String dataCotacao) {
        this.dataCotacao = dataCotacao;
    }

    public String getDataCotacaoRequisicao() {
        return dataCotacaoRequisicao;
    }

    public void setDataCotacaoRequisicao(String dataCotacaoRequisicao) {
        this.dataCotacaoRequisicao = dataCotacaoRequisicao;
    }
}
