package auca.ac.rw.smartAgritech.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "farm")
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String farmName;

    private Double sizeInHectares;
    private String farmType;   
    private String soilType;  

    @ManyToOne
    @JoinColumn(name = "farmer_id", nullable = false)
    @JsonIgnore
    private Farmer farmer;

    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL)
    private List<Crop> crops;

    public Long getId() {
        return this.id; 
    }
    public void setId(Long id) {
        this.id = id; 
    }

    public String getFarmName() { 
        return this.farmName; 
    }
    public void setFarmName(String farmName) { 
        this.farmName = farmName; 
    }

    public Double getSizeInHectares() {
        return this.sizeInHectares; 
    }
    public void setSizeInHectares(Double size) {
        this.sizeInHectares = size; 
    }

    public String getFarmType() {
        return this.farmType; 
    }
    public void setFarmType(String farmType) {
        this.farmType = farmType; 
    }

    public String getSoilType() {
        return this.soilType; 
    }
    public void setSoilType(String soilType) {
        this.soilType = soilType; 
    }

    public Farmer getFarmer() { return this.farmer; }
    public void setFarmer(Farmer farmer) { 
        this.farmer = farmer; 
    }

    public List<Crop> getCrops() { 
        return this.crops; 
    }
    public void setCrops(List<Crop> crops) { 
        this.crops = crops; 
    }
}
