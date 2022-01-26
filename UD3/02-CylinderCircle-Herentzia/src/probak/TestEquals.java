/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probak;

import model.Circle;

/**
 *
 * @author soto.aitzol
 */
public class TestEquals {
    public static void main(String[] args) {
        Circle c1 = new Circle(2, "gorria");
        Circle c2 = new Circle(2, "gorria");
        if(c1.equals(c2)){
            System.out.println("Bai");
        }else{
            System.out.println("Ez");
        }
    }
}
