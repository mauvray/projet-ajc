package grp1.BarBis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import grp1.BarBis.entities.Animation;

public interface AnimationDao extends JpaRepository<Animation, Long> {
    List<Animation> findByNomContainingIgnoreCase(String nom);
}
 