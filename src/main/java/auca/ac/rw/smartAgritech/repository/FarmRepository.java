package auca.ac.rw.smartAgritech.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import auca.ac.rw.smartAgritech.model.Farm;

@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {

    List<Farm> findByFarmer_Id(Long farmerId);

    Boolean existsByFarmNameAndFarmer_Id(String farmName, Long farmerId);

    Page<Farm> findAll(Pageable pageable);
}
