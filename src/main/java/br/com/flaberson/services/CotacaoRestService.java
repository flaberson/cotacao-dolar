package br.com.flaberson.services;

import br.com.flaberson.domain.mappers.CotacaoMapper;
import br.com.flaberson.domain.models.Cotacao;
import br.com.flaberson.domain.models.CotacaoDiaResponse;
import br.com.flaberson.domain.models.CotacaoResponse;
import br.com.flaberson.repositories.CotacaoRepository;
import br.com.flaberson.rest.CotacoesClient;
import io.quarkus.cache.CacheResult;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.Set;

@ApplicationScoped
public class CotacaoRestService {

    final Logger log = LoggerFactory.getLogger(CotacaoRestService.class);

    @RestClient
    @Inject
    CotacoesClient cotacoesClient;

    @Inject
    CotacaoRepository cotacaoRepository;

    @Inject
    private CotacaoMapper cotacaoMapper;

    @CacheResult(cacheName = "cotacoes-cache")
    public Uni<CotacaoResponse> getCotacao(String dataCotacao) {

        Optional<Cotacao> optionalCotacao = this.cotacaoRepository.findByDataCotacao(dataCotacao);

        if (optionalCotacao.isPresent()) {
            return Uni.createFrom().item(this.cotacaoMapper.toCotacaoResponse(optionalCotacao.get()));
        } else {
            return cotacoesClient.getCotacao(this.toDataFormat(dataCotacao))
                    .map(this::toCotacaoResponse)
                    .invoke(cotacao -> this.saveCotacao(toCotacao(dataCotacao, cotacao)))
                    .onFailure().recoverWithNull();
        }
    }

    CotacaoResponse toCotacaoResponse(CotacaoDiaResponse cotacaoDiaResponse) {
        Set<CotacaoResponse> cotacaoResponse = cotacaoDiaResponse.getValue();
        if (!cotacaoResponse.isEmpty()) {
            return cotacaoResponse.iterator().next();
        }
        return null;
    }

    Cotacao toCotacao(String dataCotacao, CotacaoResponse cotacaoResponse) {
        return new Cotacao("","",cotacaoResponse.getCotacaoCompra(), cotacaoResponse.getCotacaoVenda(), dataCotacao,cotacaoResponse.getDataHoraCotacao());
    }

    String toDataFormat(String dataCotacao){
        return "'" + dataCotacao + "'";
    }

    Cotacao saveCotacao(Cotacao cotacao) {
        this.cotacaoRepository.persist(cotacao);

        return cotacao;
    }
}
