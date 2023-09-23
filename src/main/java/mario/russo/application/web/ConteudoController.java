package mario.russo.application.web;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mario.russo.core.domain.entity.ConteudoEntity;
import mario.russo.core.dto.ConteudoRequestDTO;
import mario.russo.core.useCase.ConteudoService;
import mario.russo.infra.adapter.ConteudoRepositoryImpl;

@Path("conteudo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConteudoController {

    @Inject
    ConteudoService service;
    @Inject
    ConteudoRepositoryImpl repository;

    @GET
    public List<ConteudoEntity> listAllConteudo() {
        List<ConteudoEntity> conteudo = service.listAll();
        return conteudo;
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        ConteudoEntity conteudoSalvo = service.getById(id);
        return Response.ok(conteudoSalvo).build();
    }

    @GET
    @Path("signo/{signo}")
    public Response getBySignos(@PathParam("signo") String signo) {
        var conteudoSalvo = service.findBySignos(signo);
        return Response.ok(conteudoSalvo).build();
    }

    @POST
    @Transactional
    public Response save(@RequestBody ConteudoRequestDTO conteudo) throws URISyntaxException {
        ConteudoEntity conteudoSalvo = service.save(conteudo);
        return Response.created(new URI("/recurso/" + conteudoSalvo.getId())).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response upDate(@PathParam("id") Long id, ConteudoEntity conteudo) {
        service.upDate(id, conteudo);
        return Response.ok(conteudo).build();
    }
}
