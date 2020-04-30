package br.com.luizgoncalo.paymentreceivable.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {


    private Queue paymentQueue(){
        return QueueBuilder
                .durable("PAYMENT-QUEUE")
                .build();
    }

}
