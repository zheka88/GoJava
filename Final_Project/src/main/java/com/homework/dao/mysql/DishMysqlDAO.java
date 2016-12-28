package com.homework.dao.mysql;

import com.homework.dao.DAO;
import com.homework.model.Dish;
import com.homework.model.DishComponent;
import com.homework.model.Ingredient;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DishMysqlDAO implements MysqlDAO<Dish> {

    private MysqlDataManager dataManager;
    private MysqlDAO<Ingredient> ingredientDAO;

    @Override
    public void save(Dish dish) {
        if (dish.getId() == 0) {
            dataManager.create("INSERT INTO DISH (NAME) VALUES (?)", dish, this);
        } else {
            dataManager.update("UPDATE DISH SET NAME = ? WHERE ID = " + dish.getId(), dish, this);
        }
        setDishComponents(dish);
    }

    @Override
    public void delete(long id) {
        deleteDishComponents(id);
        dataManager.execute("DELETE FROM DISH WHERE ID = ?", id);
    }

    @Override
    public Dish getById(long id) {
        return dataManager.getById("SELECT ID, NAME FROM DISH WHERE ID = ?", id, this);
    }

    @Override
    public List<Dish> getByName(String name) {
        return dataManager.getAll("SELECT ID, NAME FROM DISH WHERE NAME LIKE '%" + name + "%'", this);
    }

    @Override
    public List<Dish> getAll() {
        return dataManager.getAll("SELECT ID, NAME FROM DISH", this);
    }

    @Override
    public List<Dish> getFromQuery(String sql) {
        return dataManager.getAll(sql, this);
    }

    private List<Ingredient> getDishComponents(long dishId) {
        String sql = "SELECT ID, NAME " +
                "FROM ingredient where ID in " +
                "(select INGERDIENT_ID from dish_components " +
                "where DISH_ID = " + dishId + ")";

        return ingredientDAO.getFromQuery(sql);
    }

    private void setDishComponents(Dish dish) {
        deleteDishComponents(dish.getId());

        if (dish.getComponents() != null) {
            for (DishComponent dishComponent : dish.getComponents()) {
                dataManager.execute("INSERT INTO DISH_COMPONENTS(DISH_ID, INGERDIENT_ID) VALUES ("
                        + "? , " + dishComponent.getId() + ")", dish.getId());
            }
        }
    }

    private void deleteDishComponents(long dishId) {
        dataManager.execute("DELETE FROM DISH_COMPONENTS WHERE DISH_ID = ?", dishId);
    }

    @Override
    public Dish getObjectFromResultSet(ResultSet resultSet) throws SQLException {
        Dish dish = new Dish();

        dish.setId(resultSet.getLong("ID"));
        dish.setName(resultSet.getString("NAME"));
        //dish.setComponents(getDishComponents(dish.getId()));

        return dish;
    }

    @Override
    public void setStatementParamsFromObject(PreparedStatement preparedStatement, Dish value) throws SQLException {
        preparedStatement.setString(1, value.getName());
    }

    @Override
    public void setIdFromGeneratedKeys(ResultSet generatedKeys, Dish value) throws SQLException {
        value.setId(generatedKeys.getLong(1));
    }

    public void setDataManager(MysqlDataManager dataManager) {
        this.dataManager = dataManager;
    }

    public void setIngredientDAO(MysqlDAO<Ingredient> ingredientDAO) {
        this.ingredientDAO = ingredientDAO;
    }
}
