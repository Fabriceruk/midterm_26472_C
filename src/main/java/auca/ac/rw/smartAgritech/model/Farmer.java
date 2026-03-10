package auca.ac.rw.smartAgritech.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "farmer")
public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @OneToOne(mappedBy = "farmer", cascade = CascadeType.ALL)
    private FarmerProfile profile;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "farmer", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Farm> farms;

    public Long getId() { 
        return this.id; 
    }
    public void setId(Long id) { 
        this.id = id; 
    }

    public String getFirstName() { 
        return this.firstName; 
    }
    public void setFirstName(String firstName) { 
        this.firstName = firstName; 
    }

    public String getLastName() { 
        return this.lastName; 
    }
    public void setLastName(String lastName) { 
        this.lastName = lastName; 
    }

    public String getEmail() { 
        return this.email; 
    }
    public void setEmail(String email) { 
        this.email = email; 
    }

    public String getPhoneNumber() { 
        return this.phoneNumber; 
    }
    public void setPhoneNumber(String phoneNumber) { 
        this.phoneNumber = phoneNumber; 
    }

    public FarmerProfile getProfile() { 
        return this.profile; 
    }
    public void setProfile(FarmerProfile profile) { 
        this.profile = profile; 
    }

    public Location getLocation() { 
        return this.location; 
    }
    public void setLocation(Location location) { 
        this.location = location; 
    }

    public List<Farm> getFarms() { 
        return this.farms; 
    }
    public void setFarms(List<Farm> farms) { 
        this.farms = farms; 
    }
}
