package com.example.testcase.dao;

import com.example.testcase.models.Request;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RequestDaoImpl implements RequestDao {

    final
    SessionFactory sessionFactory;


    public RequestDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Request save(Request request) {
        assert sessionFactory != null;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(request);
        session.getTransaction().commit();
        session.close();
        return request;
    }

    @Override
    public List<Request> findAll() {
        assert sessionFactory != null;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Request");
        return (List<Request>) query.list();
    }

    @Override
    public Request findById(Long id) {
        Session session = sessionFactory.openSession();
        return session.get(Request.class, id);
    }

}
