package mario.russo.core.domain.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import mario.russo.core.domain.SignoZodiaco;

@Entity
@Table(name = "conteudo")
public class ConteudoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private SignoZodiaco signo;

    private String conteudo;

    private String referencia;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    public UsuarioEntity usuario;

    public ConteudoEntity(SignoZodiaco signo, String conteudo, String referencia, UsuarioEntity usuario) {
        this.signo = signo;
        this.conteudo = conteudo;
        this.referencia = referencia;
        this.usuario = usuario;
    }

    public ConteudoEntity() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SignoZodiaco getSigno() {
        return signo;
    }

    public void setSigno(SignoZodiaco signo) {
        this.signo = signo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        ConteudoEntity other = (ConteudoEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

}
