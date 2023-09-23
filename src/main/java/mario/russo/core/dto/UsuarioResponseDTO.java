package mario.russo.core.dto;

import java.util.List;
import mario.russo.core.domain.Rules;
import mario.russo.core.domain.entity.UsuarioEntity;

public record UsuarioResponseDTO(
                Long id,
                String nome,
                String email,
                List<Rules> rules) {
        // public UsuarioResponseDTO(Long id, String nome, String email, Set<Rules>
        // rules) {
        // this.id = id;
        // this.nome = nome;
        // this.email = email;
        // this.rules = rules;
        // }

        public UsuarioResponseDTO(UsuarioEntity usuarioEntity) {
               this( usuarioEntity.getId(),
                 usuarioEntity.getNome(),
                 usuarioEntity.getEmail(),
                 usuarioEntity.getRules());
        }
}