package org.example.onlinevotingsystem.services;



import java.util.List;

import org.example.onlinevotingsystem.models.Notification;
import org.example.onlinevotingsystem.models.User;
import org.example.onlinevotingsystem.repositories.NotificationRepository;
import org.example.onlinevotingsystem.repositories.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private VoterRepository voterRepository;

    public void markAsRead(Long notificationId, String username) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("Notification not found"));

        if (!notification.getRecipient().getUsername().equals(username)) {
            throw new SecurityException("Unauthorized access to this notification.");
        }

        notification.setRead(true);
        notificationRepository.save(notification);
    }

    public List<Notification> getAllNotifications(User voter) {

        return notificationRepository.findByRecipient(voter);

    }







    public void setNotificationToAdmin(String role){

        // get admin by role
        // get all user with role admin

    }

}
