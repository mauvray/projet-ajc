package grp1.malveillancemax.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grp1.malveillancemax.entities.AlcoolFort;
import grp1.malveillancemax.exception.AlcoolFortException;
import grp1.malveillancemax.exception.NotFoundException;
import grp1.malveillancemax.exception.ReferenceNullException;
import grp1.malveillancemax.repositories.DaoAlcoolFort;

@Service
public class AlcoolFortService {

    @Autowired
    DaoAlcoolFort daoAlcoolFort;

    public AlcoolFort creAlcoolFort(String name, double prix){
        return creationAlcoolFort(new AlcoolFort(name, prix));
    }

    public AlcoolFort creationAlcoolFort(AlcoolFort AlcoolFort){
        if (AlcoolFort == null) {
            throw new ReferenceNullException();
        }
        if (AlcoolFort.getNom() == null || AlcoolFort.getNom().isBlank()){
            throw new AlcoolFortException("nom Alcool obligatoire");
        }
        if (AlcoolFort.getPrix() <= 0){
            throw new AlcoolFortException("prix Alcool et superieur à 0 obligatoire");
        }
        return daoAlcoolFort.save(AlcoolFort);
    }

    public AlcoolFort getById(Long id){
        if (id == null) {
            throw new ReferenceNullException();
        }
        return daoAlcoolFort.findById(id).orElseThrow( () -> {
            throw new NotFoundException("Alcool id " + id + " inconnu.");
        });
    }

    public AlcoolFort getByNom(String nom) {
		if (nom == null) {
			throw new ReferenceNullException();
		}

		return daoAlcoolFort.findByNom(nom).orElseThrow(() -> {
			throw new NotFoundException("Alcool " + nom + " inconnu.");
		});
	}

    public void deleteById(Long id){
        if (id == null){
            throw new ReferenceNullException("Alcool id " + id + " inconnu.");
        }
        Optional<AlcoolFort> alc = daoAlcoolFort.findById(id);
        if (alc.isEmpty()){
            throw new NotFoundException("Alcool à suprimer inconnu");
        }
        daoAlcoolFort.deleteById(id);

    }

    public void delete(AlcoolFort alcool) {
		if (alcool == null) {
			throw new ReferenceNullException("Alcool " + alcool + " inconnu.");
		} 
		deleteById(alcool.getId());
	}

    public AlcoolFort update(AlcoolFort alcool) {
        if (alcool==null) {
            throw new AlcoolFortException("alcool inconnu");
        }
        if (alcool.getId()==null) {
            throw new AlcoolFortException("alcool inconnu");
        }
        return daoAlcoolFort.save(alcool);
    }

    public List<AlcoolFort> getAllAlcool(){
        return daoAlcoolFort.findAll();
    }

    public AlcoolFort getByIdWithCocktails(Long id){
        if (id == null){
            throw new ReferenceNullException();
        }
        return daoAlcoolFort.findByIdFetchCocktails(id).orElseThrow(() -> {
            throw new NotFoundException();
        });
    }
}
