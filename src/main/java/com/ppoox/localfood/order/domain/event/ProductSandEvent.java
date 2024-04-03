package com.ppoox.localfood.order.domain.event;

import lombok.Getter;

@Getter
public class ProductSandEvent {

    private Long orderId;
    private Long productId;
    private Long address;
}
