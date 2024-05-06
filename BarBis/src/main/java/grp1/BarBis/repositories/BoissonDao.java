package grp1.BarBis.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import grp1.BarBis.entities.Boisson;
import grp1.BarBis.entities.Services;

public interface BoissonDao extends JpaRepository<Boisson,Long> {

    List<Boisson> findByNomContainingIgnoreCase(String nom);
    List<Boisson> findByCategorie(String categorie);
    List<Boisson> findByService(Services service);
    List<Boisson> findByProvenance(String provenance);
    List<Boisson> findByCouleur(String couleur);
    List<Boisson> findByStyle(String style);
    List<Boisson> findByAlcool(Boisson alcool);
    List<Boisson> findBySoft(Boisson soft);

    
} 
