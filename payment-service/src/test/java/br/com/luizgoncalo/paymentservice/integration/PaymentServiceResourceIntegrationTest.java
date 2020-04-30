package br.com.luizgoncalo.paymentservice.integration;

import br.com.luizgoncalo.paymentservice.base.BaseIntegrationTest;
import br.com.luizgoncalo.paymentservice.domain.request.PaymentRequest;
import io.restassured.RestAssured;
import java.math.BigDecimal;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PaymentServiceResourceIntegrationTest extends BaseIntegrationTest {

    @Test
    public void savePayment(){

        // @formatter:off
        RestAssured
                .given()
                    .log().all()
                    .body(createPaymentRequest())
                .when()
                    .post("/payment")
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_CREATED)
                    .body("status", Matchers.is(201));
        // @formatter:on
    }

    private PaymentRequest createPaymentRequest() {
        final PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setCpf("1234563344");
        paymentRequest.setPaymentIdentification(122222L);
        paymentRequest.setValue(new BigDecimal(345.90));

        return paymentRequest;
    }
}
