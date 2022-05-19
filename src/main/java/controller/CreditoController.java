/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import system.DataValuesException;
import view.CreditoPrendarioView;
import view.CreditoView;
import view.CreditoViviendaView;
import view.SolicitanteView;

/**
 *
 * @author march
 */
public class CreditoController implements ActionListener{
    CreditoView view;
    CreditoViviendaView viewVivienda;
    CreditoPrendarioView viewPrendario;
    SolicitanteView viewSolicitante;
    
    public CreditoController(CreditoView view) {
        this.view = view;
        this.viewPrendario = new CreditoPrendarioView();
        this.viewVivienda = new CreditoViviendaView();
        this.viewSolicitante = new SolicitanteView();
        this.view.cbTipoCredito.addActionListener(this);
        this.view.btnGuardar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.view.cbTipoCredito){
            mostrarVentanaCredito();
            
        }
        if(e.getSource() == this.view.btnGuardar){
            try {
                verificarDatosVivienda();
            } catch (DataValuesException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }
    
    private void mostrarVentanaCredito(){
        String item = String.valueOf(this.view.cbTipoCredito.getSelectedItem());
        switch (item) {
            case "Vivienda":
                limpiarCamposPrendario();
                removeTab();
                this.view.pnMainPanel.addTab("Datos vivienda",viewVivienda);
                //JOptionPane.showMessageDialog(null, "Has tomado pacha con Jet?", "Abriendo",JOptionPane.QUESTION_MESSAGE);
                break;
            case "Prendario":
                limpiarDatosVivienda();
                removeTab();
                this.view.pnMainPanel.addTab("Datos prendario",viewPrendario);
                break;
            case "Personal":
                removeTab();
                break;
            default:
                throw new AssertionError();
        }
    }
    
    private void verificarDatosCredito(){
        
    }
    private void verificarDatosVivienda() throws DataValuesException  {
        
        String ingresoFamiliar = this.viewVivienda.txtIngresoFamiliar.getText();
        if(ingresoFamiliar.replace(" ", "").equals("")) throw new DataValuesException("Campo de ingreso familiar vacio");
        try {
            double  parseIngreso = Double.parseDouble(ingresoFamiliar);
        } catch (NumberFormatException e) {
            throw new DataValuesException("Campo de ingreso familiar con letras");
        }
        
    }
    private void verificarDatosPrendario() {
    
    }
    
    private void limpiarDatosVivienda() {
        this.viewVivienda.txtIngresoFamiliar.setText("");
    }
    
    private void limpiarCamposPrendario() {
        
    }
    
    private void allCampos() {
    
        limpiarCamposPrendario();
        limpiarDatosVivienda();
    }
    
    private void guardarCredito(){
        allCampos();
    }
    
    private void removeTab(){
        if(this.view.pnMainPanel.getTabCount()>1){
            this.view.pnMainPanel.removeTabAt(1);
        }
    }
    
}
