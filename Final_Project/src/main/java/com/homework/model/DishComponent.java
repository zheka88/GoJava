package com.homework.model;

import javax.persistence.*;

@Entity
@Table(name = "DISH_COMPONENTS")
public class DishComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "DISH_ID")
    private Dish dish;

    @ManyToOne
    @JoinColumn(name = "INGREDIENT_ID")
    private Ingredient ingredient;

    @Column(name = "QUANTITY")
    private Integer quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
