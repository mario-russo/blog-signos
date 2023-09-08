package mario.russo.core.domain;

public class Usuario {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String rules;

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.isEmpty()) {
            throw new IllegalArgumentException("campo nome não pode ser vázio");
        }
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.isEmpty()) {
            throw new IllegalArgumentException("Campo E-mail não pode ser vázio");
        }
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (senha.isEmpty()) {
            throw new IllegalArgumentException("Campo idade não pode ser vázio");
        }
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
        Usuario other = (Usuario) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
