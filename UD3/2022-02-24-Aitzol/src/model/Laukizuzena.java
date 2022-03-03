/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author soto.aitzol
 */
public class Laukizuzena implements Marrazgarria{
    private Puntua erpinBat;
    private Puntua kontrakoErpina;
    
    public Laukizuzena(Puntua erpina, Puntua kontrakoErpina){
        this.erpinBat = erpina;
        this.kontrakoErpina = kontrakoErpina;
    }
    
    public Laukizuzena(int x1, int y1, int x2, int y2){
        this.erpinBat = new Puntua(x1,y1);
        this.kontrakoErpina = new Puntua(x2,y2);
    }

    public Puntua getErpinBat() {
        return erpinBat;
    }

    public Puntua getKontrakoErpina() {
        return kontrakoErpina;
    }

    public void setErpinBat(Puntua erpinBat) {
        this.erpinBat = erpinBat;
    }

    public void setKontrakoErpina(Puntua kontrakoErpina) {
        this.kontrakoErpina = kontrakoErpina;
    }
    
    
    public Puntua[] getLauErpinenArraya(){
        Puntua[] erpinenArraya = {new Puntua(erpinBat.getX(),erpinBat.getY()),new Puntua(kontrakoErpina.getX(), erpinBat.getY()), new Puntua(kontrakoErpina.getX(), kontrakoErpina.getY()), new Puntua(erpinBat.getX(), kontrakoErpina.getY())};
        return erpinenArraya;
    }
    
    public ArrayList<Puntua> getLauErpinenArrayLista(){
        ArrayList<Puntua> erpinenLista = new ArrayList<>();
        erpinenLista.add(new Puntua(erpinBat.getX(), erpinBat.getY()));
        erpinenLista.add(new Puntua(kontrakoErpina.getX(), erpinBat.getY()));
        erpinenLista.add(new Puntua(kontrakoErpina.getX(), kontrakoErpina.getY()));
        erpinenLista.add(new Puntua(erpinBat.getX(), kontrakoErpina.getY()));
        return erpinenLista;
    }

    @Override
    public String toString() {
        return Arrays.toString(getLauErpinenArraya());
    }
    
    public boolean isInside(Puntua bestePuntua){
        if(bestePuntua.getX() > erpinBat.getX() && bestePuntua.getX() < kontrakoErpina.getX() && bestePuntua.getY() > erpinBat.getY() && bestePuntua.getY() < kontrakoErpina.getY()){
            return true;
        }
        return false;
    }

    
    public void marraztu() {
       
    }
    
    @Override
    public void marraztu(Graphics g) {
        int luzera = kontrakoErpina.getX() - erpinBat.getX();
        int altuera = kontrakoErpina.getY() - erpinBat.getY();
        g.drawRect(erpinBat.getX(), erpinBat.getY(), luzera, altuera);
        //g.drawString(erpinBat.toString(), erpinBat.getX(), erpinBat.getY()-5);
        //g.fillOval(erpinBat.getX(), erpinBat.getY(), 2, 2);
    }
    
}
