package auca.ac.rw.smartAgritech.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "pesticide")
public class Pesticide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String pesticideName;   
    private String type;            
    private String manufacturer;
    private Double pricePerLiter;

    @ManyToMany(mappedBy = "pesticides")
    @JsonIgnore
    private List<Crop> crops;

    public Long getId() { 
        return this.id; }
    public void setId(Long id) { 
        this.id = id; }

    public String getPesticideName() { 
        return this.pesticideName; }
    public void setPesticideName(String n) { 
        this.pesticideName = n; 
    }

    public String getType() { 
        return this.type; 
    }
    public void setType(String type) { 
        this.type = type; 
    }

    public String getManufacturer() { 
        return this.manufacturer; 
    }
    public void setManufacturer(String m) { 
        this.manufacturer = m; 
    }

    public Double getPricePerLiter() { 
        return this.pricePerLiter; 
    }
    public void setPricePerLiter(Double p) { 
        this.pricePerLiter = p; 
    }

    public List<Crop> getCrops() { 
        return this.crops; }
    public void setCrops(List<Crop> crops) { 
        this.crops = crops; 
    }
}