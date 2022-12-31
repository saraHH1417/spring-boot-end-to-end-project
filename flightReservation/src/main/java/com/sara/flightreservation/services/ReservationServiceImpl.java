package com.sara.flightreservation.services;

import com.sara.flightreservation.DateTransferObject.ReservationRequest;
import com.sara.flightreservation.entities.Flight;
import com.sara.flightreservation.entities.Passenger;
import com.sara.flightreservation.entities.Reservation;
import com.sara.flightreservation.repositories.FlightRepository;
import com.sara.flightreservation.repositories.PassengerRepository;
import com.sara.flightreservation.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    FlightRepository flightRepository;
    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    ReservationRepository reservationRepository;


    @Override
    public Reservation bookFlight(ReservationRequest reservationRequest) {
        //Make Payment

        Long flightId = reservationRequest.getFlightId();
        Optional<Flight> flight = flightRepository.findById(flightId);

        if (flight.isPresent()) {
            Passenger passenger = new Passenger();
            passenger.setFirstName(reservationRequest.getPassengerFirstName());
            passenger.setLastName(reservationRequest.getPassengerLastName());
            passenger.setPhone(reservationRequest.getPassengerPhone());
            passenger.setEmail(reservationRequest.getPassengerEmail());
            Passenger savedPassenger = passengerRepository.save(passenger);

            Reservation reservation = new Reservation();
            reservation.setFlight(flight.get());
            reservation.setPassenger(savedPassenger);
            reservation.setCheckedIn(false);
            Reservation saveedReservation = reservationRepository.save(reservation);

            return saveedReservation;
        }

        return null;
    }
}
