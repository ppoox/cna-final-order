package com.ppoox.localfood.order.adapter.in.presentation;

import com.ppoox.localfood.order.domain.OrderStatus;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderModel extends RepresentationModel<OrderModel> {

    private Long id;
    private Long storeId;
    private Long productId;
    private String productName;
    private int quantity;
    private OrderStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedBy;

}
