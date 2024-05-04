package grp1.malveillancemax.dto.responses;


import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonView;

import grp1.malveillancemax.entities.Cocktail;

public class CocktailResponse {

    @JsonView(JsonViews.Generic.class)
    private Long id;
    @JsonView(JsonViews.Generic.class)
    private String nom;
    @JsonView(JsonViews.Generic.class)
    private double prix;
    @JsonView(JsonViews.CocktailAvecAlcool.class)
    private AlcoolFortResponse alcool;
    @JsonView(JsonViews.CocktailAvecSoft.class)
    private SoftResponse soft;

    public CocktailResponse() {
    }

    public CocktailResponse(Cocktail cocktail){
        BeanUtils.copyProperties(cocktail, this, "alcool" + "soft");
    }

    public CocktailResponse(Cocktail cocktail, boolean alcool, boolean soft){
        BeanUtils.copyProperties(cocktail, this, "alcool" + "soft");
        if(cocktail.getAlcool() != null){
            setAlcool(new AlcoolFortResponse(cocktail.getAlcool()));
        }
         if (cocktail.getSoft() != null){
            setSoft(new SoftResponse(cocktail.getSoft()));
        }
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
    public AlcoolFortResponse getAlcool() {
        return alcool;
    }
    public void setAlcool(AlcoolFortResponse alcool) {
        this.alcool = alcool;
    }
    public SoftResponse getSoft() {
        return soft;
    }
    public void setSoft(SoftResponse soft) {
        this.soft = soft;
    }

    
}
