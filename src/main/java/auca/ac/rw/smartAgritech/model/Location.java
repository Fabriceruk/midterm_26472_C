package auca.ac.rw.smartAgritech.model;

import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String code;   

    private String name;   

    @Enumerated(EnumType.STRING)
    private ELocationType type; 

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Location parent;

    public UUID getId() { 
        return this.id; 
    }
    public void setId(UUID id) { 
        this.id = id; 
    }

    public String getCode() { return this.code; }
    public void setCode(String code) { 
        this.code = code; 
    }

    public String getName() { return this.name; }
    public void setName(String name) { 
        this.name = name; 
    }

    public ELocationType getType() { 
        return this.type; 
    }
    public void setType(ELocationType type) { 
        this.type = type; 
    }

    public Location getParent() { 
        return this.parent; 
    }
    public void setParent(Location parent) { 
        this.parent = parent; 
    }
}