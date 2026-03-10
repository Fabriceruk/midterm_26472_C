package auca.ac.rw.smartAgritech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import auca.ac.rw.smartAgritech.model.Farm;
import auca.ac.rw.smartAgritech.model.Farmer;
import auca.ac.rw.smartAgritech.repository.FarmRepository;
import auca.ac.rw.smartAgritech.repository.FarmerRepository;

@Service
public class FarmService {

    @Autowired private FarmRepository farmRepository;
    @Autowired private FarmerRepository farmerRepository;

    public String saveFarm(Farm farm, Long farmerId) {
        Boolean exists = farmRepository
            .existsByFarmNameAndFarmer_Id(farm.getFarmName(), farmerId);
        if (exists) return "Farm already exists for this farmer";

        Farmer farmer = farmerRepository.findById(farmerId).orElse(null);
        if (farmer == null) return "Farmer not found";

        farm.setFarmer(farmer);
        farmRepository.save(farm);
        return "Farm saved successfully";
    }
}