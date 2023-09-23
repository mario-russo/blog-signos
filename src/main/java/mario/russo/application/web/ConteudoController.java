package mario.russo.application.web;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

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
import jakarta.ws.rs.core.Response.Status;
import mario.russo.core.domain.entity.ConteudoEntity;
import mario.russo.core.dto.ConteudoRequestDTO;
import mario.russo.core.dto.ConteudoResponseDTO;
import mario.russo.core.useCase.ConteudoService;
import mario.russo.infra.adapter.UsuarioRepositoryImpl;

@Path("conteudo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConteudoController {

    @Inject
    ConteudoService service;
    
    @Inject
    UsuarioRepositoryImpl usuarioService;

    @GET
    public Response listAllConteudo() {
        List<ConteudoEntity> conteudo = service.listAll();

        List<ConteudoResponseDTO> responseDTO = conteudo.stream()
                .map(entity -> new ConteudoResponseDTO(entity))
                .collect(Collectors.toList());

        return Response.ok(responseDTO).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        ConteudoEntity conteudoSalvo = service.getById(id);

        ConteudoResponseDTO conteudoDTO = new ConteudoResponseDTO(conteudoSalvo);

        return Response.ok(conteudoDTO).build();
    }

    @GET
    @Path("signo/{signo}")
    public Response getBySignos(@PathParam("signo") int signo) {

        var conteudoSalvo = service.findBySignos(signo);

        List<ConteudoResponseDTO> responseDTO = conteudoSalvo.stream()
                .map(entity -> new ConteudoResponseDTO(entity))
                .collect(Collectors.toList());
        return Response.ok(responseDTO).build();
    }

    @POST
    @Transactional
    public Response save(@RequestBody ConteudoRequestDTO conteudo) throws URISyntaxException {
        ConteudoEntity conteudoSalvo = service.save(conteudo);

        ConteudoResponseDTO coteudoDTO = new ConteudoResponseDTO(conteudoSalvo);

        return Response.status(Status.CREATED).location(new URI("/conteudo/" + conteudoSalvo.getId()))
                .entity(coteudoDTO).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response upDate(@PathParam("id") Long id, ConteudoEntity conteudo) {
        service.upDate(id, conteudo);
        return Response.ok(conteudo).build();
    }
}
