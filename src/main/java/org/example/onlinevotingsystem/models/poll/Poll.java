package org.example.onlinevotingsystem.models.poll;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "poll")
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "PollID")
    private int PollID;

    @Column(name = "Title")
    private String Title;

    @Column(name = "type")
    private String type;

    @Column(name = "PollDate")
    @Temporal(TemporalType.DATE)
    private Date PollDate;

    @Column(name = "TotalValue")
    private int TotalValue;

    @Column(name = "AdminID")
    private int AdminID;

    @Column(name = "CategoryID")
    private int CategoryID;



    // Constructors
    public Poll() {}

    public Poll(int pollID, String title, String type, Date pollDate, int totalVote, int adminID, int categoryID) {
        this.PollID = pollID;
        this.Title = title;
        this.type = type;
        this.PollDate = pollDate;
        this.TotalValue = totalVote;
        this.AdminID = adminID;
        this.CategoryID = categoryID;
    }

    // Getters and setters
    public int getPollID() {
        return PollID;
    }

    public void setPollID(int pollID) {
        this.PollID = PollID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = Title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getPollDate() {
        return PollDate;
    }

    public void setPollDate(Date pollDate) {
        this.PollDate = PollDate;
    }

    public int getTotalVote() {
        return TotalValue;
    }

    public void setTotalVote(int totalVote) {
        this.TotalValue = TotalValue;
    }

    public int getAdminID() {
        return AdminID;
    }

    public void setAdminID(int adminID) {
        this.AdminID = AdminID;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int categoryID) {
        this.CategoryID = CategoryID;
    }

}
