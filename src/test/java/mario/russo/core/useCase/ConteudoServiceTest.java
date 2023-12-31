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
import mario.russo.core.domain.TipoReferencia;
import mario.russo.core.domain.entity.ConteudoEntity;
import mario.russo.core.domain.entity.UsuarioEntity;
import mario.russo.infra.adapter.ConteudoRepositoryImpl;

@ExtendWith(MockitoExtension.class)
public class ConteudoServiceTest {

    @Mock
    ConteudoRepositoryImpl repository;

    @InjectMocks
    ConteudoService conteudoService;

    // private ArgumentCaptor<Conteudo> argumentCaptor =
    // ArgumentCaptor.forClass(Conteudo.class);

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Dado um Conteudo Salva no repositorio")
    void testSave() {
        ConteudoEntity conteudo = new ConteudoEntity(SignoZodiaco.ARIES, TipoReferencia.SEMANA, "conteudo",
                1,
                new UsuarioEntity("MARIO", "MARIO@MARIO", "12345"));

        when(repository.save(conteudo)).thenReturn(conteudo);

        ConteudoEntity conteudoSalvo = repository.save(conteudo);

        verify(repository, times(1)).save(conteudo);

        assertEquals(ConteudoEntity.class, conteudoSalvo.getClass());

    }

    @Test
    void listaTodosConteudos() {
        List<ConteudoEntity> conteudoList = List.of(
                new ConteudoEntity(SignoZodiaco.ARIES, TipoReferencia.SEMANA, "Conteudo", 1,
                        new UsuarioEntity("mario", "mario@mario", "1234")),
                new ConteudoEntity(SignoZodiaco.ARIES, TipoReferencia.SEMANA, "Outra Referência", 2,
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
        ConteudoEntity conteudoPeloId = new ConteudoEntity(SignoZodiaco.ARIES, TipoReferencia.MES, "Outra Referencia",
                2, usuario);

        when(repository.getById(1)).thenReturn(conteudoPeloId);

        ConteudoEntity result = conteudoService.getById(1);

        verify(repository, times(1)).getById(1);

        assertEquals(ConteudoEntity.class, result.getClass());
        assertEquals(SignoZodiaco.ARIES, result.getSigno());
        assertEquals("Outra Referencia", result.getConteudo());
        assertEquals(2, result.getReferencia());

    }

    @Test
    void dadoUmConteudoAtualiza() {
        ConteudoEntity conteudoPeloId = new ConteudoEntity(SignoZodiaco.ARIES, TipoReferencia.MES, "Outra Referencia",
                3,
                new UsuarioEntity("mario", "mario@mario", "1234"));

        repository.upDate(1, conteudoPeloId);

        verify(repository, times(1)).upDate(1, conteudoPeloId);
    }

}
