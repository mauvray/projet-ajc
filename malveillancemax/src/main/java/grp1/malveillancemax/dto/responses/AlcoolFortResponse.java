package grp1.malveillancemax.dto.responses;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonView;

import grp1.malveillancemax.entities.AlcoolFort;
import grp1.malveillancemax.services.CocktailService;


public class AlcoolFortResponse {

    @JsonView(JsonViews.Generic.class)
    private Long id;
    @JsonView(JsonViews.Generic.class)
    private String nom;
    @JsonView(JsonViews.Generic.class)
    private double prix;
    @JsonView(JsonViews.AlcoolAvecCocktail.class)
    private Set<CocktailResponse> cocktails;
    
    @Autowired
    private CocktailService cocktailSvc;

    public AlcoolFortResponse() {
    }

    public AlcoolFortResponse(AlcoolFort alcoolFort){
        BeanUtils.copyProperties(alcoolFort, this, "cocktails");
    }    

    public AlcoolFortResponse(AlcoolFort alcoolFort, boolean cocktail){
        BeanUtils.copyProperties(alcoolFort, this, "cocktails");
        if (cocktail){
            cocktails = alcoolFort.getCocktails().stream()
            .map(cockt -> new CocktailResponse(cocktailSvc.getById(cockt.getId())))
            .collect(Collectors.toSet());
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

    public Set<CocktailResponse> getCocktails() {
        return cocktails;
    }

    public void setCocktails(Set<CocktailResponse> cocktails) {
        this.cocktails = cocktails;
    }


}
