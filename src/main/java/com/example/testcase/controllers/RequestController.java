package com.example.testcase.controllers;

import com.example.testcase.dao.ClientDao;
import com.example.testcase.dao.RequestDao;
import com.example.testcase.models.Client;
import com.example.testcase.models.Request;
import com.example.testcase.models.enums.Decision;
import com.example.testcase.models.enums.MaritalStatus;
import com.example.testcase.service.RequestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/creditRequest")
public class RequestController {

    ClientDao clientDao;
    RequestService requestService;

    public RequestController(ClientDao clientDao, RequestService requestService) {
        this.clientDao = clientDao;
        this.requestService = requestService;
    }


    @GetMapping(value = {"/{decision}", ""})
    public String createRequest(Model model, @PathVariable(required = false) String decision) {
        model.addAttribute("client", new Client());
        model.addAttribute("mStatusesInRussian",
                new String[]{"Женат(а)", "Разведен(а)", "Помолвлен(а)", "Свободен(на)"});
        model.addAttribute("mStatusesInEng", MaritalStatus.values());
        if (decision != null && decision.equals(Decision.REJECTED.name()))
            model.addAttribute("rejected", true);
        return "index";
    }

    @PostMapping()
    public String checkPersonInfo(@Valid Client client, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("mStatusesInRussian",
                    new String[]{"Женат(а)", "Разведен(а)", "Помолвлен(а)", "Свободен(на)"});
            model.addAttribute("mStatusesInEng", MaritalStatus.values());
            return "index";
        } else {
            Request request = requestService.makeDecision(clientDao.save(client));
            if (request != null && request.getDecision() == Decision.APPROVED) {
                return "redirect:/contract/" + request.getRequestId();
            }
            return "redirect:/creditRequest/" + Decision.REJECTED;
        }
    }
}
