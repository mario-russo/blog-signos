package mario.russo.application.web;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mario.russo.application.Exception.ExceptionUsuario;
import mario.russo.core.domain.entity.UsuarioEntity;
import mario.russo.core.useCase.UsuarioService;

@Path("usuario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioController {

    @Inject
    UsuarioService service;

    @GET
    public Response listUsuario() {
        List<UsuarioEntity> listaDeUsuario = service.listAll();
        return Response.ok(listaDeUsuario).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) throws ExceptionUsuario {
        UsuarioEntity usuarioSalvo = service.getById(id);
        return Response.ok(usuarioSalvo).build();
    }

    @GET
    @Path("/email/{email}")
    public Response getById(@PathParam("email") String email) {
        UsuarioEntity usuarioSalvo = service.getByEmail(email);
        return Response.ok(usuarioSalvo).build();
    }

    @Transactional
    @PATCH
    @Path("/{id}")
    public Response atualiza(@PathParam("id") Long id, UsuarioEntity usuario) {
        UsuarioEntity usuarioAtualizado = service.upDate(usuario, id);
        return Response.ok(usuarioAtualizado).build();
    }
}
