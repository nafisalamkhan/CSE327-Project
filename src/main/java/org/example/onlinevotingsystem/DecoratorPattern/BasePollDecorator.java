package org.example.onlinevotingsystem.DecoratorPattern;

import org.example.onlinevotingsystem.models.Poll;
import org.example.onlinevotingsystem.models.Voter;

import java.util.List;



public class BasePollDecorator implements IPollDecorator {

    protected  IPollDecorator decoratedPoll;
    protected Poll poll;

    public BasePollDecorator(Poll poll){
        this.poll = poll;
    }

    public BasePollDecorator(IPollDecorator decoratedPoll){
        this.poll = decoratedPoll.getPoll();
        this.decoratedPoll = decoratedPoll;
    }

    @Override
    public void performOperation(String message, String username, List<Voter> voters) {
        System.out.println("Default poll operation");
    }

    @Override
    public Poll getPoll() {
        return this.poll;
    }
}
