package de.uni.herozero.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "countries")
public class Country {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Ländername ist erforderlich")
    @Column(nullable = false, unique = true)
    private String name;
    
    @NotBlank(message = "ISO-Code ist erforderlich")
    @Column(name = "iso_code", nullable = false, unique = true, length = 3)
    private String isoCode;
    
    @Column(nullable = false)
    private String continent;
    
    // Konstruktoren
    public Country() {}
    
    public Country(String name, String isoCode, String continent) {
        this.name = name;
        this.isoCode = isoCode;
        this.continent = continent;
    }
    
    // Getter und Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getIsoCode() { return isoCode; }
    public void setIsoCode(String isoCode) { this.isoCode = isoCode; }
    
    public String getContinent() { return continent; }
    public void setContinent(String continent) { this.continent = continent; }
}