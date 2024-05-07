package grp1.malveillancemax.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import grp1.malveillancemax.entities.Cocktail;

public interface DaoCocktail extends JpaRepository<Cocktail, Long>{

    Optional<Cocktail> findByNom(String name);

    List<Cocktail> findByPrixBetween(double prixMin, double prixMax);

    Optional<Cocktail> findByDescription(String description);



    @Query("select cockt from Cocktail cockt left join fetch cockt.alcool where cockt.id=:id")
    Optional<Cocktail> findByIdFetchAlcool(@Param("id") Long id);

    @Query("select cockt from Cocktail cockt left join fetch cockt.soft where cockt.id=:id")
    Optional<Cocktail> findByIdFetchSoft(@Param("id") Long id);
}
