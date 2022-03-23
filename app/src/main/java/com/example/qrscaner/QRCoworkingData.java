package com.example.qrscaner;

import java.io.Serializable;
import java.sql.Date;

public class QRCoworkingData implements Serializable {
    private String spaceTitle;
    private String firstname;
    private String lastname;
    private String email;
    private Date startSessionDateTime;
    private Date endSessionDateTime;
    private String purpose;

    public QRCoworkingData(String spaceTitle,
                           String firstname,
                           String lastname,
                           String email,
                           Date startSessionDateTime,
                           Date endSessionDateTime,
                           String purpose) {
        this.spaceTitle = spaceTitle;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.startSessionDateTime = startSessionDateTime;
        this.endSessionDateTime = endSessionDateTime;
        this.purpose = purpose;
    }

    public String getSpaceTitle() {
        return spaceTitle;
    }

    public void setSpaceTitle(String spaceTitle) {
        this.spaceTitle = spaceTitle;
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

    public Date getStartSessionDateTime() {
        return startSessionDateTime;
    }

    public void setStartSessionDateTime(Date startSessionDateTime) {
        this.startSessionDateTime = startSessionDateTime;
    }

    public Date getEndSessionDateTime() {
        return endSessionDateTime;
    }

    public void setEndSessionDateTime(Date endSessionDateTime) {
        this.endSessionDateTime = endSessionDateTime;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
