package grp1.malveillancemax.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="soft")
public class Soft extends Boisson{

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

    
}
