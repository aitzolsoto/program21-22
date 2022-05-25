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
        view.jButtonHiztegia.addActionListener(listener);
        view.jButtonItzultzailea.addActionListener(listener);
        view.jButtonItzultzaileaEzabatu.addActionListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        //listenerrak entzun dezakeen eragiketa bakoitzeko. Konponenteek 'actionCommad' propietatea daukate
        switch (actionCommand) {
            case "HITZA GEHITU":
                view.jDialogGehitu.setSize(431, 317);
                view.jDialogGehitu.setVisible(true);
                view.jDialogGehitu.setResizable(false);
                break;
            case "TXERTATU":
                Terminoa t = new Terminoa(3, view.jTextFieldGehituEuskaraz.getText().toUpperCase(), view.jTextFieldGehituGazteleraz.getText().toUpperCase());
                view.jTextFieldGehituEuskaraz.setText("");
                view.jTextFieldGehituGazteleraz.setText("");
                if(model.terminoaErrepikatuta(t.getEuskaraz(),t.getGazteleraz())){
                    System.out.println("Errepikatuta");
                }else{
                    System.out.println("Ez dago errepikatuta");
                    model.terminoaGehitu(t);
                }
                break;
            case "INPRIMATU":
                System.out.println("INPRIMATU botoia sakatu duzu");
                model.terminoakInprimatu();
                break;
            case "HITZA ASMATU":
                view.jDialogJolasa.setSize(470,335);
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
                if(!view.jTextFieldSartutakoHitza.getText().equals("") && bizitzak > 0 && model.hitzaKonprobatu(view.jLabelAsmatzekoHitza.getText(), view.jTextFieldSartutakoHitza.getText())){
                    System.out.println("Asmatu duzu");
                    view.jTextFieldSartutakoHitza.setText("");
                    view.jLabelAsmatzekoHitza.setText(model.hitzaErakutsi());
                    puntuazioa = Integer.parseInt(view.jLabelPuntuazioZenbakia.getText());
                    puntuazioa += 1;
                    view.jLabelPuntuazioZenbakia.setText(String.valueOf(puntuazioa));
                }else if(!view.jTextFieldSartutakoHitza.getText().equals("") && bizitzak > 1 && !model.hitzaKonprobatu(view.jLabelAsmatzekoHitza.getText(), view.jTextFieldSartutakoHitza.getText())){
                    System.out.println("Ez duzu asmatu");
                    view.jTextFieldSartutakoHitza.setText("");
                    bizitzak --;
                    view.jLabelBizitzak.setText(String.valueOf(bizitzak));
                }else if(!view.jTextFieldSartutakoHitza.getText().equals("") && bizitzak == 1 && !model.hitzaKonprobatu(view.jLabelAsmatzekoHitza.getText(), view.jTextFieldSartutakoHitza.getText())){
                    System.out.println("Galdu egin duzu");
                    view.jTextFieldSartutakoHitza.setText("");
                    view.jTextFieldSartutakoHitza.setEnabled(false);
                    view.jButtonHitzaSartu.setEnabled(false);
                    bizitzak = 0;
                    view.jLabelBizitzak.setText(String.valueOf(bizitzak));
                    view.jLabelGaldu.setVisible(true);
                    view.jLabelGaldu.setText("Galdu egin duzu, lortutako puntuazioa: " + view.jLabelPuntuazioZenbakia.getText());
                    view.jButtonHasiBerriro.setVisible(true);
                }else if (view.jTextFieldSartutakoHitza.getText().equals("")){
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
            case "HIZTEGIA":
                view.jDialogHiztegia.setSize(535, 333);
                view.jDialogHiztegia.setVisible(true);
                view.jDialogHiztegia.setResizable(false);
                view.jTableTerminoenTaula.setModel(new HiztegiaTableModel(model.terminoakTaulara()));
                break;
            case "ITZULI":
                if(!view.jTextFieldItzuliEuskaraz.getText().equals("") && view.jTextFieldItzuliGazteleraz.getText().equals("")){
                    view.jTextFieldItzuliGazteleraz.setText(model.terminoaItzuliGaztelerara(view.jTextFieldItzuliEuskaraz.getText().toUpperCase()));
                }else if(view.jTextFieldItzuliEuskaraz.getText().equals("") && !view.jTextFieldItzuliGazteleraz.getText().equals("")){
                    view.jTextFieldItzuliEuskaraz.setText(model.terminoaItzuliEuskerara(view.jTextFieldItzuliGazteleraz.getText().toUpperCase()));
                }
                break;
            case "EZABATU":
                view.jTextFieldItzuliEuskaraz.setText("");
                view.jTextFieldItzuliGazteleraz.setText("");
                break;
        }
    }
}
