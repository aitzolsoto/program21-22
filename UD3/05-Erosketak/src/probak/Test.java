/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probak;

import model.Erosketa;
import model.Pertsona;

/**
 *
 * @author soto.aitzol
 */
public class Test {
    public static void main(String[] args) {
        Erosketa erosketa4 = new Erosketa("E21-01", new Pertsona(1, "Karlos", "Arguiñano", "Hondartza pasialekua z/g ZARAUTZ", "kargi@zarautz.es"), 2000);
        System.out.println(erosketa4.toString());
    }
}
