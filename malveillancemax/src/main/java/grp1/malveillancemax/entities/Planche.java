package grp1.malveillancemax.entities;

import java.util.Set;
import java.util.HashSet;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
// import jakarta.persistence.ForeignKey;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;

//import com.fasterxml.jackson.annotation.JsonView;

//import soprasteria.formation.eshop.entities.jsonviews.JsonViews;

@Entity
@Table(name = "planche")
@AttributeOverride(name = "id", column = @Column(name = "planche_id"))
@AttributeOverride(name = "nom", column = @Column(name = "type_planche", nullable = false))
@AttributeOverride(name = "prix", column = @Column(name = "prix_planche", nullable = false))

public class Planche extends Plat {
    private Set<String> ingredients;

    public Planche() {

    }

    public Planche(String nom, Double prix) {
        super(nom, prix);
        this.ingredients = new HashSet<String>();
    }

    public Set<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<String> ingredients) {
        this.ingredients = ingredients;
    }

}
