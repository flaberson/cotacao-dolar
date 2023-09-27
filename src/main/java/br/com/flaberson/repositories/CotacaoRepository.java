package br.com.flaberson.repositories;

import br.com.flaberson.domain.models.Cotacao;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class CotacaoRepository implements PanacheMongoRepository<Cotacao> {
    public Optional<Cotacao> findByDataCotacao(String dataCotacao){
        return Optional.ofNullable(find("dataCotacao", dataCotacao).firstResult());
    }
}
