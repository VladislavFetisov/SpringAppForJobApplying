package com.example.testcase.dao;

import com.example.testcase.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User getUserByLogin(String login) {
        assert sessionFactory != null;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from User user where login=:login");
        query.setParameter("login", login);
        List list = query.list();
        if (list.isEmpty()) return null;
        else return (User) list.get(0);
    }
}
