package auca.ac.rw.smartAgritech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import auca.ac.rw.smartAgritech.model.Pesticide;
import auca.ac.rw.smartAgritech.repository.PesticideRepository;

@RestController
@RequestMapping("/api/pesticides")
public class PesticideController {

    @Autowired
    private PesticideRepository pesticideRepository;

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody Pesticide pesticide) {
        Boolean exists = pesticideRepository
            .existsByPesticideName(pesticide.getPesticideName());
        if (exists) return new ResponseEntity<>("Pesticide already exists", HttpStatus.CONFLICT);
        pesticideRepository.save(pesticide);
        return new ResponseEntity<>("Pesticide saved successfully", HttpStatus.OK);
    }
}