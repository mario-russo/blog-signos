package mario.russo.application.web;

import java.util.List;
import java.util.stream.Collectors;

import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mario.russo.application.Exception.ExceptionUsuario;
import mario.russo.core.domain.entity.UsuarioEntity;
import mario.russo.core.dto.UsuarioRequestDTO;
import mario.russo.core.dto.UsuarioResponseDTO;
import mario.russo.core.useCase.UsuarioService;

@Path("usuario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Authenticated
public class UsuarioController {

    @Inject
    UsuarioService service;

    @GET
    public Response listUsuario() {
        List<UsuarioEntity> usuarios = service.listAll();
        List<UsuarioResponseDTO> usuariosDTO = usuarios.stream().map(
                (usuario) -> new UsuarioResponseDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(),
                        usuario.getRules()))
                .collect(Collectors.toList());

        return Response.ok(usuariosDTO).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") int id) throws ExceptionUsuario {
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
    @PUT
    @Path("/{id}")
    public Response atualiza(@PathParam("id") int id, UsuarioRequestDTO usuario) {
        UsuarioEntity entity = service.getById(id);
        if (usuario.rule().size() > 0) {
            entity.setRules(usuario.rule());
        }
        entity.setNome(usuario.nome());
        entity.setEmail(usuario.email());
        UsuarioEntity usuarioAtualizado = service.upDate(entity, id);

        UsuarioResponseDTO responseDTO = new UsuarioResponseDTO(usuarioAtualizado);
        return Response.ok(responseDTO).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        Boolean delete = service.deleteUsuario(id);

        return Response.status(204).entity(delete).build();
    }
}
