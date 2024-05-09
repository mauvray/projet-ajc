package grp1.BarBis.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

// import java.util.List;

// import grp1.BarBis.entities.Services;


@Entity
@Table(name="boisson")
public class Boisson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="boisson_id")
    private Long id;
    @Column(name="boisson_nom", nullable = false)
    private String nom;
    @Column(name="boisson_prix")
    private double prix;
    @Column(name="boisson_categorie", nullable = false)
    private String categorie;
    @Column(name="boisson_service")
    @Enumerated(EnumType.STRING)
    private Services service;
    @Column(name="boisson_provenance")
    private String provenance;
    @Column(name="boisson_style")
    private String style;
    @Column(name="boisson_couleur")
    private String couleur;
    @ManyToOne
    @JoinColumn(name="boisson_cocktail_soft", foreignKey = @ForeignKey(name="cocktail_soft_id"))
    private Boisson soft;
    @ManyToOne
    @JoinColumn(name="boisson_cocktail_alcool", foreignKey = @ForeignKey(name="cocktail_alcool_id"))
    private Boisson alcool;
    
    public Boisson(){

    }

    public Boisson (String nom, double prix, String categorie){
        this.nom = nom;
        this.prix = prix;
        this.categorie = categorie;
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

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
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
        Boisson other = (Boisson) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }

    public String getProvenance() {
        return provenance;
    }

    public void setProvenance(String provenance) {
        this.provenance = provenance;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public Boisson getSoft() {
        return soft;
    }

    public void setSoft(Boisson soft) {
        this.soft = soft;
    }

    public Boisson getAlcool() {
        return alcool;
    }

    public void setAlcool(Boisson alcool) {
        this.alcool = alcool;
    }


}