package org.example.onlinevotingsystem.services;


import java.util.Optional;

import org.example.onlinevotingsystem.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.example.onlinevotingsystem.repositories.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // Get Admin by ID
    public Optional<User> getAdminById(int adminId) {
        return adminRepository.findById(adminId);
    }

    // Create Admin
    public User createAdmin(User admin) {
        return adminRepository.save(admin);
    }

    // Verify Password
    public boolean verifyPassword(String username, String password) {
        Optional<User> admin = adminRepository.findByUsername(username);
        return admin.isPresent() && admin.get().getPassword().equals(password);
    }

    // find by email
    public User getAdminByUsername(String username) {
        return adminRepository.findByUsername(username).get();
    }
}
