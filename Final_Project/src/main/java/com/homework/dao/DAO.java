package com.homework.dao;

import com.homework.model.Dish;

import java.util.List;

public interface DAO<T> {

    void save(T value);

    void delete(long id);

    T getById(long id);

    List<T> getByName(String name);

    List<T> getAll();

}
