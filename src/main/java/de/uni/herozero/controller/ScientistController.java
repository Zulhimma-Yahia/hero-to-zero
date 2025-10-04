package de.uni.herozero.controller;

import de.uni.herozero.model.CO2Emission;
import de.uni.herozero.model.Country;
import de.uni.herozero.service.CO2EmissionService;
import de.uni.herozero.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/scientist")
public class ScientistController {
    
    @Autowired
    private CO2EmissionService emissionService;
    
    @Autowired
    private CountryService countryService;
    
    @GetMapping("/dashboard")
    public String dashboard(Model model, Authentication authentication) {
        List<CO2Emission> pendingEmissions = emissionService.getPendingEmissions();
        List<CO2Emission> allEmissions = emissionService.getAllApprovedEmissions();
        
        model.addAttribute("pendingEmissions", pendingEmissions);
        model.addAttribute("allEmissions", allEmissions);
        model.addAttribute("username", authentication.getName());
        
        return "scientist/dashboard";
    }
    
    @GetMapping("/add")
    public String showAddForm(Model model) {
        List<Country> countries = countryService.getAllCountries();
        
        model.addAttribute("emission", new CO2Emission());
        model.addAttribute("countries", countries);
        
        return "scientist/add-emission";
    }
    
    @PostMapping("/add")
    public String addEmission(@Valid @ModelAttribute("emission") CO2Emission emission,
                            BindingResult result,
                            @RequestParam("countryId") Long countryId,
                            Authentication authentication,
                            Model model,
                            RedirectAttributes redirectAttributes) {
        
        if (result.hasErrors()) {
            List<Country> countries = countryService.getAllCountries();
            model.addAttribute("countries", countries);
            return "scientist/add-emission";
        }
        
        Optional<Country> country = countryService.getCountryById(countryId);
        if (country.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Land nicht gefunden!");
            return "redirect:/scientist/add";
        }
        
        emission.setCountry(country.get());
        emission.setSubmittedBy(authentication.getName());
        emission.setApproved(false);
        
        emissionService.saveEmission(emission);
        
        redirectAttributes.addFlashAttribute("success", "Daten erfolgreich eingereicht! Warten auf Freigabe.");
        return "redirect:/scientist/dashboard";
    }
    
    @GetMapping("/approve/{id}")
    public String approveEmission(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        CO2Emission approved = emissionService.approveEmission(id);
        
        if (approved != null) {
            redirectAttributes.addFlashAttribute("success", "Daten erfolgreich freigegeben!");
        } else {
            redirectAttributes.addFlashAttribute("error", "Daten nicht gefunden!");
        }
        
        return "redirect:/scientist/dashboard";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteEmission(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            emissionService.deleteEmission(id);
            redirectAttributes.addFlashAttribute("success", "Daten erfolgreich gelöscht!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Fehler beim Löschen!");
        }
        
        return "redirect:/scientist/dashboard";
    }
}