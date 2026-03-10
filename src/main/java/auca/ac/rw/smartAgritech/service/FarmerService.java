package auca.ac.rw.smartAgritech.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import auca.ac.rw.smartAgritech.model.Farmer;
import auca.ac.rw.smartAgritech.model.FarmerProfile;
import auca.ac.rw.smartAgritech.model.Location;
import auca.ac.rw.smartAgritech.repository.FarmerRepository;
import auca.ac.rw.smartAgritech.repository.LocationRepository;

@Service
public class FarmerService {

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private LocationRepository locationRepository;

    public String saveFarmer(Farmer farmer, FarmerProfile profile, String locationId) {

        Boolean emailExists = farmerRepository.existsByEmail(farmer.getEmail());
        if (emailExists) {
            return "Farmer with that email already exists";
        }

        if (locationId != null) {
            Location location = locationRepository
                .findById(java.util.UUID.fromString(locationId))
                .orElse(null);
            if (location != null) {
                farmer.setLocation(location);
            }
        }

        profile.setFarmer(farmer);
        farmer.setProfile(profile);

        farmerRepository.save(farmer);
        return "Farmer saved successfully";
    }

    public List<Farmer> getAllFarmersSorted(String sortBy, String direction) {
        Sort sort;
        if (direction != null && direction.equalsIgnoreCase("desc")) {
            sort = Sort.by(Sort.Direction.DESC, sortBy);
        } else {
            sort = Sort.by(Sort.Direction.ASC, sortBy);
        }
        return farmerRepository.findAll(sort);
    }

    public Page<Farmer> getFarmersPaginated(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return farmerRepository.findAll(pageable);
    }

    public List<Farmer> getFarmersByProvinceCode(String code) {
        return farmerRepository.findByLocation_Parent_Code(code);
    }

    public List<Farmer> getFarmersByProvinceName(String name) {
        return farmerRepository.findByLocation_Parent_NameIgnoreCase(name);
    }

    public List<Farmer> getFarmersByProvinceCodeOrName(String code, String name) {
        return farmerRepository.findByProvinceCodeOrProvinceName(code, name);
    }
}
