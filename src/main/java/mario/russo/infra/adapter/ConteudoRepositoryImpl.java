package mario.russo.infra.adapter;

import java.util.List;
import java.util.Optional;

import jakarta.ejb.ObjectNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import mario.russo.core.domain.SignoZodiaco;
import mario.russo.core.domain.entity.ConteudoEntity;
import mario.russo.core.ports.out.ConteudoRepository;
import mario.russo.infra.ConteudoPanache;

@ApplicationScoped
public class ConteudoRepositoryImpl implements ConteudoRepository {
    @Inject
    private ConteudoPanache conteudoPanache;

    @Override
    public int delete(ConteudoEntity conteudo) {

        boolean delete = conteudoPanache.deleteById(conteudo.getId());
        if (delete) {
            return conteudo.getId();
        } else {
            return conteudo.getId();
        }
    }

    @Override
    public ConteudoEntity getById(int id) {
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
    public ConteudoEntity upDate(int id, ConteudoEntity conteudo) {
        ConteudoEntity entity = conteudoPanache.findById(id);
        if (entity == null) {
            throw new NotFoundException();
        }
        entity.setConteudo(conteudo.getConteudo());
        entity.setSigno(conteudo.getSigno());
        entity.setReferencia(conteudo.getReferencia());
        return entity;
    }

    @Override
    public List<ConteudoEntity> findBysignos(SignoZodiaco signos) {
        var conteudoList = conteudoPanache.findBySigno(signos);
        return conteudoList;
    }

}
