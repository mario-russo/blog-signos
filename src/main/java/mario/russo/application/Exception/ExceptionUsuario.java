package mario.russo.application.Exception;

import jakarta.ws.rs.WebApplicationException;

public class ExceptionUsuario extends WebApplicationException  {
    private int status;

    public ExceptionUsuario(int status, String mensagem) {
        super(mensagem);
        this.status = status;
    }

    public ExceptionUsuario() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
