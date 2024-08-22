package com.bett.payment.Service;

import com.bett.orders.Model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderEventListener {

    @Autowired
    private PaymentService paymentService;

    @KafkaListener( topics = "orders", groupId = "payment-group")
    public void listen(Orders order) {
        paymentService.payment(order);

    }
}