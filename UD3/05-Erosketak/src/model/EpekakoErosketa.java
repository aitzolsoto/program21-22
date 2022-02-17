/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author soto.aitzol
 */
public class EpekakoErosketa extends Erosketa{
    private int epeak = 12;
    private boolean ordainketaBukatua = false;
    private double kuota;
    
    public EpekakoErosketa(String kodea,String data, Bezeroa eroslea,ArrayList<Produktua>produktuak,ArrayList<Integer>unitateak,double guztira,double kuota){
        super(kodea,data, eroslea,produktuak,unitateak, guztira);
        this.kuota = kuota;
    }
    
    public EpekakoErosketa(String kodea,String data, Bezeroa eroslea,ArrayList<Produktua>produktuak,ArrayList<Integer>unitateak){
        super(kodea,data, eroslea,produktuak,unitateak);
        this.kuota = (guztiraKalkulatu(produktuak, unitateak)/12)*1.1;
    }
    
    public double gainetikOrdainduBeharrekoa(){
        return kuota * epeak - guztira;
    }

    public double getKuota() {
        return kuota;
    }

    public void setKuota(double kuota) {
        this.kuota = kuota;
    }
    
    
}
