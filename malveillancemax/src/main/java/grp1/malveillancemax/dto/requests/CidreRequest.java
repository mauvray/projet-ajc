package grp1.malveillancemax.dto.requests;

import grp1.malveillancemax.entities.ServiceCidre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
/**
 * CidreRequest
 */

public class CidreRequest {
    private Long id;
    @NotBlank
    private String nom;
    @NotNull
    private double prix;
    private String provenance;
    private ServiceCidre service;

    public CidreRequest(){

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
    public String getProvenance(){
        return provenance;
    }
    public void setProvenance(String provenance){
        this.provenance=provenance;
    }

    public ServiceCidre getServiceCidre(){
        return service;
    }
    public void setServiceCidre(ServiceCidre service){
        this.service=service;
    }
    
}
