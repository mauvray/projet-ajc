package grp1.malveillancemax.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grp1.malveillancemax.entities.Soft;
import grp1.malveillancemax.exception.NotFoundException;
import grp1.malveillancemax.exception.ReferenceNullException;
import grp1.malveillancemax.exception.SoftException;
import grp1.malveillancemax.repositories.DaoSoft;

@Service
public class SoftService {

    @Autowired
    DaoSoft daoSoft;

////CREATION
    public Soft creaSoft(String nom, double prix, String categorie) {
        return creaSoft(new Soft(nom, prix, categorie));
    }

    public Soft creaSoft(Soft soft) {
        if (soft==null) {
            throw new ReferenceNullException();
        }
        if (soft.getNom() == null || soft.getNom().isBlank()) {
            throw new SoftException("nom obligatoire");
        }
        if (soft.getPrix() <= 0) {
            throw new SoftException("prix obligatoirement supérieur à 0");
        }
        if (soft.getCategorie() == null || soft.getCategorie().isBlank()) {
            throw new SoftException("nom obligatoire");
        }
        return daoSoft.save(soft);
    }

////MAJ
    public Soft update(Soft soft) {
        if (soft == null) {
            throw new SoftException("soft inconnu");
        }
        if (soft.getId() == null) {
            throw new SoftException("soft inconnu");
        }
        return daoSoft.save(soft);
    }
    // public Soft majPrixSoft(Soft soft, double prix) {
    //     if (soft == null) {
    //         throw new ReferenceNullException();
    //     }
    //     if (prix <= 0) {
    //         throw new ReferenceNullException("prix supérieur à 0"); 
    //     }
    //     Optional<Soft> opt = daoSoft.findById(soft.getId());
    //     if(opt.isEmpty()) {
    //         throw new NotFoundException("soft non-existant");
    //     }
    //     return daoSoft.save(soft);
    // }
    // public Soft majNomSoft(Soft soft, String nom) {
    //     if (soft == null) {
    //         throw new ReferenceNullException();
    //     }
    //     if (nom.isBlank()) {
    //         throw new ReferenceNullException("nom vide");
    //     } 
    //     Optional<Soft> opt = daoSoft.findById(soft.getId());
    //     if(opt.isEmpty()) {
    //         throw new NotFoundException("soft non-existant");
    //     }
    //     return daoSoft.save(soft);
    // }
    // public Soft majCategorieSoft(Soft soft, String categorie) {
    //     if (soft == null) {
    //         throw new ReferenceNullException();
    //     }
    //     if (categorie.isBlank()) {
    //         throw new ReferenceNullException("categorie vide");
    //     } 
    //     Optional<Soft> opt = daoSoft.findById(soft.getId());
    //     if(opt.isEmpty()) {
    //         throw new NotFoundException("soft non-existant");
    //     }
    //     return daoSoft.save(soft);
    // }

////SUPRRESSION
    public void delete(Soft soft) {
        if (soft == null) {
            throw new ReferenceNullException("Soft " + soft + " inconnu.");
        }
        deleteById(soft.getId());
    }

    public void deleteById(Long id) {
        if (id == null) {
            throw new ReferenceNullException("Soft id " + id + " inconnu.");
        }
        Optional<Soft> sft = daoSoft.findById(id);
        if (sft.isEmpty()){
            throw new NotFoundException("Soft à suprimer inconnu");
        }
        daoSoft.deleteById(id);
    }

    public Soft getById(Long id) {
        if (id == null) {
            throw new ReferenceNullException();
        }
        return daoSoft.findById(id).orElseThrow( () -> {
            throw new NotFoundException("Soft id " + id + " incconu.");
        });
    }

    public Soft getByNom(String nom) {
        if (nom == null) {
            throw new ReferenceNullException();
        }
        return daoSoft.findByNom(nom).orElseThrow( () -> {
            throw new NotFoundException("Soft " + nom + " incconu.");
        });
    }

    public List<Soft> getAll() {
        return daoSoft.findAll();
    }
}
