package grp1.malveillancemax;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import grp1.malveillancemax.entities.ServiceBiere;
import grp1.malveillancemax.entities.Biere;
import grp1.malveillancemax.services.BiereService;

/**
 * biereServiceTest
 */
@SpringBootTest
public class BiereServiceTest {

    @Autowired
    BiereService biereSrv;
    

    @Test
    void insertTestbiere(){
        Biere biere = new Biere("Loic raison1", 2, "ambre", ServiceBiere.Pression);
        biereSrv.createBiere(biere);
        assertNotNull(biere.getId());
    } 
    @Test
    void deletebiere(){
        Biere biere = new Biere("Loic raison2", 2, "ambre", ServiceBiere.Pression);
        biereSrv.createBiere(biere);
        assertNotNull(biere.getId());
        biereSrv.deleteBiere(biere);
    }
    @Test
    void updatebiere(){
        Biere biere = new Biere("Loic raison3", 2, "ambre", ServiceBiere.Pression);
        biereSrv.createBiere(biere);
        assertNotNull(biere.getId());
        biereSrv.updatePrix(biere,50);
    }
}