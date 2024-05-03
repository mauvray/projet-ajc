package grp1.malveillancemax.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import grp1.malveillancemax.repositories.DaoCidre;
import grp1.malveillancemax.entities.Cidre;
import grp1.malveillancemax.entities.ServiceCidre;
import grp1.malveillancemax.exceptions.CidreException;

import org.springframework.stereotype.Service;

@Service
public class CidreService {
    @Autowired
    private DaoCidre daoCidre;

    private void checkCidre(Cidre cidre) {
        if (cidre == null) {
            throw new CidreException("Y a plus de cidre");
        }
        if (cidre.getNom() == null || cidre.getNom().isEmpty()) {
            throw new CidreException("Renseigner un nom de cidre");
        }
        if (cidre.getPrix() < 0.01) {
            throw new CidreException("prix obligatoire");
        }
    }

    private void checkId(Long id){
        if (id==null){
            throw new CidreException("id null");
        }
    }

    public Cidre createCidre(Cidre cidre) {
        checkCidre(cidre);
        return daoCidre.save(cidre);
    }

    public Cidre createCidre(String nom, double prix, String provenance, ServiceCidre serviceCidre) {
        return createCidre(new Cidre(nom, prix, provenance, serviceCidre));
    }

    public Cidre getByID(Long id) {
        checkId(id);
        return daoCidre.findById(id).orElseThrow(() -> {
            throw new CidreException("id inconnu");
        });
    }

    public List<Cidre> getAllCidre() {
        return daoCidre.findAll();
    }

    public List<Cidre> getByProvenance(String provenance) {
        return daoCidre.findByProvenance(provenance);
    }

    public List<Cidre> getByNom(String nom) {
        return daoCidre.findByNomContainingIgnoreCase(nom);
    }

    public List<Cidre> getByService(ServiceCidre serviceCidre) {
        return daoCidre.findByServiceCidre(serviceCidre);
    }

    public void deleteCidre(Long id) {
        Cidre cidre = getByID(id);
        daoCidre.delete(cidre);
    }

    public void deleteCidre(Cidre cidre) {
        deleteCidre(cidre.getId());
    }

    public Cidre updatePrix(Cidre cidre, double prix) {
        checkCidre(cidre);
        checkId(cidre.getId());
        cidre.setPrix(prix);
        return daoCidre.save(cidre);
    }

    public Cidre updateCidre(Cidre cidre) {
        checkCidre(cidre);
        return daoCidre.save(cidre);
    }
}
