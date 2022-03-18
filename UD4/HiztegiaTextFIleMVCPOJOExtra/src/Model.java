
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author soto.aitzol
 */
public class Model {

    public static ArrayList<Terminoa> terminoakJaso() {
        ArrayList<Terminoa> jasotakoTerminoak = new ArrayList<>();
        String[] terminoaSplit = new String[3];
        Terminoa t1 = new Terminoa();
        BufferedReader inputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("terminoak.txt"));

            String l;
            while ((l = inputStream.readLine()) != null) {
                terminoaSplit = l.split(",");
                t1 = new Terminoa(Integer.parseInt(terminoaSplit[0]), terminoaSplit[1], terminoaSplit[2]);
                jasotakoTerminoak.add(t1);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return jasotakoTerminoak;
    }
    
    public void taularaGehitu(JTable taula,String euskaraz, String gazteleraz){
        int lerroKopurua = taula.getRowCount();
        Terminoa t1 = new Terminoa(lerroKopurua+1,euskaraz,gazteleraz);
        for (int i = 0; i < taula.getColumnCount(); i++) {
            if(i == 0){
                taula.setValueAt(t1.getId(), lerroKopurua+1, i);
            }else if(i == 1){
                taula.setValueAt(t1.getEuskaraz(), lerroKopurua+1, i);
            }else if(i == 2){
                taula.setValueAt(t1.getGazteleraz(), lerroKopurua+1, i);
            }
        }
    }

    public void taulakoaGorde(JTable taula) {
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;
        Terminoa t1 = new Terminoa();
        int id = 0;
        String euskaraz = "";
        String gazteleraz = "";

        try {
            outputStream = new PrintWriter(new FileWriter("gordetakoTaulakoTerminoak.txt"));
            for (int i = 0; i < taula.getRowCount(); i++) {
                for (int j = 0; j < taula.getColumnCount(); j++) {
                    if (j == 0) {
                        id = Integer.parseInt(taula.getValueAt(i, j).toString());
                    } else if (j == 1) {
                        euskaraz = taula.getValueAt(i, j).toString();
                    } else if (j == 2) {
                        gazteleraz = taula.getValueAt(i, j).toString();
                    }
                }
                t1 = new Terminoa(id, euskaraz, gazteleraz);
                outputStream.println(t1);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    
}
