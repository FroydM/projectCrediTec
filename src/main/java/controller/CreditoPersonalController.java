/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CreditoPersonalView;

/**
 *
 * @author march
 */
public class CreditoPersonalController implements ActionListener{
    CreditoPersonalView view;
    
    public CreditoPersonalController(CreditoPersonalView view) {
        this.view = view;
        this.view.btnGuardar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.view.btnGuardar) {
            System.out.println("Se apreto el boton miedo :D ");
            leerDato();
            
        }
    }
    
    private void leerDato(){
        String datosLeido = this.view.txtCuadrito.getText();
    }
}
