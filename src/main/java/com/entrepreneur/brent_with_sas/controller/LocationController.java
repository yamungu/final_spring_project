package com.entrepreneur.brent_with_sas.controller;

import com.entrepreneur.brent_with_sas.model.Location;
import com.entrepreneur.brent_with_sas.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@ComponentScan
@RestController
@RequestMapping("/api/v1/location")
public class LocationController {

    @Autowired
    private LocationService locationService;
    @GetMapping
    public List<Location> getAll(){
        return locationService.getAll();}

    @GetMapping("/{id}")
    public Location getLocationById(@PathVariable Integer id){
        return locationService.getLocationById(id);
    }

    @PostMapping
    public void create(@RequestBody Location location){
        locationService.create(location);
    }

    @PutMapping("/{id}")
    public void updateLocation(@PathVariable Integer id,@RequestBody Location location){
        locationService.updateLocation(id,location);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){locationService.delete(id);}

}
