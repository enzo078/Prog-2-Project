/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

/**
 *
 * @author Estudiante
 */
public class ClienteProveedor extends Persona{
    private int cuit;
    private String ciudad;
    private int telefono;
    private String direccion;
    
//Constructor
    public ClienteProveedor(int dni, String nombre, String apellido, String direccion, int telefono, int cuit, String ciudad){
        super(dni, nombre, apellido);
        this.cuit = cuit;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.direccion = direccion;
    }
  
    
//Getter and Setter
    public int getCuit(){
        return cuit;
    }
    
    public void setCuit(int cuit){
        this.cuit = cuit;
    }
    
    public String getCiudad(){
        return ciudad;
    }
    
    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
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
