package com.pizzeria.services.pizzaservice.api;

import com.pizzeria.services.pizzaservice.repository.model.Pizza;
import com.pizzeria.services.pizzaservice.service.PizzaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pizzas")
public final class PizzaController {

    private PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public ResponseEntity<List<Pizza>> findAll() {
        final List<Pizza> pizzas = pizzaService.getAllPizzas();
        return ResponseEntity.ok(pizzas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pizza> findById(@PathVariable long id) {
        try {
            final Pizza pizza = pizzaService.getPizzaById(id);
            return ResponseEntity.ok(pizza);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Pizza>> findByCategory(@PathVariable String category) {
        List<Pizza> pizzas = pizzaService.getAllPizzasByCategory(category);
        if (pizzas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pizzas);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody com.supermarket.services.pizzaservice.api.dto.Pizza pizza) {
        final String pizzaName = pizza.getPizzaName();
        final Double price = pizza.getPrice();
        final String category = pizza.getCategory();
        final String size = pizza.getSize();
        final Long amount = pizza.getAmount();
        try {
            final long id = pizzaService.createPizza(pizzaName, price, category, size, amount);
            final String location = String.format("/pizzas/%d", id);
            return ResponseEntity.created(URI.create(location)).build();
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @RequestBody com.supermarket.services.pizzaservice.api.dto.Pizza pizza) {
        final String pizzaName = pizza.getPizzaName();
        final Double price = pizza.getPrice();
        final String category = pizza.getCategory();
        final String size = pizza.getSize();
        final Long amount = pizza.getAmount();
        try {
            pizzaService.updatePizza(id, pizzaName, price, category, size, amount);
            return ResponseEntity.noContent().build();
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        pizzaService.deletePizza(id);
        return ResponseEntity.noContent().build();
    }
}
