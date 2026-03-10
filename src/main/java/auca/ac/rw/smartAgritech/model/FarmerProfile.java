package auca.ac.rw.smartAgritech.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "farmer_profile")
public class FarmerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nationalId;
    private String education;      
    private String specialization; 
    private int yearsOfExperience;

    @OneToOne
    @JoinColumn(name = "farmer_id", unique = true)
    @JsonIgnore
    private Farmer farmer;

    public Long getId() {
        return this.id; 
    }
    public void setId(Long id) {
        this.id = id; 
    }

    public String getNationalId() { 
        return this.nationalId; 
    }
    public void setNationalId(String nationalId) { 
        this.nationalId = nationalId; 
    }

    public String getEducation() { 
        return this.education; 
    }
    public void setEducation(String education) { 
        this.education = education; 
    }

    public String getSpecialization() { 
        return this.specialization; 
    }
    public void setSpecialization(String spec) { 
        this.specialization = spec; 
    }
    public int getYearsOfExperience() { 
        return this.yearsOfExperience; 
    }
    public void setYearsOfExperience(int y) { 
        this.yearsOfExperience = y; 
    }

    public Farmer getFarmer() { 
        return this.farmer; 
    }
    public void setFarmer(Farmer farmer) { 
        this.farmer = farmer; 
    }
}
