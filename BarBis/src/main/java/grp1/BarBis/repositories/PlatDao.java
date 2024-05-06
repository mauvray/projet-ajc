package grp1.BarBis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import grp1.BarBis.entities.Plat;

public interface PlatDao extends JpaRepository<Plat, Long> {

    List<Plat> findByNom(String nom);
    List<Plat> findByNomContaining(String nom);
    List<Plat> findByCategorie(String categorie);

}
