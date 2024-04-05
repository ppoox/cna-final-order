package com.ppoox.localfood.order.domain.event;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
public class ProductChanged {

    private Long storeId;
    private Long productId;
    private String productName;

}
