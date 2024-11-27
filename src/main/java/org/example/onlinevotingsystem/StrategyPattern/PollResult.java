package org.example.onlinevotingsystem.StrategyPattern;

import java.util.Map;

import org.example.onlinevotingsystem.models.Poll;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "poll_result")
@Data
@NoArgsConstructor
public class PollResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "pollid")
    private Poll poll;

    private String winner;

    @ElementCollection
    @CollectionTable(
            name = "vote_counts",
            joinColumns = @JoinColumn(name = "poll_result_id"),
            foreignKey = @ForeignKey(name = "fk_vote_counts_poll_result")
    )
    @MapKeyColumn(name = "`option`") // Escape the column name
    @Column(name = "count")
    private Map<String, Integer> voteCounts;

    @ElementCollection
    @CollectionTable(
            name = "vote_percentages",
            joinColumns = @JoinColumn(name = "poll_result_id"),
            foreignKey = @ForeignKey(name = "fk_vote_percentages_poll_result")
    )
    @MapKeyColumn(name = "`option`") // Escape the column name
    @Column(name = "percentage")
    private Map<String, Double> votePercentages;

    private long totalVotes = 0;

    private boolean published = false;



}