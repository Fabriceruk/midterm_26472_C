package auca.ac.rw.smartAgritech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import auca.ac.rw.smartAgritech.model.Pesticide;

@Repository
public interface PesticideRepository extends JpaRepository<Pesticide, Long> {

    Boolean existsByPesticideName(String pesticideName);
}
