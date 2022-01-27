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
public class Partida {
    private LocalDate data;
    private String aurkaria;
    private ArrayList<Futbolista> txarterlak;
    
    public Partida(LocalDate data, String aurkaria, ArrayList<Futbolista> txartelak){
        this.data = data;
        this.aurkaria = aurkaria;
        this.txarterlak = txartelak;
    }

    public LocalDate getData() {
        return data;
    }

    public String getAurkaria() {
        return aurkaria;
    }

    public ArrayList<Futbolista> getTxarterlak() {
        return txarterlak;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setAurkaria(String aurkaria) {
        this.aurkaria = aurkaria;
    }

    public void setTxarterlak(ArrayList<Futbolista> txarterlak) {
        this.txarterlak = txarterlak;
    }
    
    public void txartelaJarri(Futbolista f){
        txarterlak.add(f);
        System.out.println("Txartela duen futbolaria: " + f);
    }
}
