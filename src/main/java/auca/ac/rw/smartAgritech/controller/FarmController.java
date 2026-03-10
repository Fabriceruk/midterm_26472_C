package auca.ac.rw.smartAgritech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import auca.ac.rw.smartAgritech.model.Farm;
import auca.ac.rw.smartAgritech.service.FarmService;

@RestController
@RequestMapping("/api/farms")
public class FarmController {

    @Autowired
    private FarmService farmService;

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveFarm(
            @RequestBody Farm farm,
            @RequestParam Long farmerId) {
        String result = farmService.saveFarm(farm, farmerId);
        return result.equals("Farm saved successfully")
            ? new ResponseEntity<>(result, HttpStatus.OK)
            : new ResponseEntity<>(result, HttpStatus.CONFLICT);
    }
}