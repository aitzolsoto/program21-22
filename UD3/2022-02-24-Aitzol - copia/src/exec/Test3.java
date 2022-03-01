package exec;

import model.Kutxa;
import model.Puntua;

public class Test3 {
    public static void main(String[] args) {
        
        Kutxa k1 = new Kutxa(new Puntua(20,20),new Puntua(26,24),5);
        Kutxa k2 = new Kutxa(new Puntua(20,20),new Puntua(26,24),6);
        
        System.out.println("Kutxa handiena marraztuko dugu, hau da bolumen handiena daukana:");
        if (k1.isHandiagoa(k2)){
            k1.marraztu();
        } else
           k2.marraztu();
        
    }
}
