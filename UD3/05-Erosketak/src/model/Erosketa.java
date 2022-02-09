/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author soto.aitzol
 */
public class Erosketa {
    protected char[] kodea;
    protected LocalDate data;
    protected Bezeroa bezeroa;
    protected ArrayList<Produktua> produktuak;
    protected ArrayList<Integer> unitateak;
    protected double guztira;
    
    
    public Erosketa(String kodea, Bezeroa bezeroa, double guztira){
        this.kodea = kodea.toCharArray();
        this.bezeroa = bezeroa;
        this.guztira = guztira;
    }

    @Override
    public String toString() {
        return "Erosketa{" + "kodea=" + kodea + ", data=" + data + ", bezeroa=" + bezeroa + ", produktuak=" + produktuak + ", unitateak=" + unitateak + ", guztira=" + guztira + '}';
    }
    
    public String toStringLuzea(){
        return "EROSKETA \n" +
            "Kodea: " + kodea + " ,Data: " + data + 
            /*"\nBezeroa: " + bezeroa.getKodea() + 
            "\nIzena: " + bezeroa.getIzena() + 
            "\nHelbidea: " + bezeroa.getHelbidea() + 
            "\nEmaila: " + bezeroa.getEmaila();*/
            "\nBezeroa: " + null + 
            "\nIzena: " + null + 
            "\nHelbidea: " + null + 
            "\nEmaila: " + null +
            "\nKodea    " + "Produktua         " + "Unitateak      " + "Prezioa       " + "Zenbatekoa";
    }
    
    public char[] getKodea(){
        return kodea;
    }
}
