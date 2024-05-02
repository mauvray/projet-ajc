package grp1.malveillancemax.entities;

import java.util.Set;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "cocktail")
@AttributeOverride(name = "id", column = @Column(name="cocktail_id"))
@AttributeOverride(name = "name", column = @Column(name="cocktail_name"))
public class Cocktail extends Boisson{

    //@OneToMany
    @Transient
    private Set<AlcoolFort> alcools;
    //@OneToMany
    @Transient
    private Set<Soft> softs;
    
    public Cocktail(){
        
    }

    public Cocktail(String name, double prix) {
        super(name, prix);
    }

    public Set<AlcoolFort> getAlcools() {
        return alcools;
    }

    public void setAlcools(Set<AlcoolFort> alcools) {
        this.alcools = alcools;
    }

    public Set<Soft> getSofts() {
        return softs;
    }

    public void setSofts(Set<Soft> softs) {
        this.softs = softs;
    } 

    
 }
