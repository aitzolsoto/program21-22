/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probak;

import model.Demarcacion;
import model.Entrenador;
import model.Futbolista;
import model.Masajista;

/**
 *
 * @author soto.aitzol
 */
public class Test {
    public static void main(String[] args) {
        Futbolista f1 = new Futbolista(1, "Iñigo", "Martinez", 30, 5, Demarcacion.DEF);
        Entrenador entrenador1 = new Entrenador(2, "Francisco", "Padalino", 55, "554432");
        Masajista masajista1 = new Masajista("Fisioterapeuta",14);
        
        f1.entrenar();
        entrenador1.dirigirEntrenamiento();
        masajista1.darMasaje();
        
        System.out.println(f1);
        System.out.println(entrenador1.getNombre() + " " + entrenador1.getIdFederacion());
        System.out.println(masajista1.getNombre() + " " + masajista1.getTitulacion());
        
        
    }
}
