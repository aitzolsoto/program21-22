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
public class Komikia extends Book{
    private boolean kolorea;
    public Komikia(String name, Author author,double price,int pages,boolean kolorea){
        super(name, author, price, pages);
        this.kolorea = kolorea;
    }
    
    public boolean isKolorea(){
        return kolorea;
    }

    public void setKolorea(boolean kolorea) {
        this.kolorea = kolorea;
    }
    
    @Override
    public String getNolakoa(){
        if(kolorea){
            return "koloretakoa";
        }else{
            return "zuri-beltza";
        }
    }
    
    public String toString() {
        return "[Komikia] " + super.getName() + ", " + super.getAuthor().getName() + ", " + super.getPrice() + ", " + super.getPages();
    }
}
