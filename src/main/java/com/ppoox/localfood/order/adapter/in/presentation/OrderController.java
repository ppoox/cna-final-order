package com.ppoox.localfood.order.adapter.in.presentation;

import com.ppoox.localfood.order.application.port.in.presentation.OrderPresentationPort;
import com.ppoox.localfood.order.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderPresentationPort orderPresentationPort;

    @GetMapping(path = "", produces = { "application/hal+json" })
    public CollectionModel<OrderModel> getOrders() {
        List<Order> orders = orderPresentationPort.getOrders();

        List<OrderModel> orderModels = new ArrayList<>();
        for (Order order : orders) {
            OrderModel orderModel = new OrderModel();
            BeanUtils.copyProperties(order, orderModel);
            orderModels.add(orderModel);
        }

        Link link = linkTo(OrderController.class).withSelfRel();
        return CollectionModel.of(orderModels, link);
    }

    @PostMapping(path = "", produces = { "application/hal+json" })
    public OrderModel createOrder(@RequestBody CreateOrderDto createOrderDto) {
        Order order = orderPresentationPort.createOrder(createOrderDto);

        OrderModel orderModel = new OrderModel();
        BeanUtils.copyProperties(order, orderModel);

        Link link = linkTo(OrderController.class).withSelfRel();
        orderModel.add(link);

        return orderModel;
    }

}
