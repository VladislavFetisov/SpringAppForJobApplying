package com.example.testcase.controllers;

import com.example.testcase.dao.ClientDao;
import com.example.testcase.models.Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    final
    ClientDao clientDao;


    public AdminController(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @PostMapping("/clients")
    @ResponseBody()
    public List<Client> getAllClients() {
        return clientDao.getClients();
    }
//    ClientRepository clientRepository;
//    ContractRepository contractRepository;
//    RequestRepository requestRepository;
//
//    @Autowired
//    public AdminController(ClientRepository clientRepository,
//                           ContractRepository contractRepository,
//                           RequestRepository requestRepository) {
//        this.clientRepository = clientRepository;
//        this.contractRepository = contractRepository;
//        this.requestRepository = requestRepository;
//    }
//
//    @GetMapping()
//    public String getAdminPage() {
//        return "adminPage";
//    }
//

//
//    @PostMapping("/requests")
//    @ResponseBody()
//    public List<RequestDto> getAllRequests() {
//        return RequestDto.from(requestRepository.findAll());
//    }
//
//    @PostMapping("/contracts")
//    @ResponseBody()
//    public List<ContractDto> getAllContracts() {
//        return ContractDto.from(contractRepository.findAll());
//    }
//
//    @PostMapping("/search")
//    @ResponseBody()
//    public List<ClientDto> findClient(Text text) {
//        String[] params = text.getText().split(" ");
//        List<Client> result;
//        if (params.length == 1) {
//            if (params[0].matches(("[0-9]+"))) {
//                result = clientRepository.getClientByTelephoneNumberContains(params[0]);
//            } else {
//                result = clientRepository.getClientBySurnameContainsIgnoreCase(params[0]);
//            }
//        } else if (params.length == 2) {
//            if (params[0].matches(("[0-9]+")) && params[1].matches(("[0-9]+"))) {
//                result = clientRepository.getClientByPassportSeriesContainsAndPassportNumberContains(params[0], params[1]);
//            } else {
//                result = clientRepository.getClientBySurnameContainsIgnoreCaseAndNameContainsIgnoreCase(params[0], params[1]);
//            }
//        } else {
//            result = clientRepository.
//                    getClientBySurnameContainsIgnoreCaseAndNameContainsIgnoreCaseAndMiddleNameContainsIgnoreCase
//                            (params[0], params[1], params[2]);
//        }
//        if (result == null) return new ArrayList<>();
//        return ClientDto.from(result);
//    }

}
