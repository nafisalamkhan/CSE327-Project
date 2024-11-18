package org.example.onlinevotingsystem.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "poll") // Matches the table name in your MySQL database
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the primary key
    @Column(name = "PollID") // Matches the "PollID" column in the database
    private int pollID;

    @Column(name = "Title", nullable = false, length = 200) // Matches the "Title" column
    private String title;

    @Column(name = "type", length = 10) // Matches the "type" column, allows null by default
    private String type;

    @Temporal(TemporalType.TIMESTAMP) // Maps to a DATETIME column in MySQL
    @Column(name = "PollDate") // Matches the "PollDate" column
    private Date pollDate;

    @Column(name = "TotalVote", columnDefinition = "INT DEFAULT 0") // Matches the "TotalVote" column
    private int totalVote;

    @Column(name = "AdminID", nullable = false) // Matches the "AdminID" column
    private int adminID;

    @Column(name = "CategoryID", nullable = false) // Matches the "CategoryID" column
    private int categoryID;

    // Default constructor required by JPA
    public Poll() {}

    // Parameterized constructor (excluding pollID, which is auto-generated)
    public Poll(String title, String type, Date pollDate, int totalVote, int adminID, int categoryID) {
        this.title = title;
        this.type = type;
        this.pollDate = pollDate;
        this.totalVote = totalVote;
        this.adminID = adminID;
        this.categoryID = categoryID;
    }

    // Getters and setters
    public int getPollID() {
        return pollID;
    }

    public void setPollID(int pollID) {
        this.pollID = pollID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getPollDate() {
        return pollDate;
    }

    public void setPollDate(Date pollDate) {
        this.pollDate = pollDate;
    }

    public int getTotalVote() {
        return totalVote;
    }

    public void setTotalVote(int totalVote) {
        this.totalVote = totalVote;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
}
