package dev.java10x.FridgeAI.controller;


import dev.java10x.FridgeAI.dto.FoodItemDTO;
import dev.java10x.FridgeAI.model.FoodItem;
import dev.java10x.FridgeAI.service.FoodItemService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodItemController {
    private final FoodItemService service;

    public FoodItemController(FoodItemService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<FoodItemDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping
    public ResponseEntity<FoodItemDTO> criar(@RequestBody FoodItemDTO foodItem) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(foodItem));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody FoodItemDTO foodItem) {
        try {
            return ResponseEntity.ok(service.atualizar(id, foodItem));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ingrediente não foi encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
