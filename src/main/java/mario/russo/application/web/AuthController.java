package mario.russo.application.web;

import org.eclipse.microprofile.jwt.JsonWebToken;

import jakarta.annotation.security.RolesAllowed;
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
import mario.russo.core.domain.Usuario;
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
    public String login(LoginDto dto) throws ObjectNotFoundException {
        return token.getToken(dto);
    }

    @GET
    @Path("verify")
    @RolesAllowed({ "User" })
    public Response verify() throws ObjectNotFoundException {
        return Response.ok("acesso permitido").build();
    }
    @POST
    @Path("register")
    @Transactional
    public Response register(Usuario usuario) throws ObjectNotFoundException {
        return Response.status(Status.CREATED).entity( usuarioService.save(usuario)).build();
    }

}
