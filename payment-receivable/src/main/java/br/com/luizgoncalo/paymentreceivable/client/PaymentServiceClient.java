package br.com.luizgoncalo.paymentreceivable.client;

import br.com.luizgoncalo.paymentreceivable.domain.request.ReceivableRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "paymentService", url = "http://localhost:8080")
public interface PaymentServiceClient {

    @PostMapping("/payment")
    HttpStatus savePayment(@RequestBody final ReceivableRequest request);

}
