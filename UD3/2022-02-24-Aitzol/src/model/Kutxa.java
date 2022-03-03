/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
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
        return "Kutxa{" + "erpina = "+ getErpinBat() + ", kontrako erpina = "+ getKontrakoErpina() + ", altuera = " + altuera + ", bolumena = " + getBolumena() + '}';
    }
    
    public boolean isHandiagoa(Kutxa besteKutxaBat){
        int bolumenaBat = ((this.getKontrakoErpina().getX() - this.getErpinBat().getX()) * (this.getKontrakoErpina().getY() - this.getErpinBat().getY()) * altuera);
        int besteKutxarenBolumena = ((besteKutxaBat.getKontrakoErpina().getX() - besteKutxaBat.getErpinBat().getX()) * (besteKutxaBat.getKontrakoErpina().getY() - besteKutxaBat.getErpinBat().getY()) * besteKutxaBat.getAltuera());
        if(bolumenaBat > besteKutxarenBolumena){
            return true;
        }
        return false;
    }
    
    public int getBolumena(){
        return ((this.getKontrakoErpina().getX() - this.getErpinBat().getX()) * (this.getKontrakoErpina().getY() - this.getErpinBat().getY()) * altuera);
    }
    
    public int[] getErtzenLuzera(){
        int ertza1 = this.getKontrakoErpina().getX() - this.getErpinBat().getX();
        int ertza2 = this.getKontrakoErpina().getY() - this.getErpinBat().getY();
        int[] ertzak = {ertza1,ertza2};
        return ertzak;
    }
    
    public static Kutxa handiena(Kutxa[] kutxaSorta){
        Kutxa kutxaHandiena = kutxaSorta[0];
        for (int i = 0; i < kutxaSorta.length; i++) {
            if(kutxaHandiena.getBolumena() < kutxaSorta[i].getBolumena()){
                kutxaHandiena = kutxaSorta[i];
            }
        }
        return kutxaHandiena;
    }
    
    public static void kutxenArrayaOrdenatu(ArrayList<Kutxa> kutxaSorta){
        Kutxa temp;
        for (int i = 0; i < kutxaSorta.size(); i++) {
            for (int j = 0; j < kutxaSorta.size()-1; j++) {
                if(kutxaSorta.get(j) != null && kutxaSorta.get(j+1) != null && (kutxaSorta.get(j).getBolumena() > kutxaSorta.get(j+1).getBolumena())){
                    temp = kutxaSorta.get(j+1);
                    kutxaSorta.set(j+1, kutxaSorta.get(j));
                    kutxaSorta.set(j,temp);
                }
            }
        }
    }
    
    @Override
    public void marraztu(){
        System.out.println("Oinarria: " + super.toString() + " eta altuera:" + altuera + " dituen kutxa GUI baten marraztua izan da.");
    }
    
    @Override
    public void marraztu(Graphics g){
        g.setColor(Color.black);
        //Beheko laukia
        g.drawLine(super.getErpinBat().getX(), super.getErpinBat().getY(), super.getKontrakoErpina().getX(), super.getErpinBat().getY());
        g.drawLine(super.getKontrakoErpina().getX(), super.getErpinBat().getY(), super.getKontrakoErpina().getX()+15, super.getKontrakoErpina().getY());
        g.drawLine(super.getKontrakoErpina().getX()+15, super.getKontrakoErpina().getY(), super.getErpinBat().getX()+15, super.getKontrakoErpina().getY());
        g.drawLine(super.getErpinBat().getX()+15, super.getKontrakoErpina().getY(), super.getErpinBat().getX(), super.getErpinBat().getY());
        //Altuera
        g.drawLine(super.getErpinBat().getX(), super.getErpinBat().getY(),super.getErpinBat().getX(),super.getErpinBat().getY()-(altuera*10));
        g.drawLine(super.getKontrakoErpina().getX(), super.getErpinBat().getY(),super.getKontrakoErpina().getX(),super.getErpinBat().getY()-(altuera*10));
        g.drawLine(super.getKontrakoErpina().getX()+15, super.getKontrakoErpina().getY(),super.getKontrakoErpina().getX()+15,super.getKontrakoErpina().getY()-(altuera*10));
        g.drawLine(super.getErpinBat().getX()+15, super.getKontrakoErpina().getY(),super.getErpinBat().getX()+15,super.getKontrakoErpina().getY()-(altuera*10));
        //Goiko laukia
        g.drawLine(super.getErpinBat().getX(), super.getErpinBat().getY()-(altuera*10), super.getKontrakoErpina().getX(), super.getErpinBat().getY()-(altuera*10));
        g.drawLine(super.getKontrakoErpina().getX(), super.getErpinBat().getY()-(altuera*10), super.getKontrakoErpina().getX()+15, super.getKontrakoErpina().getY()-(altuera*10));
        g.drawLine(super.getKontrakoErpina().getX()+15, super.getKontrakoErpina().getY()-(altuera*10), super.getErpinBat().getX()+15, super.getKontrakoErpina().getY()-(altuera*10));
        g.drawLine(super.getErpinBat().getX()+15, super.getKontrakoErpina().getY()-(altuera*10), super.getErpinBat().getX(), super.getErpinBat().getY()-(altuera*10));
    }
}
    
   