package mario.russo.application.web;

import org.junit.jupiter.api.Test;

import jakarta.transaction.Transactional;
import mario.russo.core.domain.Conteudo;

import io.restassured.http.ContentType;


import static io.restassured.RestAssured.given;

public class ConteudoControllerTest {
    @Test
    public void testListAllConteudoEndpoint() {
        given()
            .when()
            .get("/conteudo")
            .then()
            .statusCode(200) // Verifique o código de status 200 (OK)
            .contentType(ContentType.JSON); // Verifique o tipo de conteúdo JSON
    }

    @Test
    public void testGetByIdEndpoint() {
        given()
            .pathParam("id", 1) // Substitua pelo ID existente
            .when()
            .get("/conteudo/{id}")
            .then()
            .statusCode(200) // Verifique o código de status 200 (OK)
            .contentType(ContentType.JSON); // Verifique o tipo de conteúdo JSON
    }

    @Test
    public void testGetBySignosEndpoint() {
        given()
            .pathParam("signo", "Áries") // Substitua pelo signo desejado
            .when()
            .get("/conteudo/signo/{signo}")
            .then()
            .statusCode(200) // Verifique o código de status 200 (OK)
            .contentType(ContentType.JSON); // Verifique o tipo de conteúdo JSON
    }

    @Test
    @Transactional
    public void testSaveEndpoint() {
        Conteudo conteudo = new Conteudo("aries","Conteudo","Referencia"); // Crie um objeto Conteudo com os dados desejados

        given()
            .body(conteudo)
            .contentType(ContentType.JSON)
            .when()
            .post("/conteudo")
            .then()
            .statusCode(200) // Verifique o código de status 200 (OK)
            .contentType(ContentType.JSON); // Verifique o tipo de conteúdo JSON
    }

    @Test
    @Transactional
    public void testUpDateEndpoint() {
        Conteudo conteudo = new Conteudo("aries","Conteudo","Referencia"); // Crie um objeto Conteudo com os dados desejados
        Long id = 1L; // Substitua pelo ID existente

        given()
            .pathParam("id", id)
            .body(conteudo)
            .contentType(ContentType.JSON)
            .when()
            .put("/conteudo/{id}")
            .then()
            .statusCode(204); // Verifique o código de status 204 (No Content)
    }
}
