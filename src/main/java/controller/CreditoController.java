/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.SolicitanteDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import system.DataValuesException;
import view.CreditoFiduciarioView;
import view.CreditoPersonalView;
import view.CreditoPrendarioView;
import view.CreditoView;
import view.CreditoViviendaView;
import view.SolicitanteView;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Moneda;
import model.Solicitante;
import services.TasaBasicaPasiva;
import services.TasaEfectivaDolares;
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
        this.view.cbxMoneda.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
 
        if(e.getSource() == this.view.cbxMoneda || e.getSource() == this.view.cbTipoCredito ){

           String tipo = String.valueOf(this.view.cbTipoCredito.getSelectedItem());
           String moneda = String.valueOf(this.view.cbxMoneda.getSelectedItem());
           
           try {
                          
             this.view.txtInteres.setText(String.format("%.2f",definirInteres(tipo, moneda)));
             
           }catch (Exception ex) {
                Logger.getLogger(CreditoController.class.getName()).log(Level.SEVERE, null, ex);
            } 

        }   
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
            } catch (DataValuesException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    private void mostrarVentanaCredito() {
       
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
    /**
     * 
     * Función para definir los intereses de los créditos
     * @param pTipo
     * @param pMoneda
     * @return
     * @throws Exception 
     */
    private double definirInteres(String pTipo, String pMoneda) throws Exception{
        
        if (pTipo.equals("Personal")&& pMoneda.equals("Colones")){
             double interesAnual = 0.18*100;
             return interesAnual;
        }
        if (pTipo.equals("Personal")& pMoneda.equals("Dolares")){
            double interesAnual = 0.16*100;
            return interesAnual;
        }
        if (pTipo.equals("Prendario")& pMoneda.equals("Colones")){
            double interesAnual = 0.15*100;
            return interesAnual;
        }
        if (pTipo.equals("Prendario")& pMoneda.equals("Dolares")){
            double interesAnual = 0.13*100;
            return interesAnual;
        }
        if (pTipo.equals("Fiduciario")& pMoneda.equals("Colones")){
            double interesAnual = 0.13*100;
            return interesAnual;
        }
        if (pTipo.equals("Fiduciario")& pMoneda.equals("Dolares")){
            double interesAnual = 0.11*100;
            return interesAnual;
        }
        if (pTipo.equals("Terreno")& pMoneda.equals("Colones")){
            double interesAnual = (((TasaBasicaPasiva.conectarTBP())/100)+0.025)*100;
            return interesAnual;
        }
        if (pTipo.equals("Terreno")& pMoneda.equals("Dolares")){
            double interesAnual = (((TasaEfectivaDolares.conectarTED())/100)+0.015)*100;
            return interesAnual;
        }
        if (pTipo.equals("Vivienda")& pMoneda.equals("Colones")){
            double interesAnual = ((TasaBasicaPasiva.conectarTBP()/100)+0.025)*100;
            return interesAnual;
        }
        if (pTipo.equals("Vivienda")& pMoneda.equals("Dolares")){
            double interesAnual = (((TasaEfectivaDolares.conectarTED())/100)+0.015)*100;
            return interesAnual;
        }
        return 0;
    }
    /**
     * Funciones para verificar los datos ingresados sean del tipo correcto 
     * @throws DataValuesException 
     */
    private void verificarDatosCredito() throws DataValuesException{
        try{
            double montoPrestamo = Double.parseDouble(this.view.txtMonto.getText());
            int plazo = Integer.parseInt(this.view.txtPlazo.getText());
            double interes = Double.parseDouble(this.view.txtInteres.getText());
            int cedulaSolicitante = Integer.parseInt(this.view.txtCedulaSolicitante.getText());
        }catch (NumberFormatException e){
            throw new DataValuesException("Ingrese un monto válido");
        }
    }
    private void verifcarDatosPersonal()throws DataValuesException{
        String razonCredito = this.viewPersonal.txtRazon.getText();
        
        if(razonCredito.replace(" ", "").equals("")) throw new DataValuesException("Ingrese la razón del crédito");

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
        
        String nombre = this.viewFiduciario.txtNombre.getText();
        String apellido = this.viewFiduciario.txt1Apellido.getText();
        String apellido2 = this.viewFiduciario.txt2Apellido.getText();
        
        if(nombre.replace(" ", "").equals("")) throw new DataValuesException("Nombre incorrecto");
        if(apellido.replace(" ", "").equals("")) throw new DataValuesException("Primer apellido incorrecto");
        if(nombre.replace(" ", "").equals("")) throw new DataValuesException("Segundo apellido incorrecto");
        
        try{
            double cedula = Double.parseDouble(this.viewFiduciario.txtCedula.getText());
        }catch (NumberFormatException e){
            throw new DataValuesException("Ingrese una cédula válida");
        }
        
        try{
            double salarioBruto = Double.parseDouble(this.viewFiduciario.txtSalarioBruto.getText());
            double salarioLiquido = Double.parseDouble(this.viewFiduciario.txtSalarioLiquido.getText());
        }catch (NumberFormatException e){
            throw new DataValuesException("Ingrese un monto válido");
        }
    
    }
    /**
     * Funciones para limpiar los campos de texto
     */
    private void limpiarCamposCredito(){
        this.view.txtMonto.setText("");
        this.view.txtPlazo.setText("");
        this.view.txtInteres.setText("");
        
    }
    private void limpiarCamposPersonal(){
        this.viewPersonal.txtRazon.setText("");
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
    }
    private void clearAllCampos() {
        limpiarCamposCredito();
        limpiarCamposPersonal();
        limpiarCamposPrendario();
        limpiarCamposVivienda();
        limpiarCamposFiduciario();
    }
    
    /**
     * Función para guardar un crédito
     * @throws DAOException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    private void guardarCredito() throws DAOException, IOException, ClassNotFoundException{
        
        Solicitante sol = SolicitanteDAO.obtenerSolicitanteById(Integer.parseInt(this.view.txtCedulaSolicitante.getText()));
        
        String moneda = String.valueOf(this.view.cbxMoneda.getSelectedItem());
        String razon = viewPersonal.txtRazon.getText();
        double salarioLiquido = sol.getSalarioLiquido();
        double monto = Double.parseDouble(this.view.txtMonto.getText());
        double interes = Double.parseDouble(this.view.txtInteres.getText());
        int plazo = Integer.parseInt(this.view.txtPlazo.getText());
        
        
        String item = String.valueOf(this.view.cbTipoCredito.getSelectedItem());
        
        switch (item) {
            case "Fiduciario" -> {
                //Solicitante sol = SolicitanteDAO.obtenerSolicitanteById(this.view.txtCedulaSolicitante.getText());
                //sol.agregarCreditoFiduciario(0, 0, 0, Moneda.COLONES, 0, TipoTasa.TASA_FILA, fiadores);
                //SolicitanteDAO.actualizarSolicitanteById(sol);
            }
            case "Prendario" -> {
                
            }
            case "Vivienda" -> {
                
            }
            case "Personal" -> {
                
                sol.agregarCreditoPersonal(monto, plazo, interes, Moneda.valueOf(moneda),razon);     
            }
            case "Terreno" -> {
                
            }
            
            default -> throw new AssertionError();
        }
    }
    private void removeTab(){
        if(this.view.pnMainPanel.getTabCount()>1){
            this.view.pnMainPanel.removeTabAt(1);
        }
    }
    
}
