package org.example.onlinevotingsystem.controllers;

import org.example.onlinevotingsystem.models.poll.Poll;
import org.example.onlinevotingsystem.repositories.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PollController {

    @Autowired
    PollRepository pollRepository;

    @GetMapping(path = "getdata")
    List<Poll> getPolls(){
        return pollRepository.findAll();

    }

}