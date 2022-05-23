package com.mycompany.projectcreditec;

import controller.MainController;
import controller.SolicitanteController;

import dao.SolicitanteDAO;
import java.io.IOException;
import java.util.ArrayList;
import model.Solicitante;
import services.MailingApi;
import services.PdfApi;
import  model.Credito;
import model.CreditoFiduciario;
import model.CreditoHipotecarioTerreno;
import model.CreditoHipotecarioVivienda;
import model.CreditoPersonal;
import model.CreditoPrendario;
import model.Fiador;
import model.Moneda;
import static model.Moneda.COLONES;
import static model.Moneda.DOLARES;
import model.Persona;
import model.TipoCredito;
import static model.TipoCredito.FIDUCIARIO;
import static model.TipoCredito.PERSONAL;
import static model.TipoCredito.PRENDARIO;
import model.TipoTasa;
import system.DAOException;
import view.MainView;
import view.SolicitanteView;


/**
 *
 * @author march
 */
public class ProjectCrediTec {

    public static void main(String[] args) throws Exception {
        //System.out.println(services.TasaBasicaPasiva.conectarTBP());
          System.out.println(TipoCredito.FIDUCIARIO.toString());
         MainView vw = new MainView();
         MainController sC = new MainController(vw);
         vw.setVisible(true);

         
        //  PdfApi newPDf = new PdfApi("prueba.pdf");
        
           
           //System.out.println(services.TasaEfectivaDolares.conectarTED());
  /*         
        try {
           //Solicitante newSolicitante = new Solicitante(123, "Froyd", "Marchena", "Loria", 750000, 700000, 84934434, "marchena.froyd@gmail.com", "Cartago", "Paraiso", "Paraiso", "En una casa");
            //SolicitanteDAO.guardarSolicitante(newSolicitante);
           //System.out.println(newSolicitante.creditosSolicitados.size());
            Solicitante getSolicitante = SolicitanteDAO.obtenerSolicitanteById(123);
            getSolicitante.agregarCreditoHipotecarioTerreno(300000, 36, 6, Moneda.DOLARES);
            SolicitanteDAO.actualizarSolicitanteById(getSolicitante);
           // getSolicitante = SolicitanteDAO.obtenerSolicitanteById(123);
            //System.out.println(getSolicitante.creditosSolicitados.size());
            ArrayList<Credito> getCreditos= SolicitanteDAO.obtenerAllCreditosBySolicitante(123);
            System.out.println(getCreditos.toArray());
        } catch (Exception e) {
                System.out.println(e.getMessage());
        }*/

        /*Solicitante newSolicitante = new Solicitante(1, "Prueba", "q", "q", 750000, 700000, 84934434, "p@gmail.com", "Cartago", "Paraiso", "Paraiso", "En una casa");
        SolicitanteDAO.guardarSolicitante(newSolicitante);
        Solicitante getSolicitante = SolicitanteDAO.obtenerSolicitanteById(1);
        getSolicitante.agregarCreditoPersonal(3000000, 5, 16, COLONES, "PAGO EXTRAORDINARIO CASA");//no califica
        getSolicitante.agregarCreditoPersonal(10000, 10, 16, Moneda.DOLARES,"COMPRA CARRO"); 
        SolicitanteDAO.actualizarSolicitanteById(getSolicitante);
   
        Solicitante newSolicitante2 = new Solicitante(2, "Prueba", "q", "q", 11000000, 7000000, 84934434, "p@gmail.com", "Cartago", "Paraiso", "Paraiso", "En una casa");
        SolicitanteDAO.guardarSolicitante(newSolicitante2);
        Solicitante getSolicitante2 = SolicitanteDAO.obtenerSolicitanteById(2);
        getSolicitante2.agregarCreditoPersonal(1000000, 5, 15, COLONES, "compra Vehiculo");
        getSolicitante2.agregarCreditoPersonal(50000, 10, 16, DOLARES,"COMPRA CARRO"); 
        SolicitanteDAO.actualizarSolicitanteById(getSolicitante2);
        
        */
   
        /**Solicitante newSolicitante3 = new Solicitante(3, "Prueba", "q", "q", 20000000, 18000000, 84934434, "p@gmail.com", "Cartago", "Paraiso", "Paraiso", "En una casa");
        //SolicitanteDAO.guardarSolicitante(newSolicitante3);
        Solicitante getSolicitante3 = SolicitanteDAO.obtenerSolicitanteById(3);
        getSolicitante3.agregarCreditoPersonal(3000000, 5, 16, COLONES, "PAGO EXTRAORDINARIO CASA");//no califica
        getSolicitante3.agregarCreditoPersonal(10000, 10, 16, Moneda.DOLARES,"COMPRA CARRO"); 
        SolicitanteDAO.actualizarSolicitanteById(getSolicitante3);*/
        
    }

}
