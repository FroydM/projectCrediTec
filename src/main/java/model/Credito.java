
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Melanie and Froyd
 */
abstract public class Credito implements Serializable{
    
    private String id;
    private TipoCredito tipo;
    protected double monto;
    protected double montoFinal;
    private int plazo; //por qué double?
    private Moneda moneda;
    private double ingresoFamiliar;
    private Estado estado  = Estado.RECHAZADO;
    private LocalDate fechaSolicitud;
    private double evaluo;
    protected double formalizacion;//LO CAMBIE 
    private double honorario;
    private double interesAnual;
    private double porcentajeInteres;
    private TipoTasa tipoTasa;
    protected final double porcentajeEvaluo = 0.0065;
    private final double honorarioMinimo = 60500;
    static private int auxid = 0;
    
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
    public Credito (TipoCredito pTipo, double pMonto,int pPlazoMeses, double pInteresAnual, Moneda pMoneda,TipoTasa tasa) {
        
        this.tipo = pTipo;
        this.monto = pMonto;
        this.plazo = pPlazoMeses;
        this.interesAnual = pInteresAnual/100;
        this.moneda = pMoneda;
        this.fechaSolicitud = LocalDate.now();
        this.tipoTasa = tasa;
        this.id = "CRE000"+auxid;
        auxid+=1;
    }
    
    abstract public ArrayList<double[]> mostrarAmortizacion();
    
    abstract public double calculoMontoFinal();
    
    /**
     * Función para calcular el costo de la formalización de préstamos
     * @return formalizacion
     */
    public double costoFormalizacion(){
        
        formalizacion = monto*0.03;

        return formalizacion;
    }
    
    /**
     * Función para calcular el costo del avaluo en préstamos hipotecarios
     * @return evaluo
     */
    public double costoAvaluo(){ 
        
        setEvaluo(monto*porcentajeEvaluo);
            
        return getEvaluo();
      
    }
    
