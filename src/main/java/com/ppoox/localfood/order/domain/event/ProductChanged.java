package com.ppoox.localfood.order.domain.event;

import lombok.Getter;

@Getter
public class ProductChanged {

    private Long id;
    private Long productId;
    private String productName;

}
