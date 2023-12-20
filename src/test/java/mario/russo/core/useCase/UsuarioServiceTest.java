package mario.russo.core.useCase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import mario.russo.application.Exception.ExceptionUsuario;
import mario.russo.core.domain.entity.UsuarioEntity;
import mario.russo.infra.adapter.UsuarioRepositoryImpl;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {
    @Mock
    UsuarioRepositoryImpl repository;
    @InjectMocks
    UsuarioService service;

    @BeforeEach
    void inicio() {
        MockitoAnnotations.openMocks(this);

    }

    @Test
    void testGetById() throws ExceptionUsuario {
        UsuarioEntity entity = new UsuarioEntity("mario", "mario@mario", "1234");

        when(repository.getById(1)).thenReturn(entity);

        UsuarioEntity resultadoUsuario = service.getById(1);

        verify(repository, times(1)).getById(1);

        assertNotNull(resultadoUsuario);
        assertEquals("mario", resultadoUsuario.getNome());
        assertEquals("mario@mario", resultadoUsuario.getEmail());

    }

    @Test
    void testListAll() {
        List<UsuarioEntity> listaDeUsuarios = List.of(
                new UsuarioEntity("mario", "mario@mario", "1234"),
                new UsuarioEntity("mario", "mario@mario", "1234"),
                new UsuarioEntity("mario", "mario@mario", "1234"));

        when(repository.listAll()).thenReturn(listaDeUsuarios);

        List<UsuarioEntity> resul = service.listAll();
        verify(repository, times(1)).listAll();
        assertEquals(3, resul.size());
    }

    @Test
    void testSave() {
        UsuarioEntity usuario = new UsuarioEntity("mario", "mario@mario", "1234");
        when(repository.save(usuario)).thenReturn(usuario);

        var result = service.save(usuario);
        verify(repository, times(1)).save(usuario);

        assertEquals(usuario.getEmail(), result.getEmail());
        assertEquals(usuario.getNome(), result.getNome());

    }

    @Test
    void testUpDate() {
        int idDoUsuario = 1;
        UsuarioEntity usuarioMock = new UsuarioEntity("mario", "mario@mario", "1234");

        when(repository.upDate(usuarioMock, idDoUsuario)).thenReturn(usuarioMock);

        UsuarioEntity usuarioAtualizado = service.upDate(usuarioMock, idDoUsuario);

        verify(repository, times(1)).upDate(usuarioMock, idDoUsuario);

        assertEquals(usuarioMock.getEmail(), usuarioAtualizado.getEmail());
        assertEquals(usuarioMock.getNome(), usuarioAtualizado.getNome());
    }

    @Test
    void testGetByEmail() {
        String email = "mario@mario";
        UsuarioEntity usuarioMock = new UsuarioEntity("mario", "mario@mario", "1234");

        when(repository.getByEmail(email)).thenReturn(usuarioMock);

        UsuarioEntity resultadoEmail = service.getByEmail(email);

        verify(repository, times(1)).getByEmail(email);

        assertEquals(email, resultadoEmail.getEmail());

    }
}
