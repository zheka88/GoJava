package com.homework.service;


import com.homework.dao.DAO;
import com.homework.model.Dish;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DishService {

    private DAO<Dish> dishDAO;

    @Transactional
    public void save(Dish dish){
        dishDAO.save(dish);
    }

    @Transactional
    public void delete(long id){
        dishDAO.delete(id);
    }

    @Transactional
    public List<Dish> getByName(String name){
        return dishDAO.getByName(name);
    }

    @Transactional
    public Dish getById(long id){
        return dishDAO.getById(id);
    }

    @Transactional
    public List<Dish> getAll(){
        return dishDAO.getAll();
    }

    public void setDishDAO(DAO<Dish> dishDAO) {
        this.dishDAO = dishDAO;
    }
}
