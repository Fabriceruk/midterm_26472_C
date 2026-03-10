package auca.ac.rw.smartAgritech.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auca.ac.rw.smartAgritech.model.ELocationType;
import auca.ac.rw.smartAgritech.model.Location;
import auca.ac.rw.smartAgritech.repository.LocationRepository;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public String saveLocationWithParent(Location location, String parentId) {

        if (parentId != null) {
            Location parent = locationRepository
                .findById(UUID.fromString(parentId))
                .orElse(null);
            if (parent != null) {
                location.setParent(parent);
            }
        }

        Boolean exists = locationRepository.existsByCode(location.getCode());
        if (exists) {
            return "Location with that code already exists";
        } else {
            locationRepository.save(location);
            return "Location saved successfully";
        }
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public List<Location> getProvinces() {
        return locationRepository.findByType(ELocationType.PROVINCE);
    }
}
