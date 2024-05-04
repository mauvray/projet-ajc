package grp1.malveillancemax.dto.responses;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonView;

import grp1.malveillancemax.entities.Soft;
import grp1.malveillancemax.services.CocktailService;

public class SoftResponse {

    @JsonView(JsonViews.Generic.class)
    private String nom;
    @JsonView(JsonViews.Generic.class)
    private double prix;
    @JsonView(JsonViews.Generic.class)
    private String categorie;
    @JsonView(JsonViews.SoftAvecCocktail.class)
    private Set<CocktailResponse> cocktails;

    @Autowired
    private CocktailService cocktailSvc;

    public SoftResponse() {
    }

      public SoftResponse(Soft soft){
        BeanUtils.copyProperties(soft, this, "cocktails");
    }    

    public SoftResponse(Soft soft, boolean cocktail){
        BeanUtils.copyProperties(soft, this, "cocktails");
        if (cocktail){
            cocktails = soft.getCocktails().stream()
            .map(cockt -> new CocktailResponse(cocktailSvc.getById(cockt.getId())))
            .collect(Collectors.toSet());
        }
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

    public Set<CocktailResponse> getCocktails() {
        return cocktails;
    }

    public void setCocktails(Set<CocktailResponse> cocktails) {
        this.cocktails = cocktails;
    }

    
    
}
