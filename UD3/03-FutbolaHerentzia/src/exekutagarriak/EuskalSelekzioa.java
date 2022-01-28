/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exekutagarriak;

import static exekutagarriak.EuskalSelekzioaMenua.selekzioa;
import java.util.ArrayList;
import model.Demarcacion;
import model.Entrenador;
import model.Futbolista;
import model.IntegranteSeleccion;
import model.Masajista;

/**
 *
 * @author soto.aitzol
 */


/** Programa honetan Euskal Selekzioko datuekin egingo dugu lan.
 *  Iturria: https://es.wikipedia.org/wiki/Selecci%C3%B3n_de_f%C3%BAtbol_de_Euskadi#Plantilla
 *
 *  
 * 
 */
public class EuskalSelekzioa {
    
    public static int azkenId = 0; 
    public static ArrayList<IntegranteSeleccion> selekzioa = new ArrayList<IntegranteSeleccion>();
    /** Programa honek metodo desberdinei deituko die banan banan. 
     *  Beharbada ez diozu koherentzia handirik topatuko programa osoari. 
     *  Ariketaren helburua da beste pakete bateko klase hierarkia erabiltzen trebatzea. 
     *   
     */
    public static void main(String[] args) {
        
        futbolariBat();
        bestePartaideBatzukSortu();
        selekzioOsoaSortu();
        int ezabatzekoIda = 4;
        if (partaideaEzabatu(ezabatzekoIda)){
            System.out.println(ezabatzekoIda + " id-a duen partaidea ezabatu da.");
        }
    }
    
    
    /** Metodo honek "Asier Villalibre"ri dagokion Futbolista objektua sortu eta formatu honetan inprimatzen du:    
     *  "Futbolista{id=1, nombre=Asier, apellidos=Villalibre, edad=23, dorsal=11, demarcacion=DEL}"
     *  Hori lortzeko Futbolista klasean toString() metodoa birdefinitu beharko duzu.
     *  Gainera, Web orrian id-rik ez dagoenez, automatikoki kalkulatzea erabaki dugu. 
     *  Horretarako, kontadore bat (Adibidez, azkenIda izeneko klase atributu bat) erabili dezakezu 
     *  partaide bat sortzen den bakoitzean handituko dena. 
     *  Amaitzeko, Villalibre entrenatzen hasiko da.
    */
    public static void futbolariBat(){
        azkenId += 1;
        Futbolista f1 = new Futbolista(azkenId, "Asier", "Villalibre", 23, 11, Demarcacion.DEL);
        System.out.println(f1);
    }
    
    /** Metodo honek hiru objektu berri sortuko ditu. Pertsona hauei dagokienak: 
     * - Javier Clemente
     * - Iñaki Sertxiberrieta
     * - Ander Etxeburu
     * Zein klaseko objektua izan behar du bakoitzak?
     * 
     * Objektu bakoitza sortu ondoren, bere datuak inprimatu eta kontzentratu eta bidaiatuko dute
     */
    public static void bestePartaideBatzukSortu(){
        Entrenador entrenador1 = new Entrenador(++azkenId, "Javier", "Clemente", 68, "49543");
        Masajista masajista1 = new Masajista(++azkenId, "Iñaki", "Sertxiberrieta", 37, "Fisioterapeuta", 12);
        IntegranteSeleccion integrante1 = new IntegranteSeleccion(++azkenId, "Ander", "Etxeburu", 42);
        
        System.out.println(entrenador1);
        System.out.println(masajista1);
        System.out.println(integrante1);
        entrenador1.concentrarse();
        masajista1.viajar();
    }
    
    
    /** Selekzio osoaren datuak gorde "selekzioa" deitutako IntegranteSeleccion klaseko 
     * ArrayList estatiko baten.
     *  
     */
    public static void selekzioOsoaSortu(){
        selekzioa.add(new Futbolista(++azkenId, "Aitor", "Fernandez", 30, 1, Demarcacion.POR));
        selekzioa.add(new Futbolista(++azkenId, "Unai", "Bustinza", 29, 2, Demarcacion.DEF));
        selekzioa.add(new Futbolista(++azkenId, "Mikel", "Balenziaga", 33, 3, Demarcacion.DEF));
        selekzioa.add(new Futbolista(++azkenId, "Asier", "Illarramendi", 31, 4, Demarcacion.MED));
        selekzioa.add(new Futbolista(++azkenId, "Iñigo", "Martinez", 30, 5, Demarcacion.DEF));
        selekzioa.add(new Futbolista(++azkenId, "Mikel", "San Jose", 32, 6, Demarcacion.MED));
        selekzioa.add(new Futbolista(++azkenId, "Gaizka", "Larrazabal", 24, 7, Demarcacion.DEF));
        selekzioa.add(new Futbolista(++azkenId, "Manu", "Garcia", 35, 8, Demarcacion.MED));
        selekzioa.add(new Futbolista(++azkenId, "Aritz", "Aduriz", 40, 9, Demarcacion.DEL));
        selekzioa.add(new Futbolista(++azkenId, "Javier", "Eraso", 31, 10, Demarcacion.MED));
        selekzioa.add(new Futbolista(++azkenId, "Asier", "Villalibre", 24, 11, Demarcacion.DEL));
        selekzioa.add(new Futbolista(++azkenId, "Aihen", "Muñoz", 24, 12, Demarcacion.DEF));
        selekzioa.add(new Futbolista(++azkenId, "Iago", "Herrerin", 34, 13, Demarcacion.POR));
        selekzioa.add(new Futbolista(++azkenId, "Aritz", "Elustondo", 27, 14, Demarcacion.DEF));
        selekzioa.add(new Futbolista(++azkenId, "Jesus", "Areso", 22, 15, Demarcacion.DEF));
        selekzioa.add(new Futbolista(++azkenId, "Iñigo", "Vicente", 24, 16, Demarcacion.DEL));
        selekzioa.add(new Futbolista(++azkenId, "Daniel", "Vivian", 22, 17, Demarcacion.DEF));
        selekzioa.add(new Entrenador(++azkenId, "Francisco", "Paladino", 57, "67555"));
        selekzioa.add(new Entrenador(++azkenId,"Joseba" , "Nuñez", 60, "54202"));
        selekzioa.add(new Entrenador(++azkenId,"Markel", "Lautadahandi",62,"10002"));
        selekzioa.add(new Masajista(++azkenId, "Iñaki", "Sertxiberrieta", 37, "Fisioterapeuta", 15));
        selekzioa.add(new IntegranteSeleccion(++azkenId, "Ander", "Etxeburu", 42));
    }
    
    /** ArrayListetik objektu bat ezabatzen du. Aurkitzen ez badu false itzuliko du
     * 
     * @param id Ezabatu nahi den partaidearen ida
     * @return 
     */
    public static boolean partaideaEzabatu(int id){
        if(selekzioa.get(id) != null){
            selekzioa.remove(id);
            return true;
        }
        return false;
    }
}
