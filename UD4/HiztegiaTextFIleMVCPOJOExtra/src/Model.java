
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public void terminoakGorde(String areakoTestua) {
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            outputStream = new PrintWriter(new FileWriter("gordetakoTerminoak.txt"));
            outputStream.print(areakoTestua);
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
