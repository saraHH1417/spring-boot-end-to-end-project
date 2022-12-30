package com.sara.flightreservation.controllers;

import com.sara.flightreservation.entities.Flight;
import com.sara.flightreservation.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ReservationController {

    @Autowired
    FlightRepository flightRepository;

    @RequestMapping("showCompleteReservation")
    public String showCompleteReservation(@RequestParam("flightId") Long flightId,
                                          ModelMap modelMap) {
        Optional<Flight> flight = flightRepository.findById(flightId);
        if (flight.isPresent()) {
            modelMap.addAttribute("flight", flight.get());
            return "completeReservation";
        }
        return "findFlights";
    }


}
