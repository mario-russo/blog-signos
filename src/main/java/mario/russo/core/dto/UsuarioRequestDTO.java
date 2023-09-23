package mario.russo.core.dto;

public record UsuarioRequestDTO(
        String nome,
        String email,
        String senha,
        String rule) {
        
}
