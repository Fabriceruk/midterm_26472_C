package auca.ac.rw.smartAgritech.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "crop")
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cropName;  
    private String cropType;  
    private String season;    
    private String status;    


    @ManyToOne
    @JoinColumn(name = "farm_id", nullable = false)
    @JsonIgnore
    private Farm farm;

    @ManyToMany
    @JoinTable(
        name = "crop_pesticide",
        joinColumns = @JoinColumn(name = "crop_id"),
        inverseJoinColumns = @JoinColumn(name = "pesticide_id")
    )
    private List<Pesticide> pesticides;

    public Long getId() { 
        return this.id;
    }
    public void setId(Long id) { 
        this.id = id; 
    }

    public String getCropName() { 
        return this.cropName; 
    }
    public void setCropName(String cropName) { 
        this.cropName = cropName; 
    }

    public String getCropType() { 
        return this.cropType; 
    }
    public void setCropType(String cropType) { 
        this.cropType = cropType; 
    }

    public String getSeason() { 
        return this.season; 
    }
    public void setSeason(String season) { 
        this.season = season; 
    }

    public String getStatus() { 
        return this.status;
    }
    public void setStatus(String status) { 
        this.status = status; 
    }

    public Farm getFarm() { 
        return this.farm; 
    }
    public void setFarm(Farm farm) { 
        this.farm = farm; 
    }

    public List<Pesticide> getPesticides() { 
        return this.pesticides; 
    }
    public void setPesticides(List<Pesticide> pesticides) {
        this.pesticides = pesticides; 
    }
}
