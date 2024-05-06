package grp1.malveillancemax.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import grp1.malveillancemax.entities.Cocktail;
import grp1.malveillancemax.entities.Soft;

public interface DaoSoft extends JpaRepository<Soft, Long> {

    Optional<Soft> findByNom(String name);  
    
    List<Soft> findByCocktails(Cocktail cocktail);

    List<Soft> findByPrixBetween(double prixMin, double prixMax);

    @Query("select soft from Soft soft left join fetch soft.cocktails where soft.id=:id")
    Optional<Soft> findByIdFetchCocktails(@Param("id") Long id);

}
