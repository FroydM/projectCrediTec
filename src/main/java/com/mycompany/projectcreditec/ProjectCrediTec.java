package com.mycompany.projectcreditec;

import controller.MainController;
import controller.SolicitanteController;
import dao.SolicitanteDAO;
import java.io.IOException;
import model.Solicitante;
import services.MailingApi;
import services.PdfApi;
import system.DAOException;
import view.MainView;
import view.SolicitanteView;

/**
 *
 * @author march
 */
public class ProjectCrediTec {

    public static void main(String[] args) {
            
            MainView vw = new MainView();
            MainController sC = new MainController(vw);
            vw.setVisible(true);
            try {
                //PdfApi pdf = new PdfApi("C:\\Users\\Public\\Documents\\example.pdf");
        } catch (Exception e) {
                System.out.println(e.getMessage());
        }
            
    }
}
