package br.com.luizgoncalo.paymentreceivable.service.impl;

import br.com.luizgoncalo.paymentreceivable.client.PaymentServiceClient;
import br.com.luizgoncalo.paymentreceivable.client.PaymentUserClient;
import br.com.luizgoncalo.paymentreceivable.domain.PaymentReceivableEntity;
import br.com.luizgoncalo.paymentreceivable.domain.reponse.UserResponse;
import br.com.luizgoncalo.paymentreceivable.domain.request.PaymentServiceRequest;
import br.com.luizgoncalo.paymentreceivable.mapper.PaymentMapper;
import br.com.luizgoncalo.paymentreceivable.repository.PaymentReceivableRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaymentServiceImpl {

    @Autowired
    private PaymentUserClient paymentUserClient;

    @Autowired
    private PaymentServiceClient paymentServiceClient;

    @Autowired
    private PaymentReceivableRepository receivableRepository;

    @Autowired
    private PaymentMapper paymentMapper;

    @Autowired
    private SendMessageService sendMessageService;

    public void receivablePayment(final PaymentServiceRequest paymentServiceRequest){
        log.info("M=receivablePayment, I=Recebendo payload de pagamento");

        PaymentReceivableEntity receivableEntity = paymentMapper.receivableRequestToReceivableEntity(paymentServiceRequest);

        sendMessageService.sendMessage("PAYMENT-EXCHANGE", "", paymentServiceRequest);
        saveReceivablePayment(receivableEntity);
        processPayment(paymentServiceRequest);

    }

    private void processPayment(final PaymentServiceRequest paymentServiceRequest){
        log.info("M=processPayment, I= Processando o pagamento {}", paymentServiceRequest.getPaymentIdentification());

        UserResponse userResponse = paymentUserClient.verifyUser(paymentServiceRequest.getCpf());

        if (userResponse.getActive()){
            paymentServiceClient.savePayment(paymentServiceRequest);
        }

    }

    private void saveReceivablePayment(final PaymentReceivableEntity receivableEntity){
        receivableRepository.save(receivableEntity);
    }


}
