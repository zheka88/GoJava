package com.homework.service;

import com.homework.dao.DAO;
import com.homework.dao.QuantityFilterDAO;
import com.homework.model.Ingredient;
import com.homework.model.Position;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class IngredientService {

    private QuantityFilterDAO<Ingredient> ingredientDAO;

    @Transactional
    public void save(Ingredient ingredient){
        ingredientDAO.save(ingredient);
    }

    @Transactional
    public void delete(long id){
        ingredientDAO.delete(id);
    }

    @Transactional
    public List<Ingredient> getByName(String name){
        return ingredientDAO.getByName(name);
    }

    @Transactional
    public Ingredient getById(long id){
        return ingredientDAO.getById(id);
    }

    @Transactional
    public List<Ingredient> getAll(){
        return ingredientDAO.getAll();
    }

    @Transactional
    public List<Ingredient> getEnding(){
        return ingredientDAO.getEnding();
    }

    public void setIngredientDAO(QuantityFilterDAO<Ingredient> ingredientDAO) {
        this.ingredientDAO = ingredientDAO;
    }
}
