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
    private double salario;
    
    
    public CreditoPersonal(double pSalario, String pRazonCredito, double pMonto, int pPlazoMeses, double pInteresAnual, Moneda pMoneda) throws Exception {
        super(TipoCredito.PERSONAL, pMonto, pPlazoMeses, pInteresAnual, pMoneda );
        
        this.salario = pSalario;
    }
    
    public boolean verificarSalario(){
        int pNumeroCuota=1;
        
        double primeraCuota= calculoCuotaAlemana(pNumeroCuota);
        double salarioMinimo = primeraCuota+(primeraCuota*0.1);
        
        return salarioMinimo>primeraCuota;
    }
    @Override
    public double calculoMontoFinal(){
        
        montoFinal=monto+ costoFormalizacion();
        
        return montoFinal;
    }
    
    public void mostrarAmortizacion(){
        
         ArrayList<double[]> info =   amortizacionAlemana();
        
        for (int i=0; i<info.size(); i++){
           System.out.println(Arrays.toString(info.get(i)));
        }
    }

    public String getRazonCredito() {
        return razonCredito;
    }

    public void setRazonCredito(String razonCredito) {
        this.razonCredito = razonCredito;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
