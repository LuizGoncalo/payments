package br.com.luizgoncalo.paymentreceivable.resource;

import br.com.luizgoncalo.paymentreceivable.domain.request.PaymentServiceRequest;
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
    private HttpStatus receivablePayment(final PaymentServiceRequest request){
         try{
             log.info("M=receivablePayment, I= Recebendo payload de pagamento");
             paymentService.receivablePayment(request);
             return HttpStatus.OK;
         } catch (Exception e) {
             log.error("M=receivablePayment, I=Erro ao receber pagamento", e);
             return HttpStatus.BAD_REQUEST;
         }
    }

}
