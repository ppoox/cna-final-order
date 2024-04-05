package com.ppoox.localfood.order.adapter.out.persistence;

import com.ppoox.localfood.order.application.port.out.persistence.OrderPersistencePort;
import com.ppoox.localfood.order.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OrderPersistenceAdapter implements OrderPersistencePort {

    private final OrderRepository orderRepository;

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> findAllByStoreIdAndProductId(Long storeId, Long productId) {
        return orderRepository.findAllByStoreIdAndProductId(storeId, productId);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void saveAll(List<Order> orders) {
        orderRepository.saveAll(orders);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
