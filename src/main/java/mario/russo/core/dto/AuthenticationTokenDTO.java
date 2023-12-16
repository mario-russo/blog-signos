package mario.russo.core.dto;

public class AuthenticationTokenDTO {
    private String token;
    private Long id;
    private String nome;

    public AuthenticationTokenDTO(String token, Long id, String nome) {
        setToken(token);
        setId(id);
        setNome(nome);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
