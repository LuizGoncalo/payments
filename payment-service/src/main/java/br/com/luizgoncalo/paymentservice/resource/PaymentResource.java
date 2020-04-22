package br.com.luizgoncalo.paymentservice.resource;

import br.com.luizgoncalo.paymentservice.domain.request.PaymentRequest;
import br.com.luizgoncalo.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private HttpStatus payment(@RequestBody final PaymentRequest request){
        try{
        paymentService.savePayment(request);
        return HttpStatus.OK;
        } catch (Exception e){
            return HttpStatus.BAD_REQUEST;
        }
    }

}
