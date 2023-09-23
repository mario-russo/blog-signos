package mario.russo.core.dto;

import mario.russo.core.domain.SignoZodiaco;
import mario.russo.core.domain.entity.ConteudoEntity;

public record ConteudoResponseDTO(
        Long id,
        String conteudo,
        String referencia,
        SignoZodiaco signo,
        UsuarioResponseDTO usuario) {
    public ConteudoResponseDTO(ConteudoEntity entity) {
        this(entity.getId(), entity.getConteudo(), entity.getReferencia(), entity.getSigno(),
                new UsuarioResponseDTO(entity.usuario.getId(), entity.usuario.getNome(),
                        entity.usuario.getEmail()));
    }

}
