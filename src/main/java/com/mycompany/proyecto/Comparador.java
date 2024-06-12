/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import java.util.Comparator;

/**
 *
 * @author enzor
 */
public class Comparador implements Comparator<ClienteComprador>{
    @Override
    public int compare(ClienteComprador e1, ClienteComprador e2) {
        return Integer.compare(e2.getCant(), e1.getCant());
    }
}
