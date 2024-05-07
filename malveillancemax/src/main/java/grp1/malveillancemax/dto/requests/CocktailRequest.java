package grp1.malveillancemax.dto.requests;

import jakarta.validation.constraints.NotBlank;

public class CocktailRequest {
    private Long id;
    @NotBlank
    private String nom;
    private double prix;
    private Long alcoolId;
    private Long softId;

    
    public CocktailRequest() {
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

    public Long getAlcoolId() {
        return alcoolId;
    }

    public void setAlcoolId(Long alcoolId) {
        this.alcoolId = alcoolId;
    }

    public Long getSoftId() {
        return softId;
    }

    public void setSoftId(Long softId) {
        this.softId = softId;
    }

    
}
