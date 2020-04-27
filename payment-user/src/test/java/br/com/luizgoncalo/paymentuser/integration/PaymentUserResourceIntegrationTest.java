package br.com.luizgoncalo.paymentuser.integration;

import br.com.luizgoncalo.paymentuser.base.BaseIntegrationTest;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PaymentUserResourceIntegrationTest extends BaseIntegrationTest {

    @Test
    public void verifyUser(){

        RestAssured
                .given()
                .log().all()
                .when()
                .get("/payment-user/12343223433")
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK);

    }

    @Test
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
