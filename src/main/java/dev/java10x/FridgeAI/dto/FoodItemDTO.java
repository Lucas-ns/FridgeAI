package dev.java10x.FridgeAI.dto;

import dev.java10x.FridgeAI.model.Category;

import java.util.Date;

public record FoodItemDTO(
        Long id,
        String nome,
        Integer quantidade,
        Category categoria,
        Date validade
) {
}
