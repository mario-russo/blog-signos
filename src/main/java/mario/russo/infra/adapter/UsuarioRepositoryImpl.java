package mario.russo.infra.adapter;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import mario.russo.application.Exception.ExceptionUsuario;
import mario.russo.core.domain.Usuario;
import mario.russo.core.ports.out.RepositoryModel;
import mario.russo.infra.UsuarioPanache;
import mario.russo.infra.entity.UsuarioEntity;

@ApplicationScoped
public class UsuarioRepositoryImpl implements RepositoryModel<Usuario> {

    @Inject
    private UsuarioPanache panache;

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        panache.persist(usuarioEntity);
        return usuarioEntity.getUsuario();
    }

    @Override
    public List<Usuario> listAll() {
        List<UsuarioEntity> listaDeentidade = panache.listAll();

        return listaDeentidade.stream().map(entity -> entity.getUsuario()).collect(Collectors.toList());
    }

    @Override
    public Usuario upDate(Usuario usuario, Long id) {
        UsuarioEntity usuarioEntity = panache.findById(id);

        usuarioEntity.setEmail(usuario.getEmail());
        usuarioEntity.setNome(usuario.getNome());

        usuarioEntity.persist();

        return usuarioEntity.getUsuario();
    }

    @Override
    public Usuario getById(Long id) throws ExceptionUsuario {
        UsuarioEntity usuarioSalvo = panache.findById(id);
        if (usuarioSalvo == null)
           return null;
        return usuarioSalvo.getUsuario();
    }

    public Usuario getByEmail(String email) {
        UsuarioEntity usuarioSalvo = panache.find("email", email).firstResult();
        return usuarioSalvo.getUsuario();
    }

}
