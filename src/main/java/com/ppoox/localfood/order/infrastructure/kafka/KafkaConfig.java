package com.ppoox.localfood.order.infrastructure.kafka;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;

import java.util.function.Consumer;
import java.util.function.Supplier;

@Configuration
public class KafkaConfig {

    private Object payload;

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    @Bean
    public Supplier<Message<Object>> supply() {
        return () -> {
            if (payload == null) {
                return null;
            }

            Message<Object> message = MessageBuilder
                    .withPayload(payload)
                    .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                    .setHeader("eventType", payload.getClass().getSimpleName())
//                    .setHeader(KafkaHeaders.GROUP_ID, "test-group")
                    .setHeader(KafkaHeaders.TOPIC, "localfood-topic")
                    .build();
            setPayload(null);

            return message;
        };
    }

    @Bean
    public Consumer<Message<String>> consume() {
        return message -> System.out.println("Received message: " + message.getPayload());
    }
}
