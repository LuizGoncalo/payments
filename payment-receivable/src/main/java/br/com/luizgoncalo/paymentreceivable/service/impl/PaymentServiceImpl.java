package br.com.luizgoncalo.paymentreceivable.service.impl;

import br.com.luizgoncalo.paymentreceivable.client.PaymentServiceClient;
import br.com.luizgoncalo.paymentreceivable.client.PaymentUserClient;
import br.com.luizgoncalo.paymentreceivable.domain.request.ReceivableRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl {

    @Autowired
    private PaymentUserClient paymentUserClient;

    @Autowired
    private PaymentServiceClient paymentServiceClient;

    public void processPayment(ReceivableRequest request){

        if (paymentUserClient.verifyUser(request.getCpf()).is2xxSuccessful()){
            paymentServiceClient.savePayment(request);
        }

    }


}
