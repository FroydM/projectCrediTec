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
public class CreditoPersonal extends Credito {
    private String razonCredito;
    
    public CreditoPersonal(String pRazonCredito, double pMonto, int pPlazoMeses, double pInteresAnual, Moneda pMoneda,double salario){
        super(TipoCredito.PERSONAL, pMonto, pPlazoMeses, pInteresAnual, pMoneda,TipoTasa.TASA_FIJA);
        this.razonCredito = pRazonCredito;
    }
    
    public boolean verificarSalario(double salario){
        int pNumeroCuota=1;
        
        double primeraCuota= calculoCuotaAlemana(pNumeroCuota);
        double salarioMinimo = primeraCuota+(primeraCuota*0.1);
        
        System.out.println("Salario:"+ salario+ "Salario minimo:"+salarioMinimo+ "cuota:" + primeraCuota);
        return salarioMinimo<=salario;
    }
    @Override
    public double calculoMontoFinal(){
        
        montoFinal=monto+ costoFormalizacion();
        
        return montoFinal;
    }
    
    @Override
    public ArrayList<double[]> mostrarAmortizacion(){
        
         ArrayList<double[]> info =   amortizacionAlemana();

        return info;
    }

    public String getRazonCredito() {
        return razonCredito;
    }

    public void setRazonCredito(String razonCredito) {
        this.razonCredito = razonCredito;
    }
}
