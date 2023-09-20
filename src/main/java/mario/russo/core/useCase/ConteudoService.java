package mario.russo.core.useCase;

import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mario.russo.core.domain.Conteudo;
import mario.russo.core.ports.in.ConteudoSave;
import mario.russo.infra.adapter.ConteudoRepositoryImpl;

@ApplicationScoped
public class ConteudoService implements ConteudoSave {

    @Inject
    private ConteudoRepositoryImpl repository;

    public ConteudoService(ConteudoRepositoryImpl repository) {
        this.repository = repository;
    }

    /**
     * @return
     */
    @Override
    public Conteudo save(Conteudo conteudo) {
        Conteudo conteudoResult = repository.save(conteudo);
        return conteudoResult;
    }

    public List<Conteudo> listAll() {
        return repository.listAll();
    }

    public Conteudo getById(long id) {
        Conteudo conteudo = repository.getById(id);
        return conteudo;
    }

    public List<Conteudo> findBySignos(String signo) {
        return repository.findBysignos(signo);
    }

    public void upDate(Long id, Conteudo conteudo) {
        repository.upDate(id, conteudo);

    }

}
