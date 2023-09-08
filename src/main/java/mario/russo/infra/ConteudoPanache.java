package mario.russo.infra;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import mario.russo.infra.entity.ConteudoEntity;

@ApplicationScoped
public class ConteudoPanache implements PanacheRepository<ConteudoEntity> {
    public List<ConteudoEntity> findBySigno(String signo) {
        return list("signo", signo);
    }

}
