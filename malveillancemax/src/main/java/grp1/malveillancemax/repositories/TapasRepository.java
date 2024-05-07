package grp1.malveillancemax.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import grp1.malveillancemax.entities.Tapas;

public interface TapasRepository extends JpaRepository<Tapas, Long>{

    List<Tapas> findByNom(String nom);

	List<Tapas> findByNomContaining(String nom);

}