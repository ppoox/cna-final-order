package com.ppoox.localfood.order.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "od_order")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long storeId;

    private Long productId;

    private String productName;

    private int quantity;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedBy;

    public void changeCompleteOrderStatus() {
        this.status = OrderStatus.COMPLETE_ORDER;
    }

    public void changeReadyProductStatus() {
        this.status = OrderStatus.READY_PRODUCT;
    }

    public void changeStartDeliveryStatus() {
        this.status = OrderStatus.START_DELIVERY;
    }

    public void changeCompleteDeliveryStatus() {
        this.status = OrderStatus.COMPLETE_DELIVERY;
    }

    public void changeCancelOrderStatus() {
        this.status = OrderStatus.CANCEL_ORDER;
    }

    public void changeOrderProductName(String productName) {
        this.productName = productName;
    }

}
