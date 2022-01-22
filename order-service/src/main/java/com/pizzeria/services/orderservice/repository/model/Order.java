package com.pizzeria.services.orderservice.repository.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "`order`", schema = "order-service")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrder;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "pizza_id")
    private Long pizzaId;

    @Column(name = "amount_pizza")
    private int amountPizza;

    @Column(name = "order_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderDate;

    @Column(name = "street")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "street_number")
    private int number;

    @Column(name = "entrance_street")
    private int entrance;

    @Column(name = "comment")
    private String comment;

    @Column(name = "status")
    private String status;

    public Order() {
    }

    public Order(Long userId, Long pizzaId, int amountPizza, LocalDateTime orderDate, String city, String street, int number, int entrance, String comment, String status) {
        this.userId = userId;
        this.pizzaId = pizzaId;
        this.amountPizza = amountPizza;
        this.orderDate = orderDate;
        this.city = city;
        this.street = street;
        this.number = number;
        this.entrance = entrance;
        this.comment = comment;
        this.status = status;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Long pizzaId) {
        this.pizzaId = pizzaId;
    }

    public int getAmountPizza() {
        return amountPizza;
    }

    public void setAmountPizza(int amountPizza) {
        this.amountPizza = amountPizza;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getEntrance() {
        return entrance;
    }

    public void setEntrance(int entrance) {
        this.entrance = entrance;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}