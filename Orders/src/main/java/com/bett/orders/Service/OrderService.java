package com.bett.orders.Service;

import com.bett.orders.Model.Orders;
import com.bett.orders.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private KafkaTemplate<String , Orders> kafkaTemplate;

    private final String topic = "orders";

    public ResponseEntity<String> createorder(Orders order){
        if (!orderRepository.findByOrderId(order.getOrderId()).isEmpty()){

            return ResponseEntity.ok("Order already exists");
        }else{
            Random random = new Random();
            int randomInt = random.nextInt(100);
            order.setOrderId(randomInt);
            orderRepository.save(order);
        }
        kafkaTemplate.send(topic, order);
        return null;
    }

}
