package grp1.malveillancemax.services;
import org.springframework.stereotype.Service;

import grp1.malveillancemax.repositories.DaoVin;
import grp1.malveillancemax.entities.Vin;
import grp1.malveillancemax.entities.ServiceVin;
import grp1.malveillancemax.exceptions.VinException;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * VinService
 */
@Service
public class VinService {

    @Autowired
    private DaoVin daoVin;


/////////////////////////////////////////////////////////::::
private void checkVin(Vin vin){
        if (vin == null){
            throw new VinException("vin null");
        }
        if (vin.getNom()==null || vin.getNom().isEmpty()){
            throw new VinException("nom obligatoire");
        }
        if (vin.getPrix() < 0.01){
            throw new VinException("prix obligatoire");
        }
    }

    private void checkId(Long id){
        if (id==null){
            throw new VinException("id null");
        }
    }

////////////////////////////////////////////////////////////

public Vin createVin(Vin vin){
        checkVin(vin);
        return daoVin.save(vin);
    }

    public Vin createVin(String nom, double prix, String provenance, String couleur, ServiceVin serviceVin){
        return createVin(new Vin(nom, prix, provenance, couleur, serviceVin));
    }

/////////////////////////////////////////////////////////////////:
    public Vin getById(Long id){
        checkId(id);
        return daoVin.findById(id).orElseThrow(() -> {
            throw new VinException("id inconnu");
        });
    }

    public List<Vin> getByCouleur(String couleur){
        return daoVin.findByCouleur(couleur);
    }

    public List<Vin> getAllVin(){
        return daoVin.findAll();
    }

    public List<Vin> getByProvenance(String provenance){
        return daoVin.findByProvenance(provenance);
    }

    public List<Vin> getByNom(String nom){
        return daoVin.findByNomContainingIgnoreCase(nom);
    }

    public List<Vin> getByService(ServiceVin serviceVin){
        return daoVin.findByServiceVin(serviceVin);
    }

/////////////////////////////////////////////////////////////////////
    public void deleteVin(Long id){
        Vin vin = getById(id);
        daoVin.delete(vin);
    }

    public void deleteVin(Vin vin){
        deleteVin(vin.getId());
    }

////////////////////////////////////////////////////////////////////
    public Vin updateVin(Vin vin){
        checkVin(vin);
        return daoVin.save(vin);
    }

     public Vin updatePrix(Vin vin, double prix){
        checkVin(vin);
        checkId(vin.getId());
        vin.setPrix(prix);
        return daoVin.save(vin);
    }
    
}