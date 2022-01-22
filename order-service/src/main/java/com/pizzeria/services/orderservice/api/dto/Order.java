package com.pizzeria.services.orderservice.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public final class order {
    private userId = userId;

    private pizzaId = pizzaId;

    private amountPizza = amountPizza;

    private orderDate = orderDate;

    private city = city;

    private street = street;

    private number = number;

    private entrance = entrance;

    private comment = comment;

    private status = status;
}