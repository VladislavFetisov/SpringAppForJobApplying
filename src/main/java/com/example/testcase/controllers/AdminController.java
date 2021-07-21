package com.example.testcase.controllers;

import com.example.testcase.dao.ClientDao;
import com.example.testcase.dao.ContractDao;
import com.example.testcase.dao.RequestDao;
import com.example.testcase.dto.ClientDto;
import com.example.testcase.dto.ContractDto;
import com.example.testcase.dto.RequestDto;
import com.example.testcase.models.Client;
import com.example.testcase.models.Text;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    ClientDao clientDao;
    RequestDao requestDao;
    ContractDao contractDao;

    public AdminController(ClientDao clientDao, RequestDao requestDao, ContractDao contractDao) {
        this.clientDao = clientDao;
        this.requestDao = requestDao;
        this.contractDao = contractDao;
    }

    @GetMapping()
    public String getAdminPage() {
        return "adminPage";
    }

    @PostMapping("/clients")
    @ResponseBody()
    public List<ClientDto> getAllClients() {
        return ClientDto.from(clientDao.findAll());
    }

    @PostMapping("/requests")
    @ResponseBody()
    public List<RequestDto> getAllRequests() {
        return RequestDto.from(requestDao.findAll());
    }

    @PostMapping("/contracts")
    @ResponseBody()
    public List<ContractDto> getAllContracts() {
        return ContractDto.from(contractDao.findAll());
    }

    @PostMapping("/search/fullName")
    @ResponseBody()
    public List<ClientDto> searchByFullName(Text text) {
        String[] params = text.getText().split(" ");
        List<Client> result;
        if (params.length == 1) {
            result = clientDao.getClientsBySurname(params[0]);
        } else if (params.length == 2) {
            result = clientDao.getClientsBySurnameAndName(params[0], params[1]);
        } else {
            result = clientDao.getClientsBySurnameAndNameAndMiddleName(params[0], params[1], params[2]);
        }
        if (result == null) return null;
        return ClientDto.from(result);
    }

    @PostMapping("/search/telephone")
    @ResponseBody()
    public List<ClientDto> searchByTelephone(Text text) {
        String[] params = text.getText().split(" ");
        List<Client> result;
        result = clientDao.getClientsByTelephoneNumber(params[0]);
        if (result == null) return null;
        return ClientDto.from(result);
    }

    @PostMapping("/search/passport")
    @ResponseBody()
    public List<ClientDto> searchByPassport(Text text) {
        String[] params = text.getText().split(" ");
        List<Client> result;
        if (params.length == 1) {
            result = clientDao.getClientByPassportSeries(params[0]);
        } else {
            result = clientDao.getClientByPassportSeriesAndNumber(params[0], params[1]);
        }
        if (result == null) return null;
        return ClientDto.from(result);
    }
}
