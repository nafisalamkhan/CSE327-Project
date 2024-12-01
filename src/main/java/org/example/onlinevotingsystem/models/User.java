package org.example.onlinevotingsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @Column(name = "enabled")
    private boolean enabled = false; // Default to false until approved

    @ManyToMany
    @JoinTable(name = "voted_polls", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "PollID"))
    private List<Poll> votedPolls;

    @ManyToMany
    @JoinTable(name = "favorite_polls", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "PollID"))
    private List<Poll> favoritePolls;


    @ManyToMany(mappedBy = "subscribedVoters")
    private List<Poll> subscribedPolls = new ArrayList<>();

    public void addSubscribedPoll(Poll poll) {
        subscribedPolls.add(poll);
    }

    public void removeSubscribedPoll(Poll poll) {
        subscribedPolls.remove(poll);
    }
}
