package com.homework.service;

import com.homework.dao.DAO;
import com.homework.model.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class KitchenJournalService {

    private DAO<KitchenJournalItem> kitchenJournalItemDAO;
    private IngredientService ingredientService;
    private DishService dishService;

    @Transactional
    public void save(KitchenJournalItem kitchenJournalItem){
        useIngredientsOnStock(kitchenJournalItem);
        kitchenJournalItemDAO.save(kitchenJournalItem);
    }

    private void useIngredientsOnStock(KitchenJournalItem kitchenJournalItem){
        boolean successful = true;
        StringBuilder errorMessage = new StringBuilder();
        List<Ingredient> stockToSave = new ArrayList<>();

        Dish dish = dishService.getById(kitchenJournalItem.getDish().getId());
        List<DishComponent> ingredientList = dish.getComponents();
        for (DishComponent dishComponent : ingredientList) {
            Ingredient ingredient = dishComponent.getIngredient();
            if (ingredient.getQuantity() < dishComponent.getQuantity()){
                successful = false;
                errorMessage.append(ingredient.getName() + " is not available! \n");
            } else {
                ingredient.setQuantity(ingredient.getQuantity() - dishComponent.getQuantity());
                stockToSave.add(ingredient);
            }
        }
        if (successful) {
            stockToSave.forEach(e -> ingredientService.save(e));
        } else {
            throw new IllegalArgumentException(errorMessage.toString());
        }
    }

    @Transactional
    public void delete(long id){
        kitchenJournalItemDAO.delete(id);
    }

    @Transactional
    public List<KitchenJournalItem> getByName(String name){
        return kitchenJournalItemDAO.getByName(name);
    }

    @Transactional
    public KitchenJournalItem getById(long id){
        return kitchenJournalItemDAO.getById(id);
    }

    @Transactional
    public List<KitchenJournalItem> getAll(){
        return kitchenJournalItemDAO.getAll();
    }

    public void setKitchenJournalItemDAO(DAO<KitchenJournalItem> kitchenJournalItemDAO) {
        this.kitchenJournalItemDAO = kitchenJournalItemDAO;
    }

    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }

    public void setIngredientService(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }
}
