package mario.russo.core.useCase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import mario.russo.core.domain.SignoZodiaco;
import mario.russo.core.domain.entity.ConteudoEntity;
import mario.russo.core.domain.entity.UsuarioEntity;
import mario.russo.infra.adapter.ConteudoRepositoryImpl;

@ExtendWith(MockitoExtension.class)
public class ConteudoServiceTest {

    @Mock
    ConteudoRepositoryImpl repository;

    @InjectMocks
    ConteudoService conteudoService;

    // private ArgumentCaptor<Conteudo> argumentCaptor = ArgumentCaptor.forClass(Conteudo.class);

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Dado um Conteudo Salva no repositorio")
    void testSave() {
        ConteudoEntity conteudo = new ConteudoEntity(SignoZodiaco.ARIES, "conteudo", "refereincia",
                new UsuarioEntity("MARIO", "MARIO@MARIO", "12345"));

        when(repository.save(conteudo)).thenReturn(conteudo);

        ConteudoEntity conteudoSalvo = repository.save(conteudo);

        verify(repository, times(1)).save(conteudo);

        assertEquals(ConteudoEntity.class, conteudoSalvo.getClass());

    }

    @Test
    void listaTodosConteudos() {
        List<ConteudoEntity> conteudoList = List.of(
                new ConteudoEntity(SignoZodiaco.ARIES, "Conteudo", "1234",
                        new UsuarioEntity("mario", "mario@mario", "1234")),
                new ConteudoEntity(SignoZodiaco.ARIES, "Outra Referência", "567a8",
                        new UsuarioEntity("mario", "mario@mario", "1234")));

        when(repository.listAll()).thenReturn(conteudoList);

        List<ConteudoEntity> result = conteudoService.listAll();

        verify(repository, times(1)).listAll();

        assertEquals(conteudoList.size(), 2);
        assertEquals(ConteudoEntity.class, result.get(0).getClass());
    }

    @Test
    void retornaUmConteudoDadoUmId() {
        UsuarioEntity usuario = new UsuarioEntity("mario", "mario@mario", "1234");
        ConteudoEntity conteudoPeloId = new ConteudoEntity(SignoZodiaco.ARIES, "Outra Referencia", "567a8", usuario);

        when(repository.getById(1L)).thenReturn(conteudoPeloId);

        ConteudoEntity result = conteudoService.getById(1L);

        verify(repository, times(1)).getById(1L);

        assertEquals(ConteudoEntity.class, result.getClass());
        assertEquals(SignoZodiaco.ARIES, result.getSigno());
        assertEquals("Outra Referencia", result.getConteudo());
        assertEquals("567a8", result.getReferencia());

    }

    @Test
    void dadoUmConteudoAtualiza() {
        ConteudoEntity conteudoPeloId = new ConteudoEntity(SignoZodiaco.ARIES, "Outra Referencia", "567a8",
                new UsuarioEntity("mario", "mario@mario", "1234"));

        repository.upDate(1l, conteudoPeloId);

        verify(repository, times(1)).upDate(1L, conteudoPeloId);
    }

}
