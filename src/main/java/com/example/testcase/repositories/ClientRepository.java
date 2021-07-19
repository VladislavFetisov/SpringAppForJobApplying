package com.example.testcase.repositories;

import com.example.testcase.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.comments.CommentLine;

import java.util.List;


public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> getClientByTelephoneNumberContains(String telephoneNumber);

    List<Client> getClientBySurnameContainsIgnoreCase(String name);

    List<Client> getClientBySurnameContainsIgnoreCaseAndNameContainsIgnoreCase(String surname, String name);

    List<Client> getClientBySurnameContainsIgnoreCaseAndNameContainsIgnoreCaseAndMiddleNameContainsIgnoreCase
            (String surname, String name, String middleName);

    List<Client> getClientByPassportSeriesContainsAndPassportNumberContains(String passportSeries, String passportNumber);
}
