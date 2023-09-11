package mario.russo.core.useCase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
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
import mario.russo.core.domain.Usuario;
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
        Usuario usuario = new Usuario("João", "email@email", "1234");
        when(repository.getById(any())).thenReturn(usuario);

        Usuario resultadoUsuario = service.getById(any());

        verify(repository, times(1)).getById(any());

        assertNotNull(resultadoUsuario);
        assertEquals("João", resultadoUsuario.getNome());
        assertEquals("email@email", resultadoUsuario.getEmail());

    }

    @Test
    void testListAll() {
        List<Usuario> listaDeUsuarios = List.of(
                new Usuario("João", "email@email", "1234"),
                new Usuario("Maria", "email@email", "1234"),
                new Usuario("José", "email@email", "1234"));

        when(repository.listAll()).thenReturn(listaDeUsuarios);

        List<Usuario> resul = service.listAll();
        verify(repository, times(1)).listAll();
        assertEquals(3, resul.size());
    }

    @Test
    void testSave() {
        Usuario usuario = new Usuario("mario", "meario@russo", "1234");
        when(repository.save(usuario)).thenReturn(usuario);

        var result = service.save(usuario);
        verify(repository, times(1)).save(usuario);

        assertEquals(usuario.getEmail(), result.getEmail());

    }

    @Test
    void testUpDate() {
        Long idDoUsuario = 1L;
        Usuario usuarioMock = new Usuario("mario", "mario@mario", "132");

        when(repository.upDate(usuarioMock, idDoUsuario)).thenReturn(usuarioMock);

        Usuario usuarioAtualizado = service.upDate(usuarioMock, idDoUsuario);

        verify(repository, times(1)).upDate(usuarioMock, idDoUsuario);

        assertEquals(usuarioMock.getEmail(), usuarioAtualizado.getEmail());
        assertEquals(usuarioMock.getNome(), usuarioAtualizado.getNome());
    }

    @Test
    void testGetByEmail() {
        String email = "mario@mario";
        Usuario usuarioMock = new Usuario("mario", "mario@mario", "123");

        when(repository.getByEmail(email)).thenReturn(usuarioMock);

        Usuario resultadoEmail = service.getByEmail(email);

        verify(repository, times(1)).getByEmail(email);
        
        assertEquals(email, resultadoEmail.getEmail());


    }
}
