package de.uni.herozero.controller;

import de.uni.herozero.model.CO2Emission;
import de.uni.herozero.model.Country;
import de.uni.herozero.service.CO2EmissionService;
import de.uni.herozero.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Optional;

@Controller
public class PublicController {
    
    @Autowired
    private CO2EmissionService emissionService;
    
    @Autowired
    private CountryService countryService;
    
    @GetMapping("/")
    public String home(Model model) {
        List<CO2Emission> emissions = emissionService.getAllApprovedEmissions();
        List<Country> countries = countryService.getAllCountries();
        
        model.addAttribute("emissions", emissions);
        model.addAttribute("countries", countries);
        
        return "index";
    }
    
    @GetMapping("/public/country")
    public String viewCountryData(@RequestParam("id") Long countryId, Model model) {
        Optional<Country> country = countryService.getCountryById(countryId);
        
        if (country.isPresent()) {
            List<CO2Emission> emissions = emissionService.getEmissionsForCountry(country.get());
            Optional<CO2Emission> latestEmission = emissionService.getLatestEmissionForCountry(country.get());
            
            model.addAttribute("country", country.get());
            model.addAttribute("emissions", emissions);
            model.addAttribute("latestEmission", latestEmission.orElse(null));
            
            return "country-detail";
        }
        
        return "redirect:/";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}