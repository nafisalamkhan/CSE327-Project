package org.example.onlinevotingsystem.models;

import java.util.ArrayList;
import java.util.List;

import org.example.onlinevotingsystem.StrategyPattern.PollResult;
import org.example.onlinevotingsystem.repositories.NotificationRepository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "poll")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PollID")
    private int pollId;

    @Column(name = "Title", nullable = false)
    private String title;

    @Column(name = "PollDate")
    private String pollDate;

    @Column(name = "TotalVote")
    private int totalVote;

    @ManyToOne
    @JoinColumn(name = "AdminID")
    private User admin;

    @ManyToOne
    @JoinColumn(name = "CategoryID", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "poll", cascade = CascadeType.ALL)
    private List<Option> options;

    @ManyToMany(mappedBy = "votedPolls")
    private List<User> voters;

    @ManyToMany
    @JoinTable(name = "poll_voter_subscription", joinColumns = @JoinColumn(name = "poll_id"), inverseJoinColumns = @JoinColumn(name = "NID"))
    private List<User> subscribedVoters = new ArrayList<>();

    @Column(name = "voting_strategy")
    private String votingStrategy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "poll_result_id", referencedColumnName = "id")
    private PollResult pollResults;

    private String weight;

    // Subscribe a voter to the poll
    public void subscribe(User voter) {
        subscribedVoters.add(voter);
    }

    // Unsubscribe a voter from the poll
    public void unsubscribe(User voter) {
        subscribedVoters.remove(voter);
    }


    public String getType() {
        return this.getClass().getAnnotation(DiscriminatorValue.class).value();
    }



}
