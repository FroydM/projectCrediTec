/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Melanie and Froyd
 */
public class Solicitante extends Persona{
    final private String[] direccion;
    private int numTelefono;
    private String email;

    
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
    
    
    
}
