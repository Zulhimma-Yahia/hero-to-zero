package de.uni.herozero.repository;

import de.uni.herozero.model.CO2Emission;
import de.uni.herozero.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CO2EmissionRepository extends JpaRepository<CO2Emission, Long> {
    List<CO2Emission> findByCountryOrderByYearDesc(Country country);
    List<CO2Emission> findByApprovedTrueOrderByYearDesc();
    List<CO2Emission> findByApprovedFalseOrderByCreatedAtDesc();
    Optional<CO2Emission> findTopByCountryAndApprovedTrueOrderByYearDesc(Country country);
    
    @Query("SELECT e FROM CO2Emission e WHERE e.approved = true ORDER BY e.year DESC, e.country.name ASC")
    List<CO2Emission> findAllApprovedOrderByYearAndCountry();
}