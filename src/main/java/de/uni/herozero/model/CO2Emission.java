package de.uni.herozero.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Entity
@Table(name = "co2_emissions")
public class CO2Emission {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id", nullable = false)
    @NotNull(message = "Land ist erforderlich")
    private Country country;
    
    @NotNull(message = "Jahr ist erforderlich")
    @Column(name = "emission_year", nullable = false)
    private Integer year;
    
    @NotNull(message = "Emissionswert ist erforderlich")
    @Positive(message = "Emissionswert muss positiv sein")
    @Column(name = "emission_value", nullable = false)
    private Double emissionValue;
    
    @Column(name = "emission_per_capita")
    private Double emissionPerCapita;
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @Column(name = "approved", nullable = false)
    private Boolean approved = false;
    
    @Column(name = "submitted_by")
    private String submittedBy;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        if (approved == null) {
            approved = false;
        }
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
    
    // Konstruktoren
    public CO2Emission() {}
    
    public CO2Emission(Country country, Integer year, Double emissionValue, Double emissionPerCapita) {
        this.country = country;
        this.year = year;
        this.emissionValue = emissionValue;
        this.emissionPerCapita = emissionPerCapita;
        this.approved = true;
    }
    
    // Getter und Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Country getCountry() { return country; }
    public void setCountry(Country country) { this.country = country; }
    
    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }
    
    public Double getEmissionValue() { return emissionValue; }
    public void setEmissionValue(Double emissionValue) { this.emissionValue = emissionValue; }
    
    public Double getEmissionPerCapita() { return emissionPerCapita; }
    public void setEmissionPerCapita(Double emissionPerCapita) { this.emissionPerCapita = emissionPerCapita; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    
    public Boolean getApproved() { return approved; }
    public void setApproved(Boolean approved) { this.approved = approved; }
    
    public String getSubmittedBy() { return submittedBy; }
    public void setSubmittedBy(String submittedBy) { this.submittedBy = submittedBy; }
}