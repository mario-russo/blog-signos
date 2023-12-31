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
import mario.russo.core.domain.TipoReferencia;

@Entity
@Table(name = "conteudo")
public class ConteudoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private SignoZodiaco signo;

    private TipoReferencia tipo;

    private String conteudo;

    private int referencia;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    public UsuarioEntity usuario;

    public ConteudoEntity(SignoZodiaco signo, TipoReferencia tipo, String conteudo, int referencia,
            UsuarioEntity usuario) {
        this.signo = signo;
        this.conteudo = conteudo;
        this.referencia = referencia;
        this.usuario = usuario;
        this.tipo = tipo;
    }

    public ConteudoEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public TipoReferencia getTipo() {
        return tipo;
    }

    public void setTipo(TipoReferencia tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
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
        if (id != other.id)
            return false;
        return true;
    }

}
