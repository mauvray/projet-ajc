package grp1.malveillancemax.dto.requests;

import jakarta.validation.constraints.NotBlank;

public class AlcoolFortRequest {
    
    private Long id;
    @NotBlank
    private String nom;
    private double prix;

    

    public AlcoolFortRequest() {
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

    
}
