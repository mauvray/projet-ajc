package grp1.malveillancemax.dto.responses;

import org.springframework.beans.BeanUtils;

import grp1.malveillancemax.dto.responses.JsonViews.Tapas;

public class TapasResponse {
    private Long id;
    private String nom;
    private double prix;

    public TapasResponse(){

    }
    public TapasResponse(Tapas tapas){
        BeanUtils.copyProperties(tapas, this);
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
