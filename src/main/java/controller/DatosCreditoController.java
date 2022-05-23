/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.SolicitanteDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Credito;
import model.Estado;
import model.Solicitante;
import static org.bouncycastle.asn1.x500.style.RFC4519Style.l;
import services.MailingApi;
import services.PdfApi;
import system.DAOException;
import view.DatosCreditosView;


/**
 *
 * @author Madelen
 */
public class DatosCreditoController implements ActionListener{
    
     private DatosCreditosView view;
     private Credito currentCredito;

    public DatosCreditoController(DatosCreditosView view) {
        this.view = view;
        currentCredito = null;
        this.view.txtCedula.addActionListener(this);
        this.view.btnMostrar.addActionListener(this);        
        this.view.btnExportar.addActionListener(this);
        this.view.btnSendEmail.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.txtCedula) {
            
            int cedula= Integer.valueOf(view.txtCedula.getText());
           
            mostrarCreditos(cedula);
        }
        if (e.getSource() == view.btnMostrar){             
            
            
            try {
                
                mostrarAmortizacion();
            } catch (DAOException ex) {
                Logger.getLogger(DatosCreditoController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DatosCreditoController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DatosCreditoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if(e.getSource() == view.btnExportar) {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("Selecciono carpeta de exportacion");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);
            if(chooser.showOpenDialog(null)== JFileChooser.APPROVE_OPTION) {
                try {
                    String ROUTE_PATH = chooser.getCurrentDirectory().getPath().replace("\\", "/");
                    System.out.println(ROUTE_PATH);
                    
                    Solicitante current = SolicitanteDAO.obtenerSolicitanteById(Integer.parseInt(view.txtCedula.getText()));
                    String info = this.currentCredito.toString()+"\n\n" + current.toString();
                    PdfApi exportPdf = new PdfApi(ROUTE_PATH+"/dataExport.pdf", view.jtAmortizacion,info);
                } catch ( DAOException |IOException   |ClassNotFoundException  ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
            
        }
        if(e.getSource() == view.btnSendEmail) {
            try {
                Solicitante current = SolicitanteDAO.obtenerSolicitanteById(Integer.parseInt(view.txtCedula.getText()));
                String info = this.currentCredito.toString()+"\n\n" + current.toString();
                PdfApi exportPdf = new PdfApi("data.pdf", view.jtAmortizacion,info);
                MailingApi.sendMailWithText(current.getEmail(), current.toString());
            } catch (DAOException |IOException   |ClassNotFoundException  ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (Exception ex) {
                Logger.getLogger(DatosCreditoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
    }
    public void mostrarAmortizacion() throws DAOException, IOException, ClassNotFoundException{
        
        int cedula= Integer.valueOf(view.txtCedula.getText());
        
        String creditoElegido =view.listaCreditos.getSelectedValue();
        String[] buscarId = creditoElegido.split("-",2);
        String idCredito = buscarId[0];
                
        ArrayList<Credito> listado = SolicitanteDAO.obtenerAllCreditosBySolicitante(cedula);
        DefaultTableModel modelo = (DefaultTableModel)view.jtAmortizacion.getModel();
        
        modelo.setRowCount(0);
        for(Credito item : listado) {
            try{
                if (item.getId().equals(idCredito)){
                    if (item.getEstado() == Estado.PREAPROBADO) {
                        this.view.txtEstado.setText("PREAPROBADO");
                    }else {
                        this.view.txtEstado.setText("Rechazado");
                    }
                    ArrayList<double[]> info = item.mostrarAmortizacion();
                    currentCredito = item;
                    for (int i=0; i<info.size(); i++){
                       
                       Object[] row= {info.get(i)[0],info.get(i)[1],info.get(i)[2],info.get(i)[3],info.get(i)[4]};
                       
                       modelo.addRow(row);                 
                    }
                    view.jtAmortizacion.setModel(modelo);
                }
            }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }
            
        }

    }
    /**
     * Función que muestra los creditos de un solicitante
     * @param pCedula 
     */
    private void mostrarCreditos(int pCedula){
        
        try {
            ArrayList<Credito> listado = SolicitanteDAO.obtenerAllCreditosBySolicitante(pCedula);
            DefaultListModel modelo = new DefaultListModel();
            
            modelo.removeAllElements();
            
            for(Credito item : listado) {
                Object row = item.getId()+ "-" +item.getTipo() + "-" + item.getMonto()+" "+ item.getEstado();
                modelo.addElement(row);
            }
            view.listaCreditos.setModel(modelo);
        } catch (DAOException | ClassNotFoundException | IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
}
