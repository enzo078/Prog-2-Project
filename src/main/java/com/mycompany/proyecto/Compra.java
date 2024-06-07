/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

/**
 *
 * @author Estudiante
 */
public class Compra {
    private String fecha;
    private ClienteComprador cliente;
    private boolean estado;
    private Empleado empleado;
    
    
//Constructor
    public Compra(String fecha, ClienteComprador cliente, boolean estado, Empleado empleado) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.estado = estado;
        this.empleado = empleado;
    }


//Getter and Setter
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ClienteComprador getCliente() {
        return cliente;
    }

    public void setCliente(ClienteComprador cliente) {
        this.cliente = cliente;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

}
