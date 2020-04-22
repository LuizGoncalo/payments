package br.com.luizgoncalo.paymentreceivable.service.impl;

import br.com.luizgoncalo.paymentreceivable.client.PaymentServiceClient;
import br.com.luizgoncalo.paymentreceivable.domain.request.ReceivableRequest;
import br.com.luizgoncalo.paymentreceivable.mapper.UserMapper;
import br.com.luizgoncalo.paymentreceivable.client.PaymentUserClient;
import org.springframework.beans.factory.annotation.Autowired;

public class PaymentServiceImpl {

    @Autowired
    private PaymentUserClient paymentUserClient;

    @Autowired
    private PaymentServiceClient paymentServiceClient;

    @Autowired
    private UserMapper userMapper;

    public void processPayment(ReceivableRequest request){

        if (paymentUserClient.verifyUser(request.getCpf()).is2xxSuccessful()){
            paymentServiceClient.savePayment(request);
        }

    }


}
