package dev.java10x.FridgeAI.mapper;

import dev.java10x.FridgeAI.dto.FoodItemDTO;
import dev.java10x.FridgeAI.model.FoodItem;
import org.springframework.stereotype.Component;

@Component
public class FoodItemMapper {

    public FoodItemDTO toDto(FoodItem foodItem) {
        return new FoodItemDTO(foodItem.getId(),
                foodItem.getNome(),
                foodItem.getQuantidade(),
                foodItem.getCategoria(),
                foodItem.getValidade());
    }


    public FoodItem toEntity(FoodItemDTO dto) {
        return new FoodItem(
                dto.id(),
                dto.nome(),
                dto.quantidade(),
                dto.categoria(),
                dto.validade()
        );
    }

}
