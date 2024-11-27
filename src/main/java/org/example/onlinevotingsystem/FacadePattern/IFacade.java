package org.example.onlinevotingsystem.FacadePattern;

import org.example.onlinevotingsystem.auth.User;

public interface IFacade {

    void createUserAndAdminApprovalNotification(User user);
}
