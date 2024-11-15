package org.example.onlinevotingsystem.repositories;

import org.example.onlinevotingsystem.models.poll.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends JpaRepository<Poll, Integer> {
}
