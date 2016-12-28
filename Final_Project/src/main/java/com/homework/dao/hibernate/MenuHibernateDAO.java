package com.homework.dao.hibernate;

import com.homework.dao.DAO;
import com.homework.model.Menu;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class MenuHibernateDAO implements DAO<Menu> {

    private SessionFactory sessionFactory;

    @Override
    public void save(Menu value) {
        sessionFactory.getCurrentSession().saveOrUpdate(value);
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Menu menu = session.load(Menu.class, id);
        session.delete(menu);
    }

    @Override
    public Menu getById(long id) {
        return sessionFactory.getCurrentSession().get(Menu.class, id);
    }

    @Override
    public List<Menu> getByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("Select menu from Menu menu where name like :name");
        query.setParameter("name", "%" + name + "%");
        return query.list();
    }

    @Override
    public List<Menu> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("Select menu from Menu menu").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
