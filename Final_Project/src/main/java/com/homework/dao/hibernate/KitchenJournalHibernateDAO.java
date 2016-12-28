package com.homework.dao.hibernate;

import com.homework.dao.DAO;
import com.homework.model.KitchenJournalItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class KitchenJournalHibernateDAO implements DAO<KitchenJournalItem> {

    private SessionFactory sessionFactory;

    @Override
    public void save(KitchenJournalItem value) {
        sessionFactory.getCurrentSession().save(value);
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        KitchenJournalItem kitchenJournalItem = session.load(KitchenJournalItem.class, id);
        session.delete(kitchenJournalItem);
    }

    @Override
    public KitchenJournalItem getById(long id) {
        return sessionFactory.getCurrentSession().get(KitchenJournalItem.class, id);
    }

    @Override
    public List<KitchenJournalItem> getByName(String name) {
        return null;
    }

    @Override
    public List<KitchenJournalItem> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("Select kitchen from KitchenJournalItem kitchen").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
