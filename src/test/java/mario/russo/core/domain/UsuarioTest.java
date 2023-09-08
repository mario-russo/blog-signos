package mario.russo.core.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

    @Test
    public void testUsuario() {
        var nome = "mario";
        var senha = "1234";
        var email = "mario@email";

        var usuario = new Usuario(nome, email, senha);

        assertEquals(nome, usuario.getNome());
        assertEquals(senha, usuario.getSenha());
        assertEquals(email, usuario.getEmail());
    }
    @DisplayName("Dado um um Nome vázio retorna um erro IllegalArgumentException")
    @Test
    void testSetNomeVazio() {
        var usuario = new Usuario();

        assertThrows(IllegalArgumentException.class, () -> {
            usuario.setNome("");
        });
    }

    @DisplayName("Dado um um E-mail vázio retorna um erro IllegalArgumentException")
    @Test
    void testemailVazio() {
        var usuario = new Usuario();

        assertThrows(IllegalArgumentException.class, () -> {
            usuario.setEmail("");
        });
    }
    
    @DisplayName("Dado uma Senha vázia retorna um erro IllegalArgumentException")
    @Test
    void testSenhaVazia (){

        var usuario = new Usuario();

        assertThrows(IllegalArgumentException.class, ()->{
            usuario.setSenha("");
        });
    }
}
