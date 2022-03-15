/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author soto.aitzol
 */
public class TerminoenTableModela extends AbstractTableModel{
    private final String[] zutabeIzenak = {"ID", "EUSKARAZ", "GAZTELERAZ"};
    ArrayList<Terminoa> terminoak = new ArrayList();
    
    public TerminoenTableModela(){
        this.terminoak = null;
    }
    @Override
    public int getRowCount() {
        return terminoak.size();
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
