package br.com.luizgoncalo.paymentreceivable.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {

    @Autowired
    private QueueConfig queueConfig;

    @Bean
    public Exchange fanoutExchange(){
        return ExchangeBuilder
                .fanoutExchange("PAYMENT-EXCHANGE")
                .durable(true)
                .build();
    }

    @Bean
    public Binding paymentFanoutBiding(){
        return BindingBuilder
                .bind(queueConfig.paymentQueue())
                .to(fanoutExchange())
                .with("")
                .noargs();
    }

}
