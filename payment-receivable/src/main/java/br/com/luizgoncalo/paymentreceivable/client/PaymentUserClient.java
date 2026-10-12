package br.com.luizgoncalo.paymentreceivable.client;

import br.com.luizgoncalo.paymentreceivable.domain.reponse.UserResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class PaymentUserClient {

    private final RestClient restClient = RestClient.builder()
            .baseUrl("http://localhost:8082")
            .build();

    public UserResponse verifyUser(final String cpf) {
        return restClient.get()
                .uri("/payment-user/{cpf}", cpf)
                .retrieve()
                .body(UserResponse.class);
    }

}
