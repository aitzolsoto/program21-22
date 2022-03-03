/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exec;

import java.util.Scanner;
import model.Kutxa;
import model.Laukizuzena;
import model.Norabidea;
import model.Puntua;

/**
 *
 * @author soto.aitzol
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
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
        
        System.out.print("Sartu zenbat mugitu nahi duzun puntua eta zein norabidetan(EZK/ESK/GORA/BEHERA): ");
        int zenbat = Integer.parseInt(in.next());
        Norabidea norabidea = Norabidea.valueOf(in.next().toUpperCase());
        puntua1.mugitu(zenbat, norabidea);
        System.out.println(puntua1);
    }
}
