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
        view.jButtonTxertatu.addActionListener(listener);
        view.jButtonIrten.addActionListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        //listenerrak entzun dezakeen eragiketa bakoitzeko. Konponenteek 'actionCommand' propietatea daukate
        switch (actionCommand) {
            case "TXERTATU":
                System.out.println("TXERTATU botoia sakatu duzu");
                Terminoa t1 = new Terminoa(view.jTextFieldEuskaraz.getText(), view.jTextFieldGazteleraz.getText());
                model.terminoaGehitu(t1);
                break;
            case "IRTEN":
                view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                break;
        }
    }
}
