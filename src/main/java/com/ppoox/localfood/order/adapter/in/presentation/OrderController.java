package com.ppoox.localfood.order.adapter.in.presentation;

import com.ppoox.localfood.order.application.port.in.presentation.OrderPresentationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderPresentationPort orderPresentationPort;

//    @Bean
//    public Supplier<Message<String>> supply() {
//        return () -> {
//            if (bq.isEmpty()) {
//                return null;
//            }
//                return MessageBuilder
//                    .withPayload(bq.poll())
//                    .setHeader(KafkaHeaders.GROUP_ID, "test-group")
//                    .setHeader(KafkaHeaders.TOPIC, "test-topic")
//                    .build();
//        };
//    }
//
//    @Bean
//    public Consumer<Message<String>> consume() {
//        return message -> System.out.println("Received message: " + message.getPayload());
//    }
}
