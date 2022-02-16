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
        this.data = LocalDate.now();
    }

    public Erosketa(String kodea, String data, Bezeroa eroslea, ArrayList<Produktua> produktuak, ArrayList<Integer> unitateak, double guztira) {
        this.kodea = kodea.toCharArray();
        this.data = LocalDate.of(Integer.parseInt(data.substring(0, 4)), Integer.parseInt(data.substring(5, 7)), Integer.parseInt(data.substring(8, 10)));
        this.bezeroa = eroslea;
        this.produktuak = produktuak;
        this.unitateak = unitateak;
        this.guztira = guztira;
    }

    public boolean guztiraEgiaztatu() {
        int zenbatekoa = 0;
        for (int i = 0; i < produktuak.size(); i++) {
            zenbatekoa += produktuak.get(i).getPrezioa() * unitateak.get(i);
        }
        if (zenbatekoa == guztira) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (produktuak == null) {
            return "Erosketa{" + "kodea=" + getKodeaStr() + ", data=" + data + ", bezeroa=" + bezeroa.toString() + ", produktuak=" + "" + ", unitateak=" + 0 + ", guztira=" + guztira + '}';
        }
        return "Erosketa{" + "kodea=" + getKodeaStr() + ", data=" + data + ", bezeroa=" + bezeroa.toString() + ", produktuak=" + produktuak.toString() + ", unitateak=" + unitateak + ", guztira=" + guztira + '}';
    }

    public String toStringLuzea() {
        String bezeroaStr = "EROSKETA \n"
                + "Kodea: " + getKodeaStr() + " ,Data: " + data
                + "\nBezeroa: " + bezeroa.getKodea()
                + "\nIzena: " + bezeroa.getIzena()
                + "\nHelbidea: " + bezeroa.getHelbidea()
                + "\nEmaila: " + bezeroa.getEmaila();

        for (int i = 0; i < produktuak.size(); i++) {
            bezeroaStr = bezeroaStr + "\n" + (i + 1) + ".produktua: " + produktuak.get(i).getKodeaStr() + ", " + produktuak.get(i).getIzena() + "," + unitateak.get(i) + "," + produktuak.get(i).getPrezioa();
        }

        if (guztiraEgiaztatu()) {
            bezeroaStr = bezeroaStr + "\n\tGUZTIRA = " + guztira;
        } else {
            bezeroaStr = bezeroaStr + "\n\tGUZTIRA = " + null;
        }

        return bezeroaStr;
    }

    public static double guztiraKalkulatu(ArrayList<Produktua> erositakoProduktuak, ArrayList<Integer> erositakoUnitateak) {
        double erosketaGuztira = 0;
        for (int i = 0; i < erositakoProduktuak.size(); i++) {
            erosketaGuztira = erositakoProduktuak.get(i).getPrezioa() * erositakoUnitateak.get(i);
        }
        return erosketaGuztira;
    }

    public char[] getKodea() {
        return kodea;
    }

    public String getKodeaStr() {
        return String.valueOf(kodea);
    }

    public double getGuztira() {
        return guztira;
    }

    public void setBezeroa(Bezeroa bezeroa) {
        this.bezeroa = bezeroa;
    }

    public void setGuztira(double guztira) {
        this.guztira = guztira;
    }

    public Bezeroa getBezeroa() {
        return bezeroa;
    }

    public LocalDate getData() {
        return data;
    }

}
