package grp1.malveillancemax;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import grp1.malveillancemax.entities.AlcoolFort;
import grp1.malveillancemax.repositories.DaoAlcoolFort;
import grp1.malveillancemax.services.AlcoolFortService;

@SpringBootTest
public class AlcoolFortServiceTest {

@Autowired
AlcoolFortService alcoolSvc;
@Autowired
DaoAlcoolFort daoAlcoolFort;


@Test
void insertAlcool(){
    AlcoolFort rhum = new AlcoolFort("Rhum", 6.5);
    alcoolSvc.creationAlcoolFort(rhum);
    AlcoolFort vodka = new AlcoolFort("Vodka", 5.0);
    alcoolSvc.creationAlcoolFort(vodka);
}

@Test
void update(){
    AlcoolFort rhum = new AlcoolFort("Rhum", 6.5);
    alcoolSvc.creationAlcoolFort(rhum);
    rhum.setPrix(15);
    alcoolSvc.update(rhum);
}

@Test
void delete(){
    AlcoolFort rhum = new AlcoolFort("Rhum", 6.5);
    alcoolSvc.creationAlcoolFort(rhum);
    AlcoolFort vodka = new AlcoolFort("Vodka", 5.0);
    alcoolSvc.creationAlcoolFort(vodka);
    // alcoolSvc.delete(rhum);
    // alcoolSvc.deleteById(2l);
    // alcoolSvc.deleteById(3l);
}
}
