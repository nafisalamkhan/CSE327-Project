package org.example.onlinevotingsystem.repositories;


import java.util.List;

import org.example.onlinevotingsystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.example.onlinevotingsystem.models.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByRecipient(User voter);
}