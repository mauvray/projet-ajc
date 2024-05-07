package grp1.malveillancemax.dto.responses;

import grp1.malveillancemax.entities.ServiceBiere;
import grp1.malveillancemax.entities.Biere;
import org.springframework.beans.BeanUtils;
/**
 * BiereResponse
 */
public class BiereResponse {

    private Long id;
    private String nom;
    private double prix;
    private String style;
    private ServiceBiere service;


    public BiereResponse(){

    }

    public BiereResponse(Biere biere){
        BeanUtils.copyProperties(biere,this);

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
