package dev.java10x.FridgeAI.service;

import dev.java10x.FridgeAI.model.FoodItem;
import dev.java10x.FridgeAI.repository.FoodItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemService {

    private final FoodItemRepository repository;

    public FoodItemService(FoodItemRepository repository) {
        this.repository = repository;
    }

    public FoodItem criar(FoodItem foodItem) {
        return repository.save(foodItem);
    }

    public List<FoodItem> listar(){
        return repository.findAll();
    }

    public FoodItem atualizar(Long id, FoodItem foodItem) {
        FoodItem item = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item não encontrado"));

        if (foodItem.getId() != null) {
            item.setId(id);
        }
        if (foodItem.getNome() != null) {
            item.setNome(foodItem.getNome());
        }
        if (foodItem.getQuantidade() != null) {
            item.setQuantidade(foodItem.getQuantidade());
        }

        return repository.save(item);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
