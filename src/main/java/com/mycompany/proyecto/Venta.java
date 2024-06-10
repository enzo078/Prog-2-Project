/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

/**
 *
 * @author Estudiante
 */
public class Venta {
    private ClienteProveedor proveedor;
    private String fecha;
    private String estado;
    private Material material;

    public Venta(ClienteProveedor proveedor,Material material, String fecha, String estado) {
        this.proveedor = proveedor;
        this.fecha = fecha;
        this.estado = estado;
        this.material = material;
    }

    public Venta() {
    }

    public ClienteProveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(ClienteProveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
    
    
}
