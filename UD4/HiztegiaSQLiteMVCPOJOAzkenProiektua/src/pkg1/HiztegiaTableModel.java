/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg1;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author soto.aitzol
 */
public class HiztegiaTableModel extends AbstractTableModel{
    private final String[] zutabeIzenak = {"ID", "EUSKARAZ", "GAZTELERAZ"};
    ArrayList<Terminoa> terminoak = new ArrayList();
    
    public HiztegiaTableModel(ArrayList<Terminoa> employees){
        this.terminoak = employees;
    }
    @Override
    public int getRowCount() {
        return terminoak.size();
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return zutabeIzenak[columnIndex];
    }

    @Override
    public int getColumnCount() {
        return zutabeIzenak.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0){
            return terminoak.get(rowIndex).getId();
        }else if (columnIndex == 1){
            return terminoak.get(rowIndex).getEuskaraz();
        }else if (columnIndex == 2){
            return terminoak.get(rowIndex).getGazteleraz();
        }
        return null;
    }
}
