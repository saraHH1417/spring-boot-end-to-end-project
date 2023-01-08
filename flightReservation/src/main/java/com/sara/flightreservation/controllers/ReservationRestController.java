package com.sara.flightreservation.controllers;

import com.sara.flightreservation.DateTransferObject.ReservationUpdateRequest;
import com.sara.flightreservation.entities.Reservation;
import com.sara.flightreservation.repositories.ReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
public class ReservationRestController {

    @Autowired
    ReservationRepository reservationRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

    @RequestMapping("/reservations/{id}")
    public Reservation findReservation(@PathVariable("id") Long id) {
        LOGGER.info("Inside findReservation() for id: " + id);
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if (reservation.isPresent()) {
            return reservation.get();
        }
       return null;
    }

    @RequestMapping("/reservations")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
        LOGGER.info("Inside updateReservation() for " + request);
        Optional<Reservation> reservation = reservationRepository.findById(request.getId());
        if (reservation.isPresent()) {
            Reservation reservationGet = reservation.get();
            reservationGet.setNumberOfBags(request.getNumberOfBags());
            reservationGet.setCheckedIn(request.getCheckedIn());
            Reservation updateedReservation = reservationRepository.save(reservationGet);
            LOGGER.info("Saving Reservation");
            return updateedReservation;
        }
        return null;
    }
}
