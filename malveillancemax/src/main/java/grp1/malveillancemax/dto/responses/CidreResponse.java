package grp1.malveillancemax.dto.responses;

import grp1.malveillancemax.entities.ServiceCidre;
import grp1.malveillancemax.entities.Cidre;
import org.springframework.beans.BeanUtils;

/**
 * CidreResponse
 */
public class CidreResponse {
    private Long id;
    private String nom;
    private double prix;
    private String provenance;
    private ServiceCidre service;

    public CidreResponse(){

    }

    public CidreResponse(Cidre cidre){
        BeanUtils.copyProperties(cidre, this);
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
