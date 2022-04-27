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
        Solicitante sol = new Solicitante(301881098, "Emilio", "Loria", "Vargas", 500000, 450000, 84934434, "marchena.froyd@gmail.com", "Cartago", "Paraiso", "Paraiso","Contiguo a la cruz roja");
        try {
            //SolicitanteDAO.guardarSolicitante(sol);
            //SolicitanteDAO.eliminarSolicitanteById(301881098);
            for(Solicitante data : SolicitanteDAO.obtenerListadoSolicitantes()){
                System.out.println(data.toString());
            }
            MainView vw = new MainView();
            MainController sC = new MainController(vw);
            vw.setVisible(true);
            
        } catch ( DAOException | IOException | ClassNotFoundException daoE) {
            System.out.println(daoE.getMessage());
        } catch (ExceptionInInitializerError ex) {
            System.out.println(ex.getMessage());
        }
    }
}
