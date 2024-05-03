package grp1.malveillancemax.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "vin")
@AttributeOverride(name = "id", column = @Column(name = "vin_id"))
@AttributeOverride(name = "nom", column = @Column(name = "Vin_nom"))
@AttributeOverride(name = "prix", column = @Column(name = "Vin_prix"))
public class Vin extends Boisson {
    @Column(name="Vin_provenance")
    private String provenance;
    @Column(name="Vin_service")
    private ServiceVin serviceVin;
    @Column(name="Vin_couleur")
    private String couleur;
    
    
    public Vin() {

    }

    public Vin(String nom, double prix, String provenance, String couleur, ServiceVin serviceVin) {
        super(nom,prix);
        this.couleur = couleur;
        this.provenance = provenance;
        this.serviceVin = serviceVin;
    }

    public String getProvenance() {
        return provenance;
    }

    public void setProvenance(String provenance) {
        this.provenance = provenance;
    }

    public ServiceVin getServiceVin() {
        return serviceVin;
    }

    public void setServiceVin(ServiceVin serviceVin) {
        this.serviceVin = serviceVin;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

  
}