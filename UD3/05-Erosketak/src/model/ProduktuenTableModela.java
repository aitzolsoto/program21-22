/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author soto.aitzol
 */
public class ProduktuenTableModela {
    JFrame jframe;
    public ProduktuenTableModela(){
        jframe = new JFrame();
        JLabel izenburua = new JLabel();
        izenburua.setBounds(5, 150, 100, 30);
        izenburua.setText("PRODUKTUAK");
        String[][] produktuak = {{"J01","Ogia","1.5"},{"J02","Esnea","1.05"},{"J03","Madalenak","2.25"},{"J04","Mermelada","3.0"}};
        String[] zutabeak = {"A","B","C"};
        JTable produktuenTaula = new JTable(produktuak, zutabeak);
        produktuenTaula.setLocation(30, 150);
        JScrollPane scrollPane = new JScrollPane(produktuenTaula);
        jframe.add(izenburua);
        jframe.add(scrollPane);
        jframe.setSize(500, 400);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new ProduktuenTableModela();
    }
}
