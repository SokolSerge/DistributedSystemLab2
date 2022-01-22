package com.pizzeria.services.pizzaservice.repository;

import com.pizzeria.services.pizzaservice.repository.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    List<Pizza> findAllByCategory(String category);
}
