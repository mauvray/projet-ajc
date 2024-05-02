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

    public Cocktail(String name, double prix, Set<AlcoolFort> alcools) {
        super(name, prix);
        this.alcools = alcools;
    }

    
    // public Cocktail(String name, double prix, Set<Soft> softs) {
    //     super(name, prix);
    //     this.softs = softs;
    // }

    public Cocktail(String name, double prix, Set<AlcoolFort> alcools, Set<Soft> softs) {
        super(name, prix);
        this.alcools = alcools;
        this.softs = softs;
    }
    
    
 }
