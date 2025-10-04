package de.uni.herozero.service;

import de.uni.herozero.model.Country;
import de.uni.herozero.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    
    @Autowired
    private CountryRepository countryRepository;
    
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
    
    public Optional<Country> getCountryById(Long id) {
        return countryRepository.findById(id);
    }
    
    public Optional<Country> getCountryByIsoCode(String isoCode) {
        return countryRepository.findByIsoCode(isoCode);
    }
    
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }
}