package org.example.onlinevotingsystem.controllers;

import java.security.Principal;
import java.util.*;

import org.example.onlinevotingsystem.models.User;
import org.example.onlinevotingsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.example.onlinevotingsystem.repositories.VoterRepository;
import org.example.onlinevotingsystem.services.NotificationService;
import org.example.onlinevotingsystem.services.PollService;
import org.example.onlinevotingsystem.models.Notification;
import org.example.onlinevotingsystem.models.Poll;

@Controller
public class PollController {

    @Autowired
    private PollService pollService;

    @Autowired
    private UserRepository voterRepository;

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/polls")
    public String showPollsForVoting(Model model,  Principal principal) {
        List<Poll> polls = pollService.getAllPolls();
        // reverse polls
        Collections.reverse(polls);

        Optional<User> currentUser = voterRepository.findByUsername(principal.getName());

        if (currentUser.isPresent()) {
            model.addAttribute("currentUser", currentUser.get());
            List<Notification> notifications = notificationService.getAllNotifications(currentUser.get());
            Collections.sort(notifications, (n1, n2) -> n2.getTimestamp().compareTo(n1.getTimestamp()));
            // unread notifications count
            long unreadCount = notifications.stream().filter(n -> !n.isRead()).count();
            model.addAttribute("unreadcount", unreadCount);
            model.addAttribute("notifications", notifications);

            // already votted map of current user
            Map<Integer, Boolean> map;
            map = pollService.getAlreadyVottedMap(currentUser.get());
            model.addAttribute("alreadyVottedMap", map);

            Map<Integer, Boolean> votedOptions = pollService.getVotedOptions(polls, currentUser.get().getId());
            model.addAttribute("vottedOptionsMap", votedOptions);

        }else {
            model.addAttribute("currentUser", null);
            model.addAttribute("vottedOptionsMap", new HashMap<Long, Boolean>());
            model.addAttribute("alreadyVottedMap", new HashMap<Integer, Boolean>());
        }

        model.addAttribute("polls", polls);

        return "polls-view";
    }

    @PostMapping("/polls/vote")
    public String castVote(Principal principal, @RequestParam("optionId") int optionId, Model model) {

        String username = principal.getName();

        pollService.castVote(optionId, username);
        return "redirect:/polls";
    }

    @PostMapping("/polls/{pollId}/subscribe")
    public ResponseEntity<?> subscribeToPoll(@PathVariable Long pollId, Principal principal) {
        String responseMessage = pollService.subscribeToPoll(pollId, principal.getName());
        return ResponseEntity.ok(responseMessage);
    }

    @PostMapping("/polls/{pollId}/unsubscribe")
    public ResponseEntity<?> unsubscribeFromPoll(@PathVariable Long pollId, Principal principal) {
        String responseMessage = pollService.unsubscribeFromPoll(pollId, principal.getName());
        return ResponseEntity.ok(responseMessage);
    }

}
