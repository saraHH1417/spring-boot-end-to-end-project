package com.sara.flightcheckin.entities;

public class Reservation extends AbstractEntity{

    private Boolean checkedIn;
    private int numberOfBags;
    private Passenger passenger;
    private Flight flight;


    public void setCheckedIn(Boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public void setNumberOfBags(int numberOfBags) {
        this.numberOfBags = numberOfBags;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Boolean getCheckedIn() {
        return checkedIn;
    }

    public int getNumberOfBags() {
        return numberOfBags;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Flight getFlight() {
        return flight;
    }
}
