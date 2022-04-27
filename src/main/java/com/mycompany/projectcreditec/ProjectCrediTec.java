package com.mycompany.projectcreditec;

import controller.MainController;
import controller.SolicitanteController;
import dao.SolicitanteDAO;
import java.io.IOException;
import model.Solicitante;
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
    }
}
