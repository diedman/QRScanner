package com.example.qrscaner;

import java.io.Serializable;
import java.sql.Date;

public class QREventData implements Serializable {
    private String eventTitle;
    private String firstname;
    private String lastname;
    private String email;
    private Date   meetingDate;


    public QREventData(String eventTitle, String firstname, String lastname, String email, Date meetingDate) {
        this.eventTitle = eventTitle;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.meetingDate = meetingDate;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(Date meetingDate) {
        this.meetingDate = meetingDate;
    }
}
