package grp1.malveillancemax.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    @Enumerated(EnumType.STRING)
    private ServiceVin service;
    @Column(name="Vin_couleur")
    private String couleur;
    
    
    public Vin() {

    }

    public Vin(String nom, double prix, String provenance, String couleur, ServiceVin serviceVin) {
        super(nom,prix);
        this.couleur = couleur;
        this.provenance = provenance;
        this.service = serviceVin;
    }

    public Vin(String nom, double prix){
        super(nom, prix);
    }

    public String getProvenance() {
        return provenance;
    }

    public void setProvenance(String provenance) {
        this.provenance = provenance;
    }

    public ServiceVin getServiceVin() {
        return service;
    }

    public void setServiceVin(ServiceVin service) {
        this.service = service;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

  
}