package mario.russo.application.mapper;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import mario.russo.application.Exception.ExceptionUsuario;
import mario.russo.core.dto.ErroMensagem;

@Provider
public class ExceptionUsuarioMapper implements ExceptionMapper<ExceptionUsuario> {

    @Override
    public Response toResponse(ExceptionUsuario exception) {
        ErroMensagem erro = new ErroMensagem();

        erro.setMensagem(exception.getMessage());
        erro.setStatus(exception.getStatus());
        
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(erro)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

}
