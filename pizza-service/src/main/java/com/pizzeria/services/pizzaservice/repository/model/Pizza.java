package com.pizzeria.services.pizzaservice.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "pizzas")
public final class Pizza {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    @Column(name = "pizza_name")
    private String pizzaName;
    @Column(name = "price")
    private Double price;
    @Column(name = "category")
    private String category;
    @Column(name = "size")
    private String size;
    @Column(name = "amount")
    private Long amount;

    public Pizza() {
    }

    public Pizza(String pizzaName, Double price, String category, String size, Long amount) {
        this.pizzaName = pizzaName;
        this.price = price;
        this.category = category;
        this.size = size;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
