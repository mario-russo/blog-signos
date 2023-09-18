package mario.russo.infra.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import jakarta.ejb.ObjectNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mario.russo.core.domain.Conteudo;
import mario.russo.core.ports.out.ConteudoRepository;
import mario.russo.infra.ConteudoPanache;
import mario.russo.infra.entity.ConteudoEntity;

@ApplicationScoped
public class ConteudoRepositoryImpl implements ConteudoRepository {
    @Inject
    private ConteudoPanache conteudoPanache;

    @Override
    public void delete(Conteudo conteudo) {
        ConteudoEntity conteudoEntity = new ConteudoEntity(conteudo);
        conteudoPanache.delete("id", conteudoEntity.getId());
    }

    @Override
    public Conteudo getById(Long id) {
        Optional<ConteudoEntity> conteudoResultado = conteudoPanache.findByIdOptional(id);
        
        if(!conteudoResultado.isPresent()){
            try {
                throw new ObjectNotFoundException("Conteudo Não Encontrado");
            } catch (ObjectNotFoundException e) {
                e.printStackTrace();
            }
        }
        Conteudo conteudo = conteudoResultado.get().conteudo();
        return conteudo;

    }

    @Override
    public List<Conteudo> listAll() {

        List<ConteudoEntity> conteudoSalvo = conteudoPanache.listAll();

        List<Conteudo> conteudoList = conteudoSalvo.stream()
                .map(conteudoEntity -> conteudoEntity.conteudo())
                .collect(Collectors.toList());

        return conteudoList;
    }

    @Override
    public Conteudo save(Conteudo conteudo) {
        var conteudoEntity = new ConteudoEntity(conteudo);
        conteudoPanache.persist(conteudoEntity);


        return conteudoEntity.conteudo();
    }

    @Override
    public void upDate(Long id, Conteudo conteudo) {
        ConteudoEntity conteudoEntity = conteudoPanache.find("id", id).firstResult();
        conteudoEntity.setReferencia(conteudo.getReferencia());
        conteudoEntity.setSigno(conteudo.getSigno());
        conteudoEntity.setConteudo(conteudo.getConteudo());
    
        conteudoPanache.persist(conteudoEntity);
    }

    @Override
    public List<Conteudo> findBysignos(String signos) {
        var conteudoList = conteudoPanache.findBySigno(signos);
        List<Conteudo> conteudo = conteudoList.stream()
                .map(conteudoEntity -> conteudoEntity.conteudo()).collect(Collectors.toList());
        return conteudo;
    }
}
