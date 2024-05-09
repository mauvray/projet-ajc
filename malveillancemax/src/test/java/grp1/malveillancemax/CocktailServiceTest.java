package grp1.malveillancemax;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertThrows;

// import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// import grp1.malveillancemax.entities.AlcoolFort;
// import grp1.malveillancemax.entities.Cocktail;
// import grp1.malveillancemax.entities.Soft;
// import grp1.malveillancemax.exception.CocktailException;
import grp1.malveillancemax.repositories.DaoAlcoolFort;
import grp1.malveillancemax.repositories.DaoCocktail;
import grp1.malveillancemax.repositories.DaoSoft;
import grp1.malveillancemax.services.AlcoolFortService;
import grp1.malveillancemax.services.CocktailService;
import grp1.malveillancemax.services.SoftService;

@SpringBootTest
public class CocktailServiceTest {

    @Autowired
    CocktailService cocktailSvc;
    @Autowired
    DaoCocktail daoCocktail;
    @Autowired
    AlcoolFortService alcoolSvc;
    @Autowired
    DaoAlcoolFort daoAlcoolFort;
    @Autowired
    SoftService softService;
    @Autowired
    DaoSoft daoSoft;

    // @Test
    // void insertCocktail(){
    //     Cocktail cock1 = new Cocktail("Sex On The Beach", 9.0);
    //     cocktailSvc.creationCocktail(cock1);
    // }
    
    // @Test
    // void ajouterAlcoolOuEtSoft(){
    //     Cocktail cock1 = new Cocktail("Sex On The Beach", 9.0);
    //     cocktailSvc.creationCocktail(cock1);
    //     AlcoolFort vodka = new AlcoolFort("Vodka", 6.5);
    //     alcoolSvc.creationAlcoolFort(vodka);
    //     cocktailSvc.ajouterAlcool(vodka, cock1);
    //     Soft soft = new Soft("jus de pomme", 2.50, "jus");
    //     softService.creaSoft(soft);
    //     cocktailSvc.ajouterSoft(soft, cock1);
    // }

    // @Test
    // void delete(){
    //     Cocktail cock1 = new Cocktail("Sex On The Beach", 9.0);
    //     cocktailSvc.creationCocktail(cock1);
    //     Cocktail cock2 = new Cocktail("Pina Colada", 9.5);
    //     cocktailSvc.creationCocktail(cock2);
    //     // cocktailSvc.delete(cock2);

    //     // AlcoolFort vodka = new AlcoolFort("Vodka", 6.5);
    //     // alcoolSvc.creationAlcoolFort(vodka);
    //     // cocktailSvc.ajouterAlcool(vodka, cock1);
    //     // cocktailSvc.delete(cock1);
    //     // alcoolSvc.deleteById(1l);

    //     // Soft soft = new Soft("jus d'ananas", 2.50, "jus");
    //     // softService.creaSoft(soft);
    //     // cocktailSvc.ajouterSoft(soft, cock2);
    //     // cocktailSvc.delete(cock2);
    //     // softService.deleteById(1l);

    //     AlcoolFort alc = new AlcoolFort("Rhum", 6.5);
    //     alcoolSvc.creationAlcoolFort(alc);
    //     cocktailSvc.ajouterAlcool(alc, cock2);
    //     Soft soft = new Soft("jus d'ananas", 2.50, "jus");
    //     softService.creaSoft(soft);
    //     cocktailSvc.ajouterSoft(soft, cock2);
    //     // alcoolSvc.deleteById(1l);
    //     // softService.deleteById(1l);
    //     cocktailSvc.delete(cock2);
    // }

    // @Test
    // void update(){
    //     Cocktail cock1 = new Cocktail("Sex On The Beach", 9.);
    //     cocktailSvc.creationCocktail(cock1);
    //     // Premier test : mise à jour du nom
    //     cock1.setNom("cock1");
    //     assertEquals("cock1", cocktailSvc.update(cock1).getNom());
    //     // Premier test : mise à jour du prix
    //     cock1.setPrix(25);
    //     AlcoolFort vodka = new AlcoolFort("Vodka", 6.5);
    //     alcoolSvc.creationAlcoolFort(vodka);
    //     cocktailSvc.ajouterAlcool(vodka, cock1);
    //     cock1.setAlcool(vodka);
    //     assertEquals(vodka, cocktailSvc.update(cock1).getAlcool());
       
    //     Cocktail to_fail = new Cocktail("test", 10.);
    //     assertThrows(CocktailException.class, () -> {
    //         cocktailSvc.update(to_fail);
    //     });
    //     assertThrows(CocktailException.class, () -> {
    //         cocktailSvc.update(null);
    //     });
        // Premier test 
        // cock1.setPrix(25);
        // cocktailSvc.update(cock1);
        // AlcoolFort vodka = new AlcoolFort("Vodka", 6.5);
        // alcoolSvc.creationAlcoolFort(vodka);
        // cocktailSvc.ajouterAlcool(vodka, cock1);
        // cock1.setAlcool(vodka);
        // cocktailSvc.update(cock1);
    // }
}
