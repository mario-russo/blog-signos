package mario.russo.core.ports.out;

import java.util.List;

import mario.russo.core.domain.Conteudo;

public interface ConteudoRepository {
    public Conteudo save(Conteudo conteudo);
    public List<Conteudo> listAll();
    public Conteudo getById(Long id);
    public void delete(Conteudo conteudo);
    public void upDate(Long id, Conteudo conteudo);
    public List<Conteudo> findBysignos(String signos);
}
