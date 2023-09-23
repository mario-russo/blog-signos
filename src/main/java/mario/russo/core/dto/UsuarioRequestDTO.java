package mario.russo.core.dto;

import java.util.List;

import mario.russo.core.domain.Rules;

public record UsuarioRequestDTO(
        String nome,
        String email,
        String senha,
        List<Rules> rule) {
        
}
