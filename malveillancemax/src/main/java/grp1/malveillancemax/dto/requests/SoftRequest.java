package grp1.malveillancemax.dto.requests;

import jakarta.validation.constraints.NotBlank;

public class SoftRequest {
private Long id;
    @NotBlank
    private String nom;
    private double prix;
    @NotBlank
    private String categorie;
    
    public SoftRequest() {
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

    
}
