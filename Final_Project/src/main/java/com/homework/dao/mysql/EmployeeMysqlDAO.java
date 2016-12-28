package com.homework.dao.mysql;

import com.homework.dao.DAO;
import com.homework.model.Employee;
import com.homework.model.Position;

import java.sql.*;
import java.util.List;

public class EmployeeMysqlDAO implements MysqlDAO<Employee> {

    private MysqlDataManager dataManager;
    private MysqlDAO<Position> positionDAO;

    @Override
    public void save(Employee employee) {
        if(employee.getId() == 0) {
            dataManager.create("INSERT INTO EMPLOYEE (NAME, AGE, POSITION_ID) VALUES (?, ?, ?)", employee, this);
        } else{
            dataManager.update("UPDATE EMPLOYEE SET NAME = ?, AGE = ?, POSITION_ID = ? WHERE ID = " + employee.getId(), employee, this);
        }
    }

    @Override
    public void delete(long id) {
        dataManager.execute("DELETE FROM EMPLOYEE WHERE ID = ?", id);
    }

    @Override
    public Employee getById(long id) {
        return dataManager.getById( "SELECT ID, NAME, AGE, POSITION_ID FROM EMPLOYEE WHERE ID = ?", id, this);
    }

    @Override
    public List<Employee> getByName(String name) {
        return dataManager.getAll("SELECT ID, NAME, AGE, POSITION_ID FROM EMPLOYEE WHERE NAME LIKE '%" + name + "%'", this);
    }

    @Override
    public List<Employee> getAll() {
        return dataManager.getAll("SELECT ID, NAME, AGE, POSITION_ID FROM EMPLOYEE", this);
    }

    @Override
    public List<Employee> getFromQuery(String sql) {
        return dataManager.getAll(sql, this);
    }

    @Override
    public Employee getObjectFromResultSet(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();

        employee.setId(resultSet.getLong("ID"));
        employee.setName(resultSet.getString("NAME"));
        employee.setAge(resultSet.getInt("AGE"));
        employee.setPosition(positionDAO.getById(resultSet.getLong("POSITION_ID")));

        return employee;
    }

    @Override
    public void setStatementParamsFromObject(PreparedStatement preparedStatement, Employee value) throws SQLException {
        preparedStatement.setString(1, value.getName());
        preparedStatement.setInt(2, value.getAge());
        if (value.getPosition() != null) {
            preparedStatement.setLong(3, value.getPosition().getId());
        }
    }

    @Override
    public void setIdFromGeneratedKeys(ResultSet generatedKeys, Employee value) throws SQLException {
        value.setId(generatedKeys.getLong(1));
    }


    public void setDataManager(MysqlDataManager dataManager) {
        this.dataManager = dataManager;
    }


    public void setPositionDAO(MysqlDAO<Position> positionDAO) {
        this.positionDAO = positionDAO;
    }
}
