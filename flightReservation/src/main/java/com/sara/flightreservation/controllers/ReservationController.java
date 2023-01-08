package com.sara.flightreservation.controllers;

import com.oracle.wls.shaded.org.apache.xpath.operations.Mod;
import com.sara.flightreservation.DateTransferObject.ReservationRequest;
import com.sara.flightreservation.entities.Flight;
import com.sara.flightreservation.entities.Reservation;
import com.sara.flightreservation.repositories.FlightRepository;
import com.sara.flightreservation.services.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ReservationController {

    @Autowired
    FlightRepository flightRepository;
    @Autowired
    ReservationService reservationService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

    @RequestMapping("showCompleteReservation")
    public String showCompleteReservation(@RequestParam("flightId") Long flightId,
                                          ModelMap modelMap) {
        LOGGER.info("ShowCompleteReservation() invoked with flightID" + flightId);
        Optional<Flight> flight = flightRepository.findById(flightId);
        if (flight.isPresent()) {
            modelMap.addAttribute("flight", flight.get());
            LOGGER.info("Flight is " + flight);
            return "completeReservation";
        }
        return "findFlights";
    }

    @RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
    public String completeReservation(ReservationRequest reservationRequest, ModelMap modelMap) {
        LOGGER.info("completeReservation() " + reservationRequest);
        Reservation reservation = reservationService.bookFlight(reservationRequest);
        modelMap.addAttribute("msg",
                "Reservation completed successfully and the id is "
                + reservation.getId());
        return "reservationConfirmation";
    }




}
