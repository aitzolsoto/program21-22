/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herentzia.abstraktoak;



public class FireMonster extends Monster {
   /** Constructs a FireMonster with the given name */
   public FireMonster(String name) {
      super(name);
   }

    @Override
    public String attack() {
       return "Attack with fire";
    }
   
}
