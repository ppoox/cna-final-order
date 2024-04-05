package com.ppoox.localfood.order.adapter.in.presentation;

import com.ppoox.localfood.order.domain.Order;
import com.ppoox.localfood.order.domain.OrderStatus;
import lombok.Getter;

@Getter
public class CreateOrderDto {

    private Long storeId;
    private Long productId;
    private String productName;
    private int quantity;

    public Order toEntity() {
        return Order.builder()
                .storeId(storeId)
                .productId(productId)
                .productName(productName)
                .quantity(quantity)
                .status(OrderStatus.COMPLETE_ORDER)
                .build();
    }
}
