package com.sara.flightcheckin.integration;

import com.sara.flightcheckin.dto.ReservationUpdateRequest;
import com.sara.flightcheckin.entities.Reservation;

public interface ReservationRestClient {

    public Reservation findReservation(Long id);
    public Reservation updateReservation(ReservationUpdateRequest request);
}
