/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Melanie and Froyd
 */
public class Solicitante extends Persona{
    final private String[] direccion;
    private int numTelefono;
    private String email;
    public ArrayList<Credito> creditosSolicitados;
    
    public Solicitante(int cedula, String nombre, String priApellido, String segApellido, double salarioBrutoMensual,
            double salarioLiquido,int numTelefono, String email, String provincia,String canton,String distrito, String otrasReferencias) {
        super(cedula, nombre, priApellido, segApellido, salarioBrutoMensual, salarioLiquido);
        this.direccion = new String[4];
        this.direccion[0] = provincia;
        this.direccion[1] = canton;
        this.direccion[2] = distrito;
        this.direccion[3] = otrasReferencias;
        this.numTelefono = numTelefono;
        this.email = email;
        this.creditosSolicitados = new ArrayList<>();
    }
    
    public Solicitante(){
        this.direccion = new String[4];
    }

    public void agregarCreditoPersonal(double monto,int plazo,double interezAnual,Moneda moneda,String razonCredito) {
        CreditoPersonal newCredito = new CreditoPersonal(razonCredito,monto, plazo, interezAnual, moneda);
        if (newCredito.verificarSalario(getSalarioLiquido())) {
            creditosSolicitados.add(newCredito);
        }else {
            JOptionPane.showMessageDialog(null, "El salario no califica");
        }
    }
    
    public void agregarCreditoPrendario(double monto,int plazo,double interezAnual,Moneda moneda,String prenda,double valorPrenda) {
        CreditoPrendario newCredito = new CreditoPrendario(prenda,valorPrenda,monto, interezAnual, plazo, moneda);
        if(newCredito.verificarPrenda()) {
            creditosSolicitados.add(newCredito);
        }
    }
    
    public void agregarCreditoFiduciario(double monto,int plazo,double interezAnual,Moneda moneda, ArrayList<Fiador> fiadores){
        CreditoFiduciario newCredito = new CreditoFiduciario(monto, plazo, interezAnual, moneda);
        for(Fiador fiador : fiadores) {
            newCredito.agregarFiador(fiador.getCedula(), fiador.getNombre(), fiador.getPriApellido(), fiador.getSegApellido(), fiador.getSalarioBrutoMensual(), fiador.getSalarioLiquido());
        }
        if(newCredito.verificarSalarioBruto() && newCredito.verificarSalarioLiquido()) {
            creditosSolicitados.add(newCredito);
        }
    }
    
    public void agregarCreditoHipotecarioTerreno(double monto,int plazo,double interezAnual,Moneda moneda) {
        CreditoHipotecarioTerreno newCredito = new CreditoHipotecarioTerreno(monto, plazo, interezAnual, moneda);
        creditosSolicitados.add(newCredito);
    }
    
    public void agregarCreditoHipotecarioVivienda(double monto,int plazo,double interezAnual,Moneda moneda,double ingresoFamiliar,char bono){
        CreditoHipotecarioVivienda newCredito = new CreditoHipotecarioVivienda(ingresoFamiliar, bono, monto, plazo, interezAnual, moneda);
        creditosSolicitados.add(newCredito);
    }
    
    
    public String getDireccion() {
        return direccion[0]+", "+direccion[1]+", "+direccion[2]+", "+direccion[3];
    }

    public void setDireccion(String provincia,String canton,String distrito, String otrasReferencias) {
        this.direccion[0] = provincia;
        this.direccion[1] = canton;
        this.direccion[2] = distrito;
        this.direccion[3] = otrasReferencias;
    }

    public int getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(int numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        String msg = super.toString();
        msg += "Telefono: " + getNumTelefono() + "\n";
        msg += "Email: " + getEmail() + "\n";
        msg += "Residencia: " + getDireccion() + "\n";
        return msg;
    }
/*
    public void agregarCreditoPersonal(double monto, int plazo, double interes, Moneda moneda) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
    
    
    
}
