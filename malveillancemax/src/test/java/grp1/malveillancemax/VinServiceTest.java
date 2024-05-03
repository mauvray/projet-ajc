package grp1.malveillancemax;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import grp1.malveillancemax.entities.ServiceVin;
import grp1.malveillancemax.entities.Vin;
import grp1.malveillancemax.services.VinService;

/**
 * vinServiceTest
 */
@SpringBootTest
public class VinServiceTest {

    @Autowired
    VinService vinSrv;
    

    @Test
    void insertTestvin(){
        Vin vin = new Vin("Loic raison", 2, "Breton","rose", ServiceVin.Bouteille);
        vinSrv.createVin(vin);
        assertNotNull(vin.getId());
    } 
    @Test
    void deletevin(){
        Vin vin = new Vin("Loic raison", 2, "Breton","rose", ServiceVin.Bouteille);
        vinSrv.createVin(vin);
        assertNotNull(vin.getId());
        vinSrv.deleteVin(vin);
    }
    @Test
    void updatevin(){
        Vin vin = new Vin("Loic raison", 2, "Breton","rose", ServiceVin.Bouteille);
        vinSrv.createVin(vin);
        assertNotNull(vin.getId());
        vinSrv.updatePrix(vin,50);
    }
}