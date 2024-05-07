package grp1.malveillancemax.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import grp1.malveillancemax.entities.AlcoolFort;
import grp1.malveillancemax.entities.Cocktail;

public interface DaoAlcoolFort extends JpaRepository<AlcoolFort, Long> {

    Optional<AlcoolFort> findByNom(String name);  

    List<AlcoolFort> findByCocktails(Cocktail cocktails);

    List<AlcoolFort> findByPrixBetween(double prixMin, double prixMax);

}
