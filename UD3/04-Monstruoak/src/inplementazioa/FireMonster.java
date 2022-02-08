/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inplementazioa;





public class FireMonster implements Monstruosoa {
   
    String name;
    public FireMonster(String name){
        this.name = name;
    }

    @Override
    public String attack() {
       return "Attack with fire";
    }
   
}
