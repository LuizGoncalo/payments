package br.com.luizgoncalo.paymentservice.service;

import br.com.luizgoncalo.paymentservice.domain.request.PaymentRequest;
import br.com.luizgoncalo.paymentservice.mapper.PaymentMapper;
import br.com.luizgoncalo.paymentservice.repository.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentMapper paymentMapper;

    public void savePayment (PaymentRequest paymentRequest){
        if(verifyPayment(paymentRequest)){
            paymentRepository.save(paymentMapper.paymentRequestToPaymentEntity(paymentRequest));
        }
    }

    protected Boolean verifyPayment(PaymentRequest paymentRequest){
        if (!paymentRequest.equals(null)){
            log.error("M=verifyPayment, I=Pagamento esta sendo processado, numero={}", paymentRequest.getPaymentIdentification());
            return Boolean.TRUE;
        }
        log.error("M=verifyPayment, I=Pagamento Invalido");
        return Boolean.FALSE;
    }

}
