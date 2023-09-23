package mario.russo.core.ports.in;

import mario.russo.core.domain.entity.ConteudoEntity;

public interface ConteudoSave {
    public ConteudoEntity save(ConteudoEntity conteudo);
}
