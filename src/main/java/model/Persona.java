/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Melanie and Froyd
 */
public class Persona implements Serializable{
    private int cedula;
    private String nombre;
    private String priApellido;
    private String segApellido;
    private double salarioBrutoMensual;
    private double salarioLiquido;
    
    /**
     * Crear el objeto de la persona
     * @param cedula Numero de identificacion de la persona
     * @param nombre Primer y segundo nombre de la persona
     * @param priApellido Apellido parterno de la persona
     * @param segApellido Apellido materno de la persona
     * @param salarioBrutoMensual  Salario bruto que gana al mes
     * @param salarioLiquido Salario liquido que obtiene al mes 
     */
    public Persona(int cedula, String nombre, String priApellido, String segApellido, double salarioBrutoMensual, double salarioLiquido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.priApellido = priApellido;
        this.segApellido = segApellido;
        this.salarioBrutoMensual = salarioBrutoMensual;
        this.salarioLiquido = salarioLiquido;
    }

    public Persona() {
        this.cedula = 0;
        this.nombre = "";
        this.priApellido = "";
        this.segApellido = "";
        this.salarioBrutoMensual = 0;
        this.salarioLiquido = 0;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPriApellido() {
        return priApellido;
    }

    public void setPriApellido(String priApellido) {
        this.priApellido = priApellido;
    }

    public String getSegApellido() {
        return segApellido;
    }

    public void setSegApellido(String segApellido) {
        this.segApellido = segApellido;
    }

    public double getSalarioBrutoMensual() {
        return salarioBrutoMensual;
    }

    public void setSalarioBrutoMensual(double salarioBrutoMensual) {
        this.salarioBrutoMensual = salarioBrutoMensual;
    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }
    
    @Override
    public String toString() {
        String msg = "Cedula: " + getCedula() + "\n";
        msg += "Nombre: " + getNombre() + "\n";
        msg += "Apellidos: " + getPriApellido() + " " + getSegApellido() + "\n";
        msg += "Salario bruto mensual: " + getSalarioBrutoMensual() + "\n";
        msg += "Salario liquido mensual: " + getSalarioLiquido() + "\n";
        return msg;
    }
    
    
}
