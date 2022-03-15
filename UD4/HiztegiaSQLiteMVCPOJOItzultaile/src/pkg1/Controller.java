package pkg1;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author soto.aitzol
 */
public class Controller implements ActionListener {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        gehituActionListener(this);
    }

    private void gehituActionListener(ActionListener listener) {
        //GUIaren konponente guztiei gehitu listenerra
        view.jButtonTerminoBerria.addActionListener(listener);
        view.jButtonIrten.addActionListener(listener);
        view.jButtonTerminoaTxertatu.addActionListener(listener);
        view.jButtonHiztegiaInprimatu.addActionListener(listener);
        view.jButtonHiztegiaItxi.addActionListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        //listenerrak entzun dezakeen eragiketa bakoitzeko. Konponenteek 'actionCommand' propietatea daukate
        switch (actionCommand) {
            case "TERMINO BERRIA":
                view.jDialogTerminoaGehitu.setSize(400,400);
                view.jDialogTerminoaGehitu.setResizable(false);
                view.jDialogTerminoaGehitu.setVisible(true);
                break;
            case "TXERTATU":
                System.out.println("TXERTATU botoia sakatu duzu");
                Terminoa t1 = new Terminoa(view.jTextFieldTxertatuEuskaraz.getText(), view.jTextFieldTxertatuGazteleraz.getText());
                model.terminoaGehitu(t1);
                view.jDialogTerminoaGehitu.dispose();
                break;
            case "HIZTEGIA INPRIMATU":
                model.terminoakInprimatu();
                view.jDialogHiztegiaInprimatu.setSize(400,400);
                view.jDialogHiztegiaInprimatu.setResizable(false);
                view.jDialogHiztegiaInprimatu.setVisible(true);
                break;
            case "HIZTEGIA ITXI":
                view.jDialogHiztegiaInprimatu.dispose();
                break;
            case "IRTEN":
                view.dispose();
                System.out.println("Itxi");
                break;
        }
    }
}
