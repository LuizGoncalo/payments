package br.com.luizgoncalo.paymentservice.resource;

import br.com.luizgoncalo.paymentservice.domain.request.PaymentRequest;
import br.com.luizgoncalo.paymentservice.domain.response.PaymentResponse;
import br.com.luizgoncalo.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payment")
public class PaymentResource {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    private ResponseEntity<PaymentResponse> payment(@RequestBody final PaymentRequest request){

        try {
            PaymentResponse paymentResponse = paymentService.savePayment(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(paymentResponse);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
