package com.ppoox.localfood.order.adapter.out.persistence;

import com.ppoox.localfood.order.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "orders", itemResourceRel = "order", path = "order")
public interface OrderRepository extends CrudRepository<Order, Long> {
}
