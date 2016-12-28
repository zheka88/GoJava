package com.homework.dao.hibernate;

import com.homework.dao.DAO;
import com.homework.dao.QuantityFilterDAO;
import com.homework.model.Image;
import com.homework.model.Ingredient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ImageHibernateDAO implements DAO<Image> {

    private SessionFactory sessionFactory;

    @Override
    public void save(Image value) {
        sessionFactory.getCurrentSession().save(value);
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Image image = session.load(Image.class, id);
        session.delete(image);
    }

    @Override
    public Image getById(long id) {
        return sessionFactory.getCurrentSession().get(Image.class, id);
    }

    @Override
    public List<Image> getByName(String name) {
        return null;
    }

    @Override
    public List<Image> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("Select image from Image image").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
