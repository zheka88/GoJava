package com.homework.dao.mysql;

import com.homework.dao.DAO;
import com.homework.dao.QuantityFilterDAO;
import com.homework.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class InventoryMysqlDAO implements QuantityFilterDAO<InventoryPosition>, MysqlDAO<InventoryPosition> {

    private MysqlDataManager dataManager;
    private MysqlDAO<Ingredient> ingredientDAO;

    @Override
    public void save(InventoryPosition inventoryPosition) {
        if(inventoryPosition.getId() == 0) {
            dataManager.create("INSERT INTO WAREHOUSE (INGREDIENT_ID, QUANTITY) VALUES (?, ?)", inventoryPosition, this);
        } else {
            dataManager.update("UPDATE WAREHOUSE SET INGREDIENT_ID = ?, QUANTITY = ? WHERE ID = " + inventoryPosition.getId(), inventoryPosition, this);
        }
    }

    @Override
    public void delete(long id) {
        dataManager.execute("DELETE FROM WAREHOUSE WHERE ID = ?", id);
    }

    @Override
    public InventoryPosition getById(long id) {
        return dataManager.getById( "SELECT ID, INGREDIENT_ID, QUANTITY FROM WAREHOUSE WHERE ID = ?", id, this);
    }

    @Override
    public List<InventoryPosition> getByName(String name) {
        return dataManager.getAll("SELECT WAREHOUSE.ID, WAREHOUSE.INGREDIENT_ID, WAREHOUSE.QUANTITY FROM WAREHOUSE INNER JOIN INGREDIENT" +
                " ON WAREHOUSE.INGREDIENT_ID = INGREDIENT.ID WHERE INGREDIENT.NAME LIKE '%" + name + "%'", this);
    }

    @Override
    public List<InventoryPosition> getAll() {
        return dataManager.getAll("SELECT ID, INGREDIENT_ID, QUANTITY FROM WAREHOUSE", this);
    }

    @Override
    public List<InventoryPosition> getFromQuery(String sql) {
        return dataManager.getAll(sql, this);
    }

    @Override
    public InventoryPosition getObjectFromResultSet(ResultSet resultSet) throws SQLException {

        InventoryPosition inventoryPosition = new InventoryPosition();

        inventoryPosition.setId(resultSet.getLong("ID"));
        inventoryPosition.setIngredient(ingredientDAO.getById(resultSet.getLong("INGREDIENT_ID")));
        inventoryPosition.setQuantity(resultSet.getInt("QUANTITY"));

        return inventoryPosition;
    }

    @Override
    public void setStatementParamsFromObject(PreparedStatement preparedStatement, InventoryPosition value) throws SQLException {
        preparedStatement.setLong(1, value.getIngredient().getId());
        preparedStatement.setInt(2, value.getQuantity());
    }

    @Override
    public void setIdFromGeneratedKeys(ResultSet generatedKeys, InventoryPosition value) throws SQLException {
        value.setId(generatedKeys.getLong(1));
    }

    public void setDataManager(MysqlDataManager dataManager) {
        this.dataManager = dataManager;
    }

    public void setIngredientDAO(MysqlDAO<Ingredient> ingredientDAO) {
        this.ingredientDAO = ingredientDAO;
    }

    @Override
    public List<InventoryPosition> getEnding() {
        return dataManager.getAll("SELECT ID, INGREDIENT_ID, QUANTITY FROM WAREHOUSE WHERE QUANTITY < 10", this);
    }
}
