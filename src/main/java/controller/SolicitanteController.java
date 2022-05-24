/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.SolicitanteDAO;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import system.DAOException;
import view.SolicitanteView;
import model.Solicitante;

/**
 *
 * @author march
 */
public class SolicitanteController implements ActionListener{
    private SolicitanteView view;
    public SolicitanteController(SolicitanteView view) {
        this.view = view;
        this.view.btnNuevo.addActionListener(this);

        listar(this.view.listaSolicitantes);
    }
    
    public SolicitanteController(){
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.btnNuevo) {
            agregar();
        }

    }
    /**
     * Esta funcion se encarga de listar los solicitantes registrados en una lista especifica.
     * @param lista Es un objeto donde se visualizaran los datos en la interfaz
     */

    private void listar(JList lista){
        try {
            ArrayList<Solicitante> listado = SolicitanteDAO.obtenerListadoSolicitantes();
            DefaultListModel modelo = new DefaultListModel();
            for(Solicitante item : listado) {
                Object row = item.getCedula() + " - " + item.getNombre()+" "+ item.getPriApellido();
                modelo.addElement(row);
            }
            lista.setModel(modelo);
        } catch (DAOException | ClassNotFoundException | IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    /**
     * Estan funcion se encarga de capturar los datos en la interfaz y almacenarlos en el sistema
     */
    private void agregar() {
        try {
            validarDatos();
            int cedula = Integer.parseInt(this.view.txtCedula.getText());
            String nombre = this.view.txtNombre.getText();
            String priApellido = this.view.txtPApellido.getText();
            String segApellido = this.view.txtSApellido.getText();
            int numTelefono = Integer.parseInt(this.view.txtContacto.getText());
            String email = this.view.txtEmail.getText();
            String provincia = this.view.cbProvincia.getSelectedItem().toString();
            String canton = this.view.txtCanton.getText();
            String distrito = this.view.txtDistrito.getText();
            String otrasReferencias = this.view.txtSennas.getText();
            double salarioBruto = Double.parseDouble(this.view.txtSalarioBruto.getText());
            double salarioLiquido = Double.parseDouble(this.view.txtSalarioLiquido.getText());
            
            Solicitante nuevoSolicitante = new Solicitante(cedula, nombre, priApellido, segApellido, salarioBruto, salarioLiquido, 
                    numTelefono, email, provincia, canton, distrito, otrasReferencias);
            SolicitanteDAO.guardarSolicitante(nuevoSolicitante);
            listar(this.view.listaSolicitantes);
            JOptionPane.showMessageDialog(null, "Registrado con exito", "Registro", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
        } catch (HeadlessException | IOException | NumberFormatException | DAOException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar: "+e.getMessage(),"Registro",JOptionPane.ERROR_MESSAGE);
        }    
    }
    /**
     * Se encarga de limpoar los campos de texto dentro de la interfaz
     */
    private void limpiarCampos() {
        this.view.txtCedula.setText("");
        this.view.txtNombre.setText("");
        this.view.txtPApellido.setText("");
        this.view.txtSApellido.setText("");
        this.view.txtContacto.setText("");
        this.view.txtEmail.setText("");
        this.view.txtCanton.setText("");
        this.view.txtDistrito.setText("");
        this.view.txtSennas.setText("");
        this.view.txtSalarioBruto.setText("");
        this.view.txtSalarioLiquido.setText("");
    }
    /**
     * Esta funcion se encarga de validar que todos los campo de texto esten completos
     * @throws DAOException Error si encuentra un campo vacio
     */
    private void validarDatos() throws DAOException {
        if(this.view.txtCedula.getText().replace(" ", "").equals("") || this.view.txtNombre.getText().replace(" ", "").equals("") || this.view.txtPApellido.getText().replace(" ", "").equals("")
                || this.view.txtSApellido.getText().replace(" ", "").equals("") || this.view.txtContacto.getText().replace(" ", "").equals("") || this.view.txtEmail.getText().replace(" ", "").equals("")
                || this.view.txtCanton.getText().replace(" ", "").equals("") || this.view.txtDistrito.getText().replace(" ", "").equals("") || this.view.txtSennas.getText().replace(" ", "").equals("")
                || this.view.txtSalarioBruto.getText().replace(" ", "").equals("") || this.view.txtSalarioLiquido.getText().replace(" ", "").equals("")) {
            throw new DAOException("Campos vacios");
        }
    }
}
