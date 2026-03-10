package auca.ac.rw.smartAgritech.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import auca.ac.rw.smartAgritech.model.Crop;

@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {

    Boolean existsByCropNameAndFarm_Id(String cropName, Long farmId);

    Page<Crop> findAll(Pageable pageable);
}
