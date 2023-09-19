package mario.russo.infra.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import mario.russo.core.domain.Conteudo;
import mario.russo.core.domain.SignoZodiaco;
import mario.russo.core.domain.Usuario;

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
    private UsuarioEntity usuario;

    public ConteudoEntity(SignoZodiaco signo, String conteudo, String referencia, UsuarioEntity usuario) {
        this.signo = signo;
        this.conteudo = conteudo;
        this.referencia = referencia;
        this.usuario = usuario;
    }

    public ConteudoEntity() {
    }

    public ConteudoEntity(Conteudo conteudo) {
        this.signo = conteudo.getSigno();
        this.conteudo = conteudo.getConteudo();
        this.referencia = conteudo.getReferencia();
        this.usuario = new UsuarioEntity(conteudo.getUsuario());
    }

    public Conteudo conteudo() {
        Conteudo conteudo = new Conteudo(this.signo, this.conteudo, this.referencia, this.getUsuario().getUsuario());
        conteudo.setId(this.getId());
        return conteudo;
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
        ConteudoEntity other = (ConteudoEntity) obj;
        if (id != other.id)
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
