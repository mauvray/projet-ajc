package grp1.malveillancemax;

import org.springframework.data.jpa.repository.JpaContext;

import grp1.malveillancemax.entities.Biere;
import grp1.malveillancemax.entities.Cidre;
import grp1.malveillancemax.entities.Planche;
import grp1.malveillancemax.entities.ServiceBiere;
import grp1.malveillancemax.entities.ServiceCidre;
import grp1.malveillancemax.repositories.DaoCidre;
import grp1.malveillancemax.entities.Tapas;

public class AppTest{
    public static void main(String[] args) {
     

        Cidre cidre1 = new Cidre("nomDeCidre",2,"Normandie",ServiceCidre.Verre);
        
        System.out.println(cidre1.getNom());

        Biere biere1 = new Biere("Chouffe",3,null,ServiceBiere.Pression);
        System.out.println(biere1.getPrix());

        Planche planche1 = new Planche("charcuterie",12.25);
        System.out.println(planche1.getNom());

        Tapas tapas1 = new Tapas("flamme munster", 4.5);
        System.out.println(tapas1.getNom());
    }
}