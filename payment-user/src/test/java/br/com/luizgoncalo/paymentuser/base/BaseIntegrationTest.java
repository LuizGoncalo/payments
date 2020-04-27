package br.com.luizgoncalo.paymentuser.base;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.web.server.LocalServerPort;

public class BaseIntegrationTest {

    @LocalServerPort
    private Integer port;

    @BeforeEach
    public void before(){
        RestAssured.port = port;
    }
}
