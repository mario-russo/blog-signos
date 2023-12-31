package mario.russo.core.dto;

import mario.russo.core.domain.SignoZodiaco;
import mario.russo.core.domain.TipoReferencia;

public record ConteudoRequestDTO(
                int id,
                TipoReferencia tipo,
                SignoZodiaco signo,
                String conteudo,
                int referencia,
                int idUsuario) {

}
