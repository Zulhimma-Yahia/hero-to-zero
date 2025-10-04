package de.uni.herozero.service;

import de.uni.herozero.model.CO2Emission;
import de.uni.herozero.model.Country;
import de.uni.herozero.repository.CO2EmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CO2EmissionService {
    
    @Autowired
    private CO2EmissionRepository emissionRepository;
    
    public List<CO2Emission> getAllApprovedEmissions() {
        return emissionRepository.findAllApprovedOrderByYearAndCountry();
    }
    
    public List<CO2Emission> getPendingEmissions() {
        return emissionRepository.findByApprovedFalseOrderByCreatedAtDesc();
    }
    
    public Optional<CO2Emission> getLatestEmissionForCountry(Country country) {
        return emissionRepository.findTopByCountryAndApprovedTrueOrderByYearDesc(country);
    }
    
    public List<CO2Emission> getEmissionsForCountry(Country country) {
        return emissionRepository.findByCountryOrderByYearDesc(country);
    }
    
    public CO2Emission saveEmission(CO2Emission emission) {
        return emissionRepository.save(emission);
    }
    
    public Optional<CO2Emission> getEmissionById(Long id) {
        return emissionRepository.findById(id);
    }
    
    public void deleteEmission(Long id) {
        emissionRepository.deleteById(id);
    }
    
    public CO2Emission approveEmission(Long id) {
        Optional<CO2Emission> emission = emissionRepository.findById(id);
        if (emission.isPresent()) {
            CO2Emission e = emission.get();
            e.setApproved(true);
            return emissionRepository.save(e);
        }
        return null;
    }
}