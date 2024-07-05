package grp1.BarBis.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="animation")
public class Animation {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="animation_id",nullable=false)
    private long id;
    @NotBlank
    @Column(name="animation_nom",nullable=false)
    private String nom;

    
    public Animation() {
    }


    public Animation(@NotBlank String nom) {
        this.nom = nom;
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Animation other = (Animation) obj;
        if (id != other.id)
            return false;
        return true;
    }

    
}
