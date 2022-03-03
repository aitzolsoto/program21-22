/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Graphics;

/**
 *
 * @author soto.aitzol
 */
public class Puntua implements Marrazgarria {
    private int x;
    private int y;
    private static int sortutakoPuntuak = 0;
    
    public Puntua(){
        x = 0;
        y = 0;
        sortutakoPuntuak++;
    }
    
    public Puntua(int x, int y){
        this.x = x;
        this.y = y;
        sortutakoPuntuak++;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static int getSortutakoPuntuak() {
        return sortutakoPuntuak;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public boolean isEzkerreragoThan(Puntua bestePuntuBat){
        if(x < bestePuntuBat.getX()){
            return true;
        }else{
            return false;
        }
    }
    
    public void mugitu(int zenbat, Norabidea norabidea){
        if(norabidea == Norabidea.EZK){ //Ezkerra
            x = x - zenbat;
        }else if(norabidea == Norabidea.ESK){ //Eskuma
            x = x + zenbat;
        }else if (norabidea == Norabidea.GORA){
            y = y + zenbat;
        }else if (norabidea == Norabidea.BEHERA){
            y = y - zenbat;
        }
    }

    @Override
    public String toString() {
        return "(" + "" + x + ", " + y + ')';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Puntua other = (Puntua) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }
    
    

    
    public void marraztu() {
        System.out.println(this + " puntua GUI baten marraztua izan da");
    }
    
    @Override
    public void marraztu(Graphics g) {
        g.drawString(this.toString(), x, y-5);
        g.fillOval(x, y, 5, 5);
    }
}
