package com.sara.flightcheckin.entities;


import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;


public class Flight extends AbstractEntity{

    private String operatingAirlines;
    private String departureCity;
    private String arrivalCity;
    private String flightNumber;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateOfDeparture;
    private Timestamp estimatedDepartureTime;



    public String getOperatingAirlines() {
        return operatingAirlines;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public Date getDateOfDeparture() {
        return dateOfDeparture;
    }

    public Timestamp getEstimatedDepartureTime() {
        return estimatedDepartureTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setOperatingAirlines(String operationAirlines) {
        this.operatingAirlines = operationAirlines;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public void setDateOfDeparture(Date dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public void setEstimatedDepartureTime(Timestamp estimatedDepartureime) {
        this.estimatedDepartureTime = estimatedDepartureime;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
}
