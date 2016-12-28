package com.homework.dao.mysql;

import com.homework.dao.DAO;
import com.homework.model.Ingredient;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class IngredientMysqlDAO implements MysqlDAO<Ingredient> {

    private MysqlDataManager dataManager;

    @Override
    public void save(Ingredient value) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Ingredient getById(long id) {
        return dataManager.getById("SELECT ID, NAME FROM INGREDIENT WHERE ID = ?", id, this);
    }

    @Override
    public List<Ingredient> getByName(String name) {
        return null;
    }

    @Override
    public List<Ingredient> getAll() {
        return dataManager.getAll("SELECT ID, NAME FROM INGREDIENT", this);
    }

    @Override
    public List<Ingredient> getFromQuery(String sql) {
        return dataManager.getAll(sql, this);
    }

    @Override
    public Ingredient getObjectFromResultSet(ResultSet resultSet) throws SQLException {
        Ingredient ingredient = new Ingredient();

        ingredient.setId(resultSet.getLong("ID"));
        ingredient.setName(resultSet.getString("NAME"));

        return ingredient;
    }

    @Override
    public void setStatementParamsFromObject(PreparedStatement preparedStatement, Ingredient value) throws SQLException {

    }

    @Override
    public void setIdFromGeneratedKeys(ResultSet generatedKeys, Ingredient value) throws SQLException {

    }

    public void setDataManager(MysqlDataManager dataManager) {
        this.dataManager = dataManager;
    }

}
