package grp1.malveillancemax.entities;

import java.util.Set;

import jakarta.persistence.Transient;

public class Cocktail extends Boisson{

    // @Transient
    private Set<AlcoolFort> alcools;
    
    // @Transient
    private Set<Soft> softs;
    
    public Cocktail(){
        
    }

    public Cocktail(String name, double prix) {
        super(name, prix);
    }
        
 }
