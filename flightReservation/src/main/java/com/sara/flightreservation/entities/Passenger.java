package com.sara.flightreservation.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "PASSENGER")
public class Passenger extends AbstractEntity{


    private String passenger;
    private String lastName;
    private String email;
    private String phone;

    public void setPassenger(String passenger) {
        this.passenger = passenger;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassenger() {
        return passenger;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
