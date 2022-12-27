package com.sara.locationweb.controllers;

import com.sara.locationweb.entities.Location;
import com.sara.locationweb.service.LocationService;
import com.sara.locationweb.utilities.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/location")
public class LocationController {

    @Autowired
    LocationService locationService;
    @Autowired
    EmailUtil emailUtility;

    @RequestMapping("/create")
    public String showCreate() {
        return "createLocation";
    }

    @RequestMapping("/saveLocation")
    public String saveLocation(
            @ModelAttribute("location") Location location,
            ModelMap modelMap) {
        Location locationSaved = locationService.saveLocation(location);
        String msg = "Location saved with id " + locationSaved.getId();
        modelMap.addAttribute("msg", msg);
//        emailUtility.sendEmail("joe.smi.34@gmail.com",
//                 "Location Saved",
//                  "Location saved successfully and is about to return a response");
        return "createLocation";
    }

    @RequestMapping("/displayLocations")
    public String displayLocations(ModelMap modelMap) {
        List<Location> locations = locationService.getAllLocations();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

    @RequestMapping("deleteLocation")
    public String deletelocations(@RequestParam("id") int id, ModelMap modelMap) {
        Optional<Location> location = locationService.getLocationById(id);
        if (location.isPresent()) {
            locationService.deleteLocation(location.get());
        }

        return this.displayLocations(modelMap);
    }

    @RequestMapping("/updateLocation")
    public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
        Optional<Location> locationById = locationService.getLocationById(id);
        if (locationById.isPresent()) {
            System.out.println("hjtrth");
            modelMap.addAttribute("location" , locationById.get());
            return "updateLocation";
        }
        modelMap.addAttribute("msg", "Location with id" + id + "doesn't exist for update");
        return this.displayLocations(modelMap);
    }

    @RequestMapping("/editLocation")
    public String editLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
        locationService.updateLocation(location);
        return this.displayLocations(modelMap);
    }
}
