package grp1.malveillancemax;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import grp1.malveillancemax.entities.Cidre;
import grp1.malveillancemax.entities.ServiceCidre;
import grp1.malveillancemax.services.CidreService;

/**
 * CidreServiceTest
 */
@SpringBootTest
public class CidreServiceTest {

    @Autowired
    CidreService cidreSrv;
    

//    @Test
    void insertTestCidre(){
        Cidre cidre = new Cidre("Loic raison", 2, "Breton", ServiceCidre.Bouteille);
        cidreSrv.createCidre(cidre);
        assertNotNull(cidre.getId());
    } 
//    @Test
    void deleteCidre(){
        Cidre cidre = new Cidre("Loic raison", 2, "Breton", ServiceCidre.Bouteille);
        cidreSrv.createCidre(cidre);
        assertNotNull(cidre.getId());
        cidreSrv.deleteCidre(cidre);
    }
    @Test
    void updateCidre(){
        Cidre cidre = new Cidre("Loic raison", 2, "Breton", ServiceCidre.Bouteille);
        cidreSrv.createCidre(cidre);
        assertNotNull(cidre.getId());
        cidreSrv.updatePrix(cidre,50);
    }
}