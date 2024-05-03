package grp1.malveillancemax.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import grp1.malveillancemax.entities.Tapas;
import grp1.malveillancemax.exceptions.TapasException;
import grp1.malveillancemax.repositories.TapasRepository;

/**
 * TapasService
 */
public class TapasService {

    @Autowired
    private TapasRepository tapasRepo;

    public Tapas create(Tapas tapas) {
        if (tapas.getNom() == null || tapas.getNom().isEmpty()) {
            throw new TapasException("Nom obligatoire");
        }
        if (tapas.getPrix() < 0.01) {
            throw new TapasException("Prix obligatoire");
        }
        return tapasRepo.save(tapas);
    }

    public Tapas create(String nom, double prix) {
        return this.create(new Tapas(nom, prix));
    }

    public Tapas getById(Long id) {
        if (id == null) {
            throw new TapasException("id obligatoire");
        }
        return tapasRepo.findById(id).orElseThrow(() -> {
            throw new TapasException("id inconnu");
        });
    }


    public List<Tapas> getByNom(String nom) {
        if (nom == null || nom.isEmpty()) {
            throw new TapasException("id obligatoire");
        }
        return tapasRepo.findByNom(nom);
    }

    public List<Tapas> getByNomContaining(String nom) {
        if (nom == null || nom.isEmpty()) {
            throw new TapasException("id obligatoire");
        }
        return tapasRepo.findByNomContaining(nom);
    }

    public List<Tapas> getAll() {
        return tapasRepo.findAll();
    }

    public void delete(Tapas tapas) {
        tapasRepo.delete(tapas);
    }

    public void delete(Long id) {
        this.delete(this.getById(id));
    }

    public Tapas update(Tapas tapas) {
        Tapas tapasEnBase = this.getById(tapas.getId());
        if (tapas.getNom() != null && !tapas.getNom().isEmpty()) {
			tapasEnBase.setNom(tapas.getNom());
		}
		if (tapas.getPrix() >= 0.01) {
			tapasEnBase.setPrix(tapas.getPrix());
		}
		return tapasRepo.save(tapasEnBase);
    }
}