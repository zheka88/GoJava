package com.homework.dao.mysql;

import com.homework.dao.DAO;
import com.homework.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class KitchenJournalMysqlDAO implements MysqlDAO<KitchenJournalItem> {

    private MysqlDataManager dataManager;
    private MysqlDAO<Dish> dishDAO;
    private MysqlDAO<Employee> employeeDAO;
    private MysqlDAO<Order> orderDAO;

    @Override
    public void save(KitchenJournalItem kitchenJournalItem) {
        if (kitchenJournalItem.getId() == 0) {
            dataManager.create("INSERT INTO KITCHEN_JOURNAL (DISH_ID, COOK_ID, ORDER_ID, DATE) VALUES (?, ?, ?, ?)", kitchenJournalItem, this);
        } else {
            dataManager.update("UPDATE KITCHEN_JOURNAL SET DISH_ID = ?, COOK_ID = ?, ORDER_ID = ?, DATE = ? WHERE ID = " + kitchenJournalItem.getId(), kitchenJournalItem, this);
        }
    }

    @Override
    public void delete(long id) {
        dataManager.execute("DELETE FROM KITCHEN_JOURNAL WHERE ID = ?", id);
    }

    @Override
    public KitchenJournalItem getById(long id) {
        return dataManager.getById( "SELECT ID, DISH_ID, COOK_ID, ORDER_ID, DATE FROM KITCHEN_JOURNAL WHERE ID = ?", id, this);
    }

    @Override
    public List<KitchenJournalItem> getByName(String name) {
        return null;
    }

    @Override
    public List<KitchenJournalItem> getAll() {
        return dataManager.getAll("SELECT ID, DISH_ID, COOK_ID, ORDER_ID, DATE FROM KITCHEN_JOURNAL", this);
    }

    @Override
    public List<KitchenJournalItem> getFromQuery(String sql) {
        return dataManager.getAll(sql, this);
    }

    @Override
    public KitchenJournalItem getObjectFromResultSet(ResultSet resultSet) throws SQLException {
        KitchenJournalItem kitchenJournalItem = new KitchenJournalItem();

        kitchenJournalItem.setId(resultSet.getLong("ID"));
        kitchenJournalItem.setDate(resultSet.getString("DATE"));
        kitchenJournalItem.setDish(dishDAO.getById(resultSet.getLong("DISH_ID")));
        kitchenJournalItem.setCook(null);
        kitchenJournalItem.setOrder(orderDAO.getById(resultSet.getLong("ORDER_ID")));

        return kitchenJournalItem;
    }

    @Override
    public void setStatementParamsFromObject(PreparedStatement preparedStatement, KitchenJournalItem value) throws SQLException {
        preparedStatement.setLong(1, value.getDish().getId());
        preparedStatement.setLong(2, value.getCook().getId());
        preparedStatement.setLong(3, value.getOrder().getId());
        preparedStatement.setString(4, value.getDate());
    }

    @Override
    public void setIdFromGeneratedKeys(ResultSet generatedKeys, KitchenJournalItem value) throws SQLException {
        value.setId(generatedKeys.getLong(1));
    }

    public void setDataManager(MysqlDataManager dataManager) {
        this.dataManager = dataManager;
    }

    public void setDishDAO(MysqlDAO<Dish> dishDAO) {
        this.dishDAO = dishDAO;
    }

    public void setEmployeeDAO(MysqlDAO<Employee> employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public void setOrderDAO(MysqlDAO<Order> orderDAO) {
        this.orderDAO = orderDAO;
    }
}
