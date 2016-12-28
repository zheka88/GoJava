package com.homework.service;

import com.homework.dao.DAO;
import com.homework.model.Dish;
import com.homework.model.Order;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class OrderService {

    private DAO<Order> orderDAO;

    @Transactional
    public void save(Order order){
        orderDAO.save(order);
    }

    @Transactional
    public void delete(long id){
        orderDAO.delete(id);
    }

    @Transactional
    public List<Order> getByName(String name){
        return orderDAO.getByName(name);
    }

    @Transactional
    public Order getById(long id){
        return orderDAO.getById(id);
    }

    @Transactional
    public List<Order> getAll(){
        return orderDAO.getAll();
    }

    @Transactional
    public List<Order> getOpen(){
        return null;
    }

    public void setOrderDAO(DAO<Order> orderDAO) {
        this.orderDAO = orderDAO;
    }
}
