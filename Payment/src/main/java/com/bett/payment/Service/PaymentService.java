package com.bett.payment.Service;

import com.bett.orders.Model.Orders;
import com.bett.payment.Model.Payment;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private KafkaTemplate<String , Orders> kafkaTemplate;

    private final String TOPIC = "payment";
    public void payment(Orders orders) {


        Payment payment = new Payment();
        payment.setPaymentId(String.valueOf(orders.getOrderId()));
        payment.setStatus("SUCCESS");

        kafkaTemplate.send(TOPIC, orders);
        System.out.println("Kshs "+orders.getOrderAmount()+ " For OrderID:" + orders.getOrderId() + " ,Paid Successfully By " + orders.getCustomerName());
    }
}
