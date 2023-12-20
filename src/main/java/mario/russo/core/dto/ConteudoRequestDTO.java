package mario.russo.core.dto;

import mario.russo.core.domain.SignoZodiaco;

public record ConteudoRequestDTO(
        int id,
        SignoZodiaco signo,
        String conteudo,
        String referencia,
        int idUsuario) {

}
