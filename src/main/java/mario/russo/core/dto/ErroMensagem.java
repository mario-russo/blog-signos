package mario.russo.core.dto;

public class ErroMensagem {
    private int status;
    private String mensagem;

    public ErroMensagem(int status, String mensagem) {
        this.status = status;
        this.mensagem = mensagem;
    }

    public ErroMensagem() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
