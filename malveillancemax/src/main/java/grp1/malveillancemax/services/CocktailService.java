package grp1.malveillancemax.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grp1.malveillancemax.entities.AlcoolFort;
import grp1.malveillancemax.entities.Cocktail;
import grp1.malveillancemax.entities.Soft;
import grp1.malveillancemax.exception.AlcoolFortException;
import grp1.malveillancemax.exception.CocktailException;
import grp1.malveillancemax.exception.NotFoundException;
import grp1.malveillancemax.exception.ReferenceNullException;
import grp1.malveillancemax.exception.SoftException;
import grp1.malveillancemax.repositories.DaoAlcoolFort;
import grp1.malveillancemax.repositories.DaoCocktail;
import grp1.malveillancemax.repositories.DaoSoft;

@Service
public class CocktailService {

    @Autowired
    DaoCocktail daoCocktail;
    @Autowired
    DaoSoft daoSoft;
    @Autowired
    DaoAlcoolFort daoAlcoolFort;

    public Cocktail creCocktail(String name, double prix){
        return creationCocktail(new Cocktail(name, prix));
    }

    public Cocktail creationCocktail(Cocktail cocktail){
        if(cocktail == null){
            throw new ReferenceNullException();
        }
        if (cocktail.getNom() == null || cocktail.getNom().isBlank()){
            throw new CocktailException("nom cocktail obligatoire");
        }
        if (!daoSoft.existsById(cocktail.getSoft().getId())){
            throw new CocktailException("le soft n'existe pas");
        }
        if (!daoAlcoolFort.existsById(cocktail.getAlcool().getId())){
            throw new CocktailException("l'alcool fort n'existe pas");
        }
        return daoCocktail.save(cocktail);
    }

    public void ajouterAlcool(AlcoolFort alcool, Cocktail cocktail) {
        if(alcool == null){
            throw new AlcoolFortException();
        }
        if (cocktail.getAlcool() != null){
            alcool = cocktail.getAlcool();
        }
        cocktail.setAlcool(alcool);
        daoCocktail.save(cocktail);
    }
        
    public void ajouterSoft(Soft soft, Cocktail cocktail) {
        if(soft == null){
            throw new SoftException("Soft was null");
        }
        if (cocktail.getSoft() != null) {
            throw new SoftException("Cocktail already got a soft");
        }
        cocktail.setSoft(soft);
        daoCocktail.save(cocktail);
    }

    public Cocktail getById(Long id){
         if (id == null) {
            throw new ReferenceNullException();
        }
        return daoCocktail.findById(id).orElseThrow( () -> {
            throw new NotFoundException("Cocktail id " + id + " inconnu.");
        });
    }

    public Cocktail getByNom(String nom) {
		if (nom == null) {
			throw new ReferenceNullException();
		}

		return daoCocktail.findByNom(nom).orElseThrow(() -> {
			throw new NotFoundException("Cocktail " + nom + " inconnu.");
		});
	}

    public void deleteById(Long id){
        if (id == null){
            throw new ReferenceNullException("Cocktail id " + id + " inconnu.");
        }
        Optional<Cocktail> cockt = daoCocktail.findById(id);
        if (cockt.isEmpty()){
            throw new NotFoundException("Cocktail à suprimer inconnu");
        }
        daoCocktail.deleteById(id);

    }

    public void delete(Cocktail cocktail) {
		if (cocktail == null) {
			throw new ReferenceNullException("Cocktail " + cocktail + " inconnu.");
		} 
		deleteById(cocktail.getId());
	}

    public Cocktail update(Cocktail cocktail) {
        if (cocktail==null) {
            throw new CocktailException("cocktail inconnu");
        }
        if (cocktail.getId()==null) {
            throw new CocktailException("cocktail inconnu");
        }
        return daoCocktail.save(cocktail);
    }

    public List<Cocktail> getAll(){
        return daoCocktail.findAll();
    }

    public Cocktail getByIdWithAlcools(Long id){
        if (id == null){
            throw new ReferenceNullException();
        }
        return daoCocktail.findByIdFetchAlcool(id).orElseThrow(() -> {
			throw new NotFoundException();
		});
    }

    public Cocktail getByIdWithSofts(Long id){
        if (id == null){
            throw new ReferenceNullException();
        }
        return daoCocktail.findByIdFetchSoft(id).orElseThrow(() -> {
            throw new NotFoundException();
        });
    }

}
