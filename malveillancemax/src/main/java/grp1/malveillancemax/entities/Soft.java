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
@Table(name="soft")
@AttributeOverride(name = "id", column = @Column(name="soft_id"))
@AttributeOverride(name = "nom", column = @Column(name="soft_nom"))
@AttributeOverride(name = "prix", column = @Column(name="soft_prix"))
public class Soft extends Boisson{

    
    @OneToMany(mappedBy = "soft", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Cocktail> cocktails = new HashSet<Cocktail>();
    @Column(name="soft_categorie")
    private String categorie;

    public Soft(){
        
    }

    public Soft(String name, Double prix, String categorie) {
        super(name, prix);
        this.categorie = categorie;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Set<Cocktail> getCocktails() {
        return cocktails;
    }

    public void setCocktails(Set<Cocktail> cocktails) {
        this.cocktails = cocktails;
    }

    
}
