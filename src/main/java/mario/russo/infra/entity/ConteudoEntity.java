package mario.russo.infra.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import mario.russo.core.domain.Conteudo;

@Entity
@Table(name = "conteudo")
public class ConteudoEntity extends PanacheEntity {
    
    private String signo;

    private String conteudo;

    private String referencia;

    public ConteudoEntity(String signo, String conteudo, String referencia) {
        this.signo = signo;
        this.conteudo = conteudo;
        this.referencia = referencia;
    }

    public ConteudoEntity() {
    }

    public ConteudoEntity(Conteudo conteudo) {
        this.signo = conteudo.getSigno();
        this.conteudo = conteudo.getConteudo();
        this.referencia = conteudo.getReferencia();
    }

    public Conteudo conteudo() {
        Conteudo conteudo = new Conteudo(this.signo, this.conteudo, this.referencia);
        conteudo.setId(this.getId());
        return conteudo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSigno() {
        return signo;
    }

    public void setSigno(String signo) {
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

}
