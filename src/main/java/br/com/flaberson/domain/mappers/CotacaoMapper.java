package br.com.flaberson.domain.mappers;

import br.com.flaberson.domain.models.Cotacao;
import br.com.flaberson.domain.models.CotacaoResponse;
import jakarta.enterprise.context.ApplicationScoped;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@ApplicationScoped
@Mapper
public interface CotacaoMapper {

    @Mapping(target = "dataHoraCotacao", source = "dataCotacaoRequisicao")
    CotacaoResponse toCotacaoResponse(Cotacao cotacao);
}
