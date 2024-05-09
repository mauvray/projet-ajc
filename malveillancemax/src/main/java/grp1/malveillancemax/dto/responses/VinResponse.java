package grp1.malveillancemax.dto.responses;

import grp1.malveillancemax.entities.ServiceVin;
import org.springframework.beans.BeanUtils;

import grp1.malveillancemax.entities.Vin;

/**
 * VinResponse
 */
public class VinResponse {
    private Long id;
    private String nom;
    private double prix;
    private String couleur;
    private String provenance;
    private ServiceVin service;

    public VinResponse(){

    }
    
    public VinResponse(Vin vin){
        BeanUtils.copyProperties(vin, this);
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

    public String getCouleur(){
        return couleur;
    }
    public void setCouleur(String couleur){
        this.couleur=couleur;
    }

    public ServiceVin getServiceVin(){
        return service;
    }
    public void setServiceVin(ServiceVin service){
        this.service=service;
    }

    
}
