package grp1.malveillancemax;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import grp1.malveillancemax.entities.Soft;
import grp1.malveillancemax.repositories.DaoSoft;
import grp1.malveillancemax.services.SoftService;

@SpringBootTest
public class SoftServiceTest {

    @Autowired
    SoftService softService;
    @Autowired
    DaoSoft daoSoft;

    @Test
    void insertSoft() {
        Soft soft = new Soft("jus de pomme", 2.50, "jus");
        softService.creaSoft(soft);
    }

    // @Test
    // void update() {
    //     Soft soft = new Soft("jus de pomme", 2.50, "jus");
    //     softService.creaSoft(soft);
    //     soft.setPrix(3);
    //     softService.update(soft);
    // }

    @Test
    void delete() {
        Soft soft = new Soft("jus de pomme", 2.50, "jus");
        softService.creaSoft(soft);
        Soft soft2 = new Soft("sprite", 3.0, "soda");
        softService.creaSoft(soft2);
        softService.delete(soft2);
        //softService.deleteById(1L);
    }

}
