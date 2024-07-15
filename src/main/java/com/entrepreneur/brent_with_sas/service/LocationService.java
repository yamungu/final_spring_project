package com.entrepreneur.brent_with_sas.service;

import com.entrepreneur.brent_with_sas.model.Location;
import com.entrepreneur.brent_with_sas.repository.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepo locationRepo;
    public List<Location> getAll() {return locationRepo.findAll();}

    public Location getLocationById(int id){return locationRepo.findById(id).orElse(null);}

    public void create(Location location){ locationRepo.save(location); }

    public void updateLocation(Integer id, Location location){
        Location existingLocation;
        existingLocation = locationRepo.findById(id).orElse(null);

        if (existingLocation !=null){
            existingLocation.setLocation_id(location.getLocation_id());
            existingLocation.setLocation_name(location.getLocation_name());
            existingLocation.setLatitude(location.getLatitude());
            existingLocation.setLongitude(location.getLongitude());
            locationRepo.save(existingLocation);
        }
    }
    public void delete(Integer id){locationRepo.deleteById(id);}

}
