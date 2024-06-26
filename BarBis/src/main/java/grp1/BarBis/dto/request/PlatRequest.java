package grp1.BarBis.dto.request;

// import grp1.BarBis.entities.Plat;
import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

// import jakarta.validation.constraints.NotBlank;

public class PlatRequest {

    private Long id;
    @NotBlank
    private String categorie;
    @NotBlank
    private String nom;
    @NotNull
    private double prix;


    public PlatRequest(){

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

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
