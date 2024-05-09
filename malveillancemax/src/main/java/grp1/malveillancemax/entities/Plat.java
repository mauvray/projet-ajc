package grp1.malveillancemax.entities;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;


//import soprasteria.formation.eshop.entities.jsonviews.JsonViews;

@MappedSuperclass
public abstract class Plat {
    // @JsonView(JsonView.Base.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @NotBlank(message = "*ne doit pas etre vide")
	@Column(name="nom",nullable = false)
	// @JsonView(JsonView.Base.class)
	private String nom;
	@Valid
	// @JsonView(JsonView.Base.class)
	private Double prix;

    public Plat(){

    }

    public Plat (String nom, Double prix){
        super();
        this.nom=nom;
        this.prix=prix;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Plat other = (Plat) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
