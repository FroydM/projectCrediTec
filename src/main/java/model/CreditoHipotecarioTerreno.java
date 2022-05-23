/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Melanie and Froyd
 */
public class CreditoHipotecarioTerreno extends Credito {

    public CreditoHipotecarioTerreno() {
    }

    public CreditoHipotecarioTerreno(double pMonto, int pPlazoMeses, double pInteresAnual, Moneda pMoneda){
        super(TipoCredito.HIPOTECARIOTERRENO, pMonto, pPlazoMeses, pInteresAnual, pMoneda,TipoTasa.TASA_INDEXADA);
        
    }
    
    @Override
    public ArrayList<double[]> mostrarAmortizacion(){
        
        ArrayList<double[]> info =  amortizacionFrancesa();
        return info;
   
    }
    
    /**
     * Función para calcular el costo de la formalización de préstamos
     * @return formalizacion
     */
    @Override
    public double costoFormalizacion(){

        super.formalizacion = super.monto*0.0075;
  
        return formalizacion;
    }
    /**
     * Función para calcular el moto total de los prestamos
     * @return monto final del prestamo
     */
    @Override
    public double calculoMontoFinal(){

        montoFinal= monto+costoAvaluo()+costoFormalizacion()+costoHonorarios();
           
        return montoFinal;
    }
  
    
}
