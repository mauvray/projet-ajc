package main.java.grp1.malveillancemax;

@MappedSuperclass
public abstract class Boisson {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private double prix;

    public Boisson(){

    }

    public Boisson(String nom, double prix){
        this.nom = nom;
        this.prix = prix;
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

    public double getPrix(){
        return prix;
    }

    public void setPrix(double prix){
        this.prix=prix;
    }

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personne other = (Boisson) obj;
		return Objects.equals(id, other.id);
	}

}
