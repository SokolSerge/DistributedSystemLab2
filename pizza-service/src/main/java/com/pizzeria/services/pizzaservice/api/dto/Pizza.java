package com.pizzeria.services.pizzaservice.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public final class Pizza {
    private String pizzaName;
    private Double price;
    private String category;
    private String size;
    private Long amount;
}
