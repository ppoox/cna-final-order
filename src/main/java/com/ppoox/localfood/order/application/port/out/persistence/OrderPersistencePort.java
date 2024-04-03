package com.ppoox.localfood.order.application.port.out.persistence;

import com.ppoox.localfood.order.domain.Order;

import java.util.Optional;

public interface OrderPersistencePort {

    Optional<Order> findById(Long id);

    Order save(Order order);
}
