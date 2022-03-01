/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Arrays;

/**
 *
 * @author soto.aitzol
 */
public class Kutxa extends Laukizuzena{
    private int altuera;
    
    public Kutxa(Puntua erpina, Puntua kontrakoErpina, int altuera){
        super(erpina,kontrakoErpina);
        this.altuera = altuera;
    }

    public int getAltuera() {
        return altuera;
    }

    @Override
    public String toString() {
        return "Kutxa{" + "altuera=" + altuera + '}';
    }
    
    public boolean isHandiagoa(Kutxa besteKutxaBat){
        int bolumenaBat = ((this.getKontrakoErpina().getX() - this.getErpinBat().getX()) * (this.getKontrakoErpina().getY() - this.getErpinBat().getY()) * altuera);
        int besteKutxarenBolumena = ((besteKutxaBat.getKontrakoErpina().getX() - besteKutxaBat.getErpinBat().getX()) * (besteKutxaBat.getKontrakoErpina().getY() - besteKutxaBat.getErpinBat().getY()) * besteKutxaBat.getAltuera());
        if(bolumenaBat > besteKutxarenBolumena){
            return true;
        }
        return false;
    }
    
    @Override
    public void marraztu(){
        System.out.println("Oinarria: " + super.toString() + " eta altuera:" + altuera + " dituen kutxa GUI baten marraztua izan da.");
    }
}
