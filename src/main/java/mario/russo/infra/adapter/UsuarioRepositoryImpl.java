package mario.russo.infra.adapter;

import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import mario.russo.application.Exception.ExceptionUsuario;
import mario.russo.core.domain.entity.UsuarioEntity;
import mario.russo.core.ports.out.RepositoryModel;
import mario.russo.infra.UsuarioPanache;

@ApplicationScoped
public class UsuarioRepositoryImpl implements RepositoryModel<UsuarioEntity> {

    @Inject
    private UsuarioPanache panache;

    @Override
    public UsuarioEntity save(UsuarioEntity usuario) {
        panache.persist(usuario);
        return usuario;
    }

    @Override
    public List<UsuarioEntity> listAll() {
        List<UsuarioEntity> listaDeentidade = panache.listAll();

        return listaDeentidade;
    }

    @Override
    public UsuarioEntity upDate(UsuarioEntity usuario, int id) {
        UsuarioEntity usuarioEntity = panache.findById(id);
        if (usuarioEntity == null) {
            throw new NotFoundException();
        }
        usuarioEntity.setEmail(usuario.getEmail());
        usuarioEntity.setNome(usuario.getNome());
        usuarioEntity.setRules(usuario.getRules());

        return usuarioEntity;
    }

    @Override
    public UsuarioEntity getById(int id) throws ExceptionUsuario {
        UsuarioEntity usuarioSalvo = panache.findById(id);
        if (usuarioSalvo == null)
            return null;
        return usuarioSalvo;
    }

    public UsuarioEntity getByEmail(String email) {
        UsuarioEntity usuarioSalvo = panache.find("email", email).firstResult();
        return usuarioSalvo;
    }

    public boolean delete(int id) {
        return panache.deleteById(id);
    }

}
