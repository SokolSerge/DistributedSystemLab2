package com.pizzeria.services.orderservice.repository;

import com.pizzeria.services.orderservice.repository.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>
{

}
