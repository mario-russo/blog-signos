package mario.russo.core.useCase;

import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import mario.russo.core.domain.Usuario;
import mario.russo.core.ports.in.ServiceBase;
import mario.russo.infra.adapter.UsuarioRepositoryImpl;

@RequestScoped
public class UsuarioService implements ServiceBase<Usuario> {

    @Inject
    UsuarioRepositoryImpl repository;

    @Override
    public Usuario save(Usuario usuario) {
        Usuario usuarioSalvo = repository.save(usuario);
        return usuarioSalvo;
    }

    @Override
    public List<Usuario> listAll() {
        return repository.listAll();
    }

    @Override
    public Usuario upDate(Usuario usuario, Long id) {
        return repository.upDate(usuario, id);
    }

    @Override
    public Usuario getById(Long id) {
        return repository.getById(id);
    }

    public Usuario getByEmail(String email) {
        return repository.getByEmail(email);
    }

}
