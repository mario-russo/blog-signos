package mario.russo.core.useCase;

import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mario.russo.core.domain.SignoZodiaco;
import mario.russo.core.domain.entity.ConteudoEntity;
import mario.russo.core.domain.entity.UsuarioEntity;
import mario.russo.core.dto.BuscaTudo;
import mario.russo.core.dto.ConteudoRequestDTO;
import mario.russo.core.dto.ConteudoResponseDTO;
import mario.russo.infra.adapter.ConteudoRepositoryImpl;

@ApplicationScoped
public class ConteudoService {

    @Inject
    private ConteudoRepositoryImpl repository;
    @Inject
    private UsuarioService usuarioservice;

    public ConteudoService(ConteudoRepositoryImpl repository) {
        this.repository = repository;
    }

    public ConteudoEntity save(ConteudoRequestDTO conteudo) {
        UsuarioEntity usuario = usuarioservice.getById(conteudo.idUsuario());
        ConteudoEntity conteudoEntity = new ConteudoEntity(conteudo.signo(), conteudo.tipo(), conteudo.conteudo(),
                conteudo.referencia(),
                usuario);

        ConteudoEntity conteudoResult = repository.save(conteudoEntity);
        return conteudoResult;
    }

    public List<ConteudoEntity> listAll() {
        return repository.listAll();
    }

    public ConteudoEntity getById(int id) {
        ConteudoEntity conteudo = repository.getById(id);
        return conteudo;
    }

    public List<ConteudoEntity> findBySignos(SignoZodiaco signo) {
        return repository.findBysignos(signo);

    }

    public ConteudoEntity upDate(int id, ConteudoEntity conteudo) {
        ConteudoEntity entity = repository.upDate(id, conteudo);
        return entity;

    }

    public int delete(ConteudoEntity conteudoEntity) {
        ConteudoEntity conteudo = getById(conteudoEntity.getId());
        return repository.delete(conteudo);

    }

    public ConteudoResponseDTO buscaTudo(BuscaTudo buscaTudo) {
        ConteudoEntity conteudo = repository.buscaTudo(buscaTudo.signo(), buscaTudo.tipo(), buscaTudo.referencia());
        return new ConteudoResponseDTO(conteudo);
    }

}
