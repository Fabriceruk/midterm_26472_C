package auca.ac.rw.smartAgritech.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import auca.ac.rw.smartAgritech.model.Crop;
import auca.ac.rw.smartAgritech.service.CropService;

@RestController
@RequestMapping("/api/crops")
public class CropController {

    @Autowired
    private CropService cropService;

    @PostMapping(value = "/save",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveCrop(
            @RequestBody Crop crop,
            @RequestParam Long farmId) {
        String result = cropService.saveCrop(crop, farmId);
        if (result.equals("Crop saved successfully")) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result, HttpStatus.CONFLICT);
        }
    }

    @PutMapping(value = "/{cropId}/assign-pesticides",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> assignPesticides(
            @PathVariable Long cropId,
            @RequestBody List<Long> pesticideIds) {
        String result = cropService.assignPesticides(cropId, pesticideIds);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/paginated", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCropsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "cropName") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        Page<Crop> result = cropService.getCropsPaginated(page, size, sortBy, direction);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}