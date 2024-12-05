package org.example.onlinevotingsystem.auth;

import org.example.onlinevotingsystem.models.User;
import org.example.onlinevotingsystem.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceProxy implements IUserServiceProxy {
    private final UserService userService;

    public UserServiceProxy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User findByUsername(String username) {
        // Add additional logic if needed
        System.out.println("Accessing user by username from proxy: " + username);
        return userService.findByUsername(username);
    }
}
