package com.example.testcase.controllers;

import com.example.testcase.dao.ClientDao;
import com.example.testcase.dao.ContractDao;
import com.example.testcase.dao.RequestDao;
import com.example.testcase.models.Client;
import com.example.testcase.models.Contract;
import com.example.testcase.models.Request;
import com.example.testcase.models.enums.MaritalStatus;
import com.example.testcase.models.enums.Status;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contract")
public class ContractController {
    ClientDao clientDao;
    RequestDao requestDao;
    ContractDao contractDao;

    public ContractController(ClientDao clientDao, RequestDao requestDao, ContractDao contractDao) {
        this.clientDao = clientDao;
        this.requestDao = requestDao;
        this.contractDao = contractDao;
    }

    @GetMapping("/{id}")
    public String getRequest(@PathVariable Long id, Model model) {
        Request requestFromDb = requestDao.findById(id);
        Client clientFromDb = requestFromDb.getClient();
        Contract contract;
        if (requestFromDb.getContract() == null) {
            contract = new Contract();
            contract.setStatus(Status.UNSIGNED);
            contract.setRequest(requestFromDb);
            contractDao.save(contract);
            requestFromDb.setContract(contract);
        } else contract = requestFromDb.getContract();

        model.addAttribute("client", clientFromDb);
        model.addAttribute("request", requestFromDb);
        model.addAttribute("maritalStatuses", MaritalStatus.values());
        model.addAttribute("contract", contract);
        model.addAttribute("contractStatuses", Status.values());
        return "contractPage";
    }

    @PostMapping("/{contractId}")
    public String signContract(@PathVariable Long contractId) {
        contractDao.setStatusOfContractById(contractId, Status.SIGNED);
        Request request=contractDao.getById(contractId).getRequest();
        return "redirect:/contract/" + request.getRequestId();
    }
}
