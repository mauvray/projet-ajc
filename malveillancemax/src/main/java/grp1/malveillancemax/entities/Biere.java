package grp1.malveillancemax.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "biere")
@AttributeOverride(name = "id", column = @Column(name = "biere_id"))
@AttributeOverride(name = "nom", column = @Column(name = "biere_nom"))
@AttributeOverride(name = "prix", column = @Column(name = "biere_prix"))
public class Biere extends Boisson {

    @Column(name="biere_style")
    private String style;
    @Column(name="biere_service")
    @Enumerated(EnumType.ORDINAL)
    private ServiceBiere serviceBiere;

    public Biere() {

    }

    public Biere(String nom, double prix, String style, ServiceBiere serviceBiere) {
        super(nom, prix);
        this.style = style;
        this.serviceBiere = serviceBiere;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public ServiceBiere getServiceBiere() {
        return serviceBiere;
    }

    public void setServiceBiere(ServiceBiere serviceBiere) {
        this.serviceBiere = serviceBiere;
    }
}