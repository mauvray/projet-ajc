package grp1.malveillancemax.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import grp1.malveillancemax.entities.Cocktail;

public interface DaoCocktail extends JpaRepository<Cocktail, Long>{

    Optional<Cocktail> findByNom(String name);

    List<Cocktail> findByPrixBetween(double prixMin, double prixMax);

    Optional<Cocktail> findByDescription(String description);
}
