package com.bett.orders.Controller;


import com.bett.orders.Model.Orders;
import com.bett.orders.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrdersController {

    @Autowired
    OrderService orderService;

 @PostMapping
    private ResponseEntity<String> createOrder(@RequestBody Orders order) {

     orderService.createorder(order);
     return ResponseEntity.ok("OrderID : " + order.getOrderId() + " ,Created Successfully ");
 }
}
