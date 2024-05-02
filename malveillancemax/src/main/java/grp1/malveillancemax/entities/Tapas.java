package grp1.malveillancemax.entities;

//import java.util.Set;
//import java.util.HashSet;

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
@Table(name = "tapas")
@AttributeOverride(name = "id", column = @Column(name = "tapas_id"))
@AttributeOverride(name = "nom", column = @Column(name = "tapas_type", nullable = false))
@AttributeOverride(name = "prix", column = @Column(name = "tapas_prix", nullable = false))

public class Tapas extends Plat {

    public Tapas() {

    }

    public Tapas(String nom, Double prix) {
        super(nom, prix);
    }

}
