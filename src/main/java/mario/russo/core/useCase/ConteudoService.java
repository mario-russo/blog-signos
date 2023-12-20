package mario.russo.core.useCase;

import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mario.russo.application.Exception.ExceptionUsuario;
import mario.russo.core.domain.SignoZodiaco;
import mario.russo.core.domain.entity.ConteudoEntity;
import mario.russo.core.domain.entity.UsuarioEntity;
import mario.russo.core.dto.ConteudoRequestDTO;
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
        ConteudoEntity conteudoEntity = new ConteudoEntity(conteudo.signo(), conteudo.conteudo(), conteudo.referencia(),
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

    public List<ConteudoEntity> findBySignos(int signoId) {
        for (SignoZodiaco signo : SignoZodiaco.values()) {
            if (signo.getId() == signoId) {
                return repository.findBysignos(signo);
            }
        }

        throw new ExceptionUsuario(404,
                "Erro Ao Buscar conteudo do id: " + signoId);
    }

    public ConteudoEntity upDate(int id, ConteudoEntity conteudo) {
        ConteudoEntity entity = repository.upDate(id, conteudo);
        return entity;

    }

    public int delete(ConteudoEntity conteudoEntity) {
        ConteudoEntity conteudo = getById(conteudoEntity.getId());
        return repository.delete(conteudo);

    }

}
