package org.example.onlinevotingsystem.DecoratorPattern;

import org.example.onlinevotingsystem.models.User;
import org.example.onlinevotingsystem.services.PollService;

import java.util.List;

public class FavoriteDecorator extends  BasePollDecorator{

    private PollService pollService;

    public  FavoriteDecorator(IPollDecorator pollDecorator, PollService pollService){
        super(pollDecorator);
        this.pollService = pollService;
    }



    @Override
    public boolean performOperation(String message, String username, List<User> voters) {
        return pollService.toggleFavorite((long)poll.getPollId(), username);
    }
}
