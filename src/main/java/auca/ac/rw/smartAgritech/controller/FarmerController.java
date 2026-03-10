package auca.ac.rw.smartAgritech.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import auca.ac.rw.smartAgritech.model.Farmer;
import auca.ac.rw.smartAgritech.model.FarmerProfile;
import auca.ac.rw.smartAgritech.service.FarmerService;

@RestController
@RequestMapping("/api/farmers")
public class FarmerController {

    @Autowired
    private FarmerService farmerService;

    @PostMapping(value = "/save",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveFarmer(
            @RequestBody Map<String, Object> body,
            @RequestParam(required = false) String locationId) {

        Farmer farmer = new Farmer();
        farmer.setFirstName((String) body.get("firstName"));
        farmer.setLastName((String) body.get("lastName"));
        farmer.setEmail((String) body.get("email"));
        farmer.setPhoneNumber((String) body.get("phoneNumber"));

        FarmerProfile profile = new FarmerProfile();
        profile.setNationalId((String) body.get("nationalId"));
        profile.setEducation((String) body.get("education"));
        profile.setSpecialization((String) body.get("specialization"));

        String result = farmerService.saveFarmer(farmer, profile, locationId);

        if (result.equals("Farmer saved successfully")) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result, HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value = "/sorted", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSortedFarmers(
            @RequestParam(defaultValue = "firstName") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        List<Farmer> farmers = farmerService.getAllFarmersSorted(sortBy, direction);
        return new ResponseEntity<>(farmers, HttpStatus.OK);
    }

    @GetMapping(value = "/paginated", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPaginatedFarmers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "firstName") String sortBy) {
        Page<Farmer> result = farmerService.getFarmersPaginated(page, size, sortBy);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/by-province", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getFarmersByProvince(
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String name) {

        List<Farmer> farmers;
        if (code != null && name != null) {
            farmers = farmerService.getFarmersByProvinceCodeOrName(code, name);
        } else if (code != null) {
            farmers = farmerService.getFarmersByProvinceCode(code);
        } else if (name != null) {
            farmers = farmerService.getFarmersByProvinceName(name);
        } else {
            return new ResponseEntity<>("Provide code or name", HttpStatus.BAD_REQUEST);
        }

        if (farmers != null && !farmers.isEmpty()) {
            return new ResponseEntity<>(farmers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No farmers found", HttpStatus.NOT_FOUND);
        }
    }
}
