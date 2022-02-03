/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exekutagarriak;

import static exekutagarriak.PartidaKudeatu.selekzioa;
import model.Entrenador;
import model.Futbolista;
import model.IntegranteSeleccion;

import java.util.ArrayList;
import java.util.Scanner;
import model.Demarcacion;
import model.Masajista;

/** Programa honetan Euskal Selekzioaren datuekin egingo dugu lan.
 *  Iturria: https://es.wikipedia.org/wiki/Selecci%C3%B3n_de_f%C3%BAtbol_de_Euskadi#Plantilla
 *
 *  Programa hau selekzioko partaideen datuak kargatzen hasiko da. 
 *  Normalena da, datu hauek fitxategi edo datu-base batetik irakurtzea baina 
 *  oraindik hori ez dakigunez egiten guk programan bertan, metodo baten barruan idatziko ditugu.
 * 
 *  Gero, horrelako menu bat agertuko zaigu:
 * 
 *  **********************************************************
 *  *    EUSKAL SELEKZIOA
 *  *  ----------------------------------
 *  *  1. Partaideen datuak ikusi (Goiburuko egoki eta laburpen azken lerro batekin (Futbolistak: 23 Entren...)
 *  *  2. Partaideen datuak ikusi taldekatuta
 *  *  3. Futbolariak alfabetikoki inprimatu
 *  *  4. Aldaketa ( Sartu zaitez zu beste partaide baten ordez. Horretarako ArrayList-en set metodoa erabiliz)
 *  *  5. Bilatu abizenetik (String-en startsWith() metodoa erabiliz adibidez)
 *  *  z. Irten
 * 
 *  *  Aukeratu zenbaki bat:
 * 
 *  **************************************************************
 */
public class EuskalSelekzioaMenua {
    
    public static int azkenId = 0; 
    public static ArrayList<IntegranteSeleccion> selekzioa = new ArrayList<>(); 
    private static Scanner in = new Scanner(System.in);
    
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
    
    public static void partaideakIkusi(){
        int futbolariak = 0;
        int entrenatzaileak = 0;
        int masajistak = 0;
        int bestePartaideak = 0;
        IntegranteSeleccion partaidea;
        for (int i = 0; i < selekzioa.size(); i++) {
            partaidea = selekzioa.get(i);
            System.out.println(partaidea);
            //System.out.printf("%15s %15s %15s %15s \n", "ID" , "IZENA", "ABIZENA", "URTEAK");
            //System.out.printf("%15d %15s %15s %15d \n", selekzioa.get(i).getId(), selekzioa.get(i).getNombre(), selekzioa.get(i).getApellido(), selekzioa.get(i).getEdad());
            
            if(partaidea instanceof Futbolista){
                futbolariak++;
            }else if(partaidea instanceof Entrenador){
                entrenatzaileak++;
            }else if(partaidea instanceof Masajista){
                masajistak++;
            }else{
                bestePartaideak++;
            }
        }
        System.out.printf("Futbolistak: %d, Entrenatzaileak: %d, Masajistak: %d, Beste partaideak: %d\n",futbolariak,entrenatzaileak,masajistak,bestePartaideak);
    }
    
    public static void partaideakIkusiTaldekatuta(){
        System.out.printf("%15s %15s %15s %15s\n", "ID" , "IZENA", "ABIZENA", "URTEAK");
        System.out.printf("-----------------------------------\n");
        System.out.printf("FUTBOLARIAK: \n");
        for (int i = 0; i < selekzioa.size(); i++) {
            Object futbolista = selekzioa.get(i);
            if(futbolista instanceof Futbolista){
                System.out.printf("%15d %15s %15s %15d\n", selekzioa.get(i).getId(), selekzioa.get(i).getNombre(), selekzioa.get(i).getApellido(), selekzioa.get(i).getEdad());
            }
        }
        
        System.out.printf("ENTRENATZAILEAK: \n");
        for (int i = 0; i < selekzioa.size(); i++) {
            Object entrenador = selekzioa.get(i);
            if(entrenador instanceof Entrenador){
                System.out.printf("%15d %15s %15s %15d\n", selekzioa.get(i).getId(), selekzioa.get(i).getNombre(), selekzioa.get(i).getApellido(), selekzioa.get(i).getEdad());
            }
        }
        
        System.out.printf("MASAJISTAK: \n");
        for (int i = 0; i < selekzioa.size(); i++) {
            Object masajista = selekzioa.get(i);
            if(masajista instanceof Masajista){
                System.out.printf("%15d %15s %15s %15d\n", selekzioa.get(i).getId(), selekzioa.get(i).getNombre(), selekzioa.get(i).getApellido(), selekzioa.get(i).getEdad());
            }
        }
        
        System.out.printf("BESTE PARTAIDEAK: \n");
        for (int i = 0; i < selekzioa.size(); i++) {
            Object partaidea = selekzioa.get(i);
            if(partaidea instanceof IntegranteSeleccion && !(partaidea instanceof Futbolista) && !(partaidea instanceof Entrenador) && !(partaidea instanceof Masajista)){
                System.out.printf("%15d %15s %15s %15d\n", selekzioa.get(i).getId(), selekzioa.get(i).getNombre(), selekzioa.get(i).getApellido(), selekzioa.get(i).getEdad());
            }
        }
    }
    
