package mario.russo.application.web;

import java.util.List;
import java.util.stream.Collectors;

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
import mario.russo.core.dto.UsuarioRequestDTO;
import mario.russo.core.dto.UsuarioResponseDTO;
import mario.russo.core.useCase.UsuarioService;

@Path("usuario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
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
    public Response atualiza(@PathParam("id") Long id, UsuarioRequestDTO usuario) {
        UsuarioEntity entity = new UsuarioEntity(usuario.nome(), usuario.email(), usuario.senha(), usuario.rule());
        UsuarioEntity usuarioAtualizado = service.upDate(entity, id);

        UsuarioResponseDTO responseDTO = new UsuarioResponseDTO(usuarioAtualizado);
        return Response.ok(responseDTO).build();
    }
}
