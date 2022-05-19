/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CreditoPersonalView;
import view.CreditoView;
import view.MainView;
import view.SolicitanteView;

/**
 *
 * @author march
 */
public class MainController implements ActionListener{
    MainView view;
    
    public MainController(MainView view) {
        this.view = view;
        this.view.btnGestionSolicitantes.addActionListener(this);
        this.view.btnGestionCreditoPersonal.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.btnGestionSolicitantes) {
            SolicitanteView panelSolicitante = new SolicitanteView();
            SolicitanteController sC = new SolicitanteController(panelSolicitante);
            this.view.mainPanel.addTab("Gestion solicitante", panelSolicitante);
        }
        
        if(e.getSource() == view.btnGestionCreditoPersonal) {
            CreditoView panelCredito = new CreditoView();
            CreditoController cpC = new CreditoController(panelCredito);
            this.view.mainPanel.addTab("Gestion credito personal", panelCredito);
        }
        
    }
}
