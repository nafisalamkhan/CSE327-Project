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
    public void performOperation(String message, String username, List<User> voters) {
        notifyVoters(message, username, voters);
    }

    private void notifyVoters(String message, String username, List<User> subscribedvoters){
        for(User voter : subscribedvoters){
            if (voter.getUsername().equals(username)){
                continue;
            }
            Notification notification = new Notification(message, voter, poll, Notification.NotificationType.POLL_UPDATED);
            notificationRepository.save(notification);
        }
    }

}
