package br.com.luizgoncalo.paymentreceivable.client;

import br.com.luizgoncalo.paymentreceivable.domain.request.PaymentServiceRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class PaymentServiceClient {

    private final RestClient restClient = RestClient.builder()
            .baseUrl("http://localhost:8080")
            .build();

    public HttpStatusCode savePayment(final PaymentServiceRequest request) {
        return restClient.post()
                .uri("/payment")
                .body(request)
                .retrieve()
                .toBodilessEntity()
                .getStatusCode();
    }

}
