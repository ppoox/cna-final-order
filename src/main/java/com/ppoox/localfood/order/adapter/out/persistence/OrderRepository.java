package com.ppoox.localfood.order.adapter.out.persistence;

import com.ppoox.localfood.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "orders", itemResourceRel = "order", path = "order")
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByStoreIdAndProductId(Long storeId, Long productId);
}
