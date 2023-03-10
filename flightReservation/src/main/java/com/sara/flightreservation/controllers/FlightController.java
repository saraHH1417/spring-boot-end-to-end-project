package com.sara.flightreservation.controllers;

import com.sara.flightreservation.entities.Flight;
import com.sara.flightreservation.repositories.FlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);
    @RequestMapping("findFlights")
    public String findFlights() {
        return "findFlights";
    }

    @RequestMapping("displayFlights")
    public String displayFlights(@RequestParam("from") String from,
                              @RequestParam("to") String to,
                              @RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate,
                              ModelMap modelMap) {
        LOGGER.info("inside findFlights() From " + from
                + " to" + to
                + " Departure date " + departureDate);
        List<Flight> flights = flightRepository.findFlights(from, to, departureDate);
        modelMap.addAttribute("flights", flights);
        LOGGER.info("Flights found are " + flights);
        return "displayFlights";
    }
}
