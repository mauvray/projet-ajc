package grp1.BarBis;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertNotNull;


import grp1.BarBis.entities.Boisson;

import grp1.BarBis.services.BoissonService;

@SpringBootTest
public class BoissonTest {

    @Autowired
    BoissonService boissonSrv;

//    @Test
    void insertBoisson(){
        Boisson b = new Boisson("nomBoisson", 3, "soft");
        boissonSrv.creationBoisson(b);
        assertNotNull(b.getId());
    }

    @Test
    void insertVin(){
        Boisson vin = new Boisson("nomVin", 5,"vin");
        vin.setCouleur("rose");
        vin.setProvenance("larzac");
       // boissonSrv.creationVin(vin);
        assertNotNull(vin.getId());
    }

    @Test
    void deleteBoisson(){
        Boisson b = new Boisson("cocaDel", 4, "soft");
        boissonSrv.creationBoisson("cocaRest", 5, "soft");
        boissonSrv.creationBoisson(b);
        boissonSrv.deleteBoisson(b);
    }

    @Test
    void update(){
        Boisson b = new Boisson("cocaDel", 4, "soft");
        boissonSrv.creationBoisson(b);
        b.setPrix(2);
        boissonSrv.update(b);

    }

    @Test
    void insertCocktail(){
        Boisson cocktail = new Boisson("Tequila Sunrise", 8, "cocktail");
        Boisson vodka = new Boisson("vodka",4,"alcoolFort");
        cocktail.setAlcool(vodka);
        boissonSrv.creationBoisson(vodka);
        boissonSrv.creationBoisson(cocktail);

    }

}
