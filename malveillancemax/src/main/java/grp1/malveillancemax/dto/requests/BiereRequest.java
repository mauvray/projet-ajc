package grp1.malveillancemax.dto.requests;

import grp1.malveillancemax.entities.ServiceBiere;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


/**
 * BiereRequest
 */
public class BiereRequest {

    private Long id;
    @NotBlank
    private String nom;
    @NotNull
    private double prix;
    private String style;
    private ServiceBiere service;

    public BiereRequest(){

    }

    public Long getId(){
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
    public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

    public String getStyle(){
        return style;
    }
    public void setStyle(String style){
        this.style=style;
    }

    public void setService(ServiceBiere service){
        this.service=service;
    }
    public ServiceBiere getService(){
        return service;
    }

}