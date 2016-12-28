package com.homework.dao.hibernate;

import com.homework.dao.DAO;
import com.homework.model.Order;
import com.homework.model.OrderPosition;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class OrderHibernateDAO implements DAO<Order> {

    private SessionFactory sessionFactory;

    @Override
    public void save(Order value) {
        for (OrderPosition position: value.getOrderContent()) {
            position.setOrder(value);
        }
        sessionFactory.getCurrentSession().saveOrUpdate(value);
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Order order = session.load(Order.class, id);
        session.delete(order);
    }

    @Override
    public Order getById(long id) {
        return sessionFactory.getCurrentSession().get(Order.class, id);
    }

    @Override
    public List<Order> getByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("Select order from Order order where name like :name or table_number like :name or waiter.name like :name");
        query.setParameter("name", "%" + name + "%");
        return query.list();
    }

    @Override
    public List<Order> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("Select orders from Order orders order by id desc").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
