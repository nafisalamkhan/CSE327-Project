package org.example.onlinevotingsystem.DecoratorPattern;

import org.example.onlinevotingsystem.models.Poll;
import org.example.onlinevotingsystem.models.User;

import java.util.List;

public interface IPollDecorator {

    boolean  performOperation(String message, String username, List<User> voters);

    Poll getPoll();
}
