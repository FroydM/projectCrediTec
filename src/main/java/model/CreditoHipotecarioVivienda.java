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

    public CreditoHipotecarioVivienda() {
    }
    /**
     * 
     * @param pIngresoFamiliar
     * @param pVivienda
     * @param pMonto
     * @param pPlazoMeses
     * @param pInteresAnual
     * @param pMoneda
     * @throws Exception 
     */
    public CreditoHipotecarioVivienda(double pIngresoFamiliar, char pVivienda, double pMonto, int pPlazoMeses, double pInteresAnual, Moneda pMoneda){
        super(TipoCredito.HIPOTECARIOVIVIENDA, pMonto, pPlazoMeses, pInteresAnual, pMoneda ,TipoTasa.TASA_INDEXADA);
        this.ingresoFamiliar = pIngresoFamiliar;
        this.vivienda = pVivienda;
        if(!((pMoneda == Moneda.COLONES &&(monto>150000000 || pPlazoMeses>360)) || (pMoneda== Moneda.DOLARES && (monto>230000 || pPlazoMeses>360)))){
            setEstado(Estado.PREAPROBADO);
        }
    }
    
    @Override
    public double costoFormalizacion(){

        super.formalizacion = (monto-bono)*0.0075;
  
        return formalizacion;
    } 
    
    /**
     * Función para calcular el moto total de los prestamos
     * @return monto final del prestamo
     */
    @Override
    public double calculoMontoFinal(){
        
        if (vivienda == 'S'){

            montoFinal= (monto-bono)+costoAvaluo()+costoFormalizacion()+costoHonorarios();
            System.out.println("Costo avaluo"+costoAvaluo());
            System.out.println("Costo formalizacion: " +costoFormalizacion());
            System.out.println("horonario: " + costoHonorarios());
            return montoFinal;
        }else{
            montoFinal= monto+costoAvaluo()+costoFormalizacion()+costoHonorarios();
            
            return montoFinal;
        }
            
    }
    @Override
    public double costoAvaluo(){
        return ((monto-bono)*0.0065);
    }

    public double calcularBonoVivienda(){
        double bono=0;
        
                
        if (ingresoFamiliar <= 282753){
            bono= 7630000;
        }else if (ingresoFamiliar>282753.5 && ingresoFamiliar<= 424129.5){
            bono= 7576000;
        }
        else if(ingresoFamiliar>424129.5 && ingresoFamiliar<= 565506){
            bono=7523000;
        }
        else if(ingresoFamiliar>565506 && ingresoFamiliar<= 706882.5){
            bono=7178000;
        }
        else if(ingresoFamiliar>706882.5 && ingresoFamiliar<= 848259){
            bono=6834000;
        }
        else if(ingresoFamiliar>848259 && ingresoFamiliar<= 989635.5){
            bono=6489000;
        }
        else if(ingresoFamiliar>989635.5 && ingresoFamiliar<= 1131012){
            bono=6145000;
        }
        else if(ingresoFamiliar>1131012 && ingresoFamiliar<= 1272388.5){
            bono=5801000;
        }
        else if(ingresoFamiliar>1272388.5 && ingresoFamiliar<= 1413765){
            bono=5456000;
        }
        else if(ingresoFamiliar>1413765 && ingresoFamiliar<= 155141.5){
            bono=5112000;
        }
        else if(ingresoFamiliar>155141.5 && ingresoFamiliar<= 1696518){
            bono=4768000;
        }
       
        return bono;
    } 

    @Override
    public ArrayList<double[]> mostrarAmortizacion() {
        ArrayList<double[]> info =  amortizacionFrancesa();
        return info;
    }
    @Override
    public String toString(){
        String msg = super.toString();
        msg += "Ingreso familiar: " + getIngresoFamiliar()+"\n";
        msg += "SolicitaBono: " + vivienda+"\n";
        return msg;
    }
}
