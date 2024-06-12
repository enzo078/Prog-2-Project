/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Estudiante
 */
public class Empleado extends Persona {
    private int nroDeLegajo;
    private String fecha;
    private int telefono;
    private String direccion;
    
//Constructor    
    public Empleado (int dni, String nombre, String apellido, String direccion, int telefono, int nroDeLegajo, String fecha){
        super (dni, nombre, apellido);
        this.nroDeLegajo = nroDeLegajo;
        this.fecha = fecha;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    public Empleado(){
    }
    
//Getter and Setter
    public int getNroDeLegajo() {
        return nroDeLegajo;
    }

    public void setNroDeLegajo(int nroDeLegajo) {
        this.nroDeLegajo = nroDeLegajo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    
}
