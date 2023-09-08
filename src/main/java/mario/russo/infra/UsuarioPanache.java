package mario.russo.infra;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import mario.russo.infra.entity.UsuarioEntity;

@ApplicationScoped
public class UsuarioPanache implements PanacheRepository<UsuarioEntity>{
    public UsuarioEntity findByEmail(String email){
        return find("email", email).firstResult();
    }
}
