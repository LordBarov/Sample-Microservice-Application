package com.arnur.amqp;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@RequiredArgsConstructor
public class RabbitMQMessageProducer {

    private final AmqpTemplate amqpTemplate;

    public void publish(Object payload, String exchange, String routingKey) {
        log.info("Publishing to {}  using routing key {}. Payload: {} ", exchange, routingKey, payload);
        amqpTemplate.convertAndSend(exchange, routingKey,payload);
        log.info("Published");

    }
}
