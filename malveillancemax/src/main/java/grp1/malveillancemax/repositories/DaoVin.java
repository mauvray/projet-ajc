package grp1.malveillancemax.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import grp1.malveillancemax.entities.ServiceVin;
import grp1.malveillancemax.entities.Vin;

/**
 * DaoVin
 */
public interface DaoVin extends JpaRepository<Vin, Long> {

   List<Vin> findByCouleur(String nom);
   List<Vin> findByProvenance(String nom);
   // Optional<Vin> findById(Long id);
   List<Vin> findByService(ServiceVin service);
   List<Vin> findByNomContainingIgnoreCase(String nom);
    
    
}