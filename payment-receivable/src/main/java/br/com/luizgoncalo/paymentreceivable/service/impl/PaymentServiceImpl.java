package br.com.luizgoncalo.paymentreceivable.service.impl;

import br.com.luizgoncalo.paymentreceivable.domain.request.ReceivableRequest;
import br.com.luizgoncalo.paymentreceivable.mapper.UserMapper;
import br.com.luizgoncalo.paymentreceivable.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class PaymentServiceImpl {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    public void processPayment(ReceivableRequest request){

        userService.verifyUser(request.getCpf());

    }


}
