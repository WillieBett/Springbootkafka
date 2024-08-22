package com.bett.payment.Model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PAYMENTS")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paymentId;
    private String status;
}
