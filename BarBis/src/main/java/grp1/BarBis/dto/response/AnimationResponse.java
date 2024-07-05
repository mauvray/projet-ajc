package grp1.BarBis.dto.response;

import org.springframework.beans.BeanUtils;

import grp1.BarBis.entities.Animation;

public class AnimationResponse {
    private Long id;
    private String nom;
    
    public AnimationResponse() {
    }

    public AnimationResponse(Animation animation) {
        BeanUtils.copyProperties(animation, this);
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

    
}
