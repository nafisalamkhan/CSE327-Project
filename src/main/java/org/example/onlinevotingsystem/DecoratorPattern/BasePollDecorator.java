package org.example.onlinevotingsystem.DecoratorPattern;

import java.util.List;

import org.example.onlinevotingsystem.models.Poll;
import org.example.onlinevotingsystem.models.User;

public class BasePollDecorator implements IPollDecorator {

    protected IPollDecorator decoratedPoll;
    protected Poll poll;

    public BasePollDecorator(Poll poll) {
        this.poll = poll;
    }

    public BasePollDecorator(IPollDecorator decoratedPoll) {
        this.poll = decoratedPoll.getPoll();
        this.decoratedPoll = decoratedPoll;
    }

    @Override
    public boolean performOperation(String message, String username, List<User> voters) {
        try {

            System.out.println("Default poll operation");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Poll getPoll() {
        return this.poll;
    }
}
