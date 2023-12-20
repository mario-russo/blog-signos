package mario.russo.core.ports.out;

import java.util.List;

import mario.russo.core.domain.SignoZodiaco;
import mario.russo.core.domain.entity.ConteudoEntity;

public interface ConteudoRepository {
    public ConteudoEntity save(ConteudoEntity conteudo);

    public List<ConteudoEntity> listAll();

    public ConteudoEntity getById(int id);

    public int delete(ConteudoEntity conteudo);

    public ConteudoEntity upDate(int id, ConteudoEntity conteudo);

    public List<ConteudoEntity> findBysignos(SignoZodiaco signos);
}
