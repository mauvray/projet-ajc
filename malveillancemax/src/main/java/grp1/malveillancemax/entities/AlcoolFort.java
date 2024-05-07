package grp1.malveillancemax.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="alcoolFort")
@AttributeOverride(name = "id", column = @Column(name="alcoolFort_id"))
@AttributeOverride(name = "nom", column = @Column(name="alcoolFort_nom"))
@AttributeOverride(name = "prix", column = @Column(name="alcoolFort_prix"))
public class AlcoolFort extends Boisson{

        
    @OneToMany(mappedBy = "alcool", cascade = CascadeType.ALL, orphanRemoval = true)    
    private Set<Cocktail> cocktails = new HashSet<Cocktail>();

    public AlcoolFort(){

    }

    public AlcoolFort(String name){
        super(name);
    }

    public AlcoolFort(String name, Double prix) {
        super(name, prix);

    }

    public Set<Cocktail> getCocktails() {
        return cocktails;
    }

    public void setCocktails(Set<Cocktail> cocktails) {
        this.cocktails = cocktails;
    }

    

}
