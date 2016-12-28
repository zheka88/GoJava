package com.homework.dao.mysql;

import com.homework.dao.DAO;
import com.homework.model.Position;

import java.sql.*;
import java.util.List;

public class PositionMysqlDAO implements MysqlDAO<Position> {

    private MysqlDataManager dataManager;

    @Override
    public Position getById(long id){
        return dataManager.getById("SELECT ID, NAME FROM POSITION WHERE ID = ?", id, this);
    }

    @Override
    public List<Position> getAll() {
         return dataManager.getAll("SELECT ID, NAME FROM POSITION", this);
    }

    @Override
    public List<Position> getFromQuery(String sql) {
        return dataManager.getAll(sql, this);
    }

    @Override
    public Position getObjectFromResultSet(ResultSet resultSet) throws SQLException {
        Position position = new Position();

        position.setId(resultSet.getLong("ID"));
        position.setName(resultSet.getString("NAME"));

        return position;
    }

    @Override
    public void save(Position value) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<Position> getByName(String name) {
        return null;
    }

    @Override
    public void setStatementParamsFromObject(PreparedStatement preparedStatement, Position value) throws SQLException {

    }

    @Override
    public void setIdFromGeneratedKeys(ResultSet generatedKeys, Position value) throws SQLException {

    }

    public void setDataManager(MysqlDataManager dataManager) {
        this.dataManager = dataManager;
    }
}
