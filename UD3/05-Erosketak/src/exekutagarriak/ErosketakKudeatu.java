/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exekutagarriak;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Bezeroa;
import model.Enpresa;
import model.EpekakoErosketa;
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
        try {
            while ((aukera = menuNagusiaErakutsi()) != 20) {
                try {
                    switch (aukera) {
                        case 1:
                            create();
                            break;
                        case 2:
                            read();
                            break;
                        case 3:
                            update();
                            break;
                        case 4:
                            delete();
                            break;
                        default:
                            System.out.println("Zenbaki okerra");
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Errorea: " + e);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Errorea: " + e);
                } catch (Exception e) {
                    System.out.println("Errorea: " + e);
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Errorea: " + e);
        }
    }

    public static int menuNagusiaErakutsi() throws InputMismatchException {
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

    public static int readMenuaErakutsi() {
        System.out.println("**************************");
        System.out.println("* READ MENUA");
        System.out.println("*---------------------");
        System.out.println("*1. Erosketen zerrenda");
        System.out.println("*2. Fakturazio osoa");
        System.out.println("*3. Bezerorik onena");
        System.out.println("*4. Helbidea bilatu");
        System.out.println("*5. Epekako erosketen txostena");
        System.out.println("*20. Menu nagusira itzuli");
        System.out.println("* -------------------");
        System.out.print("*Aukeratu zenbaki bat: ");
        return in.nextInt();
    }

    public static void create() throws IndexOutOfBoundsException, NumberFormatException {
        ArrayList<Produktua> erosketakoProduktuak = new ArrayList<>();
        ArrayList<Integer> erosketakoUnitateak = new ArrayList<>();
        char produktuenAukera = 'B';
        char epekakoErosketaDa;

        System.out.print("Sartu erosketa kodea: ");
        String kodea = in.next();
        System.out.print("Sartu bezero kodea: ");
        String bezeroKodea = in.next();
        while (produktuenAukera != 'E') {
            System.out.print("Produktu berri bat gehitu nahi duzu(B/E)? ");
            produktuenAukera = in.next().toUpperCase().charAt(0);
            if (produktuenAukera == 'B') {
                System.out.print("Sartu produktu zenbakia: ");
                erosketakoProduktuak.add(produktuKatalogoa.get(Integer.parseInt(in.next()) - 1));
                System.out.print("Sartu produktuaren unitateak: ");
                erosketakoUnitateak.add(Integer.parseInt(in.next()));
            }
        }
        System.out.print("Epekako erosketa da(B/E)? ");
        epekakoErosketaDa = in.next().toUpperCase().charAt(0);

        if (epekakoErosketaDa == 'B') {
            erosketenZerrenda.add(new EpekakoErosketa(kodea, LocalDate.now().toString(), kontaktuak.get(Integer.parseInt(bezeroKodea) - 1), erosketakoProduktuak, erosketakoUnitateak));
        } else if (epekakoErosketaDa == 'E' && erosketakoProduktuak != null) {
            erosketenZerrenda.add(new Erosketa(kodea, LocalDate.now().toString(), kontaktuak.get(Integer.parseInt(bezeroKodea) - 1), erosketakoProduktuak, erosketakoUnitateak));
        } else {
            erosketenZerrenda.add(new Erosketa(kodea, LocalDate.now().toString(), kontaktuak.get(Integer.parseInt(bezeroKodea) - 1), erosketakoProduktuak, erosketakoUnitateak, 0));
        }
    }

    public static void read() {
        int readAukera;
        while ((readAukera = readMenuaErakutsi()) != 20) {
            switch (readAukera) {
                case 1:
                    erosketenZerrenda();
                    break;
                case 2:
                    System.out.println("Fakturazio osoa: " + fakturazioOsoa());
                    break;
                case 3:
                    System.out.println("Bezerorik onena: " + bezerorikOnena().toString());
                    break;
                case 4:
                    helbideaBilatu();
                    break;
                case 5:
                    epekakoErosketenTxostena();
                    break;
                default:
                    System.out.println("");
                    break;
            }
        }
    }

    public static void update() {
        int erosketaZenbakia;
        char aukera;
        System.out.print("Sartu erosketa zenbakia: ");
        erosketaZenbakia = in.nextInt();
        if (erosketenZerrenda.get(erosketaZenbakia - 1) != null) {
            System.out.print("Erosketaren bezeroa aldatu nahi duzu(B/E)?");
            aukera = in.next().toUpperCase().charAt(0);
            if (aukera == 'B') {
                System.out.print("Sartu bezero berriaren kodea: ");
                int bezeroBerria = Integer.parseInt(in.next());
                erosketenZerrenda.get(erosketaZenbakia - 1).setBezeroa(kontaktuak.get(bezeroBerria - 1));
            }
        } else {
            System.out.println("Ez da erosketarik existitzen zenbaki horrekin");
        }
    }

    public static void delete() {
        int erosketaZenbakia;
        System.out.print("Sartu erosketa zenbakia: ");
        erosketaZenbakia = in.nextInt();
        if (erosketenZerrenda.get(erosketaZenbakia - 1) != null) {
            erosketenZerrenda.remove(erosketaZenbakia - 1);
        } else {
            System.out.println("Ez da erosketarik existitzen zenbaki horrekin");
        }
    }

    public static void helbideaBilatu() {
        String bezeroarenAbizena;
        System.out.print("Sartu bezeroaren abizena helbidea ikusteko: ");
        bezeroarenAbizena = in.next();

        for (int i = 0; i < kontaktuak.size(); i++) {
            Bezeroa konprobatzekoBezeroa = kontaktuak.get(i);
            if (konprobatzekoBezeroa instanceof Pertsona) {
                Pertsona p1 = (Pertsona) konprobatzekoBezeroa;
                if (p1.getAbizena().toLowerCase().equals(bezeroarenAbizena.toLowerCase())) {
                    System.out.println("Bezeroaren abizena: " + p1.getAbizena() + ",bezeroaren helbidea: " + p1.getHelbidea());
                }
            }
        }
    }

    public static double fakturazioOsoa() {
        double fakturazioa = 0;
        if (erosketenZerrenda != null) {
            for (int i = 0; i < erosketenZerrenda.size(); i++) {
                fakturazioa += erosketenZerrenda.get(i).getGuztira();
            }
        }
        return fakturazioa;
    }

    public static Bezeroa bezerorikOnena() {
        Bezeroa bezerorikOnena = null;
        Bezeroa konprobatzekoBezeroa = null;
        double bezeroarenGastua = 0;
        double gastuAltuena = 0;
        for (int i = 0; i < kontaktuak.size(); i++) {
            konprobatzekoBezeroa = kontaktuak.get(i);
            bezeroarenGastua = 0;
            for (int j = 0; j < erosketenZerrenda.size(); j++) {
                if (konprobatzekoBezeroa.getKodea() == erosketenZerrenda.get(j).getBezeroa().getKodea()) {
                    bezeroarenGastua += erosketenZerrenda.get(j).getGuztira();
                }
            }
            if (bezeroarenGastua > gastuAltuena) {
                bezerorikOnena = konprobatzekoBezeroa;
                gastuAltuena = bezeroarenGastua;
            }
        }

        return bezerorikOnena;
    }

    public static void epekakoErosketenTxostena() {
        System.out.println("EPEKAKO EROSKETAK");
        System.out.println("--------------------");
        System.out.printf("\n%15s %15s %15s %15s %15s %15s %15s %15s", "KODEA", "DATA", "IZENA", "GUZTIRA-ES", "EPEAK", "KUOTA", "GUZTIRA-EP", "ORDAINDUTA");
        for (int i = 0; i < erosketenZerrenda.size(); i++) {
            Erosketa konprobatzekoErosketa = erosketenZerrenda.get(i);
            if (konprobatzekoErosketa instanceof EpekakoErosketa) {
                System.out.printf("\n%15d %15s %15s %15.2f %15s %15.2f %15.2f %15s", konprobatzekoErosketa.getBezeroa().getKodea(), konprobatzekoErosketa.getData(), konprobatzekoErosketa.getBezeroa().getIzena(), konprobatzekoErosketa.getGuztira(), "12", ((EpekakoErosketa) konprobatzekoErosketa).getKuota(), konprobatzekoErosketa.getGuztira() + ((EpekakoErosketa) konprobatzekoErosketa).gainetikOrdainduBeharrekoa(), "BAI");
            }
        }
        System.out.print("\n");
    }

    public static void erosketenZerrenda() {
        for (int i = 0; i < erosketenZerrenda.size(); i++) {
            System.out.println(erosketenZerrenda.get(i).toString());
        }
    }

    public static void initialize() {
        kontaktuak.add(new Pertsona(1, "Karlos", "Arguinano", "Hondartza pasialekua z/g ZARAUTZ", "kargi@zarautz.es"));
        kontaktuak.add(new Pertsona(2, "Martin", "Berasategi", "Mirakontxa z/g DONOSTIA", "mbrea@donostia.es"));
        String[] emailak = {"idazkaria@uni.eus", "zuzendaria@uni.eus"};
        kontaktuak.add(new Enpresa(3, "Uni Eibar-Ermua", "Uni Eibar-Ermua", "Otaola Etorbidea 29.EIBAR", emailak));

        produktuKatalogoa.add(new Produktua("C01", "Toshiba Satelite Pro", 450));
        produktuKatalogoa.add(new Produktua("C02", "Hp Pavilion", 600));
        produktuKatalogoa.add(new Produktua("T01", "Samsung Galaxy", 1300));
        produktuKatalogoa.add(new Produktua("T02", "iPhone XX", 630));

        ArrayList<Produktua> produktuak = new ArrayList<>();
        ArrayList<Integer> unitateak = new ArrayList<>();

        //Erosketa 1
        produktuak.add(produktuKatalogoa.get(0));
        unitateak.add(4);
        produktuak.add(produktuKatalogoa.get(1));
        unitateak.add(2);
        produktuak.add(produktuKatalogoa.get(2));
        unitateak.add(3);
        erosketenZerrenda.add(new Erosketa("E18-01", "2018/09/25", kontaktuak.get(1), produktuak, unitateak, 3630));

        //Erosketa 2
        produktuak.removeAll(produktuak);
        unitateak.removeAll(unitateak);
        produktuak.add(produktuKatalogoa.get(0));
        unitateak.add(15);
        erosketenZerrenda.add(new Erosketa("E18-02", "2018/10/24", kontaktuak.get(0), produktuak, unitateak, 6750));

        //Erosketa 3
        produktuak.removeAll(produktuak);
        unitateak.removeAll(unitateak);
        produktuak.add(produktuKatalogoa.get(0));
        unitateak.add(1);
        produktuak.add(produktuKatalogoa.get(2));
        unitateak.add(1);
        erosketenZerrenda.add(new Erosketa("E19-01", "2019/01/09", kontaktuak.get(0), produktuak, unitateak, 660));

        //Erosketa 4
        produktuak.removeAll(produktuak);
        unitateak.removeAll(unitateak);
        produktuak.add(produktuKatalogoa.get(0));
        unitateak.add(3);
        produktuak.add(produktuKatalogoa.get(1));
        unitateak.add(1);
        produktuak.add(produktuKatalogoa.get(3));
        unitateak.add(1);
        erosketenZerrenda.add(new EpekakoErosketa("E19-02", "2019/02/09", kontaktuak.get(0), produktuak, unitateak, 3250, 300));

        //Erosketa 5
        produktuak.removeAll(produktuak);
        unitateak.removeAll(unitateak);
        produktuak.add(produktuKatalogoa.get(1));
        unitateak.add(25);
        erosketenZerrenda.add(new Erosketa("E21-01", "2020/01/17", kontaktuak.get(2), produktuak, unitateak, 15000));
    }
}
