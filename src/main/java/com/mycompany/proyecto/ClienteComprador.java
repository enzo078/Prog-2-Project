/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

/**
 *
 * @author Estudiante
 */
public class ClienteComprador extends Persona{
    private int telefono;
    private String direccion;
    
    public ClienteComprador(int dni, String nombre, String apellido, String direccion, int telefono) {
        super(dni, nombre, apellido);
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
//Getter and Setter

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
