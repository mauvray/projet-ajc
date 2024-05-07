package grp1.malveillancemax.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cocktail")
@AttributeOverride(name = "id", column = @Column(name="cocktail_id"))
@AttributeOverride(name = "nom", column = @Column(name="cocktail_nom"))
@AttributeOverride(name = "prix", column = @Column(name="cocktail_prix"))
public class Cocktail extends Boisson{

    @ManyToOne
    @JoinColumn(name="alcool_id",foreignKey = @ForeignKey(name="cocktail_alcool_id_fk"), nullable=true)
    private AlcoolFort alcool;
   
    @ManyToOne
    @JoinColumn(name="soft_id",foreignKey = @ForeignKey(name="cocktail_soft_id_fk"), nullable=true)
    private Soft soft;

    @Column(name="cocktail_description", columnDefinition = "TEXT")
    private String description;
    
    public Cocktail(){
        
    }

    public Cocktail(String name, double prix) {
        super(name, prix);
    }

    public AlcoolFort getAlcool() {
        return alcool;
    }

    public void setAlcool(AlcoolFort alcool) {
        this.alcool = alcool;
    }

    public Soft getSoft() {
        return soft;
    }

    public void setSoft(Soft soft) {
        this.soft = soft;
    }


    
 }
