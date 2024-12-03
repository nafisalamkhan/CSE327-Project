package org.example.onlinevotingsystem.DecoratorPattern;

import org.example.onlinevotingsystem.models.Notification;
import org.example.onlinevotingsystem.models.User;
import org.example.onlinevotingsystem.repositories.NotificationRepository;

import java.util.List;

public class NotificationDecorator extends BasePollDecorator{

    private NotificationRepository notificationRepository;

    public NotificationDecorator(IPollDecorator pollDecorator, NotificationRepository notificationRepository){

        super(pollDecorator);
        this.notificationRepository = notificationRepository;
    }

    @Override
    public boolean performOperation(String message, String username, List<User> voters) {
        return notificationService.notifyVoters(message, username, voters, poll);

    }

}
