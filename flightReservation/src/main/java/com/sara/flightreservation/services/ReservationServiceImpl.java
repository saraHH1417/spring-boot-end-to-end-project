package com.sara.flightreservation.services;

import com.sara.flightreservation.DateTransferObject.ReservationRequest;
import com.sara.flightreservation.entities.Flight;
import com.sara.flightreservation.entities.Passenger;
import com.sara.flightreservation.entities.Reservation;
import com.sara.flightreservation.repositories.FlightRepository;
import com.sara.flightreservation.repositories.PassengerRepository;
import com.sara.flightreservation.repositories.ReservationRepository;
import com.sara.flightreservation.util.EmailUtil;
import com.sara.flightreservation.util.PDFGenerator;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    FlightRepository flightRepository;
    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    PDFGenerator pdfGenerator;

    @Autowired
    EmailUtil emailUtil;

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

    private static final String ITINERATY_DIR =  Paths.get("./").toAbsolutePath().toString();

    @Transactional
    @Override
    public Reservation bookFlight(ReservationRequest reservationRequest) {

        LOGGER.info("Inside bookFlight()");

        //Make Payment
        Long flightId = reservationRequest.getFlightId();
        LOGGER.info("Fetching flight for flight id " + flightId);
        Optional<Flight> flight = flightRepository.findById(flightId);

        if (flight.isPresent()) {
            Passenger passenger = new Passenger();
            passenger.setFirstName(reservationRequest.getPassengerFirstName());
            passenger.setLastName(reservationRequest.getPassengerLastName());
            passenger.setPhone(reservationRequest.getPassengerPhone());
            passenger.setEmail(reservationRequest.getPassengerEmail());
            LOGGER.info("Saving the passenger: " + passenger);
            Passenger savedPassenger = passengerRepository.save(passenger);

            Reservation reservation = new Reservation();
            reservation.setFlight(flight.get());
            reservation.setPassenger(savedPassenger);
            reservation.setCheckedIn(false);

            LOGGER.info("Saving the reservation: " + reservation);
            Reservation saveedReservation = reservationRepository.save(reservation);
            String filePath = ITINERATY_DIR + saveedReservation.getId() + ".pdf";

            LOGGER.info("Generating the Itinerary");
            pdfGenerator.generateItinerary(
                    saveedReservation,
                    filePath);
            LOGGER.info("Emailing the Itinerary");
//            emailUtil.sendItinerary(passenger.getEmail(), filePath);
            // I commented the above line because we haven't set the email settings
            // The above line sends the flight details  to the email

            return saveedReservation;
        }

        return null;
    }
}
