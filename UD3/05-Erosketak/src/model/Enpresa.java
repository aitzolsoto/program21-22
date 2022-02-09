/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author soto.aitzol
 */
public class Enpresa implements Bezeroa{
    private int kodea;
    private String izenJuridikoa;
    private String izenKomertziala;
    private String helbidea;
    private String[] kontaktoenEmailak;

    @Override
    public int getKodea() {
        return kodea;
    }

    @Override
    public String getIzena() {
        return izenJuridikoa;
    }

    @Override
    public String getHelbidea() {
        return helbidea;
    }

    @Override
    public String getEmaila() {
        return "";
    }
}
