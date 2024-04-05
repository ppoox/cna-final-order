package com.ppoox.localfood.order.domain.event;

import lombok.Getter;

@Getter
public class ProductSand {

    private Long orderId;
    private Long storeId;
    private Long productId;
    private String address;
}
