package com.ppoox.localfood.order.domain.policy;

import com.ppoox.localfood.order.application.port.out.persistence.OrderPersistencePort;
import com.ppoox.localfood.order.domain.Order;
import com.ppoox.localfood.order.domain.event.ProductChanged;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ChangeProductPolicy {

    private final OrderPersistencePort orderPersistencePort;

    @Bean
    public Consumer<Message<ProductChanged>> productChangedEvent() {
        return message -> {
            MessageHeaders headers = message.getHeaders();
            if (!"product-changed".equals(headers.get(KafkaHeaders.RECEIVED_TOPIC))) {
                return;
            }

            ProductChanged payload = message.getPayload();

            List<Order> orders = orderPersistencePort.findAllByStoreIdAndProductId(payload.getStoreId(), payload.getProductId())
                    .stream()
                    .peek(order -> order.changeOrderProductName(payload.getProductName()))
                    .collect(Collectors.toList());

            orderPersistencePort.saveAll(orders);
        };
    }
}
