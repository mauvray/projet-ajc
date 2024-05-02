package grp1.malveillancemax;

import grp1.malveillancemax.entities.Biere;
import grp1.malveillancemax.entities.Cidre;
import grp1.malveillancemax.entities.ServiceBiere;
import grp1.malveillancemax.entities.ServiceCidre;

public class AppTest{
    public static void main(String[] args) {
        Cidre cidre1 = new Cidre("nomDeCidre",2,"Normandie",ServiceCidre.Verre);
        System.out.println(cidre1.getNom());

        Biere biere1 = new Biere("Chouffe",3,null,ServiceBiere.Pression);
        System.out.println(biere1.getPrix());
    }
}