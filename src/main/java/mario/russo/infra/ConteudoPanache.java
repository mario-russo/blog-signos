package mario.russo.infra;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import mario.russo.core.domain.SignoZodiaco;
import mario.russo.core.domain.TipoReferencia;
import mario.russo.core.domain.entity.ConteudoEntity;

@ApplicationScoped
public class ConteudoPanache implements PanacheRepositoryBase<ConteudoEntity, Integer> {
    public List<ConteudoEntity> findBySigno(SignoZodiaco signo) {
        return list("signo", signo);
    }

    public ConteudoEntity buscaPorSignoTipoReferencia(SignoZodiaco signo, TipoReferencia tipo, int referencia) {
        return find("signo = ?1 and referencia = ?2 and tipo = ?3", signo, referencia, tipo).firstResult();
    }

}
