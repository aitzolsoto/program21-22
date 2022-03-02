/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exec;

import java.util.Scanner;
import model.Kutxa;
import model.Puntua;

/**
 *
 * @author soto.aitzol
 */
public class Test5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Kutxa[] kutxaSorta = new Kutxa[10];
        /*kutxaSorta[0] = new Kutxa(new Puntua(20,20),new Puntua(26,24),6);
        kutxaSorta[1] = new Kutxa(new Puntua(10,15),new Puntua(20,22),4);
        kutxaSorta[2] = new Kutxa(new Puntua(5,10),new Puntua(12,14),6);
        kutxaSorta[3] = new Kutxa(new Puntua(8,12),new Puntua(12,15),10);
        kutxaSorta[4] = new Kutxa(new Puntua(9,17),new Puntua(15,24),3);
        kutxaSorta[5] = new Kutxa(new Puntua(30,20),new Puntua(40,27),3);
        kutxaSorta[6] = new Kutxa(new Puntua(23,10),new Puntua(30,16),7);
        kutxaSorta[7] = new Kutxa(new Puntua(21,30),new Puntua(26,36),4);
        kutxaSorta[8] = new Kutxa(new Puntua(19,12),new Puntua(25,18),2);
        kutxaSorta[9] = new Kutxa(new Puntua(26,14),new Puntua(36,24),7);*/
        
        for (int i = 0; i < kutxaSorta.length; i++) {
            System.out.print("Sartu lehenengo erpinaren koordenatuak(z1 z2): ");
            Puntua erpina = new Puntua(in.nextInt(),in.nextInt());
            System.out.print("Sartu kontrako erpinaren koordenatuak(z1 z2): ");
            Puntua kontrakoErpina = new Puntua(in.nextInt(),in.nextInt());
            System.out.print("Sartu altuera: ");
            int altuera = in.nextInt();
            
            kutxaSorta[i] = new Kutxa(erpina,kontrakoErpina,altuera);
        }
        
        System.out.printf("%15s %15s %16s %15s %15s", "KUTXA","ERPINA" , "KONTR. ERPINA", "ALTUERA", "BOLUMENA");
        System.out.printf("\n----------------------------------------------------------------------------------");
        for (int i = 0; i < kutxaSorta.length; i++) {
            System.out.printf("\n%15d %15s %15s %15d %15d", (i+1),kutxaSorta[i].getErpinBat() , kutxaSorta[i].getKontrakoErpina(), kutxaSorta[i].getAltuera(), kutxaSorta[i].getBolumena());
        }
        System.out.println("");
    }
}
