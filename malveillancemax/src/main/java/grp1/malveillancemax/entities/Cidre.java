package grp1.malveillancemax.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "cidre")
@AttributeOverride(name = "id", column = @Column(name = "cidre_id"))
@AttributeOverride(name = "nom", column = @Column(name = "cidre_nom"))
@AttributeOverride(name = "prix", column = @Column(name = "cidre_nom"))
public class Cidre extends Boisson {
    @Column(name="cidre_provenance")
    private String provenance;
    @Column(name="cidre_service")
    private ServiceCidre serviceCidre;

    public Cidre() {

    }

    public Cidre(String nom, double prix, String provenance, ServiceCidre serviceCidre) {
        super(nom,prix);
        this.provenance = provenance;
        this.serviceCidre = serviceCidre;
    }

    public String getProvenance() {
        return provenance;
    }

    public void setProvenance(String provenance) {
        this.provenance = provenance;
    }

    public ServiceCidre getServiceCidre() {
        return serviceCidre;
    }

    public void setServiceCidre(ServiceCidre serviceCidre) {
        this.serviceCidre = serviceCidre;
    }

  
}