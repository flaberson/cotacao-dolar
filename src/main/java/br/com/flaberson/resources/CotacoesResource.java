package br.com.flaberson.resources;

import br.com.flaberson.services.CotacaoRestService;
import br.com.flaberson.services.CotacaoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cotacao")
public class CotacoesResource {

    @Inject
    CotacaoRestService cotacaoRestService;
    @Inject
    CotacaoService cotacaoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{dataCotacao}")
    public Response buscaCotacaoPorData(@PathParam("dataCotacao") String dataCotacao) {

        var retorno = cotacaoRestService.getCotacao(dataCotacao);

        return Response.status(Response.Status.OK)
                .entity(retorno.await().indefinitely())
                .build();
    }

    @GET
    public Response getAllCotacoes() {
        return Response.status(Response.Status.OK)
                .entity(cotacaoService.getAllCotacoes())
                .build();
    }
}
