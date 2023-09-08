// package mario.russo;

// import io.quarkus.test.junit.QuarkusTest;
// import mario.russo.core.domain.Usuario;

// import org.junit.jupiter.api.Test;

// import static io.restassured.RestAssured.given;
// import static org.hamcrest.CoreMatchers.is;

// @QuarkusTest
// public class GreetingResourceTest {

//     @Test
//     public void testHelloEndpoint() {
//         var usuario = new Usuario("mario", "mario@mario", "1234");
//         given()
//                 .when().get("/hello")
//                 .then()
//                 .statusCode(200)
//                 .body();
//     }

// }