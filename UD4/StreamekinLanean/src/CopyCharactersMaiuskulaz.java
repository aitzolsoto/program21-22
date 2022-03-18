/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author soto.aitzol
 */
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharactersMaiuskulaz {

    public static void main(String[] args) throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("xanadu.txt");
            outputStream = new FileWriter("letraOrdezkatuz.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                if (c >= 97 && c <= 122) {
                    System.out.println(c);
                    int letraMaiuskulaz = c - 32;
                    outputStream.write(letraMaiuskulaz);
                } else {
                    outputStream.write(c);
                }

            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
