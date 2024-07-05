package grp1.BarBis.dto.request;

import jakarta.validation.constraints.NotBlank;

public class AnimationRequest {

    private Long id;
    @NotBlank
    private String nom;

    public AnimationRequest() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public String getNom(){
        return nom;
    }

    public void setNom(String nom){
        this.nom=nom;
    }
}
