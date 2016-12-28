package com.homework.dao.mysql;

import com.homework.model.*;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderMysqlDAO implements MysqlDAO<Order> {

    private MysqlDataManager dataManager;
    private MysqlDAO<Employee> employeeDAO;
    private MysqlDAO<OrderPosition> orderPositionDAO;

    @Override
    public void save(Order order) {
        if(order.getId() == 0) {
            dataManager.create("INSERT INTO ORDERS (TABLE_NUMBER, DATE, WAITER, OPEN) VALUES (?, ?, ?, ?)", order, this);
        } else {
            dataManager.update("UPDATE ORDERS SET TABLE_NUMBER = ?, DATE = ?, WAITER = ?, OPEN = ?  WHERE ID = " + order.getId(), order, this);
        }
        setContents(order);
    }

    @Override
    public void delete(long id) {
        dataManager.execute("DELETE FROM ORDERS WHERE ID = ?", id);
    }

    @Override
    public Order getById(long id) {
        return dataManager.getById("SELECT ID, TABLE_NUMBER, DATE, WAITER, OPEN FROM ORDERS WHERE ID = ?", id, this);
    }

    @Override
    public List<Order> getByName(String name) {
        return null;
     }

    @Override
    public List<Order> getAll() {
        return dataManager.getAll("SELECT ID, TABLE_NUMBER, DATE, WAITER, OPEN FROM ORDERS", this);
    }

    @Override
    public List<Order> getFromQuery(String sql) {
        return dataManager.getAll(sql, this);
    }

    private List<OrderPosition> getContents(Order order) {
        String sql = "SELECT ID, DISH_ID, QUANTITY " +
                "FROM ORDER_CONTENT where ORDER_ID = " + order.getId();

        List<OrderPosition> orderPositions = orderPositionDAO.getFromQuery(sql);
        for (OrderPosition orderPosition: orderPositions) {
            orderPosition.setOrder(order);
        }

        return orderPositions;
    }

    private void setContents(Order order) {
        deleteContents(order.getId());

        if (order.getOrderContent() != null) {
            for (OrderPosition orderPosition : order.getOrderContent()) {
                orderPosition.setOrder(order);
                orderPositionDAO.save(orderPosition);
             }
        }
    }

    private void deleteContents(long orderId) {
        dataManager.execute("DELETE FROM ORDER_CONTENT WHERE ORDER_ID = ?", orderId);
    }

    @Override
    public Order getObjectFromResultSet(ResultSet resultSet) throws SQLException {
        Order order = new Order();

        order.setId(resultSet.getLong("ID"));
        order.setTableNumber(resultSet.getInt("TABLE_NUMBER"));
        order.setDate(resultSet.getString("DATE"));
        //order.setWaiter(employeeDAO.getById(resultSet.getLong("WAITER")));
        if (resultSet.getInt("OPEN") == 1) {
            order.setIsClosed(true);
        }

        order.setOrderContent(getContents(order));

        return order;
    }

    @Override
    public void setStatementParamsFromObject(PreparedStatement preparedStatement, Order value) throws SQLException {
        preparedStatement.setInt(1, value.getTableNumber());
        preparedStatement.setDate(2, new Date(System.currentTimeMillis()));
        preparedStatement.setLong(3, value.getWaiter().getId());
        preparedStatement.setInt(4, value.getIsClosed() ? 1 : 0);
    }

    @Override
    public void setIdFromGeneratedKeys(ResultSet generatedKeys, Order value) throws SQLException {
        value.setId(generatedKeys.getLong(1));
    }


    public void setDataManager(MysqlDataManager dataManager) {
        this.dataManager = dataManager;
    }

    public void setEmployeeDAO(MysqlDAO<Employee> employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public void setOrderPositionDAO(MysqlDAO<OrderPosition> orderPositionDAO) {
        this.orderPositionDAO = orderPositionDAO;
    }
}
