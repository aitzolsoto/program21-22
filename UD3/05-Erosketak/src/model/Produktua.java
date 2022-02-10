/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author soto.aitzol
 */
public class Produktua {
    private char[] kodea;
    private String izena;
    private double prezioa;
    
    public Produktua(String kodea, String izena, double prezioa){
        this.kodea = kodea.toCharArray();
        this.izena = izena;
        this.prezioa = prezioa;
    }
    
    public Produktua(char[] kodea, String izena, double prezioa) {
        this.kodea = kodea;
        this.izena = izena;
        this.prezioa = prezioa;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public void setPrezioa(double prezioa) {
        this.prezioa = prezioa;
    }

    public char[] getKodea() {
        return kodea;
    }

    public String getIzena() {
        return izena;
    }

    public double getPrezioa() {
        return prezioa;
    }
    
    public String getKodeaStr() {
        return String.valueOf(kodea);
    }
    @Override
    public String toString() {
        return "Produktua{" + "kodea=" + getKodeaStr() + ", izena=" + izena + ", prezioa=" + prezioa + '}';
    }
}
