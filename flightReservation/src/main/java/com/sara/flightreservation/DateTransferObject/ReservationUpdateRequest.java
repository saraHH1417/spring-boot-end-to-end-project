package com.sara.flightreservation.DateTransferObject;

import com.oracle.wls.shaded.org.apache.xpath.operations.Bool;

public class ReservationUpdateRequest {
    private Long id;
    private Boolean checkedIn;
    private int numberOfBags;

    public Long getId() {
        return id;
    }

    public Boolean getCheckedIn() {
        return checkedIn;
    }

    public int getNumberOfBags() {
        return numberOfBags;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCheckedIn(Boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public void setNumberOfBags(int numberOfBags) {
        this.numberOfBags = numberOfBags;
    }
}
