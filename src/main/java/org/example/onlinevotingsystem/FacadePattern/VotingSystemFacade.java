package org.example.onlinevotingsystem.FacadePattern;


import org.example.onlinevotingsystem.models.User;
import org.example.onlinevotingsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VotingSystemFacade implements IFacade {

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public void createUserAndAdminApprovalNotification(User user) {

        //creating user
        userService.registerUser(user);
        //creating notification
        //notificationService.sendNotificationToAdmin(Constants.ROLE_ADMIN_USER_Approver);
    }
}
