package mario.russo.core.ports.in;

import java.util.List;

public interface ServiceBase<T> {
    T save(T usuario);

    List<T> listAll();

    T getById(Long id);

    T upDate(T usuario, Long id);
}
