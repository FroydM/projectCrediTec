/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Melanie and Froyd
 */
public class CreditoHipotecarioVivienda extends Credito {
    
    double ingresoFamiliar;
    char vivienda;
    double bono=0;
    
    private static TipoCredito tipo= TipoCredito.HIPOTECARIOVIVIENDA;

    public CreditoHipotecarioVivienda() {
    }

    public CreditoHipotecarioVivienda(double pIngresoFamiliar, char pVivienda, double pMonto, int pPlazoMeses, double pInteresAnual, Moneda pMoneda) throws Exception {
        super(tipo, pMonto, pPlazoMeses, pInteresAnual, pMoneda );
        
        this.ingresoFamiliar = pIngresoFamiliar;
        this.vivienda = pVivienda;
        
        //solicitarAmortizacionFrancesa();
    }
    
    public double costoAvaluo(){ 
        
        super.setEvaluo(super.getMonto()*super.porcentajeEvaluo);
            
        return super.getEvaluo();
      
    }

    @Override
    public double costoFormalizacion(){

        super.formalizacion = super.monto*0.0075;
  
        return formalizacion;
    } 
    
    /**
     * Función para calcular el moto total de los prestamos
     * @return monto final del prestamo
     */
    public double calculoMontoFinal(){
        
        if (vivienda == 'S'){
            
            double bono = calcularBonoVivienda(); 
            
            monto-= bono;

            montoFinal= monto+costoAvaluo()+costoFormalizacion()+costoHonorarios();
            
            return montoFinal;
        }else{
            
            montoFinal= monto+costoAvaluo()+costoFormalizacion()+costoHonorarios();
            
            return montoFinal;
        }
            
    }

    public double calcularBonoVivienda(){
        double bono=0;
        
                
        if (ingresoFamiliar <= 282753){
            bono= 7630000;
        }
        if (ingresoFamiliar>282753.5 || ingresoFamiliar<= 424129.5){
            bono= 7576000;
        }
        if(ingresoFamiliar>424129.5|| ingresoFamiliar<= 565506){
            bono=7523000;
        }
        if(ingresoFamiliar>565506 || ingresoFamiliar<= 706882.5){
            bono=7178000;
        }
        if(ingresoFamiliar>706882.5 || ingresoFamiliar<= 848259){
            bono=6834000;
        }
        if(ingresoFamiliar>848259 || ingresoFamiliar<= 989635.5){
            bono=6489000;
        }
        if(ingresoFamiliar>989635.5 || ingresoFamiliar<= 1131012){
            bono=6145000;
        }
        if(ingresoFamiliar>1131012 || ingresoFamiliar<= 1272388.5){
            bono=5801000;
        }
        if(ingresoFamiliar>1272388.5 || ingresoFamiliar<= 1413765){
            bono=5456000;
        }
        if(ingresoFamiliar>1413765 || ingresoFamiliar<= 155141.5){
            bono=5112000;
        }
        if(ingresoFamiliar>155141.5 || ingresoFamiliar<= 1696518){
            bono=4768000;
        }
       
        return bono;
    } 

}
