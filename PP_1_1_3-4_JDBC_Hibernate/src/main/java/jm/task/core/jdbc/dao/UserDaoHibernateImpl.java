package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.SQLQuery;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private SessionFactory factory;
    public UserDaoHibernateImpl() {
        try {
            this.factory = new Util().getSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createUsersTable() {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.createSQLQuery(SQLQuery.CREATE_TABLE.getQuery()).executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public void dropUsersTable() {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.createSQLQuery(SQLQuery.DROP_TABLE.getQuery()).executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(new User(name, lastName, age));
            session.getTransaction().commit();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (final Session session = factory.openSession()) {
            User user = session.load(User.class, id);
            if (user != null) {
                session.beginTransaction();
                session.delete(user);
                session.getTransaction().commit();
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (final Session session = factory.openSession()) {
//            CriteriaBuilder cb = session.getCriteriaBuilder();
//            CriteriaQuery<User> cr = cb.createQuery(User.class);
//            Root<User> root = cr.from(User.class);
//            cr.select(root);
//            TypedQuery<User> query = session.createQuery(cr);
//            return  query.getResultList();
            return session.createQuery("select a from User a", User.class).getResultList();
        }
    }

    @Override
    public void cleanUsersTable() {
        try (final Session session = factory.openSession()) {
            session.beginTransaction();
            session.createSQLQuery(SQLQuery.CLEAN_TABLE.getQuery()).executeUpdate();
            session.getTransaction().commit();
        }
    }
    public void closeFactory() {
        if (!factory.isClosed()) {
            factory.close();
        }
    }
}
