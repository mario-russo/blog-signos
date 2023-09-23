package mario.russo.core.dto;

import mario.russo.core.domain.SignoZodiaco;

public record ConteudoRequestDTO(
        SignoZodiaco signo,
        String conteudo,
        String referencia,
        Long idUsuario) {

}
