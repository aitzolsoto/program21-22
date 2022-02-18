/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author soto.aitzol
 */
public class ProduktuenTableModela extends AbstractTableModel {

    private final String[] zutabeIzenak = {"Kodea", "Izena", "Prezioa"};
    ArrayList<Produktua> data = new ArrayList();

    public ProduktuenTableModela() {
        data.add(new Produktua("J01","Ogia",1.5));
        data.add(new Produktua("J02","Esnea",1.05));
        data.add(new Produktua("J03","Madalenak",2.25));
        data.add(new Produktua("J04","Mermelada",3.0));
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return zutabeIzenak.length;
    }
    
    //Escribe los valores de manera especifica dependiendo de que tipo sean Boolean, double...
    @Override
    public Class getColumnClass(int columnIndex){
        return getValueAt(0, columnIndex).getClass();
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return zutabeIzenak[columnIndex];
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        if(columnIndex == 2){
            return true;
        }
        return false;
    }
    
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
    
    
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0){
            return data.get(rowIndex).getKodeaStr();
        }else if (columnIndex == 1){
            return data.get(rowIndex).getIzena();
        }else if (columnIndex == 2){
            return data.get(rowIndex).getPrezioa();
        }
        return null;
    }

}
