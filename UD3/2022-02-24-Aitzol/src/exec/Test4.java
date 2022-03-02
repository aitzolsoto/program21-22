/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exec;

import model.Kutxa;
import model.Laukizuzena;
import model.Puntua;

/**
 *
 * @author soto.aitzol
 */
public class Test4 {
    public static void main(String[] args) {
        Kutxa k2 = new Kutxa(new Puntua(20,20),new Puntua(26,24),6);
        Kutxa k1 = new Kutxa(new Puntua(10,20),new Puntua(15,22),8);
        Kutxa k3 = new Kutxa(new Puntua(21,22),new Puntua(26,24),10);
        Kutxa[] kutxaSorta = {k1,k2,k3};
        Laukizuzena lauki2 = new Laukizuzena(10,10,15,19);
        Puntua puntua1 = new Puntua(10,10);
        
        System.out.println(k1.getBolumena());
        System.out.println(k2.getBolumena());
        System.out.println(k3.getBolumena());
        System.out.println(lauki2.isInside(new Puntua(14,20)));
        System.out.println(Kutxa.handiena(kutxaSorta));
        
        puntua1.mugitu(5, 1);
        System.out.println(puntua1);
    }
}
