package com.homework.service;

import com.homework.dao.DAO;
import com.homework.model.Position;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class PositionService {

    private DAO<Position> positionDAO;

    @Transactional
    public void save(Position position){
        positionDAO.save(position);
    }

    @Transactional
    public void delete(long id){
        positionDAO.delete(id);
    }

    @Transactional
    public List<Position> getAll(){
        return positionDAO.getAll();
    }

    @Transactional
    public Position getById(long id){
        return positionDAO.getById(id);
    }

    public void setPositionDAO(DAO<Position> positionDAO) {
        this.positionDAO = positionDAO;
    }
}
