package mario.russo.core.dto;

import mario.russo.core.domain.SignoZodiaco;
import mario.russo.core.domain.TipoReferencia;
import mario.russo.core.domain.entity.ConteudoEntity;
import mario.russo.core.domain.entity.UsuarioEntity;

public record ConteudoResponseDTO(
        int id,
        String conteudo,
        int referencia,
        SignoZodiaco signo,
        UsuarioResponseDTO usuario,
        TipoReferencia tipo) {

    public ConteudoResponseDTO(ConteudoEntity entity) {
        this(entity.getId(), entity.getConteudo(), entity.getReferencia(), entity.getSigno(),
                usuarioFactory(entity.getUsuario()), entity.getTipo());
    }

    private static UsuarioResponseDTO usuarioFactory(UsuarioEntity entity) {
        return new UsuarioResponseDTO(entity);
    }

}
