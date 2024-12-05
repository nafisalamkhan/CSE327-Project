package org.example.onlinevotingsystem.auth;

import org.example.onlinevotingsystem.models.User;

public interface IUserServiceProxy {
    User findByUsername(String username);
}