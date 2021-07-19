package com.example.testcase.controllers;

import com.example.testcase.models.Client;
import com.example.testcase.models.Request;
import com.example.testcase.repositories.ClientRepository;
import com.example.testcase.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/creditRequest")
public class RequestController {
    final
    RequestService requestService;

    final
    ClientRepository clientRepository;

    @Autowired
    public RequestController(RequestService requestService, ClientRepository clientRepository) {
        this.requestService = requestService;
        this.clientRepository = clientRepository;
    }

    @GetMapping()
    public String createRequest(Model model) {
        model.addAttribute("client", new Client());
        model.addAttribute("mStatuses", Client.MaritalStatus.values());
        return "index";
    }

    @PostMapping()
    public String checkPersonInfo(@Valid Client client, BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println("BINDING RESULT ERROR");
            model.addAttribute("mStatuses", Client.MaritalStatus.values());
            return "index";
        } else {
            Request request = requestService.makeDecision(clientRepository.save(client));
            if (request != null && request.getDecision() == Request.Decision.APPROVED) {
                return "redirect:/contract/" + request.getRequestId();
            }
            return "redirect:/creditRequest";
        }
    }
}
