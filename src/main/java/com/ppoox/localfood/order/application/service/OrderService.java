package com.ppoox.localfood.order.application.service;

import com.ppoox.localfood.order.adapter.in.presentation.CreateOrderDto;
import com.ppoox.localfood.order.application.port.in.presentation.OrderPresentationPort;
import com.ppoox.localfood.order.application.port.out.persistence.OrderPersistencePort;
import com.ppoox.localfood.order.domain.Order;
import com.ppoox.localfood.order.domain.event.OrderedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService implements OrderPresentationPort {

    private final OrderPersistencePort orderPersistencePort;
    private final StreamBridge streamBridge;

    @Transactional
    @Override
    public Order createOrder(CreateOrderDto createOrderDto) {
        Order order = orderPersistencePort.save(createOrderDto.toEntity());
        streamBridge.send("ordered-out-0", new OrderedEvent(order));
        return order;
    }

    @Override
    public List<Order> getOrders() {
        return orderPersistencePort.findAll();
    }
}
