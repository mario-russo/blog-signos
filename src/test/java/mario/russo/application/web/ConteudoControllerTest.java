package mario.russo.application.web;

import org.junit.jupiter.api.Test;

import jakarta.transaction.Transactional;
import mario.russo.core.domain.SignoZodiaco;
import mario.russo.core.domain.entity.ConteudoEntity;
import mario.russo.core.domain.entity.UsuarioEntity;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class ConteudoControllerTest {
    @Test
    public void testListAllConteudoEndpoint() {

        // given()
        //         .when()
        //         .get("/conteudo")
        //         .then()
        //         .statusCode(200) // Verifique o código de status 200 (OK)
        //         .contentType(ContentType.JSON); // Verifique o tipo de conteúdo JSON
    }

    @Test
    public void testGetByIdEndpoint() {
        given()
                .pathParam("id", 1) // Substitua pelo ID existente
                .when()
                .get("/conteudo/{id}")
                .then();
        // .statusCode(200) // Verifique o código de status 200 (OK)
        // .contentType(ContentType.JSON); // Verifique o tipo de conteúdo JSON
    }

    @Test
    public void testGetBySignosEndpoint() {
        given()
                .pathParam("signo", "aries") // Substitua pelo signo desejado
                .when()
                .get("/conteudo/signo/{signo}");
        // .then()
        // .statusCode(200) // Verifique o código de status 200 (OK)
        // .contentType(ContentType.JSON); // Verifique o tipo de conteúdo JSON
    }

    @Test
    @Transactional
    public void testSaveEndpoint() {
        ConteudoEntity conteudo = new ConteudoEntity(SignoZodiaco.ARIES, "Conteudo", "Referencia",
                new UsuarioEntity("mario", "mario@mario", "1234")); // Crie um objeto Conteudo com os dados desejados

        given()
                .body(conteudo)
                .contentType(ContentType.JSON)
                .when()
                .post("/conteudo")
                .then();
        // .statusCode(200) // Verifique o código de status 200 (OK)
        // .contentType(ContentType.JSON); // Verifique o tipo de conteúdo JSON
    }

    @Test
    @Transactional
    public void testUpDateEndpoint() {
        ConteudoEntity conteudo = new ConteudoEntity(SignoZodiaco.LEAO, "Conteudo", "Referencia",
                new UsuarioEntity("mario", "mario@mario", "1234")); // Crie um objeto Conteudo com os
        // dados desejados
        Long id = 1L; // Substitua pelo ID existente

        given()
                .pathParam("id", id)
                .body(conteudo)
                .contentType(ContentType.JSON)
                .when()
                .put("/conteudo/{id}")
                .then();
        // .statusCode(204); // Verifique o código de status 204 (No Content)
    }
}
