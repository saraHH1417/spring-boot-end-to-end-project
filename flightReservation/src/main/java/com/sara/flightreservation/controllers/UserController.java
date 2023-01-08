package com.sara.flightreservation.controllers;

import com.sara.flightreservation.entities.User;
import com.sara.flightreservation.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @RequestMapping("/showReg")
    public String showRegisterationPage() {
        LOGGER.info("inside showRegisterationPage() method");
        return "/login/registerUser";
    }

    @RequestMapping("/showLogin")
    public String showLogin() {
        return "login/login";
    }

    @RequestMapping(value = "registerUser", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user) {
        LOGGER.info("Inside register() " + user);
        userRepository.save(user);
        return "login/login";
    }

    @RequestMapping(value = "login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        ModelMap modelMap) {
        LOGGER.info("inside Login ad the email is " + email);
        LOGGER.error("ERROR");
        LOGGER.warn("warn");
        LOGGER.info("info");

        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return "findFlights";
        }
        modelMap.addAttribute("msg", "Invalid username or password. Please try again.");
        return "login/login";
    }
}
