package br.com.flaberson.resources;

import br.com.flaberson.services.CotacaoRestService;
import br.com.flaberson.services.CotacaoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/cotacao")
public class CotacoesResource {

    private static final Logger log = LoggerFactory.getLogger(CotacoesResource.class);

    @Inject
    CotacaoRestService cotacaoRestService;
    @Inject
    CotacaoService cotacaoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{dataCotacao}")
    public Response buscaCotacaoPorData(@PathParam("dataCotacao") String dataCotacao) {

        return Response.status(Response.Status.OK)
                .entity(cotacaoRestService.getCotacao(dataCotacao))
                .build();
    }

    @GET
    public Response getAllCotacoes() {
        return Response.status(Response.Status.OK)
                .entity(cotacaoService.getAllCotacoes())
                .build();
    }
}
