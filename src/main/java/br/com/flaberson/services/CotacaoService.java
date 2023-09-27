package br.com.flaberson.services;

import br.com.flaberson.domain.models.Cotacao;
import br.com.flaberson.repositories.CotacaoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CotacaoService {

    @Inject
    CotacaoRepository cotacaoRepository;

    public List<Cotacao> getAllCotacoes() {
        return cotacaoRepository.listAll();
    }

    public Optional<Cotacao> getCotacao(String dataCotacao) {
        return cotacaoRepository.findByDataCotacao(dataCotacao);
    }
}
