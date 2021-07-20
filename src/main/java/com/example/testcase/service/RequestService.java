package com.example.testcase.service;

import com.example.testcase.models.Client;
import com.example.testcase.models.Request;
import com.example.testcase.models.enums.Decision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RequestService {
//    final
//    RequestRepository requestRepository;
//
//    @Autowired
//    public RequestService(RequestRepository requestRepository) {
//        this.requestRepository = requestRepository;
//    }
//
//    public Request makeDecision(Client client) {
//        Request request = new Request();
//        Random random = new Random();
//        request.setClient(client);
//        client.getRequests().add(request);
//        if (random.nextBoolean()) {
//            request.setDecision(Decision.APPROVED);
//            request.setLoanSum((client.getCreditAmount()));
//            request.setMonthsAmount(String.valueOf(random.nextInt(12) + 1));
//        } else {
//            request.setDecision(Decision.REJECTED);
//            request.setLoanSum("0");
//            request.setMonthsAmount("0");
//        }
//        return requestRepository.save(request);
//    }
}
