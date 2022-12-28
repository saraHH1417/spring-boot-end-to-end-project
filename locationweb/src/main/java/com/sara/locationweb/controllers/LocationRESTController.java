package com.sara.locationweb.controllers;

import com.sara.locationweb.entities.Location;
import com.sara.locationweb.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/rest/locations")
public class LocationRESTController {

    @Autowired
    LocationRepository locationRepository;

    @GetMapping
    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

    @PostMapping
    public Location createlocation(@RequestBody Location location) {
        return locationRepository.save(location);
    }

    @PutMapping
    public Location updateLocation(@RequestBody Location location) {
        return locationRepository.save(location);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteLocations(@PathVariable("id") int id) {
        Location location = locationRepository.getReferenceById(id);
        locationRepository.delete(location);
        Map<String, String> response = new HashMap<>();
        response.put("Message", "Record deleted successfully");
        return response;
    }

    @GetMapping("/{id}")
    public Optional<Location> getLocation(@PathVariable("id") int id) {
        return locationRepository.findById(id);
    }

}
