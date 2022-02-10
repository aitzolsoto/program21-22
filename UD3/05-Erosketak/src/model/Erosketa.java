/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.Month;
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

    public Erosketa(String kodea, Bezeroa bezeroa, double guztira) {
        this.kodea = kodea.toCharArray();
        this.bezeroa = bezeroa;
        this.guztira = guztira;
    }

    public Erosketa(String kodea, String data, Bezeroa eroslea, ArrayList<Produktua> produktuak, ArrayList<Integer> unitateak, double guztira) {
        this.kodea = kodea.toCharArray();
        this.data = LocalDate.of(Integer.parseInt(data.substring(6, 10)), Integer.parseInt(data.substring(3, 5)), Integer.parseInt(data.substring(0, 2)));
        this.bezeroa = eroslea;
        this.produktuak = produktuak;
        this.unitateak = unitateak;
        this.guztira = guztira;
    }
    
    public boolean guztiraEgiaztatu(){
        int zenbatekoa = 0;
        for (int i = 0; i < produktuak.size(); i++) {
            zenbatekoa += produktuak.get(i).getPrezioa() * unitateak.get(i);
        }
        
        if(zenbatekoa == guztira){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Erosketa{" + "kodea=" + getKodeaStr() + ", data=" + data + ", bezeroa=" + bezeroa.toString() + ", produktuak=" + produktuak.toString() + ", unitateak=" + unitateak + ", guztira=" + guztira + '}';
    }

    public String toStringLuzea() {
        return "EROSKETA \n"
                + "Kodea: " + getKodeaStr() + " ,Data: " + data
                + "\nBezeroa: " + bezeroa.getKodea()
                + "\nIzena: " + bezeroa.getIzena()
                + "\nHelbidea: " + bezeroa.getHelbidea()
                + "\nEmaila: " + bezeroa.getEmaila()
                + "\n"+ produktuak.toString();
                
                

    }

    public char[] getKodea() {
        return kodea;
    }
    
    public String getKodeaStr(){
        return String.valueOf(kodea);
    }
}
