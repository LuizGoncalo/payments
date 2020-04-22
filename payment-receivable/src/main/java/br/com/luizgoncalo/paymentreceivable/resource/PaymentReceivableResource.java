package br.com.luizgoncalo.paymentreceivable.resource;

import br.com.luizgoncalo.paymentreceivable.domain.request.ReceivableRequest;
import br.com.luizgoncalo.paymentreceivable.service.PaymentReceivableService;
import br.com.luizgoncalo.paymentreceivable.service.UserService;
import br.com.luizgoncalo.paymentreceivable.service.impl.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/payment-receivable")
public class PaymentReceivableResource {

    @Autowired
    PaymentServiceImpl paymentService;

    @PostMapping
    private HttpStatus receivablePayment(ReceivableRequest request){
         try{
             log.info("Salvando o pagamento na payment service");
             paymentService.processPayment(request);
             return HttpStatus.OK;
         } catch (Exception e) {
             log.error("Erro ao salvar", e);
             return HttpStatus.NO_CONTENT;
         }
    }

}
