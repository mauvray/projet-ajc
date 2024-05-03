package grp1.malveillancemax.services;
import org.springframework.stereotype.Service;

import java.util.List;

import grp1.malveillancemax.entities.Biere;
import grp1.malveillancemax.entities.ServiceBiere;
import grp1.malveillancemax.exceptions.BiereException;
import grp1.malveillancemax.repositories.DaoBiere;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class BiereService{

    @Autowired
    private DaoBiere daoBiere;


//////////////////////////////////////////////////////
    private void checkBiere(Biere biere){
        if (biere == null){
            throw new BiereException("biere null");
        }
        if (biere.getNom()==null || biere.getNom().isEmpty()){
            throw new BiereException("nom obligatoire");
        }
        if (biere.getPrix() < 0.01){
            throw new BiereException("prix obligatoire");
        }
    }

    private void checkId(Long id){
        if (id==null){
            throw new BiereException("id null");
        }
    }

/////////////////////////////////////////////////////////
    public Biere createBiere(Biere biere){
        checkBiere(biere);
        return daoBiere.save(biere);
    }

    public Biere createBiere(String nom, double prix, String style, ServiceBiere serviceBiere){
        return createBiere(new Biere(nom, prix, style, serviceBiere));
    }

////////////////////////////////////////////////////////////

    public Biere getById(Long id){
        checkId(id);
        return daoBiere.findById(id).orElseThrow(() -> {
            throw new BiereException("id inconnu");
        });
    }

    public List<Biere> getAllBiere(){
        return daoBiere.findAll();
    }

    public List<Biere> getByStyle(String style){
        return daoBiere.findByStyle(style);
    }

    public List<Biere> getByService(ServiceBiere serviceBiere){
        return daoBiere.findByServiceBiere(serviceBiere);
    }

    public List<Biere> getByNom(String nom){
        return daoBiere.findByNomContainingIgnoreCase(nom);
    }

/////////////////////////////////////////////////////////////////

    public void deleteBiere(Long id){
        Biere biere = getById(id);
        daoBiere.delete(biere);
    }

    public void deleteBiere(Biere biere){
        deleteBiere(biere.getId());
    }

//////////////////////////////////////////////////////////////

    public Biere updatePrix(Biere biere, double prix){
        checkBiere(biere);
        checkId(biere.getId());
        biere.setPrix(prix);
        return daoBiere.save(biere);
    }

    public Biere updateBiere(Biere biere){
        checkBiere(biere);
        return daoBiere.save(biere);
    }




}