
package exec;

import model.Laukizuzena;
import model.Puntua;


public class Test2 {
    public static void main(String[] args) {
        
        Laukizuzena lauki1 = new Laukizuzena(new Puntua(0,0),new Puntua(10,5));
        Laukizuzena lauki2 = new Laukizuzena(15,10,12,19);
        
        System.out.println("Sortutako puntuak: " + Puntua.getSortutakoPuntuak());
        
        System.out.println("Lehen laukiazuzena: "+ lauki1);
        
        System.out.println("Bigarren laukizuzena:");
        for (Puntua p:lauki2.getLauErpinenArrayLista()){
            System.out.println(p);
        }
    }
}
