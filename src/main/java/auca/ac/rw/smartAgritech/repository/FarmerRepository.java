package auca.ac.rw.smartAgritech.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import auca.ac.rw.smartAgritech.model.Farmer;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, Long> {

    // ── existsBy (Criteria 7) ────────────────────────────────────
    // Spring generates: SELECT COUNT(*)>0 FROM farmer WHERE email=?
    // Returns true/false — no need to load the full object!
    Boolean existsByEmail(String email);
    Boolean existsByPhoneNumber(String phoneNumber);

    // ── Retrieve by Province Code (Criteria 8) ──────────────────
    // Traverses: farmer.location.parent.code
    // (location's parent is the province)
    List<Farmer> findByLocation_Parent_Code(String provinceCode);

    // ── Retrieve by Province Name (Criteria 8) ──────────────────
    List<Farmer> findByLocation_Parent_NameIgnoreCase(String provinceName);

    // ── Retrieve by Province Code OR Name (Criteria 8) ──────────
    // Custom JPQL query — search by EITHER code OR name in one call
    @Query("SELECT f FROM Farmer f " +
           "JOIN f.location l " +
           "JOIN l.parent p " +
           "WHERE p.code = :code " +
           "OR LOWER(p.name) = LOWER(:name)")
    List<Farmer> findByProvinceCodeOrProvinceName(
        @Param("code") String provinceCode,
        @Param("name") String provinceName
    );

    // ── Pagination + Sorting (Criteria 3) ───────────────────────
    // Pageable carries: page number, page size, sort field+direction
    Page<Farmer> findAll(Pageable pageable);

    // Paginated farmers from a specific province
    Page<Farmer> findByLocation_Parent_Code(String provinceCode, Pageable pageable);
}
