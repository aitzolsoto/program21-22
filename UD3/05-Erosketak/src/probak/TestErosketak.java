/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probak;

import java.util.ArrayList;
import model.Bezeroa;
import model.Enpresa;
import model.EpekakoErosketa;
import model.Erosketa;
import model.Pertsona;
import model.Produktua;

/**
 *
 * @author soto.aitzol
 */
public class TestErosketak {

    public static void main(String[] args) {
        Bezeroa b1 = new Pertsona(1, "Karlos", "Arguiñano", "Hondartza pasialekua z/g ZARAUTZ", "kargi@zarautz.es");
        Bezeroa b2 = new Pertsona(2, "Martin", "Berasategi", "Mirakontxa z/g DONOSTIA", "mbrea@donostia.es");

        String[] emailak = {"idazkaria@uni.eus", "zuzendaria@uni.eus"};
        Bezeroa enpresa1 = new Enpresa(3, "Uni Eibar-Ermua", "Uni Eibar-Ermua", "Otaola Etorbidea 29.EIBAR", emailak);

        //Erosketa 1
        ArrayList<Produktua> produktuak = new ArrayList<>();
        produktuak.add(new Produktua("C01", "Toshiba Satelite Pro", 450));
        ArrayList<Integer> unitateak = new ArrayList<>();
        unitateak.add(15);

        Erosketa erosketa1 = new Erosketa("E18-01", "24/10/2019", b1, produktuak, unitateak, 6750);
        System.out.println(erosketa1.toString());
        if (erosketa1.guztiraEgiaztatu()) {
            System.out.println("Datuak zuzenak dira");
        } else {
            System.out.println("Datak gaizki daude");
        }
        //Erosketa 2
        produktuak.removeAll(produktuak);
        unitateak.removeAll(unitateak);

        produktuak.add(new Produktua("C02", "Hp Pavilion", 600));
        unitateak.add(25);

        Erosketa erosketa2 = new Erosketa("E21-01", "09/02/2019", enpresa1, produktuak, unitateak, 15000);
        System.out.println(erosketa2.toStringLuzea());
        if (erosketa2.guztiraEgiaztatu()) {
            System.out.println("Datuak zuzenak dira");
        } else {
            System.out.println("Datak gaizki daude");
        }
        
        //Erosketa 3
        produktuak.removeAll(produktuak);
        unitateak.removeAll(unitateak);

        produktuak.add(new Produktua("C01", "Toshiba Satelite Pro", 450));
        produktuak.add(new Produktua("C02", "Hp Pavilion", 600));
        produktuak.add(new Produktua("T02", "iPhone XX", 1300));
        unitateak.add(3);
        unitateak.add(1);
        unitateak.add(1);

        EpekakoErosketa erosketa3 = new EpekakoErosketa("E21-01", "17/01/2020", b1, produktuak, unitateak, 3250,300);
        System.out.println(erosketa3.toStringLuzea());
        if (erosketa3.guztiraEgiaztatu()) {
            System.out.println("Datuak zuzenak dira");
        } else {
            System.out.println("Datak gaizki daude");
        }
        
        System.out.println(erosketa3.gainetikOrdainduBeharrekoa());
    }
}
