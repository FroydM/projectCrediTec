/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.CreditoFiduciario;
import model.Moneda;
import model.TipoTasa;
import system.DataValuesException;
import view.CreditoFiduciarioView;
import view.CreditoPersonalView;
import view.CreditoPrendarioView;
import view.CreditoView;
import view.CreditoViviendaView;
import view.SolicitanteView;
import dao.SolicitanteDAO;
import java.io.IOException;
import model.Solicitante;
import system.DAOException;
/**
 *
 * @author Melanie and Froyd
 */
public class CreditoController implements ActionListener{
    CreditoView view;
    CreditoFiduciarioView viewFiduciario;
    CreditoViviendaView viewVivienda;
    CreditoPrendarioView viewPrendario;
    CreditoPersonalView viewPersonal;
    SolicitanteView viewSolicitante;
    
    public CreditoController(CreditoView view) {
        this.view = view;
        this.viewFiduciario = new CreditoFiduciarioView();
        this.viewPrendario = new CreditoPrendarioView();
        this.viewVivienda = new CreditoViviendaView();
        this.viewSolicitante = new SolicitanteView();
        this.viewPersonal = new CreditoPersonalView();
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
               String item = String.valueOf(this.view.cbTipoCredito.getSelectedItem());
               
               switch(item){
                   
                   case"Fiduciario":
                       verificarDatosFiduciario();
                       break;
                   case"Prendario":
                       verificarDatosPrendario();
                       break;
                   case"Personal":
                       verifcarDatosPersonal();
                       break; 
                   case"Vivienda":
                       verificarDatosVivienda();
                       break;
               }
               
               verificarDatosCredito();
               guardarCredito();
            } catch (DataValuesException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }
    
    private void mostrarVentanaCredito(){
        String item = String.valueOf(this.view.cbTipoCredito.getSelectedItem());
        switch (item) {
            case "Fiduciario":
                removeTab();
                limpiarCamposVivienda();
                limpiarCamposPrendario();
                this.view.pnMainPanel.addTab("Datos Fiduciario", viewFiduciario);
                break;
            case "Prendario":
                limpiarCamposVivienda();
                limpiarCamposPrendario();
                removeTab();
                this.view.pnMainPanel.addTab("Datos prendario",viewPrendario);
                break;
            case "Vivienda":
                limpiarCamposPrendario();
                limpiarCamposFiduciario();
                removeTab();
                this.view.pnMainPanel.addTab("Datos vivienda",viewVivienda);
                //JOptionPane.showMessageDialog(null, "Has tomado pacha con Jet?", "Abriendo",JOptionPane.QUESTION_MESSAGE);
                break;
            case "Personal":
                clearAllCampos();
                removeTab();
                this.view.pnMainPanel.addTab("Datos personal", viewPersonal);
                break;
            case "Terreno":
                clearAllCampos();
                removeTab();
                break;
            
            default:
                throw new AssertionError();
        }
    }
    
