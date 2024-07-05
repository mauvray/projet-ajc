package grp1.BarBis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grp1.BarBis.entities.Animation;
import grp1.BarBis.exceptions.AnimationException;
import grp1.BarBis.repositories.AnimationDao;

@Service
public class AnimationService {

    @Autowired
    private AnimationDao animDao;

    public Animation create(Animation animation) {
        if (animation.getNom() == null || animation.getNom().isEmpty()) {
            throw new AnimationException("nom obligatoire");
        }
        return animDao.save(animation);
    }

    public Animation create(String nom) {
        return this.create(new Animation(nom));
    }

    public Animation getById(Long id) {
        if (id == null) {
            throw new AnimationException("Id obligatoire");
        }
        return animDao.findById(id).orElseThrow(() -> {
            throw new AnimationException("id inconnu");
        });
    }

    public List<Animation> getByNom(String nom){
        return animDao.findByNomContainingIgnoreCase(nom);
    }

    public List<Animation> getAll(){
        return animDao.findAll();
    }

    public void delete(Animation anim){
        animDao.delete(anim);
    }

    public void delete(Long id){
        animDao.delete(this.getById(id));
    }

    public Animation update(Animation anim){
        Animation animBase = this.getById(anim.getId());
        if(anim.getNom() != null || anim.getNom().isEmpty()){
            animBase.setNom((anim.getNom()));
        }
        return animDao.save(animBase);
    }
}
