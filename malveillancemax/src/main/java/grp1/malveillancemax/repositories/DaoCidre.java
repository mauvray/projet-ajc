package grp1.malveillancemax.repositories;


import java.util.List;
// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import grp1.malveillancemax.entities.Cidre;
import grp1.malveillancemax.entities.ServiceCidre;

/**
 * DaoCidre
 */
public interface DaoCidre extends JpaRepository<Cidre, Long> {
    List<Cidre> findByProvenance(String provenance);
    List<Cidre> findByServiceCidre(ServiceCidre serviceCidre);
    List<Cidre> findByNomContainingIgnoreCase(String nom);
    // Optional<Cidre> findById(Long id);

}