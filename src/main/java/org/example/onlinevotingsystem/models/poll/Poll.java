package org.example.onlinevotingsystem.models.poll;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "poll") // Matches the exact table name in your database
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pollID;

    private String title;
    private String type;

    @Temporal(TemporalType.DATE)
    private Date pollDate;

    private int totalVote;
    private int adminID;
    private int categoryID;

    // Constructors
    public Poll() {}

    public Poll(int pollID, String title, String type, Date pollDate, int totalVote, int adminID, int categoryID) {
        this.pollID = pollID;
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
