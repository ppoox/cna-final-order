package com.ppoox.localfood.order.domain.event;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class OrderCanceled {

    private Long orderId;

}