    /**
     * Función para calcular los honorarios del prestamo
     * @return honorarios
     */
    public double costoHonorarios(){
        double calculoHonorario=0;
        
        honorario = monto*0.02;
        
        if(honorario<60500){             
            return honorarioMinimo;
        }

        if(honorario>60500 && monto<=11000000 ){
            calculoHonorario+= monto*0.02;
        } 
              
        if(monto>11000000 ){
             calculoHonorario+= 11000000*0.02;   
        }        
       
        if (monto >11000000 && monto <= 16500000){
            calculoHonorario+= (monto-11000000)*0.015; 
        }
        
        if(monto>16500000 ){
             calculoHonorario+= (16500000-11000000)*0.015;  
        }  
        
        if (monto >16500000|| monto >= 33000000){
            calculoHonorario+= (monto-16500000)*0.0125;
           
        }
        if(monto > 33000000){
            calculoHonorario+= (monto-33000000)*0.01;
            
        }
        honorario=calculoHonorario;
        
       return honorario; 
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
    /**
     * Función para calcular el monto de amortizacion con el estilo Francés
     * @return amortizacionList, lista con el calculo de amorización.
     */
    public ArrayList amortizacionFrancesa(){
        ArrayList<double[]> amortizacionList = new ArrayList<> ();
        
        double deuda= calculoMontoFinal();
        double montoCuota= calculoCuotaFrancesa();
        int numeroCuota=1;
        
        for (int i=0;  i<plazo; i++){
            
            double amortizacionFrancesa [] ={numeroCuota,montoCuota,calculoInteresHipotecario(numeroCuota),calculoAmortizacionHipotecaria(numeroCuota),deuda};
            
            amortizacionList.add(amortizacionFrancesa);
            
            deuda-=montoCuota;
            numeroCuota+=1; 
        }
        return amortizacionList;
        
    }
    
    /**
     * Función para calcular el monto de amortizacion con el estilo Alemán
     * @return amortizacionList, lista con el calculo de amorización.
     */
    public ArrayList amortizacionAlemana(){
        ArrayList<double[]> amortizacionList = new ArrayList<>();
        
        double deuda= calculoMontoFinal();
        double montoAmortizacion= calculoAmortizacionAleman();
        System.out.println("cuota amortizació: "+Math.round(montoAmortizacion) );
        double montoCuota=0;
        int numeroCuota=1;
        
        for (int i=0;  i<plazo; i++){
            montoCuota=calculoCuotaAlemana(numeroCuota);
            
            double amortizacionAlemana [] ={numeroCuota,montoCuota,calculoInteresAleman(numeroCuota),montoAmortizacion,deuda};
            
            amortizacionList.add(amortizacionAlemana);
            
            deuda-=montoAmortizacion;
            numeroCuota+=1; 
        }

        return amortizacionList;
    }

    /**
     * Función para calcular la cuota fija en el sistema frances
     * @return monto de la cuota
     */
    public double calculoCuotaFrancesa(){

        double montoPrestamo=calculoMontoFinal();
        double cuotaFija;
        double calculo=(1+interesAnual);
        
        double calculo2= Math.pow(calculo, (-plazo));

        cuotaFija=(montoPrestamo*interesAnual)/(1-(calculo2));
        
        return Math.round(cuotaFija);
    }
    /**
     * Función para calcular el monto correspondiente al interes del prestamo hipotecario
     * @param pCuota, el numero de la cuota en el que se desea consultar
     * @return el monto del interes
     */
    public double calculoInteresHipotecario(int pCuota){
        double cuoataMensual= calculoCuotaFrancesa();
        int cuotas= pCuota;
        double cuotainteresMensual=0;
        
        double calculo=(1+interesAnual);
        double calculo2= (plazo+1)-cuotas;

        double calculo3= Math.pow(calculo, calculo2);

        cuotainteresMensual= Math.round((cuoataMensual*(1-(1/calculo3)))) ;
        
        return Math.round(cuotainteresMensual);
    }
    /**
     * Función para calcular el monto correspondiente a la amortización del prestamo hipotecario
     * @param pCuota, el numero de la cuota en el que se desea consultar
     * @return el monto de la amortización 
     */
    public double calculoAmortizacionHipotecaria(int pCuota){
        double cuoataMensual= calculoCuotaFrancesa();
        int cuotas=pCuota;
        double cuotaAmortizacionMensual=0;
        
        double calculo=(1+interesAnual);
        double calculo2= (plazo+1)-cuotas;
        double calculo3= Math.pow(calculo, calculo2);
        
        cuotaAmortizacionMensual = (cuoataMensual/calculo3) ;

        return Math.round(cuotaAmortizacionMensual);
    }
    
    /*Función para calcular la cuota fija correspondiente a la amortización del prestamo personal
     *@return el monto de la amortización 
     */
    public double calculoAmortizacionAleman(){
        double monto = calculoMontoFinal();
        double cuotaFija = monto/plazo;
     
        return Math.round(cuotaFija);
    }
    
    /*Función para calcular el monto de interes en cada cuota del prestamo personal
     *@return el monto de la cuota de interes 
     */
    public double calculoInteresAleman(int pNumeroCuota){
        double monto = calculoMontoFinal();
        double cuotaInteres = (plazo-pNumeroCuota+1)*((monto*interesAnual)/plazo);
        
        return Math.round(cuotaInteres);
    }
    
    /*Función para calcular el monto total de la cuota en cada cuota del prestamo personal
     *@return el monto de la cuota 
     */
    public double calculoCuotaAlemana(int pNumeroCuota){
        double monto=calculoMontoFinal();
        double cuotaTotal=0;
        double cuotaAnterior;
        
        if(pNumeroCuota< plazo && pNumeroCuota==1 ){
            
           cuotaTotal = (monto/plazo)+(interesAnual*monto);
            System.out.println("interes:" +interesAnual);
           
           return cuotaTotal;
              
        }
        if (pNumeroCuota<= plazo && pNumeroCuota>1 ){
            cuotaAnterior = (monto/plazo)+interesAnual*monto;
            
            for (int i=1; i<pNumeroCuota;i++){
                
               // System.out.println(cuotaAnterior);
                cuotaTotal = cuotaAnterior-interesAnual*(monto/plazo);
                
                cuotaAnterior=cuotaTotal;
            }    
        }
        
        return cuotaTotal;
    }

    /**
     * Metodos accesores
     * @return 
     */
    public TipoCredito getTipo() {
        return tipo;
    } 

    public double getMonto() {
        return monto;
    }

    public double getEvaluo() {
        return evaluo;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setEvaluo(double evaluo) {
        this.evaluo = evaluo;
    }

    public TipoTasa getTipoTasa() {
        return tipoTasa;
    }

    public void setTipoTasa(TipoTasa tipoTasa) {
        this.tipoTasa = tipoTasa;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getId() {
        return id;
    }

    public double getMontoFinal() {
        return montoFinal;
    }

    public int getPlazo() {
        return plazo;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public double getIngresoFamiliar() {
        return ingresoFamiliar;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public double getFormalizacion() {
        return formalizacion;
    }

    public double getHonorario() {
        return honorario;
    }

    public double getInteresAnual() {
        return interesAnual;
    }

    public double getPorcentajeInteres() {
        return porcentajeInteres;
    }

    public double getPorcentajeEvaluo() {
        return porcentajeEvaluo;
    }

    public double getHonorarioMinimo() {
        return honorarioMinimo;
    }

    public static int getAuxid() {
        return auxid;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setId(String id) {
        this.id = "CRE000"+id;
    }
    
    
    
    @Override
    public String toString() {
        String msg= "Monto inicial: "  + getMonto()+"\n";
        msg += "Monto final: " + getMontoFinal()+"\n";
        msg += "Tipo de credito: " + tipo.toString()+"\n";
        msg += "Estado: " + estado.toString()+"\n";
        return msg;
    }
   
    
}
