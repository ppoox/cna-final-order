package com.ppoox.localfood.order.application.service;

import com.ppoox.localfood.order.adapter.out.persistence.OrderPersistenceAdapter;
import com.ppoox.localfood.order.application.port.in.presentation.OrderPresentationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService implements OrderPresentationPort {

    private final OrderPersistenceAdapter orderPersistenceAdapter;
}
