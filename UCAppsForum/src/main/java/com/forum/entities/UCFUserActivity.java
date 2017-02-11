package com.forum.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "EP_USER_ACTIVITY")
public class UCFUserActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@SequenceGenerator(name = "actiivtyidgenerator", sequenceName = "ACTIVITY_ID_SEQ", allocationSize = 1)
    @Column(name = "activity_id")
    private long userActivityID;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UCFUser ucfUser;

    @Column(name = "activity")
    private String userActivity;

    @Column(name = "creation_date")
    private Date creationDate;

    public long getUserActivityID() {
        return userActivityID;
    }

    public String getUserActivity() {
        return userActivity;
    }

    public void setUserActivity(String userActivity) {
        this.userActivity = userActivity;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

	public UCFUser getUcfUser() {
		return ucfUser;
	}

	public void setUcfUser(UCFUser ucfUser) {
		this.ucfUser = ucfUser;
	}

	public void setUserActivityID(long userActivityID) {
		this.userActivityID = userActivityID;
	}

   
}
