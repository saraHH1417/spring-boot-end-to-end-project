package com.sara.flightcheckin.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

public class CheckInController {

    @RequestMapping("/showStartCheckIn")
    public String showStartCheckIn() {
        return "startCheckIn";
    }
}
