/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pkg1.Model;
import pkg1.View;

public class Controller implements ActionListener {

    private Model model;
    private View view;
    private int bizitzak;
    private int puntuazioa;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        gehituActionListener(this);

    }

    private void gehituActionListener(ActionListener listener) {
        //GUIaren konponente guztiei gehitu listenerra
        view.jButtonHitzaGehituDialog.addActionListener(listener);
        view.jButtonHitzaAsmatuDialog.addActionListener(listener);
        view.jButtonHitzaSartu.addActionListener(listener);
        view.jButtonHitzBerriaGehitu.addActionListener(listener);
        view.jButtonHasiBerriro.addActionListener(listener);
        view.jButtonItzultzaileaDialog.addActionListener(listener);
        view.jButtonItzultzailea.addActionListener(listener);
        view.jButtonItzultzaileaEzabatu.addActionListener(listener);
        view.jButtonTerminoaEzabatu.addActionListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        //listenerrak entzun dezakeen eragiketa bakoitzeko. Konponenteek 'actionCommad' propietatea daukate
        switch (actionCommand) {
            case "HIZTEGIA":
                view.jDialogGehitu.setSize(657, 367);
                view.jDialogGehitu.setVisible(true);
                view.jDialogGehitu.setResizable(false);
                view.jTableTerminoenTaula.setModel(new HiztegiaTableModel(model.terminoakTaulara()));
                break;
            case "TXERTATU":
                Terminoa t = new Terminoa(3, view.jTextFieldGehituEuskaraz.getText().toUpperCase(), view.jTextFieldGehituGazteleraz.getText().toUpperCase());
                if (view.jTextFieldGehituEuskaraz.getText().isEmpty() || view.jTextFieldGehituGazteleraz.getText().isEmpty()) {
                    System.out.println("Hitza falta da");
                    view.jOptionPaneMezua.showMessageDialog(null, "Hitza falta da");
                } else if (model.terminoaErrepikatuta(t.getEuskaraz(), t.getGazteleraz())) {
                    System.out.println("Hitza errepikatuta dago");
                    view.jOptionPaneMezua.showMessageDialog(null, "Hitza errepikatuta dago");
                } else {
                    System.out.println("Ez dago errepikatuta");
                    model.terminoaGehitu(t);
                    view.jTableTerminoenTaula.setModel(new HiztegiaTableModel(model.terminoakTaulara()));
                }
                view.jTextFieldGehituEuskaraz.setText("");
                view.jTextFieldGehituGazteleraz.setText("");
                break;
            case "INPRIMATU":
                System.out.println("INPRIMATU botoia sakatu duzu");
                model.terminoakInprimatu();
                break;
            case "HITZA ASMATU":
                view.jDialogJolasa.setSize(470, 335);
                view.jDialogJolasa.setResizable(false);
                view.jDialogJolasa.setVisible(true);
                view.jLabelAsmatzekoHitza.setText(model.hitzaErakutsi());
                view.jLabelGaldu.setVisible(false);
                view.jButtonHasiBerriro.setVisible(false);
                bizitzak = 3;
                puntuazioa = 0;
                view.jLabelBizitzak.setText(String.valueOf(bizitzak));
                view.jTextFieldSartutakoHitza.setEnabled(true);
                view.jButtonHitzaSartu.setEnabled(true);
                break;
            case "SARTU":
                if (!view.jTextFieldSartutakoHitza.getText().equals("") && bizitzak > 0 && model.hitzaKonprobatu(view.jLabelAsmatzekoHitza.getText(), view.jTextFieldSartutakoHitza.getText())) {
                    System.out.println("Asmatu duzu");
                    view.jTextFieldSartutakoHitza.setText("");
                    view.jLabelAsmatzekoHitza.setText(model.hitzaErakutsi());
                    puntuazioa = Integer.parseInt(view.jLabelPuntuazioZenbakia.getText());
                    puntuazioa += 1;
                    view.jLabelPuntuazioZenbakia.setText(String.valueOf(puntuazioa));
                } else if (!view.jTextFieldSartutakoHitza.getText().equals("") && bizitzak > 1 && !model.hitzaKonprobatu(view.jLabelAsmatzekoHitza.getText(), view.jTextFieldSartutakoHitza.getText())) {
                    System.out.println("Ez duzu asmatu");
                    view.jTextFieldSartutakoHitza.setText("");
                    bizitzak--;
                    view.jLabelBizitzak.setText(String.valueOf(bizitzak));
                } else if (!view.jTextFieldSartutakoHitza.getText().equals("") && bizitzak == 1 && !model.hitzaKonprobatu(view.jLabelAsmatzekoHitza.getText(), view.jTextFieldSartutakoHitza.getText())) {
                    System.out.println("Galdu egin duzu");
                    view.jTextFieldSartutakoHitza.setText("");
                    view.jTextFieldSartutakoHitza.setEnabled(false);
                    view.jButtonHitzaSartu.setEnabled(false);
                    bizitzak = 0;
                    view.jLabelBizitzak.setText(String.valueOf(bizitzak));
                    view.jLabelGaldu.setVisible(true);
                    view.jLabelGaldu.setText("Galdu egin duzu, lortutako puntuazioa: " + view.jLabelPuntuazioZenbakia.getText());
                    view.jButtonHasiBerriro.setVisible(true);
                } else if (view.jTextFieldSartutakoHitza.getText().equals("")) {
                    System.out.println("Hitz bat sartu behar duzu");
                }
                break;
            case "HASI BERRIRO":
                bizitzak = 3;
                puntuazioa = 0;
                view.jTextFieldSartutakoHitza.setEnabled(true);
                view.jButtonHitzaSartu.setEnabled(true);
                view.jLabelAsmatzekoHitza.setText(model.hitzaErakutsi());
                view.jLabelBizitzak.setText(String.valueOf(bizitzak));
                view.jLabelPuntuazioZenbakia.setText(String.valueOf(puntuazioa));
                view.jLabelGaldu.setVisible(false);
                view.jButtonHasiBerriro.setVisible(false);
                break;
            case "ITZULTZAILEA":
                view.jDialogItzultzailea.setSize(347, 300);
                view.jDialogItzultzailea.setVisible(true);
                view.jDialogItzultzailea.setResizable(false);
                break;
            case "ITZULI":
                if(view.jTextFieldItzuliEuskaraz.getText().isEmpty() && view.jTextFieldItzuliGazteleraz.getText().isEmpty()){
                    view.jOptionPaneMezua.showMessageDialog(null, "Hitz bat sartu behar duzu");
                }else if(model.terminoaItzuliGaztelerara(view.jTextFieldItzuliEuskaraz.getText()).isEmpty() && model.terminoaItzuliEuskerara(view.jTextFieldItzuliGazteleraz.getText()).isEmpty()){ 
                    view.jOptionPaneMezua.showMessageDialog(null, "Ez da hitza aurkitu");
                }else if(!view.jTextFieldItzuliEuskaraz.getText().equals("") && view.jTextFieldItzuliGazteleraz.getText().equals("")){ //Hitza gaztelerara
                    view.jTextFieldItzuliGazteleraz.setText(model.terminoaItzuliGaztelerara(view.jTextFieldItzuliEuskaraz.getText()));         
                }else if (view.jTextFieldItzuliEuskaraz.getText().equals("") && !view.jTextFieldItzuliGazteleraz.getText().equals("")) { //Hitza euskerara
                    view.jTextFieldItzuliEuskaraz.setText(model.terminoaItzuliEuskerara(view.jTextFieldItzuliGazteleraz.getText()));
                    System.out.println(model.terminoaItzuliEuskerara(view.jTextFieldItzuliGazteleraz.getText()));
                }
                break;
            case "EZABATU":
                view.jTextFieldItzuliEuskaraz.setText("");
                view.jTextFieldItzuliGazteleraz.setText("");
                break;
            case "TERMINOA EZABATU":
                model.terminoaEzabatuTaulatik(view.jTableTerminoenTaula);
                view.jTableTerminoenTaula.setModel(new HiztegiaTableModel(model.terminoakTaulara()));
        }
    }
}
