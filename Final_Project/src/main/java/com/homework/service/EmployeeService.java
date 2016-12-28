package com.homework.service;


import com.homework.dao.DAO;
import com.homework.model.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class EmployeeService {

    private DAO<Employee> employeeDAO;

    @Transactional
    public void save(Employee employee){
        employeeDAO.save(employee);
    }

    @Transactional
    public void delete(long id){
        employeeDAO.delete(id);
    }

    @Transactional
    public List<Employee> getByName(String name){
        return employeeDAO.getByName(name);
    }

    @Transactional
    public Employee getById(long id){
        return employeeDAO.getById(id);
    }

    @Transactional
    public List<Employee> getAll(){
        return employeeDAO.getAll();
    }

    public void setEmployeeDAO(DAO<Employee> employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
}
