package grp1.BarBis.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name="plat")
//@MappedSuperclass
public class Plat{
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="plat_id",nullable = false)
	private Long id;
    @NotBlank(message = "*ne doit pas etre vide")
	@Column(name="plat_categorie",nullable = false)
    private String categorie;
    @NotBlank(message = "*ne doit pas etre vide")
	@Column(name="plat_nom",nullable = false)
    private String nom;
  //  @Valid
    @Column(name="plat_prix")
    private double prix;

    public Plat (){

    }

    public Plat (String nom, String categorie, double prix){
        super();
        this.nom=nom;
        this.categorie=categorie;
        this.prix=prix;
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

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
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

    public Long getId() {
        return id;
    }

}