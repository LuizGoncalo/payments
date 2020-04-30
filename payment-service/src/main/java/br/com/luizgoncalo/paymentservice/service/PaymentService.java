package br.com.luizgoncalo.paymentservice.service;

import br.com.luizgoncalo.paymentservice.domain.PaymentEntity;
import br.com.luizgoncalo.paymentservice.domain.request.PaymentRequest;
import br.com.luizgoncalo.paymentservice.domain.response.PaymentResponse;
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

    public PaymentResponse savePayment (final PaymentRequest paymentRequest){
       log.info("M=savePayment, I=Processando pagamento {}", paymentRequest.getPaymentIdentification());

       PaymentEntity paymentEntity = paymentMapper.paymentRequestToPaymentEntity(paymentRequest);

       paymentRepository.save(paymentEntity);

       return paymentMapper.paymentEntityToPaymentResponse(paymentEntity);

    }

}
