package org.example.onlinevotingsystem.controllers;

import org.example.onlinevotingsystem.models.poll.Poll;
import org.example.onlinevotingsystem.services.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PollController {

    @Autowired
    private PollService pollService;

    @GetMapping("/polls/view")
    public String viewAllPolls(Model model) {
        List<Poll> polls = pollService.getAllPolls();
        model.addAttribute("polls", polls);
        return "polls"; // Refers to polls.html in templates folder
    }
}
