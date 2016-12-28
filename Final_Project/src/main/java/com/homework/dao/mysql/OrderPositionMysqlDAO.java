package com.homework.dao.mysql;

import com.homework.dao.DAO;
import com.homework.model.Dish;
import com.homework.model.Ingredient;
import com.homework.model.OrderPosition;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderPositionMysqlDAO implements MysqlDAO<OrderPosition> {

    private MysqlDataManager dataManager;
    private MysqlDAO<Dish> dishDAO;

    @Override
    public void save(OrderPosition orderPosition) {
        if(orderPosition.getId() == 0) {
            dataManager.create("INSERT INTO ORDER_CONTENT (ORDER_ID, DISH_ID, QUANTITY) VALUES (?, ?, ?)", orderPosition, this);
        } else {
            dataManager.update("UPDATE ORDER_CONTENT SET ORDER_ID = ?, DISH_ID = ?, QUANTITY = ?  WHERE ID = " + orderPosition.getId(), orderPosition, this);
        }
    }

    @Override
    public void delete(long id) {
        dataManager.execute("DELETE FROM ORDER_CONTENT WHERE ID = ?", id);
    }

    @Override
    public OrderPosition getById(long id) {
        return dataManager.getById("SELECT ID, ORDER_ID, DISH_ID, QUANTITY FROM ORDER_CONTENT WHERE ID = ?", id, this);
    }

    @Override
    public List<OrderPosition> getByName(String name) {
        return null;
    }

    @Override
    public List<OrderPosition> getAll() {
        return dataManager.getAll("SELECT ID, ORDER_ID, DISH_ID, QUANTITY FROM ORDER_CONTENT", this);
    }

    @Override
    public List<OrderPosition> getFromQuery(String sql) {
        return dataManager.getAll(sql, this);
    }

    @Override
    public OrderPosition getObjectFromResultSet(ResultSet resultSet) throws SQLException {
        OrderPosition orderPosition = new OrderPosition();

        orderPosition.setId(resultSet.getLong("ID"));
        //orderPosition.setOrder(resultSet.getLong("ORDER_ID"));
        orderPosition.setDish(dishDAO.getById(resultSet.getLong("DISH_ID")));
        orderPosition.setQuantity(resultSet.getInt("QUANTITY"));

        return orderPosition;
    }

    @Override
    public void setStatementParamsFromObject(PreparedStatement preparedStatement, OrderPosition value) throws SQLException {
        preparedStatement.setLong(1, value.getOrder().getId());
        preparedStatement.setLong(2, value.getDish().getId());
        preparedStatement.setInt(3, value.getQuantity());
    }

    @Override
    public void setIdFromGeneratedKeys(ResultSet generatedKeys, OrderPosition value) throws SQLException {
        value.setId(generatedKeys.getLong(1));
    }

    public void setDataManager(MysqlDataManager dataManager) {
        this.dataManager = dataManager;
    }

    public void setDishDAO(MysqlDAO<Dish> dishDAO) {
        this.dishDAO = dishDAO;
    }
}
