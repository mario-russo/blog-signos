package mario.russo.core.ports.out;

import java.util.List;

import mario.russo.core.domain.SignoZodiaco;
import mario.russo.core.domain.entity.ConteudoEntity;

public interface ConteudoRepository {
    public ConteudoEntity save(ConteudoEntity conteudo);
    public List<ConteudoEntity> listAll();
    public ConteudoEntity getById(Long id);
    public void delete(ConteudoEntity conteudo);
    public void upDate(Long id, ConteudoEntity conteudo);
    public List<ConteudoEntity> findBysignos(SignoZodiaco signos);
}
