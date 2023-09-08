package mario.russo.core.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Conteudo {
    private Long id;
    @NotBlank(message = "Não pode ser vázio")
    @NotNull(message = "vazio")
    private String signo;
    private String conteudo;
    private String referencia;

    public Conteudo(String signo, String conteudo, String referencia) {
        setSigno(signo);
        setConteudo(conteudo);
        setReferencia(referencia);
    }

    public Conteudo() {

    }

    public String getSigno() {
        return signo;
    }

    public void setSigno(String signo) {
        if (signo.isEmpty()) {
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
