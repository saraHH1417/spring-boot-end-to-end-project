package com.sara.flightreservation.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "FLIGHT")
public class Flight extends AbstractEntity{

    private String operationAirline;
    private String departureCity;
    private String arrivalCity;
    private Date dateOfDeparture;
    private Timestamp estimatedDepartureime;



    public String getOperationAirline() {
        return operationAirline;
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

    public Timestamp getEstimatedDepartureime() {
        return estimatedDepartureime;
    }


    public void setOperationAirline(String operationAirline) {
        this.operationAirline = operationAirline;
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

    public void setEstimatedDepartureime(Timestamp estimatedDepartureime) {
        this.estimatedDepartureime = estimatedDepartureime;
    }
}
