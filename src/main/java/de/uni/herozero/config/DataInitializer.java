package de.uni.herozero.config;

import de.uni.herozero.model.CO2Emission;
import de.uni.herozero.model.Country;
import de.uni.herozero.model.User;
import de.uni.herozero.service.CO2EmissionService;
import de.uni.herozero.service.CountryService;
import de.uni.herozero.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private CountryService countryService;
    
    @Autowired
    private CO2EmissionService emissionService;
    
    @Autowired
    private UserService userService;
    
    @Override
    public void run(String... args) throws Exception {
        // Demo-Benutzer erstellen
        if (!userService.existsByUsername("scientist")) {
            User user = new User("scientist", "password", "Dr. Maria Schmidt", "scientist@example.com");
            userService.saveUser(user);
        }
        
        // Länder erstellen - Alle Weltregionen
        Country[] countries = {
            // Europa
            new Country("Deutschland", "DEU", "Europa"),
            new Country("Frankreich", "FRA", "Europa"),
            new Country("Vereinigtes Königreich", "GBR", "Europa"),
            new Country("Italien", "ITA", "Europa"),
            new Country("Spanien", "ESP", "Europa"),
            new Country("Polen", "POL", "Europa"),
            new Country("Niederlande", "NLD", "Europa"),
            new Country("Belgien", "BEL", "Europa"),
            new Country("Schweden", "SWE", "Europa"),
            new Country("Österreich", "AUT", "Europa"),
            new Country("Schweiz", "CHE", "Europa"),
            new Country("Norwegen", "NOR", "Europa"),
            new Country("Dänemark", "DNK", "Europa"),
            new Country("Finnland", "FIN", "Europa"),
            new Country("Portugal", "PRT", "Europa"),
            new Country("Griechenland", "GRC", "Europa"),
            new Country("Tschechien", "CZE", "Europa"),
            new Country("Rumänien", "ROU", "Europa"),
            new Country("Ungarn", "HUN", "Europa"),
            new Country("Irland", "IRL", "Europa"),
            
            // Nordamerika
            new Country("USA", "USA", "Nordamerika"),
            new Country("Kanada", "CAN", "Nordamerika"),
            new Country("Mexiko", "MEX", "Nordamerika"),
            
            // Südamerika
            new Country("Brasilien", "BRA", "Südamerika"),
            new Country("Argentinien", "ARG", "Südamerika"),
            new Country("Kolumbien", "COL", "Südamerika"),
            new Country("Chile", "CHL", "Südamerika"),
            new Country("Peru", "PER", "Südamerika"),
            new Country("Venezuela", "VEN", "Südamerika"),
            new Country("Ecuador", "ECU", "Südamerika"),
            
            // Asien
            new Country("China", "CHN", "Asien"),
            new Country("Japan", "JPN", "Asien"),
            new Country("Indien", "IND", "Asien"),
            new Country("Südkorea", "KOR", "Asien"),
            new Country("Indonesien", "IDN", "Asien"),
            new Country("Thailand", "THA", "Asien"),
            new Country("Vietnam", "VNM", "Asien"),
            new Country("Philippinen", "PHL", "Asien"),
            new Country("Malaysia", "MYS", "Asien"),
            new Country("Singapur", "SGP", "Asien"),
            new Country("Pakistan", "PAK", "Asien"),
            new Country("Bangladesch", "BGD", "Asien"),
            new Country("Israel", "ISR", "Asien"),
            new Country("Türkei", "TUR", "Asien"),
            new Country("Saudi-Arabien", "SAU", "Asien"),
            new Country("Iran", "IRN", "Asien"),
            new Country("Irak", "IRQ", "Asien"),
            new Country("VAE", "ARE", "Asien"),
            
            // Afrika
            new Country("Südafrika", "ZAF", "Afrika"),
            new Country("Nigeria", "NGA", "Afrika"),
            new Country("Ägypten", "EGY", "Afrika"),
            new Country("Algerien", "DZA", "Afrika"),
            new Country("Marokko", "MAR", "Afrika"),
            new Country("Kenia", "KEN", "Afrika"),
            new Country("Äthiopien", "ETH", "Afrika"),
            new Country("Ghana", "GHA", "Afrika"),
            new Country("Tansania", "TZA", "Afrika"),
            new Country("Angola", "AGO", "Afrika"),
            
            // Ozeanien
            new Country("Australien", "AUS", "Ozeanien"),
            new Country("Neuseeland", "NZL", "Ozeanien")
        };
        
        // Länder speichern
        for (Country country : countries) {
            if (countryService.getCountryByIsoCode(country.getIsoCode()).isEmpty()) {
                countryService.saveCountry(country);
            }
        }
        
        // Realistische CO2-Emissionsdaten für alle Länder (2023)
        Object[][] emissionsData = {
            // Europa
            {"DEU", 2023, 675.8, 8.1},
            {"FRA", 2023, 298.3, 4.5},
            {"GBR", 2023, 348.5, 5.2},
            {"ITA", 2023, 321.7, 5.4},
            {"ESP", 2023, 258.9, 5.5},
            {"POL", 2023, 319.4, 8.4},
            {"NLD", 2023, 153.2, 8.7},
            {"BEL", 2023, 96.8, 8.3},
            {"SWE", 2023, 41.2, 4.0},
            {"AUT", 2023, 63.4, 7.1},
            {"CHE", 2023, 37.8, 4.4},
            {"NOR", 2023, 38.5, 7.1},
            {"DNK", 2023, 33.1, 5.7},
            {"FIN", 2023, 42.6, 7.7},
            {"PRT", 2023, 47.3, 4.6},
            {"GRC", 2023, 63.2, 6.0},
            {"CZE", 2023, 98.7, 9.3},
            {"ROU", 2023, 78.5, 4.1},
            {"HUN", 2023, 51.2, 5.3},
            {"IRL", 2023, 37.4, 7.5},
            
            // Nordamerika
            {"USA", 2023, 4807.0, 14.5},
            {"CAN", 2023, 557.3, 14.7},
            {"MEX", 2023, 471.8, 3.7},
            
            // Südamerika
            {"BRA", 2023, 462.8, 2.2},
            {"ARG", 2023, 171.2, 3.8},
            {"COL", 2023, 84.3, 1.7},
            {"CHL", 2023, 89.7, 4.7},
            {"PER", 2023, 58.4, 1.8},
            {"VEN", 2023, 131.5, 4.6},
            {"ECU", 2023, 38.9, 2.2},
            
            // Asien
            {"CHN", 2023, 11472.0, 8.1},
            {"JPN", 2023, 1067.0, 8.5},
            {"IND", 2023, 2654.0, 1.9},
            {"KOR", 2023, 611.2, 11.9},
            {"IDN", 2023, 619.3, 2.3},
            {"THA", 2023, 267.4, 3.8},
            {"VNM", 2023, 283.5, 2.9},
            {"PHL", 2023, 147.8, 1.4},
            {"MYS", 2023, 254.3, 7.8},
            {"SGP", 2023, 37.2, 6.4},
            {"PAK", 2023, 225.7, 1.0},
            {"BGD", 2023, 98.4, 0.6},
            {"ISR", 2023, 65.3, 7.5},
            {"TUR", 2023, 448.9, 5.3},
            {"SAU", 2023, 672.3, 19.3},
            {"IRN", 2023, 749.8, 8.9},
            {"IRQ", 2023, 189.4, 4.7},
            {"ARE", 2023, 206.8, 20.8},
            
            // Afrika
            {"ZAF", 2023, 435.6, 7.3},
            {"NGA", 2023, 104.3, 0.5},
            {"EGY", 2023, 251.4, 2.5},
            {"DZA", 2023, 175.6, 4.0},
            {"MAR", 2023, 71.8, 2.0},
            {"KEN", 2023, 18.5, 0.4},
            {"ETH", 2023, 16.2, 0.1},
            {"GHA", 2023, 17.9, 0.6},
            {"TZA", 2023, 11.3, 0.2},
            {"AGO", 2023, 23.7, 0.7},
            
            // Ozeanien
            {"AUS", 2023, 414.2, 16.2},
            {"NZL", 2023, 36.8, 7.4},
            
            // Historische Daten für Deutschland (Beispiel)
            {"DEU", 2022, 683.7, 8.2},
            {"DEU", 2021, 702.4, 8.5},
            {"DEU", 2020, 644.9, 7.8},
            {"DEU", 2019, 730.5, 8.8},
            
            // Historische Daten für USA
            {"USA", 2022, 4821.3, 14.6},
            {"USA", 2021, 4903.1, 14.9},
            {"USA", 2020, 4458.7, 13.6},
            
            // Historische Daten für China
            {"CHN", 2022, 11397.0, 8.1},
            {"CHN", 2021, 11290.0, 8.0},
            {"CHN", 2020, 10668.0, 7.6}
        };
        
        // CO2-Daten speichern
        for (Object[] data : emissionsData) {
            String isoCode = (String) data[0];
            Integer year = (Integer) data[1];
            Double value = (Double) data[2];
            Double perCapita = (Double) data[3];
            
            Country country = countryService.getCountryByIsoCode(isoCode).orElse(null);
            if (country != null) {
                CO2Emission emission = new CO2Emission(country, year, value, perCapita);
                emission.setApproved(true);
                emission.setSubmittedBy("System");
                emissionService.saveEmission(emission);
            }
        }
        
        System.out.println("==============================================");
        System.out.println("Datenbank erfolgreich initialisiert!");
        System.out.println("Anzahl Länder: " + countryService.getAllCountries().size());
        System.out.println("Anzahl CO2-Daten: " + emissionService.getAllApprovedEmissions().size());
        System.out.println("==============================================");
        System.out.println("Demo-Login:");
        System.out.println("Benutzername: scientist");
        System.out.println("Passwort: password");
        System.out.println("==============================================");
    }
}