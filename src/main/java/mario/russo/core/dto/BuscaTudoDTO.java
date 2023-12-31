package mario.russo.core.dto;

import mario.russo.core.domain.SignoZodiaco;
import mario.russo.core.domain.TipoReferencia;

public record BuscaTudoDTO(
                int referencia,
                SignoZodiaco signo,
                TipoReferencia tipo) {

}
