/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

/**
 *
 * @author Estudiante
 */
public class Persona {
    private int dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private int telefono;


//Constructor
    public Persona(int dni, String nombre, String apellido){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }    
    
    public Persona(){
        
    }
    
    
//Getter and Setter
    public int getDni (){
        return dni;
    }
    
    public void setDni (int dni){
        this.dni = dni;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getApellido(){
        return apellido;
    }
    
    public void setApellido(String apellido){
        this.apellido = apellido;
    }  

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
