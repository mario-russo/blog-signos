package mario.russo.core.domain.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import mario.russo.core.domain.Rules;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;
    private List<Rules> rules = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<ConteudoEntity> conteudo = new ArrayList<>();

    public UsuarioEntity(String nome, String email, String senha, List<Rules> rules) {
        setNome(nome);
        setEmail(email);
        setSenha(senha);
        setRules(rules);
    }

    public UsuarioEntity(String nome, String email, String senha) {
        setNome(nome);
        setEmail(email);
        setSenha(senha);
    }

    public UsuarioEntity() {
    }

    public Collection<ConteudoEntity> getConteudo() {
        return conteudo;
    }

    public void setConteudo(ConteudoEntity conteudo) {
        this.conteudo.add(conteudo);
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

    public List<Rules> getRules() {
        return rules;
    }

    public void setRules(Rules rules) {
        this.rules.add(rules);
    }

    public void setRules(List<Rules> rules) {
        HashSet<Rules> flag = new HashSet<>();
        for (Rules rules2 : rules) {
            flag.add(rules2);
        }
        this.rules = new ArrayList<>(flag);
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
        UsuarioEntity other = (UsuarioEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setConteudo(List<ConteudoEntity> conteudo) {
        this.conteudo = conteudo;
    }

}
