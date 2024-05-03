package grp1.malveillancemax.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import grp1.malveillancemax.entities.Biere;
import grp1.malveillancemax.entities.ServiceBiere;

/**
 * DaoBiere
 */
public interface DaoBiere extends JpaRepository<Biere, Long> {

    List<Biere> findByStyle(String style);
    List<Biere> findByServiceBiere(ServiceBiere serviceBiere);
    Optional<Biere> findById(Long id);
    List<Biere> findByNomContainingIgnoreCase(String nom);

    
}