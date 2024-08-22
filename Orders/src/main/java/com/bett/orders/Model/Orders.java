package com.bett.orders.Model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ORDERS")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int orderId;
    private String customerId;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private Double OrderAmount;
}
