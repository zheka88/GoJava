package com.homework.dao.mysql;

import com.homework.dao.DAO;
import com.homework.model.Dish;
import com.homework.model.Menu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MenuMysqlDAO implements MysqlDAO<Menu> {

    private MysqlDataManager dataManager;
    private MysqlDAO<Dish> dishDAO;

    @Override
    public void save(Menu menu) {
        if (menu.getId() == 0) {
            dataManager.create("INSERT INTO MENU (NAME) VALUES (?)", menu, this);
        } else {
            dataManager.update("UPDATE MENU SET NAME = ? WHERE ID = " + menu.getId(), menu, this);
        }
        setDishes(menu);
    }

   @Override
    public void delete(long id) {
        dataManager.execute("DELETE FROM MENU WHERE ID = ?", id);
    }

    @Override
    public Menu getById(long id) {
        return dataManager.getById("SELECT ID, NAME FROM MENU WHERE ID = ?", id, this);
    }

    @Override
    public List<Menu> getByName(String name) {
        return dataManager.getAll("SELECT ID, NAME FROM MENU WHERE NAME LIKE '%" + name + "%'", this);
    }

    @Override
    public List<Menu> getAll() {
        return dataManager.getAll("SELECT ID, NAME FROM MENU", this);
    }

    @Override
    public List<Menu> getFromQuery(String sql) {
        return dataManager.getAll(sql, this);
    }

    private List<Dish> getDishes(long menuId) {

        String sql = "SELECT ID, NAME " +
                "FROM DISH where ID in " +
                "(select DISH_ID from MENU_CONTENT " +
                "where MENU_ID = " + menuId + ")";

        return dishDAO.getFromQuery(sql);
     }

    private void setDishes(Menu menu) {
        deleteDishes(menu.getId());

        if (menu.getDishes() != null) {
            for (Dish dish : menu.getDishes()) {
                dataManager.execute("INSERT INTO MENU_CONTENT(MENU_ID, DISH_ID) VALUES ("
                        + "?, " + dish.getId() + ")", menu.getId());
            }
        }
    }

    private void deleteDishes(long menuId) {
        dataManager.execute("DELETE FROM MENU_CONTENT WHERE MENU_ID = ?", menuId);
    }

    @Override
    public Menu getObjectFromResultSet(ResultSet resultSet) throws SQLException {
        Menu menu = new Menu();

        menu.setId(resultSet.getLong("ID"));
        menu.setName(resultSet.getString("NAME"));
        menu.setDishes(getDishes(menu.getId()));

        return menu;
    }

    @Override
    public void setStatementParamsFromObject(PreparedStatement preparedStatement, Menu value) throws SQLException {
        preparedStatement.setString(1, value.getName());
    }

    @Override
    public void setIdFromGeneratedKeys(ResultSet generatedKeys, Menu value) throws SQLException {
        value.setId(generatedKeys.getLong(1));
    }

    public void setDataManager(MysqlDataManager dataManager) {
        this.dataManager = dataManager;
    }

    public void setDishDAO(MysqlDAO<Dish> dishDAO) {
        this.dishDAO = dishDAO;
    }
}
