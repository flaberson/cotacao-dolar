package br.com.flaberson.rest;

import br.com.flaberson.domain.models.CotacaoDiaResponse;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@ApplicationScoped
@RegisterRestClient(configKey = "cotacao-api")
public interface CotacoesClient {

    @GET
    @Path("CotacaoDolarDia(dataCotacao=@dataCotacao)")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<CotacaoDiaResponse> getCotacao(@QueryParam("@dataCotacao") String dataCotacao);
}
