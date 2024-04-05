package com.ppoox.localfood.order.domain.policy;

import com.ppoox.localfood.order.application.port.out.persistence.OrderPersistencePort;
import com.ppoox.localfood.order.domain.event.OrderCanceled;
import com.ppoox.localfood.order.domain.event.ProductSand;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Consumer;

@Service
@Transactional
@RequiredArgsConstructor
public class ChangeOrderStatusPolicy {

    private final OrderPersistencePort orderPersistencePort;

    @Bean
    public Consumer<Message<ProductSand>> productSandEvent() {
        return message -> {
            MessageHeaders headers = message.getHeaders();
            if (!"product-sand".equals(headers.get(KafkaHeaders.RECEIVED_TOPIC))) {
                return;
            }

            ProductSand payload = message.getPayload();

            orderPersistencePort.findById(payload.getOrderId()).ifPresent(order -> {
                order.changeReadyProductStatus();
                orderPersistencePort.save(order);
            });
        };
    }

    @Bean
    public Consumer<Message<OrderCanceled>> orderCanceledEvent() {
        return message -> {
            MessageHeaders headers = message.getHeaders();
            if (!"order-canceled".equals(headers.get(KafkaHeaders.RECEIVED_TOPIC))) {
                return;
            }

            OrderCanceled payload = message.getPayload();

            orderPersistencePort.findById(payload.getOrderId()).ifPresent(order -> {
                order.changeCancelOrderStatus();
                orderPersistencePort.save(order);
            });
        };
    }
}
