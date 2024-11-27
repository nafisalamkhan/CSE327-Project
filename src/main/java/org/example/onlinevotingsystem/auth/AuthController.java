package org.example.onlinevotingsystem.auth;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") @Valid User user, Model model) {
        userService.registerUser(user);
        model.addAttribute("message", "Registration successful. Please wait for admin approval.");
        return "login";
    }

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("error", error);
        return "login";
    }

    @GetMapping("/index")
    public String showIndexPage(Principal principal) {
        String username = principal.getName();

        if ("admin-1".equals(username) || "admin-2".equals(username)) {
            return "redirect:/admin-index";
        }
        return "redirect:/polls";
    }

    @GetMapping("/")
    public String showHomePage(Principal principal) {
        String username = principal.getName();

        if ("admin-1".equals(username) || "admin-2".equals(username)) {
            return "redirect:/admin-index";
        }
        return "redirect:/polls";
    }
}
