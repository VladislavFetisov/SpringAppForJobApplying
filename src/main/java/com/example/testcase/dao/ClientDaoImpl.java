package com.example.testcase.dao;

import com.example.testcase.models.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDaoImpl implements ClientDao {
    final
    SessionFactory sessionFactory;

    public ClientDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Client> findAll() {
        assert sessionFactory != null;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Client");
        List<Client> output = query.list();
        session.close();
        return output;
    }


    @Override
    public Client save(Client client) {
        assert sessionFactory != null;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(client);
        session.getTransaction().commit();
        session.close();
        return client;
    }

    @Override
    public List<Client> getClientsBySurname(String surname) {
        assert sessionFactory != null;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Client where upper(surname) like upper( concat(:param,'%'))");
        query.setParameter("param", surname);
        List<Client> output = query.list();
        session.close();
        return output;
    }

    @Override
    public List<Client> getClientsBySurnameAndName(String surname, String name) {
        assert sessionFactory != null;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Client where UPPER( surname) like upper(CONCAT(:surname,'%'))" +
                " and upper(name) like upper(concat( :name,'%'))");
        query.setParameter("surname", surname);
        query.setParameter("name", name);
        List<Client> output = query.list();
        session.close();
        return output;
    }

    @Override
    public List<Client> getClientsBySurnameAndNameAndMiddleName(String surname, String name, String middleName) {
        assert sessionFactory != null;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Client where UPPER( surname) like upper(CONCAT(:surname,'%'))" +
                " and upper(name) like upper(concat( :name,'%')) and upper(middleName) like upper(concat( :middleName,'%'))");
        query.setParameter("surname", surname);
        query.setParameter("name", name);
        query.setParameter("middleName", middleName);
        List<Client> output = query.list();
        session.close();
        return output;
    }

    @Override
    public List<Client> getClientsByTelephoneNumber(String telephoneNumber) {
        assert sessionFactory != null;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Client where telephoneNumber like concat(:param,'%')");
        query.setParameter("param", telephoneNumber);
        List<Client> output = query.list();
        session.close();
        return output;
    }

    @Override
    public List<Client> getClientByPassportSeriesAndNumber(String passportSeries, String passportNumber) {
        assert sessionFactory != null;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Client where passportSeries like CONCAT(:series,'%')" +
                " and passportNumber like concat( :number,'%')");
        query.setParameter("series", passportSeries);
        query.setParameter("number", passportNumber);
        List<Client> output = query.list();
        session.close();
        return output;
    }

    @Override
    public List<Client> getClientByPassportSeries(String passportSeries) {
        assert sessionFactory != null;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Client where passportSeries like CONCAT(:series,'%')");
        query.setParameter("series", passportSeries);
        List<Client> output = query.list();
        session.close();
        return output;
    }

}
