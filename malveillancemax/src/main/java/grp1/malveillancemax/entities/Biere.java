package main.java.grp1.malveillancemax.entities;

import main.java.grp1.malveillancemax.Boisson;

@Entity
@Table(name = "biere")
@AttributeOverride(name = "id", column = @Column(name = "biere_id"))
@AttributeOverride(name = "nom", column = @Column(name = "biere_nom"))
@AttributeOverride(name = "prix", column = @Column(name = "biere_nom"))
public class Biere extends Boisson {
    @Column(name="biere_style")
    private String style;
    @Column(name="biere_service")
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