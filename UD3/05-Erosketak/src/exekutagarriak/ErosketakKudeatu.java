/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exekutagarriak;

import java.util.ArrayList;
import java.util.Scanner;
import model.Bezeroa;
import model.Enpresa;
import model.Erosketa;
import model.Pertsona;
import model.Produktua;

/**
 *
 * @author soto.aitzol
 */
public class ErosketakKudeatu {
    private static ArrayList<Bezeroa> kontaktuak = new ArrayList();
    private static ArrayList<Produktua> produktuKatalogoa = new ArrayList();
    private static ArrayList<Erosketa> erosketenZerrenda = new ArrayList();
    
    private static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        initialize();
        int aukera;
        //while (aukera = menuNagusiaErakutsi) != 20
    }
    
    public static int menuNagusiaErakutsi(){
        System.out.println("**************************");
        System.out.println("* EROSKETEN KUDEAKETA");
        System.out.println("*---------------------");
        System.out.println("*1. Create (Datuak gehitu)");
        System.out.println("*2. Read (Ikusi)");
        System.out.println("*3. Update (Aldatu)");
        System.out.println("*4. Delete (Ezabatu)");
        System.out.println("*20. Irten");
        System.out.println("* -------------------");
        System.out.print("*Aukeratu zenbaki bat: ");
        return in.nextInt();
    }
    
    public static int readMenuaErakutsi(){
        System.out.println("**************************");
        System.out.println("* READ MENUA");
        System.out.println("*---------------------");
        System.out.println("*1. Erosketen zerrenda");
        System.out.println("*2. Fakturazio osoa");
        System.out.println("*3. Bezerorik onena");
        System.out.println("*4. Helbidea bilatu");
        System.out.println("*5. Epekako erosketen txostena");
        System.out.println("*5. Menu nagusira itzuli");
        System.out.println("* -------------------");
        System.out.print("*Aukeratu zenbaki bat: ");
        return in.nextInt();
    }
    
    public static void create(){
        System.out.print("Sartu erosketa kodea: ");
        String kodea = in.next();
        System.out.print("Sartu bezero kodea: ");
        String bezeroKodea = in.next();
        System.out.print("Guztira ordaindu beharrekoa: ");
        String guztira = in.next();
        System.out.print("Epekako erosketa da(B/E)? ");
        if(in.next().toUpperCase().charAt(0) == 'B'){
            
        }else{
            erosketenZerrenda.add(new Erosketa(kodea, kontaktuak.get(Integer.parseInt(kodea)), Double.parseDouble(guztira)));
        }
    }
    
    public static void read(){
        
    }
    
    public static void update(){
        
    }
    
    public static void delete(){
        System.out.print("Sartu erosketa zenbakia: ");
        erosketenZerrenda.remove(in.nextInt());
    }
    
    public static void erosketenZerrenda(){
        for (int i = 0; i < erosketenZerrenda.size(); i++) {
            System.out.println(erosketenZerrenda.get(i).toString());
        }
    }
    
    public static void initialize(){
        kontaktuak.add(new Pertsona(1, "Karlos", "Arguiñano", "Hondartza pasialekua z/g ZARAUTZ", "kargi@zarautz.es"));
        kontaktuak.add(new Pertsona(2, "Martin", "Berasategi", "Mirakontxa z/g DONOSTIA", "mbrea@donostia.es"));
        String[] emailak = {"idazkaria@uni.eus", "zuzendaria@uni.eus"};
        kontaktuak.add(new Enpresa(3, "Uni Eibar-Ermua", "Uni Eibar-Ermua", "Otaola Etorbidea 29.EIBAR", emailak));
        
        produktuKatalogoa.add(new Produktua("C01", "Toshiba Satelite Pro", 450));
        produktuKatalogoa.add(new Produktua("C02", "Hp Pavilion", 600));
        produktuKatalogoa.add(new Produktua("T01", "Samsung Galaxy", 1300));
        produktuKatalogoa.add(new Produktua("T02", "iPhone XX", 630));

    }
}
