package com.example.testcase.dao;

import com.example.testcase.models.Client;
import com.example.testcase.models.Contract;
import com.example.testcase.models.Request;
import com.example.testcase.models.enums.Status;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContractDaoImpl implements ContractDao {

    final
    SessionFactory sessionFactory;


    public ContractDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Contract save(Contract contract) {
        assert sessionFactory != null;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(contract);
        session.getTransaction().commit();
        session.close();
        return contract;
    }

    @Override
    public List<Contract> findAll() {
        assert sessionFactory != null;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Contract contr join fetch contr.request req join fetch req.client");
        return (List<Contract>) query.list();
    }

    @Override
    public Contract getById(Long id) {
        Session session = sessionFactory.openSession();
        return session.get(Contract.class, id);
    }


    @Override
    public void setStatusOfContractById(Long id, Status status) {
        assert sessionFactory != null;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Contract contract = session.get(Contract.class, id);
        contract.setStatus(status);
        session.update(contract);
        session.getTransaction().commit();
        session.close();
    }
}
