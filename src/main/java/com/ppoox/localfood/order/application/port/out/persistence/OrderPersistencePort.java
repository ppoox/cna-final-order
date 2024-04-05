package com.ppoox.localfood.order.application.port.out.persistence;

import com.ppoox.localfood.order.domain.Order;

import java.util.List;
import java.util.Optional;

public interface OrderPersistencePort {

    Optional<Order> findById(Long id);

    List<Order> findAllByStoreIdAndProductId(Long storeId, Long productId);

    Order save(Order order);

    void saveAll(List<Order> orders);

    List<Order> findAll();
}
