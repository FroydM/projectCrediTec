/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Melanie and Froyd
 */
public class CreditoPrendario extends Credito {
    private String prenda;
    private double valorPrenda;
    
    private static TipoCredito tipo= TipoCredito.PRENDARIO;

    public CreditoPrendario(String prenda, double valorPrenda, double pInteresAnual, double pMonto, int pPlazoMeses, Moneda pMoneda) throws Exception {
        super(tipo, pMonto, pPlazoMeses,pInteresAnual, pMoneda);
        this.prenda = prenda;
        this.valorPrenda = valorPrenda;

    }
    
    public boolean verificarPrenda(){
        double calculoPrenda = (calculoMontoFinal()*0.85)/1;
        
        return getValorPrenda()> calculoPrenda;
    }
    
    /**
     * Función para calcular el moto total de los prestamos
     * @return monto final del prestamo
     */
    public double calculoMontoFinal(){
          
        montoFinal= monto+costoFormalizacion()+costoHonorarios();
            
        return montoFinal;
    }   
    
    public void mostrarAmortizacion(){
        
         ArrayList<double[]> info =  amortizacionAmericana();
        
        for (int i=0; i<info.size(); i++){
           System.out.println(Arrays.toString(info.get(i)));
        }
    }
       
    public double getValorPrenda() {
        return valorPrenda;
    }
    
    
}
