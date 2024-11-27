package org.example.onlinevotingsystem.DecoratorPattern;

import org.example.onlinevotingsystem.models.Poll;
import org.example.onlinevotingsystem.models.Voter;

import java.util.List;

public interface IPollDecorator {

    void  performOperation(String message, String username, List<Voter> voters);

    Poll getPoll();
}
