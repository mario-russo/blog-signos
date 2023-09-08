package mario.russo.core.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConteudoTest {
    @Test
    void testconteudo(){
        var signo ="aries";
        var post = "novo conteudo";
        var referencia = "samana 1";


        var conteudo = new Conteudo(signo, post, referencia);

        assertEquals(signo,conteudo.getSigno());
        assertEquals(post,conteudo.getConteudo()); 
        assertEquals(referencia,conteudo.getReferencia()); 
    }

    @Test
    void testSignoVazio(){
        var conteudo = new Conteudo();

        assertThrows(IllegalArgumentException.class, ()->{
            conteudo.setSigno("");
        });
    }

    @DisplayName("Dado um Referência retorna um IllegalArgumentExeption")
    @Test
    void testReferenciaVazio(){

        var conteudo = new Conteudo();

        assertThrows(IllegalArgumentException.class, ()->{
            conteudo.setReferencia("");
        } );
    }

    @DisplayName("Dado um Conteudo vázio retorna um IllegalArgumentExeption")
    @Test
    void testConteudoVazio(){
        
        var conteudo = new Conteudo();

        assertThrows(IllegalArgumentException.class, ()->{
            
            conteudo.setConteudo("");
        });
    }
}
