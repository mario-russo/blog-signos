package mario.russo.application.web;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import mario.russo.core.domain.Conteudo;
import mario.russo.core.useCase.ConteudoService;
import mario.russo.infra.adapter.ConteudoRepositoryImpl;

@Path("/conteudo")
public class ConteudoController {
    @Inject
    ConteudoService service;
    @Inject
    ConteudoRepositoryImpl repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Conteudo> listAllConteudo() {
        List<Conteudo> conteudo = service.listAll();
        return conteudo;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Conteudo getById(@PathParam("id") Long id) {
        Conteudo conteudoSalvo = service.getById(id);
        return conteudoSalvo;
    }

    @GET
    @Path("signo/{signo}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Conteudo> getBySignos(@PathParam("signo") String signo) {
        var conteudoSalvo = service.findBySignos(signo);
        return conteudoSalvo;
    }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Conteudo save(@RequestBody @Valid Conteudo conteudo) {
        return service.save(conteudo);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public void upDate(@PathParam("id") Long id, Conteudo conteudo) {
        service.upDate(id, conteudo);
    }
}
