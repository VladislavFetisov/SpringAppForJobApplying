package com.example.testcase.dao;

import com.example.testcase.models.Client;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public interface ClientDao extends Crud<Client> {

    @Override
    List<Client> findAll();

    @Override
    Client save(Client client);

    List<Client> getClientsBySurname(String surname);

    List<Client> getClientsBySurnameAndName(String surname, String name);

    List<Client> getClientsBySurnameAndNameAndMiddleName(String surname, String name, String middleName);

    List<Client> getClientsByTelephoneNumber(String telephoneNumber);

    List<Client> getClientByPassportSeriesAndNumber(String passportSeries, String passportNumber);

    List<Client> getClientByPassportSeries(String passportSeries);
}
