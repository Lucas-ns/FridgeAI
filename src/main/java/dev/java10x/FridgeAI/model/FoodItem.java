package dev.java10x.FridgeAI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "food_item")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer quantidade;
    @Enumerated(EnumType.STRING)
    private Category categoria;
    private Date validade;

}
