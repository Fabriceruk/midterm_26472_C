package auca.ac.rw.smartAgritech.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import auca.ac.rw.smartAgritech.model.Crop;
import auca.ac.rw.smartAgritech.model.Farm;
import auca.ac.rw.smartAgritech.model.Pesticide;
import auca.ac.rw.smartAgritech.repository.CropRepository;
import auca.ac.rw.smartAgritech.repository.FarmRepository;
import auca.ac.rw.smartAgritech.repository.PesticideRepository;

@Service
public class CropService {

    @Autowired
    private CropRepository cropRepository;

    @Autowired
    private FarmRepository farmRepository;

    @Autowired
    private PesticideRepository pesticideRepository;

    public String saveCrop(Crop crop, Long farmId) {
        Boolean exists = cropRepository.existsByCropNameAndFarm_Id(
            crop.getCropName(), farmId);
        if (exists) {
            return "Crop already exists on this farm";
        }
        Farm farm = farmRepository.findById(farmId).orElse(null);
        if (farm == null) {
            return "Farm not found";
        }
        crop.setFarm(farm);
        cropRepository.save(crop);
        return "Crop saved successfully";
    }

    public String assignPesticides(Long cropId, List<Long> pesticideIds) {
        Crop crop = cropRepository.findById(cropId).orElse(null);
        if (crop == null) { return "Crop not found"; }

        List<Pesticide> pesticides = pesticideRepository.findAllById(pesticideIds);
        crop.setPesticides(pesticides);
        cropRepository.save(crop);
        return "Pesticides assigned successfully";
    }

    public Page<Crop> getCropsPaginated(int page, int size, String sortBy, String dir) {
        Sort sort = (dir != null && dir.equalsIgnoreCase("desc"))
            ? Sort.by(Sort.Direction.DESC, sortBy)
            : Sort.by(Sort.Direction.ASC, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        return cropRepository.findAll(pageable);
    }
}
