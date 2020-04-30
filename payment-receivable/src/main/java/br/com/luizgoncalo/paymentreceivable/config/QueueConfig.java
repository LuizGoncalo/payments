package br.com.luizgoncalo.paymentreceivable.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {


    @Bean
    public Queue paymentQueue(){
        return QueueBuilder
                .durable("PAYMENT-QUEUE")
                .build();
    }

}
