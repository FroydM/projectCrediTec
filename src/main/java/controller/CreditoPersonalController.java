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
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    
    private void leerDato(){
        String datosLeido = this.view.txtRazon.getText();
        
    }
}
