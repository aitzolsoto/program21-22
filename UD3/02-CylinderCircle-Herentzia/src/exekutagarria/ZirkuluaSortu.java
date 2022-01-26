/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exekutagarria;

import java.util.Scanner;
import model.Circle;
import model.Cylinder;

/**
 *
 * @author soto.aitzol
 */
public class ZirkuluaSortu {

    private Scanner in = new Scanner(System.in);
    private double radius;
    private String color;
    private double height;
    
    public ZirkuluaSortu(){
        formaAukeratu();
    }
    
    private void formaAukeratu(){
        System.out.print("Zirkulu arrunta edo zilindroa sortu nahi duzu(a/z)? ");
        char c = in.nextLine().charAt(0);
        if(c == 'a'){
            zirkuluArruntaSortu();
        }else if(c == 'z'){
            zilindroaSortu();
        }else{
            System.out.println("Karaktere horrek ez du balio");
        }
    }

    private void zirkuluArruntaSortu() {
        System.out.print("Zein izango da bere erradioa? ");
        radius = in.nextDouble();
        in.nextLine();
        System.out.print("Zein izango da bere kolorea? ");
        color = in.nextLine();
        Circle c1 = new Circle(radius, color);
        System.out.println("Hauek dira sortutako zirkuluaren ezaugarriak: ");
        System.out.println("Erradioa: " + c1.getRadius());
        System.out.println("Kolorea: " + c1.getColor());
        System.out.printf("Azalera: %.2f \n", c1.getArea());
    }

    private void zilindroaSortu() {
        System.out.print("Zein izango da bere erradioa? ");
        radius = in.nextDouble();
        in.nextLine();
        System.out.print("Zein izango da bere kolorea? ");
        color = in.nextLine();
        System.out.print("Zein izango da bere altuera? ");
        height = in.nextDouble();
        Cylinder cy1 = new Cylinder(height, radius, color);
        System.out.println("Hauek dira sortutako zirkuluaren ezaugarriak: ");
        System.out.println("Erradioa: " + cy1.getRadius());
        System.out.println("Kolorea: " + cy1.getColor());
        System.out.println("Altuera: " + cy1.getHeight());
        System.out.printf("Azalera: %.2f \n", cy1.getArea());
        System.out.printf("Bolumena: %.2f \n", cy1.getVolume());
    }

    public static void main(String[] args) {
        new ZirkuluaSortu();
    }
}
