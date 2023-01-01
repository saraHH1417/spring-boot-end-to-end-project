package com.sara.flightcheckin.entities;



public class Passenger extends AbstractEntity{

    private String firstName;
    private String lastName;
    private String email;
    private String phone;


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getLastName() {
        return lastName;
    }

    public String getFirstName(String firstName) {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}