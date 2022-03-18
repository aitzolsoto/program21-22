
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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

    public String terminoakJaso() throws IOException {
        String jasotakoTerminoak = "";
        String[] terminoaSplit = new String[3];
        Terminoa t1 = new Terminoa();
        BufferedReader inputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("terminoak.txt"));

            String l;
            while ((l = inputStream.readLine()) != null) {
                terminoaSplit = l.split(",");
                t1 = new Terminoa(Integer.parseInt(terminoaSplit[0]), terminoaSplit[1], terminoaSplit[2]);
                if (jasotakoTerminoak.equals("")) {
                    jasotakoTerminoak = t1.toString();
                } else {
                    jasotakoTerminoak = jasotakoTerminoak + "\n" + t1.toString();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (inputStream != null) {
                inputStream.close();
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
