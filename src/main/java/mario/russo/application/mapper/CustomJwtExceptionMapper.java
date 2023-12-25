package mario.russo.application.mapper;

import java.util.HashMap;
import java.util.Map;

import io.smallrye.jwt.build.JwtException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class CustomJwtExceptionMapper implements ExceptionMapper<JwtException> {

    @Override
    public Response toResponse(JwtException exception) {
        Map<String, Boolean> verifica = new HashMap<>();

        verifica.put("acesso", false);
        return Response.status(Status.UNAUTHORIZED).entity(exception.getMessage()).build();
    }

}
