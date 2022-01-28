/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exekutagarriak;


import java.util.ArrayList;
import model.Demarcacion;
import model.Entrenador;
import model.Futbolista;
import model.IntegranteSeleccion;
import model.Masajista;
import model.Partida;

/**
 *
 * @author soto.aitzol
 */
public class PartidaKudeatu {
    public static ArrayList<IntegranteSeleccion> selekzioa = new ArrayList<IntegranteSeleccion>();
    public Partida[] partidak;
    
    public static void main(String[] args) {
        selekzioOsoaSortu();
    }
    
    public static void selekzioOsoaSortu(){
        selekzioa.add(new Futbolista(1, "Aitor", "Fernandez", 30, 1, Demarcacion.POR));
        selekzioa.add(new Futbolista(2, "Unai", "Bustinza", 29, 2, Demarcacion.DEF));
        selekzioa.add(new Futbolista(3, "Mikel", "Balenziaga", 33, 3, Demarcacion.DEF));
        selekzioa.add(new Futbolista(4, "Asier", "Illarramendi", 31, 4, Demarcacion.MED));
        selekzioa.add(new Futbolista(5, "Iñigo", "Martinez", 30, 5, Demarcacion.DEF));
        selekzioa.add(new Futbolista(6, "Mikel", "San Jose", 32, 6, Demarcacion.MED));
        selekzioa.add(new Futbolista(7, "Gaizka", "Larrazabal", 24, 7, Demarcacion.DEF));
        selekzioa.add(new Futbolista(8, "Manu", "Garcia", 35, 8, Demarcacion.MED));
        selekzioa.add(new Futbolista(9, "Aritz", "Aduriz", 40, 9, Demarcacion.DEL));
        selekzioa.add(new Futbolista(10, "Javier", "Eraso", 31, 10, Demarcacion.MED));
        selekzioa.add(new Futbolista(11, "Asier", "Villalibre", 24, 11, Demarcacion.DEL));
        selekzioa.add(new Futbolista(12, "Aihen", "Muñoz", 24, 12, Demarcacion.DEF));
        selekzioa.add(new Futbolista(13, "Iago", "Herrerin", 34, 13, Demarcacion.POR));
        selekzioa.add(new Futbolista(14, "Aritz", "Elustondo", 27, 14, Demarcacion.DEF));
        selekzioa.add(new Futbolista(15, "Jesus", "Areso", 22, 15, Demarcacion.DEF));
        selekzioa.add(new Futbolista(16, "Iñigo", "Vicente", 24, 16, Demarcacion.DEL));
        selekzioa.add(new Futbolista(17, "Daniel", "Vivian", 22, 17, Demarcacion.DEF));
        
        selekzioa.add(new Entrenador(18, "Francisco", "Paladino", 57, "67555"));
        selekzioa.add(new Entrenador(19,"Joseba" , "Nuñez", 60, "54202"));
        selekzioa.add(new Entrenador(20,"Markel", "Lautadahandi",62,"10002"));
        
        selekzioa.add(new Masajista(21, "Iñaki", "Sertxiberrieta", 37, "Fisioterapeuta", 15));
        
        selekzioa.add(new IntegranteSeleccion(22, "Ander", "Etxeburu", 42));
    }
}
