package br.com.luizgoncalo.paymentuser.integration;

import br.com.luizgoncalo.paymentuser.base.BaseIntegrationTest;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PaymentUserResourceIntegrationTest extends BaseIntegrationTest {

    @Test
    @DisplayName("Verificar usuario ativo")
    public void verifyUserActive(){

        RestAssured
            .given()
                .log().all()
            .when()
                .get("/payment-user/12343223432")
            .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .body("active", Matchers.is(true));

    }

    @Test
    @DisplayName("Verificar usuario inativo")
    public void verifyUserInactive(){

        RestAssured
            .given()
                .log().all()
            .when()
                .get("/payment-user/12212121234")
            .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .body("active", Matchers.is(false));

    }

    @Test
    @DisplayName("Verificar NOT FOUND(404)")
    public void verifyUserError(){

        RestAssured
            .given()
                .log().all()
            .when()
                .get("/payment-user")
            .then()
                .log().all()
                .statusCode(HttpStatus.SC_NOT_FOUND);

    }

}
