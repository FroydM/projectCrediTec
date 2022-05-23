/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Madelen
 */
public class CreditoFiduciario extends Credito {
    
    private ArrayList<Fiador> fiadores;
  
    public CreditoFiduciario(double pMonto, int pPlazoMeses, double pInteresAnual, Moneda pMoneda){

        super(TipoCredito.FIDUCIARIO, pMonto, pPlazoMeses, pInteresAnual, pMoneda, TipoTasa.TASA_FIJA);

        
       fiadores= new ArrayList<>();

    }
    public CreditoFiduciario(double pMonto, int pPlazoMeses, double pInteresAnual, Moneda pMoneda,ArrayList<Fiador> fiadores){
        super(TipoCredito.FIDUCIARIO, pMonto, pPlazoMeses, pInteresAnual, pMoneda, TipoTasa.TASA_FIJA);
        
        
       this.fiadores= fiadores;

    }
    @Override
    public double calculoMontoFinal(){
        
        montoFinal=monto+ costoFormalizacion();
        
        return montoFinal;
    }
    
    public void agregarFiador(int cedula, String nombre, String priApellido, String segApellido, double salarioBrutoMensual, double salarioLiquido){
        
        Fiador fiador = new Fiador(cedula,nombre,priApellido,segApellido,salarioBrutoMensual,salarioLiquido);
        
        fiadores.add(fiador);
    }
    
    public boolean verificarSalarioBruto(){
        double salarioBrutoTotal=0;
        double salarioBrutoMinimo= monto*0.2;
        
        for (int i=0; i<fiadores.size();i++){
            salarioBrutoTotal+= fiadores.get(i).getSalarioBrutoMensual();
        }
        
        if(salarioBrutoTotal>salarioBrutoMinimo){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean verificarSalarioLiquido(){
        double cuotaPrestamo=calculoCuotaFrancesa();
        double salarioLiquido=0;
        
        for (int i=0; i<fiadores.size();i++){
             salarioLiquido+= fiadores.get(i).getSalarioLiquido();
             
            if(salarioLiquido>cuotaPrestamo){
                 
            }else{
                return false;
            }  
        }
        return true;
    }
    
    @Override
    public ArrayList<double[]> mostrarAmortizacion(){
        
        ArrayList<double[]> info =  amortizacionFrancesa();
        return info;
        
        
    }
}
