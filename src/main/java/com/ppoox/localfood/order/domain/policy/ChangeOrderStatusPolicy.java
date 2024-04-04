package com.ppoox.localfood.order.domain.policy;

import com.ppoox.localfood.order.application.port.out.persistence.OrderPersistencePort;
import com.ppoox.localfood.order.domain.event.ProductSandEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class ChangeOrderStatusPolicy {

    private final OrderPersistencePort orderPersistencePort;

    @Bean
    public Consumer<Message<ProductSandEvent>> productSandEvent() {
        return message -> {
            System.out.println("배송준비중");

            MessageHeaders headers = message.getHeaders();
            if (!headers.containsValue("ProductSandEvent")) {
                return;
            }

            ProductSandEvent payload = message.getPayload();


            orderPersistencePort.findById(payload.getOrderId()).ifPresent(order -> {
                order.changeReadyProductStatus();
                orderPersistencePort.save(order);
            });
        };
    }
}
