package com.homework.dao.hibernate;

import com.homework.dao.DAO;
import com.homework.model.Dish;
import com.homework.model.DishComponent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class DishHibernateDAO implements DAO<Dish> {

    private SessionFactory sessionFactory;

    @Override
    public void save(Dish value) {
        for (DishComponent position: value.getComponents()) {
            position.setDish(value);
        }
        sessionFactory.getCurrentSession().saveOrUpdate(value);
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Dish dish = session.load(Dish.class, id);
        session.delete(dish);
    }

    @Override
    public Dish getById(long id) {
        return sessionFactory.getCurrentSession().get(Dish.class, id);
    }

    @Override
    public List<Dish> getByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("Select dish from Dish dish where name like :name");
        query.setParameter("name", "%" + name + "%");
        return query.list();
    }

    @Override
    public List<Dish> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("Select dish from Dish dish").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
