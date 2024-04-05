package com.ppoox.localfood.order.application.port.in.presentation;

import com.ppoox.localfood.order.adapter.in.presentation.CreateOrderDto;
import com.ppoox.localfood.order.domain.Order;

import java.util.List;

public interface OrderPresentationPort {

    Order createOrder(CreateOrderDto orderDto);

    List<Order> getOrders();
}
