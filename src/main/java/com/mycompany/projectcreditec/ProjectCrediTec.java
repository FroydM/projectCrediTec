package com.mycompany.projectcreditec;

import controller.MainController;
import controller.SolicitanteController;
import dao.SolicitanteDAO;
import java.io.IOException;
import model.Solicitante;
import  model.Credito;
import model.CreditoFiduciario;
import model.CreditoHipotecarioTerreno;
import model.CreditoHipotecarioVivienda;
import model.CreditoPersonal;
import model.CreditoPrendario;
import model.Fiador;
import model.Moneda;
import static model.Moneda.COLONES;
import model.Persona;
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
            
            
            /*Credito cp1 = new CreditoPrendario("Auto",7250000 , 0.07, 8000000, 96, COLONES);
            System.out.println("EL COSTO DE LA FORMALIZACIÓN ES: " + cp1.costoFormalizacion()+"\n");
            System.out.println("EL COSTO DE LOS HONORARIOS ES: "+ cp1.costoHonorarios()+"\n");
            System.out.println("EL MONTO TOTAL DEL PRESTAMO ES : "+ cp1.calculoMontoFinal()+"\n");
            System.out.println("AMORTIZACIÓN : "+ cp1.amortizacionAmericana()+"\n");
            
            Solicitante s1 = new Solicitante ();
            s1.solicitarPrestamo(PRENDARIO, "AUTO", 8000000, 0.15, 1000000, 5, COLONES);
            
            
            
            CreditoHipotecario ch1 = new CreditoHipotecario (HIPOTECARIO,'N', 1000000,5,0.15, COLONES);
            
            System.out.println("EL COSTO DEL AVALUO ES: " + ch1.costoAvaluo()+"\n");
            System.out.println("EL COSTO DE LA FORMALIZACIÓN ES: " + ch1.costoFormalizacion()+"\n");
            System.out.println("EL COSTO DE LOS HONORARIOS ES: "+ ch1.costoHonorarios()+"\n");
            System.out.println("EL MONTO TOTAL DEL PRESTAMO ES : "+ ch1.calculoMontoFinal()+"\n");
            */
            
            /*System.out.println("LA CUOTA MENSUAL ES : "+ ch1.calculoCuotaHipotecaria()+"\n");
            System.out.println("LA CUOTA INTERES MENSUAL ES : "+ ch1.calculoInteresHipotecario()+"\n");
            System.out.println("LA CUOTA INTERES MENSUAL ES : "+ ch1.calculoAmortizacionHipotecaria()+"\n");
            
            ch1.mostrarAmortizacion();
            */
            /*
            CreditoHipotecarioVivienda chv1= new CreditoHipotecarioVivienda(2125000, 'S', 42000000, 20, 0.15, COLONES);
            
            System.out.println("EL BONO ES : "+ chv1.calcularBonoVivienda()+"\n");
            
            System.out.println("EL MONTO FINAL DEL PRESTAMO ES : "+chv1.calculoMontoFinal()+"\n");
            */
            /*
            CreditoPersonal cp1 = new CreditoPersonal(700000, "colegiatura", 1000000, 5,0.15, COLONES);
            
            //System.out.println("LA CUOTA  MENSUAL ES : "+cp1.calculoCuotaAlemana(1)+"\n");
            //System.out.println("LA CUOTA INTERES MENSUAL ES : "+cp1.calculoInteresAleman(1)+"\n");
            //System.out.println("LA CUOTA AMORTIZACION MENSUAL ES : "+cp1.calculoAmortizacionAleman()+"\n");
            
            cp1.mostrarAmortizacion();*/
           /*
           CreditoFiduciario cf1 = new CreditoFiduciario(15000000,120,0.05,COLONES);
           System.out.println(Math.round(cf1.calculoMontoFinal()));
           System.out.println(Math.round(cf1.calculoCuotaFrancesa())); 
           
           Fiador f1 = new Fiador( 116630093,"Melanie", "Jimenez",  "Sandoval",  2000000,  1685000);
           Fiador f2 = new Fiador( 9101897,"Flora", "Sandoval",  "Cordero",  1300000,  1045000); 
           
           cf1.agregarFiador(f1);
           cf1.agregarFiador(f2);
           
           System.out.println(cf1.verificarSalarioBruto());
           
           System.out.println(cf1.verificarSalarioLiquido());*/
           
         
          
            
    }
}
