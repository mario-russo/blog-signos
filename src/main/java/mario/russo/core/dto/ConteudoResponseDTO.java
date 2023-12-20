package mario.russo.core.dto;

import mario.russo.core.domain.SignoZodiaco;
import mario.russo.core.domain.entity.ConteudoEntity;
import mario.russo.core.domain.entity.UsuarioEntity;

public record ConteudoResponseDTO(
        int id,
        String conteudo,
        String referencia,
        SignoZodiaco signo,
        UsuarioResponseDTO usuario) {
    public ConteudoResponseDTO(ConteudoEntity entity) {
        this(entity.getId(), entity.getConteudo(), entity.getReferencia(), entity.getSigno(),
                usuarioFactory(entity.getUsuario()));
    }

    private static UsuarioResponseDTO usuarioFactory(UsuarioEntity entity) {
        return new UsuarioResponseDTO(entity);
    }

}
