package mario.russo.core.ports.out;

import java.util.List;

import mario.russo.application.Exception.ExceptionUsuario;

public interface RepositoryModel<T> {
     T save(T usuario);

     List<T> listAll();

     T getById(int id) throws ExceptionUsuario;

     T upDate(T usuario, int id);
}
