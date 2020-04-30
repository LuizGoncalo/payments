package br.com.luizgoncalo.paymentreceivable.client;

import br.com.luizgoncalo.paymentreceivable.domain.reponse.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "paymentUser", url = "http://localHost:8082")
public interface PaymentUserClient {

    @GetMapping("/payment-user/{cpf}")
    UserResponse verifyUser(@PathVariable final String cpf);

}