    public static void aldaketa(){
        System.out.print("Sartu aldatu nahi duzun partaidearen ID-a: ");
        int id = in.nextInt();
        System.out.print("Sartu partaidearen izen berria: ");
        String izena = in.next();
        System.out.print("Sartu partaidearen abizen berria: ");
        String abizena = in.next();
        System.out.print("Sartu partaide berriaren adina: ");
        int adina = in.nextInt();
        
        IntegranteSeleccion partaideBerria = new IntegranteSeleccion(id, izena, abizena, adina);
        selekzioa.set(id-1, partaideBerria);
    }
    
    public static void bilatu(){
        System.out.print("Sartu partaidearen abizena: ");
        String abizena = in.next();
        for (int i = 0; i < selekzioa.size(); i++) {
            if(selekzioa.get(i).getApellido().startsWith(abizena)){
                System.out.println(selekzioa.get(i).toString());
            }
        }
    }
    
    public static void futbolariakAlfabetikokiIkusi(){
        ArrayList<IntegranteSeleccion> temp = new ArrayList<IntegranteSeleccion>();
        //Ordenatu
        for (int i = 0; i < selekzioa.size(); i++) {
            for (int j = 0; j < selekzioa.size()-1; j++) {
                if(selekzioa.get(j).getApellido().compareTo(selekzioa.get(j+1).getApellido()) > 0){
                    temp.add(0, selekzioa.get(j+1));
                    selekzioa.set(j+1, selekzioa.get(j));
                    selekzioa.set(j, temp.get(0));
                }
            }
        }
        
        System.out.printf("%15s %15s %15s %15s\n", "ID" , "IZENA", "ABIZENA", "URTEAK");
        for (int i = 0; i < selekzioa.size(); i++) {
            Object futbolaria = selekzioa.get(i);
            if(futbolaria instanceof Futbolista){
                System.out.printf("%15s %15s %15s %15s\n", selekzioa.get(i).getId() , selekzioa.get(i).getNombre(), selekzioa.get(i).getApellido(), selekzioa.get(i).getEdad());
            }
        }
    }
       
    public static void main(String[] args) {
        selekzioOsoaSortu();
        char aukera;
        do{
        System.out.println("EUSKAL SELEKZIOA");
        System.out.println("-----------------------");
        System.out.println("1. Partaideen datuak ikusi (Goiburuko egoki eta laburpen azken lerro batekin (Futbolistak: 23 Entren...)");
        System.out.println("2. Partaideen datuak ikusi taldekatuta");
        System.out.println("3. Futbolariak alfabetikoki inprimatu");
        System.out.println("4. Aldaketa ( Sartu zaitez zu beste partaide baten ordez. Horretarako ArrayList-en set metodoa erabiliz)");
        System.out.println("5. Bilatu abizenetik (String-en startsWith() metodoa erabiliz adibidez)");
        System.out.println("z. Irten");
        System.out.print("Aukeratu zenbaki bat:");
        aukera = in.next().charAt(0);
        
        switch(aukera){
            case '1':
                partaideakIkusi();
                break;
            case '2':
                partaideakIkusiTaldekatuta();
                break;
            case '3':
                futbolariakAlfabetikokiIkusi();
                break;
            case '4':
                aldaketa();
                break;
            case '5':
                bilatu();
                break;
            default:
                break;
        }
        }while(aukera != 'z');
    }   
}