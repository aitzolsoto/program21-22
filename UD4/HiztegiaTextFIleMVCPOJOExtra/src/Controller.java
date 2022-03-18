
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import sun.java2d.d3d.D3DRenderQueue;

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
    public Controller(Model model, View view) throws IOException{
        this.model = model;
        this.view = view;
        anadirActionListener(this); 
    }    
    private void anadirActionListener(ActionListener listener) {
        //GUIaren konponente guztiei gehitu listenerra
        view.jButtonGorde.addActionListener(listener);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        //listenerrak entzun dezakeen eragiketa bakoitzeko. Konponenteek 'actionCommad' propietatea daukate
        switch (actionCommand) {
            case "GORDE eta IRTEN":
                //model.terminoakGorde(view.jTextAreaHiztegia.getText());
                view.dispose();
            break;
        }
    }
 }
