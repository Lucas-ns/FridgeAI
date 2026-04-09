package dev.java10x.FridgeAI.controller;


import dev.java10x.FridgeAI.model.FoodItem;
import dev.java10x.FridgeAI.service.FoodItemService;
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
    public ResponseEntity<List<FoodItem>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping
    public ResponseEntity<FoodItem> criar(@RequestBody FoodItem foodItem) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(foodItem));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody FoodItem foodItem) {
        return ResponseEntity.ok(service.atualizar(id, foodItem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.ok("O alimento foi deletado.");
    }
}
