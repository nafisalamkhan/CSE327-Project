package org.example.onlinevotingsystem.models;

import java.util.ArrayList;
import java.util.List;
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
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PollID")
    private int pollId;

    @Column(name = "Title", nullable = false)
    private String title;

    @Column(name = "type")
    private String type;

    @Column(name = "PollDate")
    private String pollDate;

    @Column(name = "TotalVote")
    private int totalVote;

    @ManyToOne
    @JoinColumn(name = "AdminID", nullable = false)
    private Voter admin;

    @ManyToOne
    @JoinColumn(name = "CategoryID", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "poll", cascade = CascadeType.ALL)
    private List<Option> options;

    @ManyToMany(mappedBy = "votedPolls")
    private List<Voter> voters;

    @ManyToMany
    @JoinTable(name = "poll_voter_subscription", joinColumns = @JoinColumn(name = "poll_id"), inverseJoinColumns = @JoinColumn(name = "NID"))
    private List<Voter> subscribedVoters = new ArrayList<>();

    // Subscribe a voter to the poll
    public void subscribe(Voter voter) {
        subscribedVoters.add(voter);
    }

    // Unsubscribe a voter from the poll
    public void unsubscribe(Voter voter) {
        subscribedVoters.remove(voter);
    }

    // Notify all subscribed voters about an update
    public void notifyVoters(String message, NotificationRepository notificationRepository, String username) {
        for (Voter voter : subscribedVoters) {
            if (voter.getUsername().equals(username)) {
                continue;
            }
            Notification notification = new Notification(message, voter, this,
                    Notification.NotificationType.POLL_UPDATED);
            notificationRepository.save(notification);
        }
    }


}
