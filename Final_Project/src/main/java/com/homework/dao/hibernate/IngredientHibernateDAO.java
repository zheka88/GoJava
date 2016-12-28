package com.homework.dao.hibernate;

import com.homework.dao.DAO;
import com.homework.dao.QuantityFilterDAO;
import com.homework.model.Ingredient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class IngredientHibernateDAO implements QuantityFilterDAO<Ingredient> {

    private SessionFactory sessionFactory;

    @Override
    public void save(Ingredient value) {
        sessionFactory.getCurrentSession().saveOrUpdate(value);
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Ingredient ingredient = session.load(Ingredient.class, id);
        session.delete(ingredient);
    }

    @Override
    public Ingredient getById(long id) {
        return sessionFactory.getCurrentSession().get(Ingredient.class, id);
    }

    @Override
    public List<Ingredient> getByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("Select ingredient from Ingredient ingredient where name like :name");
        query.setParameter("name", "%" + name + "%");
        return query.list();
    }

    @Override
    public List<Ingredient> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("Select ingredient from Ingredient ingredient").list();
    }

    @Override
    public List<Ingredient> getEnding() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("Select ingredient from Ingredient ingredient where quantity < :quantity");
        query.setParameter("quantity", 10);
        return query.list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
