package br.com.luizgoncalo.paymentreceivable.service.impl;

import br.com.luizgoncalo.paymentreceivable.domain.request.PaymentServiceRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class SendMessageService {

    private RabbitTemplate rabbitTemplate;

    public void sendMessage(final String exchange, final String routingKey, final PaymentServiceRequest message){
        rabbitTemplate.convertAndSend(exchange,routingKey,message);
    }

}
