package com.homework.service;

import com.homework.dao.DAO;
import com.homework.model.Dish;
import com.homework.model.Menu;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class MenuService {

    private DAO<Menu> menuDAO;

    @Transactional
    public void save(Menu menu){
        menuDAO.save(menu);
    }

    @Transactional
    public void delete(long id){
        menuDAO.delete(id);
    }

    @Transactional
    public List<Menu> getByName(String name){
        return menuDAO.getByName(name);
    }

    @Transactional
    public Menu getById(long id){
        return menuDAO.getById(id);
    }

    @Transactional
    public List<Menu> getAll(){
        return menuDAO.getAll();
    }

    public void setMenuDAO(DAO<Menu> menuDAO) {
        this.menuDAO = menuDAO;
    }
}
