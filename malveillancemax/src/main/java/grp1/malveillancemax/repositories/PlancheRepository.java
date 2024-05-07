package grp1.malveillancemax.repositories;

import java.util.List;
// import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import grp1.malveillancemax.entities.Planche;

public interface PlancheRepository extends JpaRepository<Planche, Long> {

    List<Planche> findByNom(String nom);

	List<Planche> findByNomContaining(String nom);
}
