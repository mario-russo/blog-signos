package mario.russo.core.ports.in;

import java.util.List;

import mario.russo.application.Exception.ExceptionUsuario;

public interface ServiceBase<T> {
    T save(T usuario);

    List<T> listAll();

    T getById(int id) throws ExceptionUsuario;

    T upDate(T usuario, int id);
}
