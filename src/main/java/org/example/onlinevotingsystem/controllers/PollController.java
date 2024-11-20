package org.example.onlinevotingsystem.controllers;

import org.example.onlinevotingsystem.repositories.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PollController {

    @Autowired
    private PollRepository pollRepository;

    @GetMapping(path = "/polls")
    public String getPolls(Model model) {
        model.addAttribute("polls", pollRepository.findAll());
        return "polls";
    }
}