package com.homework.dao;

import java.util.List;

public interface QuantityFilterDAO<T> extends DAO<T> {
    List<T> getEnding();
}
