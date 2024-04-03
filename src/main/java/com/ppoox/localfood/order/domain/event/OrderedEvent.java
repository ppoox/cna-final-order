package com.ppoox.localfood.order.domain.event;

import com.ppoox.localfood.order.infrastructure.kafka.AbstractEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class OrderedEvent extends AbstractEvent {

    private Long id;
    private Long storeId;
    private Long productId;
    private int quantity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedBy;

    public OrderedEvent(Object aggregate) {
        super(aggregate);
    }

}
