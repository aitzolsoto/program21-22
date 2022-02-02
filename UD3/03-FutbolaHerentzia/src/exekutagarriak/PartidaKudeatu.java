/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exekutagarriak;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
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
    public static Partida[] partidak;
    private static int sortutakoPartidak = 0;
    private static Scanner in = new Scanner(System.in);

    public static void selekzioOsoaSortu() {
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
        selekzioa.add(new Entrenador(19, "Joseba", "Nuñez", 60, "54202"));
        selekzioa.add(new Entrenador(20, "Markel", "Lautadahandi", 62, "10002"));

        selekzioa.add(new Masajista(21, "Iñaki", "Sertxiberrieta", 37, "Fisioterapeuta", 15));

        selekzioa.add(new IntegranteSeleccion(22, "Ander", "Etxeburu", 42));
    }

    public static void partidakAsmatu() {
        //1.Partida
        partidak[sortutakoPartidak] = new Partida(LocalDate.of(2016, 05, 27), "Corcega");
        partidak[sortutakoPartidak].txartelaJarri(new Futbolista(5, "Iñigo", "Martinez", 30, 5, Demarcacion.DEF));
        partidak[sortutakoPartidak].txartelaJarri(new Futbolista(12, "Aihen", "Muñoz", 24, 12, Demarcacion.DEF));
        sortutakoPartidak++;
        //2.Partida
        partidak[sortutakoPartidak] = new Partida(LocalDate.of(2016, 12, 20), "Tunez");
        partidak[sortutakoPartidak].txartelaJarri(new Futbolista(14, "Aritz", "Elustondo", 27, 14, Demarcacion.DEF));
        partidak[sortutakoPartidak].txartelaJarri(new Futbolista(12, "Aihen", "Muñoz", 24, 12, Demarcacion.DEF));
        partidak[sortutakoPartidak].txartelaJarri(new Futbolista(11, "Asier", "Villalibre", 24, 11, Demarcacion.DEL));
        sortutakoPartidak++;
        //3.Partida
        partidak[sortutakoPartidak] = new Partida(LocalDate.of(2018, 10, 12), "Venezuela");
        partidak[sortutakoPartidak].txartelaJarri(new Futbolista(10, "Javier", "Eraso", 31, 10, Demarcacion.MED));
        partidak[sortutakoPartidak].txartelaJarri(new Futbolista(6, "Mikel", "San Jose", 32, 6, Demarcacion.MED));
        sortutakoPartidak++;

        //4.Partida
        partidak[sortutakoPartidak] = new Partida(LocalDate.of(2019, 05, 19), "Panama");
        partidak[sortutakoPartidak].txartelaJarri(new Futbolista(5, "Iñigo", "Martinez", 30, 5, Demarcacion.DEF));
        partidak[sortutakoPartidak].txartelaJarri(new Futbolista(12, "Aihen", "Muñoz", 24, 12, Demarcacion.DEF));
        partidak[sortutakoPartidak].txartelaJarri(new Futbolista(9, "Aritz", "Aduriz", 40, 9, Demarcacion.DEL));
        partidak[sortutakoPartidak].txartelaJarri(new Futbolista(11, "Asier", "Villalibre", 24, 11, Demarcacion.DEL));
        partidak[sortutakoPartidak].txartelaJarri(new Futbolista(1, "Aitor", "Fernandez", 30, 1, Demarcacion.POR));
        sortutakoPartidak++;

        //5.Partida
        partidak[sortutakoPartidak] = new Partida(LocalDate.of(2020, 11, 16), "Costa Rica");
        partidak[sortutakoPartidak].txartelaJarri(new Futbolista(10, "Javier", "Eraso", 31, 10, Demarcacion.MED));
        sortutakoPartidak++;
    }

    public static void partidaBatenDatuakEskatu() {
        System.out.print("Sartu partiduaren data(Urtea Hilabetea Eguna): ");
        String urteaStr = in.next();
        String hilabeteaStr = in.next();
        String egunaStr = in.next();
        //System.out.println("Data: " + urtea + ", " + hilabetea + ", " + eguna);

        System.out.print("Sartu aurkariaren izena: ");
        String aurkaria = in.next();

        partidak[sortutakoPartidak] = new Partida(LocalDate.of(Integer.parseInt(urteaStr), Integer.parseInt(hilabeteaStr), Integer.parseInt(egunaStr)), aurkaria);
        char aukera;
        do {
            System.out.print("Txartel bat jarri nahi duzu(B/E)? ");
            aukera = in.next().toUpperCase().charAt(0);
            if (aukera == 'B') {
                System.out.print("Sartu futbolariari buruzko informazioa(ID izena abizena adina dortsala): ");
                String id = in.next();
                String izena = in.next();
                String abizena = in.next();
                String adina = in.next();
                String dortsala = in.next();

                partidak[sortutakoPartidak].txartelaJarri(new Futbolista(Integer.parseInt(id), izena, abizena, Integer.parseInt(adina), Integer.parseInt(dortsala), null));
            }
        } while (aukera != 'E');
        System.out.println(partidak[sortutakoPartidak]);
        sortutakoPartidak++;
    }

    public static void jokalarienTxartelak() {
        int txartelakGuztira = 0;
        ArrayList<Futbolista> ateratakoTxartelGuztiak = new ArrayList<>();
        //Jokalariak gorde eta txartelak kontatu
        for (int i = 0; i < partidak.length; i++) {
            if (partidak[i] != null) {
                for (int j = 0; j < partidak[i].getTxarterlak().size(); j++) {
                    ateratakoTxartelGuztiak.add(partidak[i].getTxarterlak().get(j));
                }
                txartelakGuztira += partidak[i].getTxarterlak().size();
            }
        }

        int count1 = Collections.frequency(ateratakoTxartelGuztiak, ateratakoTxartelGuztiak.get(0));
        System.out.println(ateratakoTxartelGuztiak.get(0).getNombre() + ": " + count1);

        System.out.println("Txartelak guztira: " + txartelakGuztira);
    }

    public static int jokatutakoPartidaKopurua() {
        int partidaKopurua = 0;
        for (int i = 0; i < partidak.length; i++) {
            if (partidak[i] != null) {
                partidaKopurua++;
            }
        }

       
        return partidaKopurua;
    }

    public static void partidakBatazBeste() {
        long egunakGuztira = 0;
        int partidaBatazBeste = 0;
        int jokatutakoPartidak = 0;
        LocalDate partida1;
        LocalDate partida2;
        for (int i = 0; i < partidak.length; i++) {
            if (partidak[i] != null && partidak[i + 1] != null) {
                partida1 = partidak[i].getData();
                partida2 = partidak[i+1].getData();
                egunakGuztira += ChronoUnit.DAYS.between(partida1, partida2);
            }

        }
        
        jokatutakoPartidak = jokatutakoPartidaKopurua();
        partidaBatazBeste = (int)egunakGuztira / (jokatutakoPartidak-1);
        System.out.println("Egunak: " + egunakGuztira);
        System.out.println("Partido bat jokatzen da " + partidaBatazBeste + " egunero");
    }

    public static void main(String[] args) {
        selekzioOsoaSortu();
        partidak = new Partida[20];
        partidakAsmatu();
        // partidaBatenDatuakEskatu();
         System.out.println("Jokatutako partida kopurua: " + jokatutakoPartidaKopurua());
        partidakBatazBeste();
    }

}
