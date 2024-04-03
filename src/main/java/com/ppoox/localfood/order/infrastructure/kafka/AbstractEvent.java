package com.ppoox.localfood.order.infrastructure.kafka;

import com.ppoox.localfood.order.OrderApplication;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class AbstractEvent {

    String eventType;

    Long timestamp;

    public AbstractEvent(Object aggregate) {
        this();
        BeanUtils.copyProperties(aggregate, this);
    }

    public AbstractEvent() {
        this.eventType = this.getClass().getSimpleName();
        this.timestamp = System.currentTimeMillis();
    }

    public void publish() {
        KafkaConfig kafkaConfig = OrderApplication.applicationContext.getBean(KafkaConfig.class);
        kafkaConfig.setPayload(this);
        kafkaConfig.supply();
    }
}
