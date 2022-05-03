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

    private static TipoCredito tipo= TipoCredito.HIPOTECARIOTERRENO;

    public CreditoHipotecarioTerreno() {
    }

    public CreditoHipotecarioTerreno(double pMonto, int pPlazoMeses, double pInteresAnual, Moneda pMoneda) throws Exception {
        super(tipo, pMonto, pPlazoMeses, pInteresAnual, pMoneda);
        
        amortizacionFrancesa();
    }
    
    public void mostrarAmortizacion(){
        
         ArrayList<double[]> info =  amortizacionFrancesa();
        
        for (int i=0; i<info.size(); i++){
           System.out.println(Arrays.toString(info.get(i)));
        }
    }
    
    /**
     * Función para calcular el costo del avaluo en préstamos hipotecarios
     * @return evaluo
     */
    public double costoAvaluo(){ 
        
        super.setEvaluo(super.monto*super.porcentajeEvaluo);
            
        return super.getEvaluo();
      
    }
    /**
     * Función para calcular el costo de la formalización de préstamos
     * @return formalizacion
     */
    public double costoFormalizacion(){

        super.formalizacion = super.monto*0.0075;
  
        return formalizacion;
    }
    /**
     * Función para calcular el moto total de los prestamos
     * @return monto final del prestamo
     */
    public double calculoFinal(){

        montoFinal= monto+costoAvaluo()+costoFormalizacion()+costoHonorarios();
           
        return montoFinal;
    }
  
    
}
