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
public class CreditoPrendario extends Credito {
    private String prenda;
    private double valorPrenda;
   

    public CreditoPrendario(String prenda, double valorPrenda, double pMonto,double pInteresAnual , int pPlazoMeses, Moneda pMoneda) {
        super(TipoCredito.PRENDARIO, pMonto, pPlazoMeses,pInteresAnual, pMoneda,TipoTasa.TASA_FIJA);

        this.prenda = prenda;
        this.valorPrenda = valorPrenda;
        if(verificarPrenda() && !((pMoneda == Moneda.COLONES &&(monto>30000000 || pPlazoMeses>84)) || (pMoneda== Moneda.DOLARES && (monto>45000 || pPlazoMeses>84)))){
            setEstado(Estado.PREAPROBADO);
        }

    }
    
    public boolean verificarPrenda(){
        double calculoPrenda = (calculoMontoFinal()*0.85)/1;
        
        return getValorPrenda()> calculoPrenda;
    }
    
    /**
     * Función para calcular el moto total de los prestamos
     * @return monto final del prestamo
     */
    @Override
    public double calculoMontoFinal(){
          
        montoFinal= monto+costoFormalizacion()+costoHonorarios();
            
        return montoFinal;
    }   
    
    @Override
    public ArrayList<double[]> mostrarAmortizacion(){
        
         ArrayList<double[]> info =  amortizacionAmericana();
       
        return info;
    }
       
    public double getValorPrenda() {
        return valorPrenda;
    }
    
    @Override
    public String toString(){
        String msg = super.toString();
        msg += "Prenda: "+ prenda+"\n";
        msg += "Valor de prenda: "+valorPrenda +"\n";
        return msg;
    }
    
}
