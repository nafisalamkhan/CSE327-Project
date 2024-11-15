package org.example.onlinevotingsystem.repositories;

import org.example.onlinevotingsystem.models.poll.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<Poll, Integer> {
}
