package com.bett.orders.Repository;


import com.bett.orders.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository  extends JpaRepository<Orders, Integer> {

    List<Orders> findByOrderId(int orderId);
}
