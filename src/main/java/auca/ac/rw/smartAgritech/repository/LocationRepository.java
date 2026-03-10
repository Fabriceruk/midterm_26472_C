package auca.ac.rw.smartAgritech.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import auca.ac.rw.smartAgritech.model.ELocationType;
import auca.ac.rw.smartAgritech.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, UUID> {

    Boolean existsByCode(String code);


    List<Location> findByType(ELocationType type);
    List<Location> findByParent_Id(UUID parentId);

    @Query("SELECT l FROM Location l WHERE " +
           "(l.code = :code OR LOWER(l.name) = LOWER(:name)) " +
           "AND l.type = 'PROVINCE'")
    List<Location> findProvinceByCodeOrName(
        @Param("code") String code,
        @Param("name") String name
    );
}
