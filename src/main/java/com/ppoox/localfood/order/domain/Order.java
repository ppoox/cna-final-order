package com.ppoox.localfood.order.domain;

import com.ppoox.localfood.order.domain.event.OrderedEvent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "od_order")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long storeId;

    private Long productId;

    private int quantity;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedBy;

    @PostPersist
    public void onPostPersist() {
        OrderedEvent orderedEvent = new OrderedEvent(this);
        orderedEvent.publish();
    }

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
}
