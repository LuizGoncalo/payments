package br.com.luizgoncalo.paymentreceivable.service.impl;

import br.com.luizgoncalo.paymentreceivable.client.PaymentServiceClient;
import br.com.luizgoncalo.paymentreceivable.client.PaymentUserClient;
import br.com.luizgoncalo.paymentreceivable.domain.PaymentReceivableEntity;
import br.com.luizgoncalo.paymentreceivable.domain.request.ReceivableRequest;
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

    public void receivablePayment(final ReceivableRequest receivableRequest){
        log.info("M=receivablePayment, I- Recebendo payload de pagamento");

        PaymentReceivableEntity receivableEntity = paymentMapper.receivableRequestToReceivableEntity(receivableRequest);

        receivableRepository.save(receivableEntity);
        processPayment(receivableRequest);

    }

    protected void processPayment(final ReceivableRequest request){
        log.info("M=processPayment, I= Processando o pagamento {}", request.getPaymentIdentification());

        if (paymentUserClient.verifyUser(request.getCpf()).is2xxSuccessful()){
            paymentServiceClient.savePayment(request);
        }

    }


}
