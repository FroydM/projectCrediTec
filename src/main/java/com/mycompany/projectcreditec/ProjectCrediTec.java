package com.mycompany.projectcreditec;

import controller.MainController;
import controller.SolicitanteController;
import dao.SolicitanteDAO;
import java.io.IOException;
import model.Solicitante;
import static model.TipoCredito.HIPOTECARIO;
import  model.Credito;
import model.CreditoPrendario;
import model.Moneda;
import static model.Moneda.COLONES;
import model.TipoCredito;
import static model.TipoCredito.FIDUCIARIO;
import static model.TipoCredito.PERSONAL;
import static model.TipoCredito.PRENDARIO;
import system.DAOException;
import view.MainView;
import view.SolicitanteView;

/**
 *
 * @author march
 */
public class ProjectCrediTec {

    public static void main(String[] args) throws Exception {
            
           /*MainView vw = new MainView();
            MainController sC = new MainController(vw);
            vw.setVisible(true);*/
            
            /*Credito c1 = new Credito (HIPOTECARIO, 10000000,12 , COLONES);
            Credito c2 = new Credito (PERSONAL, 15000000,12 , COLONES);
            Credito c3 = new Credito (FIDUCIARIO, 25000000,12 , COLONES);
            Credito c4 = new Credito (PRENDARIO, 8000000,12 , COLONES);
            
            System.out.println("EL COSTO DEL EVALUO ES: " + c4.costoAvaluo()+"\n");
            System.out.println("EL COSTO DE LA FORMALIZACIÓN ES: " + c4.costoFormalizacion()+"\n");
            System.out.println("EL COSTO DE LOS HONORARIOS ES: "+ c4.costoHonorarios()+"\n");
            System.out.println("EL MONTO TOTAL DEL PRESTAMO ES : "+ c4.calculoMontoFinal()+"\n");
            System.out.println("EL MONTO REQUERIDO DE LA PRENDA ES : "+ c4.verificarPrenda()+"\n");
           
            */
            /*
            CreditoPrendario cp1 = new CreditoPrendario("Auto", 10000000, 0.15, 909500, 5, COLONES);
            System.out.println("EL COSTO DE LA FORMALIZACIÓN ES: " + cp1.costoFormalizacion()+"\n");
            System.out.println("EL COSTO DE LOS HONORARIOS ES: "+ cp1.costoHonorarios()+"\n");
            System.out.println("EL MONTO TOTAL DEL PRESTAMO ES : "+ cp1.calculoMontoFinal()+"\n");
            */
            Solicitante s1 = new Solicitante ();
            s1.solicitarPrestamo(PRENDARIO, "AUTO", 8000000, 0.15, 1000000, 5, COLONES);
            
    }
}
