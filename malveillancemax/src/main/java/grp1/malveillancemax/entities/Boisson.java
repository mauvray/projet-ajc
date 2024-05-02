package grp1.malveillancemax.entities;


import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Boisson {

    private Long Id;
    private String name;
    private double prix;

    public Boisson() {
        
    }

    public Boisson(String name){

    }

    public Boisson(String name, double prix) {
        this.name = name;
        this.prix = prix;
    }
    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((Id == null) ? 0 : Id.hashCode());
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
        Boisson other = (Boisson) obj;
        if (Id == null) {
            if (other.Id != null)
                return false;
        } else if (!Id.equals(other.Id))
            return false;
        return true;
    }

    
    
}
