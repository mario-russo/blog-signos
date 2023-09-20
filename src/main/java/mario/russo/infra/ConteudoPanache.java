package mario.russo.infra;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import mario.russo.infra.entity.ConteudoEntity;

@ApplicationScoped
public class ConteudoPanache implements PanacheRepositoryBase<ConteudoEntity, Long> {
    public List<ConteudoEntity> findBySigno(String signo) {
        return list("signo", signo);
    }

}
