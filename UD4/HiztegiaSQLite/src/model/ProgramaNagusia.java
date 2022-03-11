/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Scanner;

/**
 *
 * @author soto.aitzol
 */
public class ProgramaNagusia {
    private static Scanner in = new Scanner(System.in);
    private static int aukera = 0;
    
    public static void menuaErakutsi(){
        System.out.println("---------------");
        System.out.println("MENUA");
        System.out.println("---------------");
        System.out.println("1.Terminoak inprimatu");
        System.out.println("2.Terminoak gehitu");
        System.out.println("3.Terminoak ezabatu");
        System.out.println("4.Terminoak aldatu");
        System.out.println("5.Irten");
        System.out.print("Sartu zenbaki bat: ");
    }
    public static void main(String[] args) {
        SQLiteKudeatu sqlk = new SQLiteKudeatu();
        do{
            menuaErakutsi();
            aukera = Integer.parseInt(in.next());
            switch(aukera){
                case 1:
                    sqlk.terminoakInprimatu();
                    break;
                case 2:
                    System.out.print("Sartu terminoa euskaraz eta gazteleraz: ");
                    sqlk.terminoaGehitu(in.next(), in.next());
                    break;
                case 3:
                    System.out.print("Sartu ezabatu nahi duzun terminoaren ID-a: ");
                    sqlk.terminoaEzabatu(Integer.parseInt(in.next()));
                    break;
                case 4:
                    System.out.print("Sartu aldatu nahi duzun terminoaren ID-a eta termino berria euskaraz eta gazteleraz: ");
                    sqlk.terminoaAldatu(Integer.parseInt(in.next()), in.next(), in.next());
                    break;
                case 5:
                    System.out.println("Agur");
                    break;
                default:
                    System.out.println("Zenbaki okerra sartu duzu");
                    break;
            }
            System.out.println("");
        }while(aukera != 5);
    }
}
