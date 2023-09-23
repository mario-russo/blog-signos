package mario.russo.infra;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import mario.russo.core.domain.entity.UsuarioEntity;

@ApplicationScoped
public class UsuarioPanache implements PanacheRepositoryBase<UsuarioEntity, Long> {
    public UsuarioEntity findByEmail(String email) {
        return find("email", email).firstResult();
    }
}
