package mario.russo.core.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Conteudo {
    private Long id;
    @NotBlank(message = "Não pode ser vázio")
    @NotNull(message = "vazio")
    private SignoZodiaco signo;
    private String conteudo;
    private String referencia;
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Conteudo(SignoZodiaco signo, String conteudo, String referencia, Usuario usuario) {
        setSigno(signo);
        setConteudo(conteudo);
        setReferencia(referencia);
        setUsuario(usuario);
    }

    public Conteudo() {

    }

    public SignoZodiaco getSigno() {
        return signo;
    }

    public void setSigno(SignoZodiaco signo) {
        if (signo == null) {
            throw new IllegalArgumentException("Campo signo não pode ser vázio");
        }
        this.signo = signo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        if (conteudo.isEmpty()) {
            throw new IllegalArgumentException("Campo Conteudo não pode ser vázio");
        }

        this.conteudo = conteudo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {

        if (referencia.isEmpty()) {
            throw new IllegalArgumentException("Campo Conteudo não pode ser vázio");
        }
        this.referencia = referencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (int) (prime * result + id);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Conteudo other = (Conteudo) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
