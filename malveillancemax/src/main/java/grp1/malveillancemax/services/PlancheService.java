package grp1.malveillancemax.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grp1.malveillancemax.entities.Planche;
import grp1.malveillancemax.exceptions.BiereException;
import grp1.malveillancemax.exceptions.PlancheException;
import grp1.malveillancemax.repositories.PlancheRepository;

@Service
public class PlancheService {

    @Autowired
    private PlancheRepository plancheRepo;

    public Planche create(Planche planche){
        if (planche.getNom() == null || planche.getNom().isEmpty()) {
			throw new PlancheException("nom obligatoire");
		}
		if (planche.getPrix() < 0.01) {
			throw new PlancheException("prix obligatoire");
		}
		return plancheRepo.save(planche);
    }

    public Planche create(String nom, double prix) {
		return this.create(new Planche(nom, prix));
	}

    public Planche getById(Long id) {
                if (id == null) {
                    throw new PlancheException("id obligatoire");
                }
                return plancheRepo.findById(id).orElseThrow(() -> {
                    throw new PlancheException("id inconnu");
                });
    }
    
    public List<Planche> getByNom(String nom) {
		return plancheRepo.findByNomContaining(nom);
	}

    public List<Planche> getAll() {
		return plancheRepo.findAll();
	}

    public void delete(Planche planche) {
		plancheRepo.delete(planche);
	}

	public void delete(Long id) {
		this.delete(this.getById(id));
	}

    public Planche update(Planche planche) {
		Planche plancheEnBase = this.getById(planche.getId());
		if (planche.getNom() != null && !planche.getNom().isEmpty()) {
			plancheEnBase.setNom(planche.getNom());
		}
		if (planche.getPrix() >= 0.01) {
			plancheEnBase.setPrix(planche.getPrix());
		}
		return plancheRepo.save(plancheEnBase);
	}

    public void checkId(Long id) {
        if (id==null){
            throw new PlancheException("id null");
    	} 
	}
}