package com.example.testcase.controllers;

import com.example.testcase.models.Client;
import com.example.testcase.models.Contract;
import com.example.testcase.models.Request;
import com.example.testcase.models.enums.MaritalStatus;
import com.example.testcase.models.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contract")
public class ContractController {
//    final
//    ClientRepository clientRepository;
//    RequestRepository requestRepository;
//    ContractRepository contractRepository;
//
//    @Autowired
//    public ContractController(ClientRepository clientRepository,
//                              RequestRepository requestRepository,
//                              ContractRepository contractRepository) {
//        this.clientRepository = clientRepository;
//        this.requestRepository = requestRepository;
//        this.contractRepository = contractRepository;
//    }
//
//    @GetMapping("/{id}")
//    public String getRequest(@PathVariable Long id, Model model) {
//        Request requestFromDb = requestRepository.getById(id);
//        Client clientFromDb = requestFromDb.getClient();
//        Contract contract;
//        if (requestFromDb.getContract() == null) {
//            contract = new Contract();
//            contract.setStatus(Status.UNSIGNED);
//            contract.setRequest(requestFromDb);
//            contractRepository.save(contract);
//            requestFromDb.setContract(contract);
//        } else contract = requestFromDb.getContract();
//
//        model.addAttribute("client", clientFromDb);
//        model.addAttribute("request", requestFromDb);
//        model.addAttribute("maritalStatuses", MaritalStatus.values());
//        model.addAttribute("contract", contract);
//        model.addAttribute("contractStatuses", Status.values());
//        return "contractPage";
//    }
//
//    @PostMapping("/{contractId}")
//    public String signContract(@PathVariable Long contractId) {
//        contractRepository.setStatusOfContractById(contractId, String.valueOf(Status.SIGNED));
//        Request request=contractRepository.getById(contractId).getRequest();
//        return "redirect:/contract/" + request.getRequestId();
//    }
}
