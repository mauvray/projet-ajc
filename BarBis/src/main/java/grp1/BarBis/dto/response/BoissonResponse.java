package grp1.BarBis.dto.response;


import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonView;

import grp1.BarBis.entities.Boisson;
import grp1.BarBis.entities.Services;


public class BoissonResponse {
    @JsonView(JsonViews.Basic.class)
    private Long id;
    @JsonView(JsonViews.Basic.class)
    private String nom;
    @JsonView(JsonViews.Basic.class)
    private double prix;
    @JsonView(JsonViews.Basic.class)
    private String categorie;
    @JsonView(JsonViews.Basic.class)
    private Services service;
    @JsonView(JsonViews.Basic.class)
    private String provenance;
    @JsonView(JsonViews.Basic.class)
    private String style;
    @JsonView(JsonViews.Basic.class)
    private String couleur;
    @JsonView(JsonViews.CocktailAvecSoftEtOuAlcool.class)
    private BoissonResponse alcool;
    @JsonView(JsonViews.CocktailAvecSoftEtOuAlcool.class)
    private BoissonResponse soft;
    

    public BoissonResponse(){

    }

    public BoissonResponse(Boisson boisson){
        BeanUtils.copyProperties(boisson, this);
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



    

    
}
