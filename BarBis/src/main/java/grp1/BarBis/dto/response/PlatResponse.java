package grp1.BarBis.dto.response;

import org.springframework.beans.BeanUtils;

import grp1.BarBis.entities.Plat;
// import grp1.BarBis.entities.Services;

public class PlatResponse {

    private Long id;
    private String nom;
    private String categorie;
    private double prix;

    public PlatResponse(){

    }

    public PlatResponse(Plat plat){
        BeanUtils.copyProperties(plat, this);
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
