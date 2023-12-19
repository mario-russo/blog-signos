package mario.russo.infra.adapter;

import java.util.List;
import java.util.Optional;
import jakarta.ejb.ObjectNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mario.russo.core.domain.SignoZodiaco;
import mario.russo.core.domain.entity.ConteudoEntity;
import mario.russo.core.ports.out.ConteudoRepository;
import mario.russo.infra.ConteudoPanache;

@ApplicationScoped
public class ConteudoRepositoryImpl implements ConteudoRepository {
    @Inject
    private ConteudoPanache conteudoPanache;

    @Override
    public Long delete(ConteudoEntity conteudo) {

        long delete = conteudoPanache.delete("id", conteudo.getId());
        return delete;
    }

    @Override
    public ConteudoEntity getById(Long id) {
        Optional<ConteudoEntity> conteudoResultado = conteudoPanache.findByIdOptional(id);

        if (!conteudoResultado.isPresent()) {
            try {
                throw new ObjectNotFoundException("Conteudo Não Encontrado");
            } catch (ObjectNotFoundException e) {
                e.printStackTrace();
            }
        }

        return conteudoResultado.get();

    }

    @Override
    public List<ConteudoEntity> listAll() {

        List<ConteudoEntity> conteudoSalvo = conteudoPanache.listAll();

        return conteudoSalvo;
    }

    @Override
    public ConteudoEntity save(ConteudoEntity conteudo) {

        conteudoPanache.persist(conteudo);
        return conteudo;

    }

    @Override
    public void upDate(Long id, ConteudoEntity conteudo) {
        ConteudoEntity conteudoEntity = conteudoPanache.findById(id);
        conteudoEntity.setReferencia(conteudo.getReferencia());
        conteudoEntity.setSigno(conteudo.getSigno());
        conteudoEntity.setConteudo(conteudo.getConteudo());

        conteudoPanache.persist(conteudoEntity);
    }

    @Override
    public List<ConteudoEntity> findBysignos(SignoZodiaco signos) {
        var conteudoList = conteudoPanache.findBySigno(signos);
        return conteudoList;
    }

}
