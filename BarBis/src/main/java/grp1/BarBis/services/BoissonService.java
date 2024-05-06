package grp1.BarBis.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import grp1.BarBis.entities.Boisson;
import grp1.BarBis.entities.Services;
import grp1.BarBis.repositories.BoissonDao;
import grp1.BarBis.exceptions.BoissonException;

@Service
public class BoissonService {

    @Autowired
    private BoissonDao daoBoisson;


    /////////////////////////////////////////
       private void checkBoisson(Boisson boisson){
        if (boisson == null){
            throw new BoissonException("boisson null");
        }
        if (boisson.getNom()==null || boisson.getNom().isEmpty()){
            throw new BoissonException("nom obligatoire");
        }
        if (boisson.getPrix() < 0.01){
            throw new BoissonException("prix obligatoire");
        }
        if (boisson.getCategorie()==null || boisson.getCategorie().isEmpty()){
            throw new BoissonException("categorie obligatoire");
        }
    }

    private void checkId(Long id){
        if (id==null){
            throw new BoissonException("id null");
        }
    }
/////////////////////////////////////////////////////////
    public Boisson creationBoisson(String nom, double prix, String categorie){
        return creationBoisson(new Boisson(nom, prix, categorie));

    }
    public Boisson creationBoisson(Boisson boisson){
        checkBoisson(boisson);
        return daoBoisson.save(boisson);
    }

   

//////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////
    public Boisson getById(Long id){
        checkId(id);
        return daoBoisson.findById(id).orElseThrow(() -> {
            throw new BoissonException("id inconnu");
        });
    }
    public List<Boisson> getAll(){
        return daoBoisson.findAll();
    }

    public List<Boisson> getByCategorie(String categorie){
        return daoBoisson.findByCategorie(categorie);
    }
    public List<Boisson> getByProvenance(String provenance){
        return daoBoisson.findByProvenance(provenance);
    }
    public List<Boisson> getByCouleur(String couleur){
        return daoBoisson.findByCouleur(couleur);
    }

    public List<Boisson> getByService(Services service){
        return daoBoisson.findByService(service);
    }

    public List<Boisson> getByNom(String nom){
        return daoBoisson.findByNomContainingIgnoreCase(nom);
    }

    public List<Boisson> getByAlcool(Boisson alcool){
        return daoBoisson.findByAlcool(alcool);
    }

    public List<Boisson> getBySoft(Boisson soft){
        return daoBoisson.findBySoft(soft);
    }

    ////////////////////////////////////////////////

    public void deleteBoisson(Long id){
        Boisson boisson = getById(id);
        daoBoisson.delete(boisson);
    }

    public void deleteBoisson(Boisson boisson){
        deleteBoisson(boisson.getId());
    }

    ///////////////////////////////////////////////

    public Boisson update(Boisson boisson){
        checkBoisson(boisson);
        return daoBoisson.save(boisson);
    }

}
