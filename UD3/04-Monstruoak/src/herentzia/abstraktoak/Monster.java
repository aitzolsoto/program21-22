/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herentzia.abstraktoak;

/**
 * The abstract superclass Monster defines the expected common behaviors,
 *   via abstract methods.
 */
abstract public class Monster {
   private String name;  // private instance variable

   /** Constructs a Monster instance of the given name */
   public Monster(String name) {
      this.name = name;
   }

   /** Define common behavior for all its subclasses */
   abstract public String attack();
}