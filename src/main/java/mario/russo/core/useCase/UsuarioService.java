package mario.russo.core.useCase;

import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import mario.russo.application.Exception.ExceptionUsuario;
import mario.russo.core.domain.entity.UsuarioEntity;
import mario.russo.core.ports.in.ServiceBase;
import mario.russo.infra.adapter.UsuarioRepositoryImpl;

@RequestScoped
public class UsuarioService implements ServiceBase<UsuarioEntity> {

    @Inject
    UsuarioRepositoryImpl repository;

    @Override
    public UsuarioEntity save(UsuarioEntity usuario) {
        UsuarioEntity usuarioSalvo = repository.save(usuario);
        return usuarioSalvo;
    }

    @Override
    public List<UsuarioEntity> listAll() {
        return repository.listAll();
    }

    @Override
    public UsuarioEntity upDate(UsuarioEntity usuario, int id) {
        return repository.upDate(usuario, id);
    }

    @Override
    public UsuarioEntity getById(int id) throws ExceptionUsuario {
        UsuarioEntity usuario = repository.getById(id);
        if (usuario == null)
            throw new ExceptionUsuario(Response.Status.NOT_FOUND.getStatusCode(),
                    "Erro Ao Buscar Usuario do id: " + id);
        return usuario;
    }

    public UsuarioEntity getByEmail(String email) {
        return repository.getByEmail(email);
    }

    public boolean deleteUsuario(int id) {
        return repository.delete(id);
    }

}
