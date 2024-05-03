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
import grp1.malveillancemax.repositories.DaoCocktail;

@Service
public class CocktailService {

    @Autowired
    DaoCocktail daoCocktail;

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
            throw new SoftException();
        }
        if (cocktail.getSoft() != null){
            soft = cocktail.getSoft();
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
}
