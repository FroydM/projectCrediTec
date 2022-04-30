
package model;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Melanie and Froyd
 */
public class Credito {
    private String id;
    private TipoCredito tipo;
    private double monto;
    private double montoFinal;
    private int plazo; //por qué double?
    private Moneda moneda;
    private Estado estado;
    private LocalDate fechaSolicitud;
    private double evaluo;
    private double formalizacion;//LO CAMBIE 
    private double honorario;
    private double interesAnual;
    private double porcentajeInteres;

    
    private final double porcentajeEvaluo = 0.0065;
    private final double honorarioMinimo = 60500;
    private int auxid=0;
    
    /**
     * Constructor de objetos tipo Credito vacío.
     */
    public Credito(){
      
    }  
    /**
     * Constructor de objetos tipo Credito.
     * @param pTipo, indica el tipo de crédito solicitado.
     * @param pMonto, indica el monto total del crédito solicitado.
     * @param pPlazoMeses, indica el plazo en término de meses.
     * @param pInteresAnual, indica el monto de interes en el año
     * @param pMoneda, indica la moneda en que se solicitó el crédito.
     * @throws java.lang.Exception
     */
    public Credito (TipoCredito pTipo, double pMonto,int pPlazoMeses, double pInteresAnual, Moneda pMoneda) throws Exception{
        
        this.tipo = pTipo;
        this.monto = pMonto;
        this.plazo = pPlazoMeses;
        this.interesAnual = pInteresAnual;
        this.moneda = pMoneda;
        this.fechaSolicitud = LocalDate.now();
        
        this.id = "CRE000"+auxid;
        auxid+=1;
    }
    /**
     * Función para calcular el costo del avaluo en préstamos hipotecarios
     * @return evaluo
     */
    public double costoAvaluo(){   
        if(tipo == TipoCredito.HIPOTECARIO ){
            evaluo= monto*porcentajeEvaluo;
            
            return evaluo;
        }else{
            return 0;
        }    
    }
    /**
     * Función para calcular el costo de la formalización de préstamos
     * @return formalizacion
     */
    public double costoFormalizacion(){
        if (tipo == TipoCredito.HIPOTECARIO){
            formalizacion = monto*0.0075;
          
        }else{
            formalizacion = monto*0.03;
        }
        
        return formalizacion;
    }
    /**
     * Función para calcular los honorarios del prestamo
     * @return honorarios
     */
    public double costoHonorarios(){
       
        if(monto>3025000 && monto<11000000){
            honorario = monto*0.02;
            return honorario;
        }
        if (monto > 11000000  && monto <= 16500000){
            honorario = monto*0.015;
            return honorario;
        }
        if (monto > 16500000 && monto <= 33000000){
            honorario = monto*0.0125;
            return honorario;
        }
        if(monto > 33000000){
            honorario = monto*0.01;
            return honorario;
        }
       return honorarioMinimo; 
    } 
    /**
     * Función para calcular el moto total de los prestamos
     * @return monto final del prestamo
     */
    public double calculoMontoFinal(){
        if (tipo == TipoCredito.PRENDARIO){
            double costoFormalizacion = costoFormalizacion();
            double costoHonorarios = costoHonorarios();
            
            montoFinal= monto+costoFormalizacion+costoHonorarios;
            
            return montoFinal;
        }
       return 0; 
    }
    /**
     * Función para calcular el monto de amortizacion con el estilo americano
     * @return amortizacionList, lista con el calculo de amorización.
     */
    public ArrayList amortizacionAmericana(){
        
        ArrayList<double[]> amortizacionList = new ArrayList<> ();

        double numeroCuota=1;
              
        double amortizacion = calculoMontoFinal();
        double cuotaInteresMensual= interesAnual*montoFinal;
        double montoCuota=cuotaInteresMensual; 
        double totalIntereses=0;

        for (int i=0;  i<plazo; i++){
            
            if (i<plazo-1){
                double amortizacionAmericana [] ={numeroCuota,montoCuota,cuotaInteresMensual,0,montoFinal};
                
                amortizacionList.add(amortizacionAmericana);
                totalIntereses+= cuotaInteresMensual;

            }else{
                montoCuota+=amortizacion;

                double amortizacionAmericana [] ={numeroCuota,montoCuota,cuotaInteresMensual,montoFinal,0};
                
                amortizacionList.add(amortizacionAmericana);
                
                totalIntereses+= cuotaInteresMensual;
            }
            
            numeroCuota+=1;
        }    

        return amortizacionList;
        
    }

    public TipoCredito getTipo() {
        return tipo;
    }    
    
}
