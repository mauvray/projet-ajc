package grp1.BarBis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grp1.BarBis.entities.Plat;
import grp1.BarBis.exceptions.PlatException;
import grp1.BarBis.repositories.PlatDao;

@Service
public class PlatService {

    @Autowired
    private PlatDao platDao;

    public Plat create(Plat plat){
        if (plat.getNom() == null || plat.getNom().isEmpty()) {
			throw new PlatException("nom obligatoire");
		}
		if (plat.getPrix() < 0.01) {
			throw new PlatException("prix obligatoire");
		}
        if (plat.getCategorie() == null || plat.getCategorie().isEmpty()) {
			throw new PlatException("nom obligatoire");
		}
		return platDao.save(plat);
    }

    public Plat create(String nom, String categorie, double prix) {
		return this.create(new Plat(nom, categorie, prix));
	}

    public Plat getById(Long id) {
                if (id == null) {
                    throw new PlatException("id obligatoire");
                }
                return platDao.findById(id).orElseThrow(() -> {
                    throw new PlatException("id inconnu");
                });
    }

    public List<Plat> getByNom(String nom) {
		return platDao.findByNomContaining(nom);
	}

    public List<Plat> getByCategorie(String categorie) {
		return platDao.findByCategorie(categorie);
	}

    public List<Plat> getAll() {
		return platDao.findAll();
	}

    public void delete(Plat planche) {
		platDao.delete(planche);
	}

	public void delete(Long id) {
		this.delete(this.getById(id));
	}

    public Plat update(Plat plat) {
		Plat platEnBase = this.getById(plat.getId());
		if (plat.getNom() != null && !plat.getNom().isEmpty()) {
			platEnBase.setNom(plat.getNom());
		}
        if (plat.getCategorie() != null && !plat.getCategorie().isEmpty()) {
			platEnBase.setCategorie(plat.getCategorie());
		}
		if (plat.getPrix() >= 0.01) {
			platEnBase.setPrix(plat.getPrix());
		}
		return platDao.save(platEnBase);
	}
}
