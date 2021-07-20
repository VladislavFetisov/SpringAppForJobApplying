package com.example.testcase.dao;

import com.example.testcase.config.HibernateConf;
import com.example.testcase.models.Client;
import com.example.testcase.models.Contract;
import com.example.testcase.models.Request;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
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
    public List<Client> getClients() {
//        Configuration configuration = new Configuration().configure();
//        configuration.addAnnotatedClass(Client.class);
//        configuration.addAnnotatedClass(Contract.class);
//        configuration.addAnnotatedClass(Request.class);
//        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
//        SessionFactorysessionFactory = configuration.buildSessionFactory(builder.build());
//        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
//        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
//                .applySettings(configuration.getProperties());
//        SessionFactory sessionFactory = configuration
//                .buildSessionFactory(builder.build());
        assert sessionFactory != null;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
//        Query query = session.createQuery("from Client");
//        List clients = query.list();
        Client client = new Client();
        client.setName("TRIGGER");
        Request request = new Request();
        session.save(client);
        request.setClient(client);
        client.getRequests().add(request);
        session.save(request);
        session.getTransaction().commit();
        session.close();
        return null;
    }

    @Override
    public List<Client> getClientsBySurname(String surname) {
        return null;
    }

    @Override
    public List<Client> getClientsBySurnameAndName(String surname, String name) {
        return null;
    }

    @Override
    public List<Client> getClientsBySurnameAndNameAndMiddleName(String surname, String name, String middleName) {
        return null;
    }
}
