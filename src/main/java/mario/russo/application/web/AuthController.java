package mario.russo.application.web;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.microprofile.jwt.JsonWebToken;

import io.quarkus.security.Authenticated;
import jakarta.ejb.ObjectNotFoundException;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import mario.russo.auth.CriaToken;
import mario.russo.auth.LoginDto;
import mario.russo.core.domain.entity.UsuarioEntity;
import mario.russo.core.dto.AuthenticationTokenDTO;
import mario.russo.core.dto.UsuarioRequestDTO;
import mario.russo.core.dto.UsuarioResponseDTO;
import mario.russo.core.useCase.UsuarioService;

@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthController {
    @Inject
    UsuarioService usuarioService;
    @Inject
    CriaToken token;

    @Inject
    JsonWebToken jwt;

    @POST
    @Path("login")
    public Response login(LoginDto dto) throws ObjectNotFoundException {
        AuthenticationTokenDTO authenticationTokenDTO = token.getToken(dto);
        return Response.ok().entity(authenticationTokenDTO).build();
    }

    @GET
    @Path("verify")
    // @PermitAll
    @Authenticated
    public Response verify() {
        Map<String, Boolean> verificar = new HashMap<>();
        try {
            verificar.put("acesso", true);
            return Response.ok().entity(verificar).build();

        } catch (Exception e) {
            verificar.put("acesso", false);
            return Response.status(401).entity(e).build();
        }
    }

    @POST
    @Path("register")
    @Transactional
    public Response register(UsuarioRequestDTO usuario) throws ObjectNotFoundException {

        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario.nome(), usuario.email(), usuario.senha(),
                usuario.rule());

        UsuarioEntity usuarioSalvo = usuarioService.save(usuarioEntity);

        UsuarioResponseDTO usuarioResposnse = new UsuarioResponseDTO(usuarioSalvo.getId(), usuarioSalvo.getNome(),
                usuarioSalvo.getEmail(), usuarioEntity.getRules());

        return Response.status(Status.CREATED).entity(usuarioResposnse).build();
    }

}
