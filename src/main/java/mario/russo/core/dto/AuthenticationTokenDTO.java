package mario.russo.core.dto;

public class AuthenticationTokenDTO {
    public String token;

    public AuthenticationTokenDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
