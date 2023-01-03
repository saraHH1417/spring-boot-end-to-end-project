package com.sara.flightcheckin.integration;

import com.sara.flightcheckin.dto.ReservationUpdateRequest;
import com.sara.flightcheckin.entities.Reservation;

public interface ReservationRestClient {

    Reservation findReservation(Long id);
    Reservation updateReservation(ReservationUpdateRequest request);
}
