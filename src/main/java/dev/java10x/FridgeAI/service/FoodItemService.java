package dev.java10x.FridgeAI.service;

import dev.java10x.FridgeAI.dto.FoodItemDTO;
import dev.java10x.FridgeAI.mapper.FoodItemMapper;
import dev.java10x.FridgeAI.model.FoodItem;
import dev.java10x.FridgeAI.repository.FoodItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemService {

    private final FoodItemRepository repository;
    private final FoodItemMapper mapper;

    public FoodItemService(FoodItemRepository repository, FoodItemMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public FoodItemDTO criar(FoodItemDTO foodItem) {
        FoodItem item = mapper.toEntity(foodItem);
        return mapper.toDto(repository.save(item));
    }

    public List<FoodItemDTO> listar(){
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public FoodItemDTO atualizar(Long id, FoodItemDTO foodItem) {
        FoodItem item = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item não encontrado"));

        if (foodItem.id() != null) {
            item.setId(id);
        }
        if (foodItem.nome() != null) {
            item.setNome(foodItem.nome());
        }
        if (foodItem.quantidade() != null) {
            item.setQuantidade(foodItem.quantidade());
        }
        if (foodItem.categoria() != null) {
            item.setCategoria(foodItem.categoria());
        }
        if (foodItem.validade() != null) {
            item.setValidade(foodItem.validade());
        }

        return mapper.toDto(repository.save(item));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
