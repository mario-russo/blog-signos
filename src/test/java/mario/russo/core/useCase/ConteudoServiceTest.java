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
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import mario.russo.core.domain.Conteudo;
import mario.russo.core.domain.SignoZodiaco;
import mario.russo.core.domain.Usuario;
import mario.russo.core.ports.out.ConteudoRepository;

@ExtendWith(MockitoExtension.class)
public class ConteudoServiceTest {

    @Mock
    ConteudoRepository repository;

    @InjectMocks
    ConteudoService conteudoService;

    private ArgumentCaptor<Conteudo> argumentCaptor = ArgumentCaptor.forClass(Conteudo.class);

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Dado um Conteudo Salva no repositorio")
    void testSave() {
        var conteudo = new Conteudo(SignoZodiaco.ARIES, "mario@mario", "1234",
                new Usuario("mario", "mario@mario", "1234"));

        conteudoService.save(conteudo);

        verify(repository, times(1)).save(argumentCaptor.capture());
        Conteudo result = argumentCaptor.getValue();

        assertEquals(conteudo.getConteudo(), result.getConteudo());
        assertEquals(conteudo.getReferencia(), result.getReferencia());
        assertEquals(conteudo.getSigno(), result.getSigno());
    }

    @Test
    void listaTodosConteudos() {
        List<Conteudo> conteudoList = List.of(
                new Conteudo(SignoZodiaco.ARIES, "Conteudo", "1234", new Usuario("mario", "mario@mario", "1234")),
                new Conteudo(SignoZodiaco.ARIES, "Outra Referência", "567a8",
                        new Usuario("mario", "mario@mario", "1234")));

        when(repository.listAll()).thenReturn(conteudoList);

        List<Conteudo> result = conteudoService.listAll();

        verify(repository, times(1)).listAll();

        assertEquals(conteudoList.size(), 2);
        assertEquals(Conteudo.class, result.get(0).getClass());
    }

    @Test
    void retornaUmConteudoDadoUmId() {
        Conteudo conteudoPeloId = new Conteudo(SignoZodiaco.ARIES, "Outra Referencia", "567a8",
                new Usuario("mario", "mario@mario", "1234"));

        when(repository.getById(1L)).thenReturn(conteudoPeloId);

        Conteudo result = conteudoService.getById(1L);

        verify(repository, times(1)).getById(1L);

        assertEquals(Conteudo.class, result.getClass());
        assertEquals(SignoZodiaco.ARIES, result.getSigno());
        assertEquals("Outra Referencia", result.getConteudo());
        assertEquals("567a8", result.getReferencia());

    }

    @Test
    void dadoUmConteudoAtualiza() {
        Conteudo conteudoPeloId = new Conteudo(SignoZodiaco.ARIES, "Outra Referencia", "567a8",
                new Usuario("mario", "mario@mario", "1234"));

        repository.upDate(1l, conteudoPeloId);

        verify(repository, times(1)).upDate(1L, conteudoPeloId);
    }

}
