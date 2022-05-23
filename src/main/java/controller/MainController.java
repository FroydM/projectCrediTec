/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.SolicitanteDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Solicitante;
import system.DAOException;
import system.DataValuesException;
import view.CreditoPersonalView;
import view.CreditoView;
import view.DatosCreditosView;
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
        this.view.btnSolicitudCredito.addActionListener(this);
        this.view.btnInfoCredito.addActionListener(this);
        this.view.tabla.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == view.btnInfoCredito){
            DatosCreditosView panelDatosCredito = new DatosCreditosView();
            DatosCreditoController dC = new DatosCreditoController (panelDatosCredito);
            this.view.mainPanel.addTab("Datos Créditos", panelDatosCredito);
        }
        if(e.getSource() == view.btnGestionSolicitantes) {
            SolicitanteView panelSolicitante = new SolicitanteView();
            SolicitanteController sC = new SolicitanteController(panelSolicitante);
            this.view.mainPanel.addTab("Gestion solicitante", panelSolicitante);
        }
        
        if(e.getSource() == view.btnSolicitudCredito) {

            try {
               int cedula = Integer.parseInt(JOptionPane.showInputDialog("Digite su número de cédula:"));
               
               Solicitante sd = SolicitanteDAO.obtenerSolicitanteById(cedula);
               
               CreditoView panelCredito = new CreditoView();
               CreditoController cpC = new CreditoController(panelCredito);
               this.view.mainPanel.addTab("Solicitud de Crédito", panelCredito);
               
               panelCredito.txtCedulaSolicitante.setText(Integer.toString(cedula));
               panelCredito.txtCedulaSolicitante.setText(Integer.toString(cedula));
               panelCredito.txtNombre.setText(sd.getNombre());
               panelCredito.txtApellido1.setText(sd.getPriApellido());
               panelCredito.txtApellido2.setText(sd.getSegApellido());

  
            } catch (DAOException | ClassNotFoundException | IOException  ex) {
              //esto da error
                //Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                
                JOptionPane.showMessageDialog(null,"Solicitante no registrado:");
            }
            
        }
        
    }
}
