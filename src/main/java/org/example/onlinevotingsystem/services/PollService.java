package org.example.onlinevotingsystem.services;

import org.example.onlinevotingsystem.models.poll.Poll;
import org.example.onlinevotingsystem.repositories.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollService {

    @Autowired
    private PollRepository pollRepository;

    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }
}
