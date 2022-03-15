/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

/**
 *
 * @author soto.aitzol
 */
public class Terminoa {
    private int id;
    private String euskaraz;
    private String gazteleraz;
    
    public Terminoa(String euskaraz,String gazteleraz){
        this.id = 0;
        this.euskaraz = euskaraz;
        this.gazteleraz = gazteleraz;
    }
    
    public Terminoa(int id, String euskaraz,String gazteleraz){
        this.id = id;
        this.euskaraz = euskaraz;
        this.gazteleraz = gazteleraz;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getEuskaraz() {
        return euskaraz;
    }

    public String getGazteleraz() {
        return gazteleraz;
    }

    public void setEuskaraz(String euskaraz) {
        this.euskaraz = euskaraz;
    }

    public void setGazteleraz(String gazteleraz) {
        this.gazteleraz = gazteleraz;
    }

    @Override
    public String toString() {
        return "Terminoa{" + "euskaraz=" + euskaraz + ", gazteleraz=" + gazteleraz + '}';
    }
    
    
}
