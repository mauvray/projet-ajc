package grp1.malveillancemax.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import grp1.malveillancemax.entities.Cocktail;
import grp1.malveillancemax.entities.Soft;

public interface DaoSoft extends JpaRepository<Soft, Long> {

    Optional<Soft> findByNom(String name);  
    
    List<Soft> findByCocktails(Cocktail cocktail);

    List<Soft> findByPrixBetween(double prixMin, double prixMax);

}
