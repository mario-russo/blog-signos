package mario.russo.core.ports.out;

import java.util.List;

public interface RepositoryModel<T> {
     T save(T usuario);

     List<T> listAll();

     T getById(Long id);

     T upDate(T usuario, Long id);
}
