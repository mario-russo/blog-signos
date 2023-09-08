package mario.russo.infra.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import mario.russo.core.domain.Usuario;

@Entity
@Table(name = "usuario")
public class UsuarioEntity extends PanacheEntity{
   
    private String nome;
    private String email;
    private String senha;

    public UsuarioEntity(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public UsuarioEntity() {
    }

    public UsuarioEntity(Usuario usuario) {
        setEmail(usuario.getEmail());
        setNome(usuario.getNome());
        setSenha(usuario.getSenha());
    }

    public Usuario getUsuario(){
       Usuario usuario = new Usuario(this.nome, this.email, this.senha);
       usuario.setId(this.id);
       return usuario;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
        UsuarioEntity other = (UsuarioEntity) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
