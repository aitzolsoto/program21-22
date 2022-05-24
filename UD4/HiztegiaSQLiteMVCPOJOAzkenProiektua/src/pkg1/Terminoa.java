/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

import java.util.Objects;


public class Terminoa {
    private int id;
    private String euskaraz;
    private String gazteleraz;

    public Terminoa(int id, String euskaraz, String gazteleraz) {
        this.id = id;
        this.euskaraz = euskaraz;
        this.gazteleraz = gazteleraz;
    }

    public int getId() {
        return id;
    }

    public String getEuskaraz() {
        return euskaraz;
    }

    public String getGazteleraz() {
        return gazteleraz;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEuskaraz(String euskaraz) {
        this.euskaraz = euskaraz;
    }

    public void setGazteleraz(String gazteleraz) {
        this.gazteleraz = gazteleraz;
    }

    @Override
    public String toString() {
        return String.format("%3d  %-30s%-30s",id, euskaraz, gazteleraz);
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Terminoa other = (Terminoa) obj;
        if (!Objects.equals(this.euskaraz, other.euskaraz)) {
            return false;
        }
        if (!Objects.equals(this.gazteleraz, other.gazteleraz)) {
            return false;
        }
        return true;
    }
    
    
    
}
