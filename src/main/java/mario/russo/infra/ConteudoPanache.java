package mario.russo.infra;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import mario.russo.core.domain.SignoZodiaco;
import mario.russo.core.domain.entity.ConteudoEntity;

@ApplicationScoped
public class ConteudoPanache implements PanacheRepositoryBase<ConteudoEntity, Integer> {
    public List<ConteudoEntity> findBySigno(SignoZodiaco signo) {
        return list("signo", signo);
    }

}
