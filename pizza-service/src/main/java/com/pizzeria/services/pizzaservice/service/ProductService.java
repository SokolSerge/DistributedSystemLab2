package com.pizzeria.services.pizzaservice.service;

import com.pizzeria.services.pizzaservice.repository.PizzaRepository;
import com.pizzeria.services.pizzaservice.repository.model.Pizza;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    public Pizza getPizzaById(long id) throws IllegalArgumentException {
        final Optional<Pizza> maybePizza = pizzaRepository.findById(id);
        if (maybePizza.isEmpty()) throw new IllegalArgumentException("Pizza not found");
        else return maybePizza.get();
    }

    public long createPizza(String pizzaName, Double price, String category, String size, Long amount) {
        if (!category.equals("Spicy")
                && !category.equals("No Spicy")
                && !category.equals("Vegeterian")) throw  new IllegalArgumentException("Illegal category argumnet");
        final Pizza pizza = new Pizza(pizzaName, price, category, size, amount);
        final Pizza savedPizza = pizzaRepository.save(pizza);
        return savedPizza.getId();
    }

    public void updatePizza(long id, String pizzaName, Double price, String category, String size, Long amount) throws IllegalArgumentException {
        final Optional<Pizza> maybePizza = pizzaRepository.findById(id);
        if (maybePizza.isEmpty()) throw new IllegalArgumentException("Pizza not found");
        Pizza pizza = maybePizza.get();
        if (pizzaName != null && !pizzaName.isBlank()) pizza.setPizzaName(pizzaName);
        if (price != null && !price.isNaN() && !price.isInfinite()) pizza.setPrice(price);
        if (category != null && !category.isBlank() &&(category.equals("Spicy")
                || category.equals("No Spicy")
                || category.equals("Vegeterian"))) pizza.setCategory(category);
        if (size != null && !size.isBlank()) pizza.setSize(size);
        if (amount != null && amount>0) pizza.setAmount(amount);
    }

    public void deletePizza(long id)     {
        pizzaRepository.deleteById(id);
    }

    public List<Pizza> getAllPizzasByCategory(String category) {
        return pizzaRepository.findAllByCategory(category);
    }
}
