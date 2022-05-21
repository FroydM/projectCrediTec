package com.mycompany.projectcreditec;

import controller.MainController;
import controller.SolicitanteController;
import dao.SolicitanteDAO;
import java.io.IOException;
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
            
           MainView vw = new MainView();
           MainController sC = new MainController(vw);
           vw.setVisible(true);
           PdfApi newPDf = new PdfApi("prueba.pdf");
        try {
           // Solicitante newSolicitante = new Solicitante(123, "Froyd", "Marchena", "Loria", 750000, 700000, 84934434, "marchena.froyd@gmail.com", "Cartago", "Paraiso", "Paraiso", "En una casa");
            //SolicitanteDAO.guardarSolicitante(newSolicitante);
            //System.out.println(newSolicitante.creditosSolicitados.size());
            //Solicitante getSolicitante = SolicitanteDAO.obtenerSolicitanteById(123);
            //getSolicitante.agregarCreditoHipotecarioTerreno(300000, 36, 6, Moneda.DOLARES, TipoTasa.TASA_INDEXADA);
            //SolicitanteDAO.actualizarSolicitanteById(getSolicitante);
            //getSolicitante = SolicitanteDAO.obtenerSolicitanteById(123);
            //System.out.println(getSolicitante.creditosSolicitados.size());
        } catch (Exception e) {
                System.out.println(e.getMessage());
        }

           //System.out.println(services.TasaEfectivaDolares.conectarTED());
    }
}
