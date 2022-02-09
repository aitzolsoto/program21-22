/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probak;

import model.Erosketa;

/**
 *
 * @author soto.aitzol
 */
public class TestErosketak {
    public static void main(String[] args) {
        Erosketa erosketa1 = new Erosketa("E18-01", null, 450);
        System.out.println(erosketa1.getKodea());
        System.out.println(erosketa1.toStringLuzea());
    }
}
