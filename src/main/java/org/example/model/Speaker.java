package org.example.model;

public class Speaker {

    private String firstname;
    private String lastname;
    private double seedNum; // A var that get seeded at runtime.

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

    public double getSeededNum() {
        return seedNum;
    }

    public void setSeedNum(double seededNum) {
        this.seedNum = seededNum;
    }
}