    private void verificarDatosCredito() throws DataValuesException{
        try{
            double montoPrestamo = Double.parseDouble(this.view.txtMonto.getText());
            double plazo = Double.parseDouble(this.view.txtPlazo.getText());
            double interes = Double.parseDouble(this.view.txtInteres.getText());
            double cedulaSolicitante = Double.parseDouble(this.view.txtCedulaSolicitante.getText());
        }catch (NumberFormatException e){
            throw new DataValuesException("Ingrese un monto válido");
        }
    }
    private void verifcarDatosPersonal()throws DataValuesException{
        String razonCredito = this.viewPersonal.txtRazon.getText();
        
        if(razonCredito.replace(" ", "").equals("")) throw new DataValuesException("Ingrese la razón del crédito");
        
        try{
            double salario = Double.parseDouble(this.viewPersonal.txtSalario.getText());
        }catch (NumberFormatException e){
            throw new DataValuesException("Ingrese un monto válido");
        }
    }
    private void verificarDatosPrendario() throws DataValuesException {
        String nombrePrenda = this.viewPrendario.txtPrenda.getText();
        
        if(nombrePrenda.replace(" ", "").equals("")) throw new DataValuesException("Ingrese el nombre de la prenda");
        
        try{
            double valorPrenda = Double.parseDouble(this.viewPrendario.txtValor.getText());
        }catch (NumberFormatException e){
            throw new DataValuesException("Ingrese un monto válido");
        }
    }
    private void verificarDatosVivienda() throws DataValuesException  {
        
        String ingresoFamiliar = this.viewVivienda.txtIngresoFamiliar.getText();
        if(ingresoFamiliar.replace(" ", "").equals("")) throw new DataValuesException("Ingreso familiar vacío");
        try {
            double  parseIngreso = Double.parseDouble(ingresoFamiliar);
        } catch (NumberFormatException e) {
            throw new DataValuesException("Ingrese un monto válido");
        }
        
    }
    private void verificarDatosFiduciario() throws DataValuesException {
        if(this.viewFiduciario.fiadores.isEmpty()) throw new DataValuesException("No se encuentra fiadores registrados");
    
    }
    private void limpiarCamposCredito(){
        this.view.txtMonto.setText("");
        this.view.txtPlazo.setText("");
        this.view.txtInteres.setText("");
        this.view.txtCedulaSolicitante.setText("");
        this.view.txtNombre.setText("");
        this.view.txtApellido1.setText("");
        this.view.txtApellido2.setText("");
        
    }
    private void limpiarCamposPersonal(){
        this.viewPersonal.txtRazon.setText("");
        this.viewPersonal.txtSalario.setText("");
    }
    private void limpiarCamposVivienda() {
        this.viewVivienda.txtIngresoFamiliar.setText("");
        this.viewVivienda.rbSi.setSelected(true);
    }
    private void limpiarCamposPrendario() {
        this.viewPrendario.txtPrenda.setText("");
        this.viewPrendario.txtValor.setText("");
    }
    private void limpiarCamposFiduciario(){
        this.viewFiduciario.txtCedula.setText("");
        this.viewFiduciario.txtNombre.setText("");
        this.viewFiduciario.txt1Apellido.setText("");
        this.viewFiduciario.txt2Apellido.setText("");
        this.viewFiduciario.txtSalarioBruto.setText("");
        this.viewFiduciario.txtSalarioLiquido.setText("");
        this.viewFiduciario.fiadores.clear();
        this.viewFiduciario.listaFiador.removeAll();
    }
    private void clearAllCampos() {
        limpiarCamposCredito();
        limpiarCamposPersonal();
        limpiarCamposPrendario();
        limpiarCamposVivienda();
        limpiarCamposFiduciario();
    }
    
    
    private void guardarCredito(){
        try {
            String item = String.valueOf(this.view.cbTipoCredito.getSelectedItem());
        double monto = Double.parseDouble(this.view.txtMonto.getText());
        int plazo = Integer.parseInt(this.view.txtPlazo.getText());
        double interes = Double.parseDouble(this.view.txtInteres.getText());
        Moneda moneda=null;
        if(this.view.cbxMoneda.getSelectedItem().toString().equals("Colones")) moneda = Moneda.COLONES;
        if(this.view.cbxMoneda.getSelectedItem().toString().equals("Dolares")) moneda = Moneda.DOLARES;
        Solicitante currentSolicitante = SolicitanteDAO.obtenerSolicitanteById(Integer.parseInt(this.view.txtCedulaSolicitante.getText()));
            switch (item) {
                case "Fiduciario" -> {
                    currentSolicitante.agregarCreditoFiduciario(monto, plazo, interes, moneda, monto, this.viewFiduciario.fiadores);
                    
                }
                case "Prendario" -> {
                    String prenda = this.viewPrendario.txtPrenda.getText();
                    double valorPrenda = Double.parseDouble(this.viewPrendario.txtValor.getText());
                    currentSolicitante.agregarCreditoPrendario(monto, plazo, interes, moneda, monto, prenda, valorPrenda);
                }
                case "Vivienda" -> {
                    double ingresoFamiliar = Double.parseDouble(this.viewVivienda.txtIngresoFamiliar.getText());
                    char bono='N';
                    if(this.viewVivienda.rbSi.isSelected())bono = 'S';
                    currentSolicitante.agregarCreditoHipotecarioVivienda(monto, plazo, interes, moneda, monto,ingresoFamiliar, bono);
                
                }
                case "Personal" -> {
                    String razon = this.viewPersonal.txtRazon.getText();
                    currentSolicitante.agregarCreditoPersonal(monto, plazo, interes, moneda, razon);
                    
                }
                case "Terreno" -> {
                    currentSolicitante.agregarCreditoHipotecarioTerreno(monto, plazo, interes, moneda);
                    
                    
                }
            
                default -> throw new AssertionError();
            }
            SolicitanteDAO.actualizarSolicitanteById(currentSolicitante);
            JOptionPane.showMessageDialog(null, "Credito registrado correctamente");
        } catch (IOException | ClassNotFoundException | NumberFormatException | DAOException e) {
        }
    }
    private void removeTab(){
        if(this.view.pnMainPanel.getTabCount()>1){
            this.view.pnMainPanel.removeTabAt(1);
        }
    }
    
}
