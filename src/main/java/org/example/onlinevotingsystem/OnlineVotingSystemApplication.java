package org.example.onlinevotingsystem;

import org.example.onlinevotingsystem.auth.Role;
import org.example.onlinevotingsystem.auth.RoleRepository;
import org.example.onlinevotingsystem.auth.User;
import org.example.onlinevotingsystem.auth.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class OnlineVotingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineVotingSystemApplication.class, args);
    }


    @Bean
    CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (roleRepository.findByName("ROLE_USER").isEmpty()) {
                roleRepository.save(new Role("ROLE_USER"));
                roleRepository.save(new Role("ROLE_ADMIN"));

                User admin = new User();
                admin.setName("Super Admin");
                admin.setUsername("admin");
                admin.setEmail("admin@example.com");
                admin.setPassword(passwordEncoder.encode("123"));
                admin.setEnabled(true);
                admin.setRoles(Set.of(roleRepository.findByName("ROLE_ADMIN").get()));
                userRepository.save(admin);
            }
        };
    }


}
