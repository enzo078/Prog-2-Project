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
    private String estado;
    private Empleado empleado;
    private Material material;
    
    
//Constructor
    public Compra(String fecha, ClienteComprador cliente, String estado, Empleado empleado, Material material) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.estado = estado;
        this.empleado = empleado;
        this.material = material;
    }
    
    public Compra(){
        
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Compra{" + "fecha=" + fecha + ", cliente=" + cliente + ", estado=" + estado + ", empleado=" + empleado + ", material=" + material + '}';
    }

    
}
