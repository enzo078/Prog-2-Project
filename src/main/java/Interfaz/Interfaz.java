/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import com.mycompany.proyecto.Empleado;
import com.mycompany.proyecto.ClienteComprador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.mycompany.proyecto.ClienteProveedor;
import com.mycompany.proyecto.Comparador;
import com.mycompany.proyecto.Compra;
import com.mycompany.proyecto.Venta;
import com.mycompany.proyecto.Material;
import com.mycompany.proyecto.Persona;
import com.toedter.calendar.JDateChooser;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Array;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TableView;
import java.util.Date;
import java.util.Iterator;
import javax.swing.table.TableModel;

/**
 *
 * @author enzor
 */
public class Interfaz extends javax.swing.JFrame {

    private InicioSesion panel1;
    int xMouse, yMouse;
    
    
    public Interfaz() {
        initComponents();
        leerArchivo();
        actualizarTabla();
        actualizarTablaCompradores();
        actualizarTablaMateriales();
        actualizarTablaProveedores();
        llenarDatosCompra();
        llenarDatosVenta();
        mostrarComboBoxEmpleado();
        mostrarComboBoxComprador();
        mostrarComboBoxProveedor();
        
        
        
    }
    
    public void setPanel1(InicioSesion panel1){
        this.panel1 = panel1;
    }
    
    ArrayList <Empleado> listaEmpleados = new ArrayList<>();
    ArrayList <Persona> listaPersonas = new ArrayList<>();
    ArrayList <Material> listaMateriales = new ArrayList<>();
    ArrayList<Compra> listaCompras = new ArrayList<>();
    ArrayList<Venta> listaVentas = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    DefaultComboBoxModel defaul = new DefaultComboBoxModel();
    
    public void cargarArchivo() {
    try {
        File archivo = new File("Backup.txt");
        FileWriter fArchivo = new FileWriter(archivo);
        BufferedWriter bArchivo = new BufferedWriter(fArchivo);
        bArchivo.append("*\n");
        
       
        
        for (Empleado empleado : listaEmpleados) {
            bArchivo.append(empleado.getNombre()).append("\n");
            bArchivo.append(empleado.getApellido()).append("\n");
            bArchivo.append(Integer.toString(empleado.getDni())).append("\n");
            bArchivo.append(empleado.getDireccion()).append("\n");
            bArchivo.append(Integer.toString(empleado.getTelefono())).append("\n");
            bArchivo.append(Integer.toString(empleado.getNroDeLegajo())).append("\n");
            bArchivo.append(empleado.getFecha()).append("\n");
            if(listaEmpleados.indexOf(empleado) != listaEmpleados.size()-1)
            bArchivo.append("*\n");
        }

        if(!listaPersonas.isEmpty()){
        bArchivo.append("Personas\n");
        
        for (Persona cliente : listaPersonas) {
            if (cliente instanceof ClienteComprador) {
                bArchivo.append("Comprador\n");
                bArchivo.append(cliente.getNombre()).append("\n");
                bArchivo.append(cliente.getApellido()).append("\n");
                bArchivo.append(Integer.toString(cliente.getDni())).append("\n");
                bArchivo.append(Integer.toString(((ClienteComprador)cliente).getCant())).append("\n");
                bArchivo.append(((ClienteComprador) cliente).getDireccion()).append("\n");
                bArchivo.append(Integer.toString(((ClienteComprador) cliente).getTelefono())).append("\n");
                if(listaPersonas.indexOf(cliente) != listaPersonas.size()-1)
                bArchivo.append("*\n");
            }
   
        
      
            else if (cliente instanceof ClienteProveedor) {
                bArchivo.append("Proveedor\n");
                bArchivo.append(cliente.getNombre()).append("\n");
                bArchivo.append(cliente.getApellido()).append("\n");
                bArchivo.append(Integer.toString(cliente.getDni())).append("\n");
                bArchivo.append(Integer.toString(((ClienteProveedor) cliente).getCuit())).append("\n");
                bArchivo.append(((ClienteProveedor) cliente).getDireccion()).append("\n");
                bArchivo.append(Integer.toString(((ClienteProveedor) cliente).getTelefono())).append("\n");
                bArchivo.append(((ClienteProveedor) cliente).getCiudad()).append("\n");
                if(listaPersonas.indexOf(cliente) != listaPersonas.size()-1)
                bArchivo.append("*\n");
            }}
        }
        

        if(!listaMateriales.isEmpty()){
        bArchivo.append("Materiales\n");
        for (Material material : listaMateriales) {
            bArchivo.append(material.getNombre()).append("\n");
            bArchivo.append(material.getDescripcion()).append("\n");
            bArchivo.append(material.getMedida()).append("\n");
            bArchivo.append(Integer.toString(material.getStock())).append("\n");
            bArchivo.append(Double.toString(material.getPrecioCompra())).append("\n");
            bArchivo.append(Double.toString(material.getPrecioVenta())).append("\n");
            if(listaMateriales.indexOf(material) != listaMateriales.size()-1)
            bArchivo.append("*\n");
        }
        }

        if(!listaCompras.isEmpty()){
        bArchivo.append("Compras\n");
        for (Compra compra : listaCompras) {
            bArchivo.append(compra.getEstado()).append("\n");
            bArchivo.append(compra.getFecha()).append("\n");
            
            Empleado empleado = compra.getEmpleado();
            bArchivo.append(empleado.getNombre()).append("\n");
            bArchivo.append(empleado.getApellido()).append("\n");
            bArchivo.append(Integer.toString(empleado.getDni())).append("\n");
            bArchivo.append(empleado.getDireccion()).append("\n");
            bArchivo.append(Integer.toString(empleado.getTelefono())).append("\n");
            bArchivo.append(Integer.toString(empleado.getNroDeLegajo())).append("\n");
            bArchivo.append((empleado.getFecha())+"\n");
            
            ClienteComprador cliente = compra.getCliente();
            bArchivo.append(cliente.getNombre()).append("\n");
            bArchivo.append(cliente.getApellido()).append("\n");
            bArchivo.append(Integer.toString(cliente.getDni())).append("\n");
            bArchivo.append(cliente.getDireccion()).append("\n");
            bArchivo.append(Integer.toString(cliente.getTelefono())).append("\n");
            
            Material material = compra.getMaterial();
            bArchivo.append(material.getNombre()).append("\n");
            bArchivo.append(material.getDescripcion()).append("\n");
            bArchivo.append(material.getMedida()).append("\n");
            bArchivo.append(Integer.toString(material.getStock())).append("\n");
            bArchivo.append(Double.toString(material.getPrecioCompra())).append("\n");
            bArchivo.append(Double.toString(material.getPrecioVenta())).append("\n");
            if(listaCompras.indexOf(compra) != listaCompras.size()-1)
            bArchivo.append("*\n");
        }}

        if(!listaVentas.isEmpty()){
        bArchivo.append("Ventas\n");
        for (Venta venta : listaVentas) {
            bArchivo.append(venta.getEstado()).append("\n");
            bArchivo.append(venta.getFecha()).append("\n");
            bArchivo.append(Double.toString(venta.getCantidad())).append("\n");
            
            ClienteProveedor clienteVentas = venta.getProveedor();
            bArchivo.append(clienteVentas.getNombre()).append("\n");
            bArchivo.append(clienteVentas.getApellido()).append("\n");
            bArchivo.append(Integer.toString(clienteVentas.getDni())).append("\n");
            bArchivo.append(Integer.toString(clienteVentas.getCuit())).append("\n");
            bArchivo.append(clienteVentas.getDireccion()).append("\n");
            bArchivo.append(Integer.toString(clienteVentas.getTelefono())).append("\n");
            bArchivo.append(clienteVentas.getCiudad()).append("\n");
            
            Material materialVentas = venta.getMaterial();
            bArchivo.append(materialVentas.getNombre()).append("\n");
            bArchivo.append(materialVentas.getDescripcion()).append("\n");
            bArchivo.append(materialVentas.getMedida()).append("\n");
            bArchivo.append(Integer.toString(materialVentas.getStock())).append("\n");
            bArchivo.append(Double.toString(materialVentas.getPrecioCompra())).append("\n");
            bArchivo.append(Double.toString(materialVentas.getPrecioVenta())).append("\n");
            if(listaVentas.indexOf(venta) != listaVentas.size()-1)
            bArchivo.append("*\n");
        }}

        bArchivo.append("Fin\n");
        bArchivo.close();

    } catch (FileNotFoundException ex) {
        JOptionPane.showMessageDialog(null, "Error al cargar archivo", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, "Error inesperado", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    public void mostrarComboBoxEmpleado(){
       
        DefaultComboBoxModel<String> modeloEmpleado = new DefaultComboBoxModel<>();
    for (Empleado empleado : listaEmpleados) {
        modeloEmpleado.addElement(empleado.getNombre());
    }
    boxModifEmpleado.setModel(modeloEmpleado);
    }  
    
    public void mostrarComboBoxProveedor(){
       
        DefaultComboBoxModel<String> modeloProveedor = new DefaultComboBoxModel<>();
    for (Persona proveedor : listaPersonas) {
        if (proveedor instanceof ClienteProveedor) {
            modeloProveedor.addElement(proveedor.getNombre());
        }
    }
    boxProveedor.setModel(modeloProveedor);
    }
    
    public void mostrarComboBoxComprador(){
        
         DefaultComboBoxModel<String> modeloComprador = new DefaultComboBoxModel<>();
    for (Persona cliente : listaPersonas) {
        if (cliente instanceof ClienteComprador) {
            modeloComprador.addElement(cliente.getNombre());
        }
    }
    boxComprador.setModel(modeloComprador);
    }
    
    public void leerArchivo() {
    SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");

    try {
        File archivo = new File("Backup.txt");
        FileReader rArchivo = new FileReader(archivo);
        BufferedReader bArchivo = new BufferedReader(rArchivo);

        String valorActual;
        valorActual = bArchivo.readLine();

        // Leer empleados
        if (valorActual != null) {
            while (valorActual.equals("*")) {
                Empleado empleado = new Empleado();
                
                empleado.setNombre(bArchivo.readLine());
                empleado.setApellido(bArchivo.readLine());
                empleado.setDni(Integer.parseInt(bArchivo.readLine()));  // Asegurarse que esta línea contenga solo números
                empleado.setDireccion(bArchivo.readLine());
                empleado.setTelefono(Integer.parseInt(bArchivo.readLine()));  // Asegurarse que esta línea contenga solo números
                empleado.setNroDeLegajo(Integer.parseInt(bArchivo.readLine()));  // Asegurarse que esta línea contenga solo números
                empleado.setFecha(bArchivo.readLine());
                listaEmpleados.add(empleado);
                
                valorActual = bArchivo.readLine();
            }

            // Leer cliente comprador
            while (valorActual.equals("Personas") || valorActual.equals("*")) {
                valorActual = bArchivo.readLine();
                if (valorActual.equals("Comprador")) {
                    ClienteComprador cliente = new ClienteComprador();
                    
                    cliente.setNombre(bArchivo.readLine());
                    cliente.setApellido(bArchivo.readLine());
                    cliente.setDni(Integer.parseInt(bArchivo.readLine()));  // Asegurarse que esta línea contenga solo números
                    cliente.setCant(Integer.parseInt(bArchivo.readLine()));  // Asegurarse que esta línea contenga solo números
                    cliente.setDireccion(bArchivo.readLine());
                    cliente.setTelefono(Integer.parseInt(bArchivo.readLine()));  // Asegurarse que esta línea contenga solo números
                    listaPersonas.add(cliente);
                    
                    valorActual = bArchivo.readLine();
                } else if (valorActual.equals("Proveedor")) {
                    // Leer cliente proveedor
                    ClienteProveedor cliente = new ClienteProveedor();
                    
                    cliente.setNombre(bArchivo.readLine());
                    cliente.setApellido(bArchivo.readLine());
                    cliente.setDni(Integer.parseInt(bArchivo.readLine()));  // Asegurarse que esta línea contenga solo números
                    cliente.setCuit(Integer.parseInt(bArchivo.readLine()));  // Asegurarse que esta línea contenga solo números
                    cliente.setDireccion(bArchivo.readLine());
                    cliente.setTelefono(Integer.parseInt(bArchivo.readLine()));  // Asegurarse que esta línea contenga solo números
                    cliente.setCiudad(bArchivo.readLine());
                    listaPersonas.add(cliente);
                    
                    valorActual = bArchivo.readLine();
                }
            }

            // Leer materiales
            while (valorActual.equals("Materiales") || valorActual.equals("*")) {
                Material material = new Material();
                
                material.setNombre(bArchivo.readLine());
                material.setDescripcion(bArchivo.readLine());
                material.setMedida(bArchivo.readLine());
                material.setStock(Integer.parseInt(bArchivo.readLine()));  // Asegurarse que esta línea contenga solo números
                material.setPrecioCompra((float) Double.parseDouble(bArchivo.readLine()));  // Asegurarse que esta línea contenga solo números
                material.setPrecioVenta((float) Double.parseDouble(bArchivo.readLine()));  // Asegurarse que esta línea contenga solo números
                listaMateriales.add(material);
                
                valorActual = bArchivo.readLine();
            }

            // Leer compras
            while (valorActual.equals("Compras") || valorActual.equals("*")) {
                Compra compra = new Compra();
                Empleado empleado = new Empleado();
                ClienteComprador cliente = new ClienteComprador();
                Material material = new Material();
                
                compra.setEstado(bArchivo.readLine());
                compra.setFecha(bArchivo.readLine());
                
                empleado.setNombre(bArchivo.readLine());
                empleado.setApellido(bArchivo.readLine());
                empleado.setDni(Integer.parseInt(bArchivo.readLine()));  // Asegurarse que esta línea contenga solo números
                empleado.setDireccion(bArchivo.readLine());
                empleado.setTelefono(Integer.parseInt(bArchivo.readLine()));  // Asegurarse que esta línea contenga solo números
                empleado.setNroDeLegajo(Integer.parseInt(bArchivo.readLine()));  // Asegurarse que esta línea contenga solo números
                empleado.setFecha(bArchivo.readLine());
                compra.setEmpleado(empleado);
                
                cliente.setNombre(bArchivo.readLine());
                cliente.setApellido(bArchivo.readLine());
                cliente.setDni(Integer.parseInt(bArchivo.readLine()));  // Asegurarse que esta línea contenga solo números
                cliente.setDireccion(bArchivo.readLine());
                cliente.setTelefono(Integer.parseInt(bArchivo.readLine()));  // Asegurarse que esta línea contenga solo números
                compra.setCliente(cliente);
                
                material.setNombre(bArchivo.readLine());
                material.setDescripcion(bArchivo.readLine());
                material.setMedida(bArchivo.readLine());
                material.setStock(Integer.parseInt(bArchivo.readLine()));  // Asegurarse que esta línea contenga solo números
                material.setPrecioCompra((float) Double.parseDouble(bArchivo.readLine()));  // Asegurarse que esta línea contenga solo números
                material.setPrecioVenta((float) Double.parseDouble(bArchivo.readLine()));  // Asegurarse que esta línea contenga solo números
                compra.setMaterial(material);
                
                listaCompras.add(compra);
                
                valorActual = bArchivo.readLine();
            }

            // Leer ventas
            while (valorActual.equals("Ventas") || valorActual.equals("*")) {
                Venta venta = new Venta();
                ClienteProveedor clienteVentas = new ClienteProveedor();
                Material materialVentas = new Material();
                
                venta.setEstado(bArchivo.readLine());
                venta.setFecha(bArchivo.readLine());
                venta.setCantidad((float) Double.parseDouble(bArchivo.readLine()));
                
                clienteVentas.setNombre(bArchivo.readLine());
                clienteVentas.setApellido(bArchivo.readLine());
                clienteVentas.setDni(Integer.parseInt(bArchivo.readLine()));  // Asegurarse que esta línea contenga solo números
                clienteVentas.setCuit((int) Integer.parseInt(bArchivo.readLine()));  // Asegurarse que esta línea contenga solo números
                clienteVentas.setDireccion(bArchivo.readLine());
                clienteVentas.setTelefono(Integer.parseInt(bArchivo.readLine()));  // Asegurarse que esta línea contenga solo números
                clienteVentas.setCiudad(bArchivo.readLine());
                venta.setProveedor(clienteVentas);
                
                materialVentas.setNombre(bArchivo.readLine());
                materialVentas.setDescripcion(bArchivo.readLine());
                materialVentas.setMedida(bArchivo.readLine());
                materialVentas.setStock(Integer.parseInt(bArchivo.readLine()));  // Asegurarse que esta línea contenga solo números
                materialVentas.setPrecioCompra((float) Double.parseDouble(bArchivo.readLine()));  // Asegurarse que esta línea contenga solo números
                materialVentas.setPrecioVenta((float) Double.parseDouble(bArchivo.readLine()));  // Asegurarse que esta línea contenga solo números
                venta.setMaterial(materialVentas);
                
                listaVentas.add(venta);
                
                valorActual = bArchivo.readLine();
            }
        }
        bArchivo.close();
    } catch (FileNotFoundException ex) {
        JOptionPane.showMessageDialog(null, "Hubo un error en la carga de datos", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Error al cargar un número", "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();  // Añadir rastreo de pila para depuración
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Hubo un error inesperado", "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();  // Añadir rastreo de pila para depuración
    }
}

    

    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        estadoCompra = new javax.swing.ButtonGroup();
        estadoVenta = new javax.swing.ButtonGroup();
        bg = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        panelSalir = new javax.swing.JPanel();
        salir = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botonMateriales = new javax.swing.JButton();
        botonProveedores = new javax.swing.JButton();
        botonEmpleados = new javax.swing.JButton();
        botonCompradores = new javax.swing.JButton();
        botonCompras = new javax.swing.JButton();
        botonVentas = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        panelExit = new javax.swing.JPanel();
        extBttn = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        pintarPanel = new javax.swing.JPanel();
        empleadosPanel = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        botonCargarEmpleado = new javax.swing.JButton();
        direEmpleado = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        apellidoEmpleado = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        nombreEmpleado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        dniEmpleado = new javax.swing.JSpinner();
        teleEmpleado = new javax.swing.JSpinner();
        legajoEmpleado = new javax.swing.JSpinner();
        fechaEmpleado = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        nombreEmpleado1 = new javax.swing.JTextField();
        teleEmpleado1 = new javax.swing.JSpinner();
        jLabel31 = new javax.swing.JLabel();
        apellidoEmpleado1 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        direEmpleado1 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        actualizarEmpleado = new javax.swing.JButton();
        eliminarEmpleado = new javax.swing.JButton();
        fechaEmpleado1 = new com.toedter.calendar.JDateChooser();
        boxModifEmpleado = new javax.swing.JComboBox<>();
        compradoresPanel = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCompradores1 = new javax.swing.JTable();
        nombreComprador = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        apellidoComprador = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        direComprador = new javax.swing.JTextField();
        cargarCompradores = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        dniComprador = new javax.swing.JSpinner();
        telComprador = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        nombreComprador1 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        telComprador1 = new javax.swing.JSpinner();
        apellidoComprador1 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        direComprador1 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        eliminarComprador = new javax.swing.JButton();
        actualizarComprador = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        boxComprador = new javax.swing.JComboBox<>();
        proveedoresPanel = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        cargarProveedores = new javax.swing.JButton();
        direProveedor = new javax.swing.JTextField();
        ciudadProveedor = new javax.swing.JTextField();
        apellidoProveedor = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        nombreProveedor = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaProveedores = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        dniProveedor = new javax.swing.JSpinner();
        telProveedor = new javax.swing.JSpinner();
        cuitProveedor = new javax.swing.JSpinner();
        jPanel8 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        nombreProveedor1 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        apellidoProveedor1 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        telProveedor1 = new javax.swing.JSpinner();
        jLabel49 = new javax.swing.JLabel();
        ciudadProveedor1 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        direProveedor1 = new javax.swing.JTextField();
        eliminarProveedor = new javax.swing.JButton();
        actualizarProveedor = new javax.swing.JButton();
        boxProveedor = new javax.swing.JComboBox<>();
        comprasPanel = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        boxCompraClientes = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        boxCompraEmpleado = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        cargarCompra = new javax.swing.JButton();
        fechaCompra = new com.toedter.calendar.JDateChooser();
        jLabel51 = new javax.swing.JLabel();
        boxMaterialCompra = new javax.swing.JComboBox<>();
        botonPagado = new javax.swing.JRadioButton();
        botonNoPagado = new javax.swing.JRadioButton();
        ventasPanel = new javax.swing.JPanel();
        boxMaterialVenta = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        boxProveedorVenta = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        ventaDespachada = new javax.swing.JRadioButton();
        ventaNoDespachada = new javax.swing.JRadioButton();
        cargarVenta = new javax.swing.JButton();
        fechaVenta = new com.toedter.calendar.JDateChooser();
        cantidadMaterial = new javax.swing.JSpinner();
        jLabel57 = new javax.swing.JLabel();
        materialesPanel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        nombreMaterial = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        desMaterial = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cargarMateriales = new javax.swing.JButton();
        stockMaterial = new javax.swing.JSpinner();
        compraMaterial = new javax.swing.JSpinner();
        ventaMaterial = new javax.swing.JSpinner();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaMateriales = new javax.swing.JTable();
        boxMaterialMedida = new javax.swing.JComboBox<>();
        listarPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaListarEmpleados = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaListarClientes = new javax.swing.JTable();
        listarEmpleados = new javax.swing.JButton();
        listarClientes = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaListarClientesAlf = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tablaListarVentas = new javax.swing.JTable();
        listarFecha1 = new com.toedter.calendar.JDateChooser();
        listarFecha2 = new com.toedter.calendar.JDateChooser();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        mostrarTotal = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(51, 51, 51));
        bg.setForeground(new java.awt.Color(51, 51, 51));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu.setBackground(new java.awt.Color(51, 51, 51));
        menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        menu.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 152, 240, 10));

        jSeparator3.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        menu.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 10, 120));

        panelSalir.setBackground(new java.awt.Color(153, 153, 153));
        panelSalir.setForeground(new java.awt.Color(241, 116, 9));

        salir.setBackground(new java.awt.Color(241, 116, 9));
        salir.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        salir.setForeground(new java.awt.Color(0, 0, 0));
        salir.setText("             SALIR");
        salir.setToolTipText("");
        salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelSalirLayout = new javax.swing.GroupLayout(panelSalir);
        panelSalir.setLayout(panelSalirLayout);
        panelSalirLayout.setHorizontalGroup(
            panelSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelSalirLayout.setVerticalGroup(
            panelSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(salir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        menu.add(panelSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 620, 120, -1));

        jLabel2.setBackground(new java.awt.Color(241, 116, 9));
        jLabel2.setForeground(new java.awt.Color(241, 116, 9));
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\enzor\\Downloads\\Logo (1).png")); // NOI18N
        menu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 170, 130));

        botonMateriales.setText("Materiales");
        botonMateriales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMaterialesActionPerformed(evt);
            }
        });
        menu.add(botonMateriales, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, 200, 50));

        botonProveedores.setText("Proveedores");
        botonProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonProveedoresActionPerformed(evt);
            }
        });
        menu.add(botonProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 200, 50));

        botonEmpleados.setText("Empleados");
        botonEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEmpleadosActionPerformed(evt);
            }
        });
        menu.add(botonEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 200, 50));

        botonCompradores.setText("Compradores");
        botonCompradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCompradoresActionPerformed(evt);
            }
        });
        menu.add(botonCompradores, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 200, 50));

        botonCompras.setText("Compras");
        botonCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonComprasActionPerformed(evt);
            }
        });
        menu.add(botonCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 200, 50));

        botonVentas.setText("Ventas");
        botonVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVentasActionPerformed(evt);
            }
        });
        menu.add(botonVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 200, 50));

        jButton1.setText("Listar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        menu.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 540, 80, 40));

        bg.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 720));

        panelExit.setBackground(new java.awt.Color(51, 51, 51));

        extBttn.setBackground(new java.awt.Color(51, 51, 51));
        extBttn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        extBttn.setForeground(new java.awt.Color(255, 255, 255));
        extBttn.setText("  X");
        extBttn.setToolTipText("");
        extBttn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        extBttn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        extBttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                extBttnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                extBttnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                extBttnMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelExitLayout = new javax.swing.GroupLayout(panelExit);
        panelExit.setLayout(panelExitLayout);
        panelExitLayout.setHorizontalGroup(
            panelExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(extBttn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );
        panelExitLayout.setVerticalGroup(
            panelExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelExitLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(extBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bg.add(panelExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 0, 30, 30));

        header.setBackground(new java.awt.Color(51, 51, 51));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                headerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 780, 30));

        pintarPanel.setLayout(new java.awt.CardLayout());

        jPanel4.setForeground(new java.awt.Color(102, 102, 102));

        botonCargarEmpleado.setText("CARGAR");
        botonCargarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCargarEmpleadoActionPerformed(evt);
            }
        });

        jLabel4.setText("Direccion");

        jLabel3.setText("DNI");

        jLabel11.setText("Fecha Ingreso");

        jLabel12.setText("Nro. Legajo");

        jLabel5.setText("Apellido");

        jLabel13.setText("Telefono");

        jLabel1.setText("Nombre");

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "DNI", "Direccion", "Telefono", "Legajo", "Ingreso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaEmpleados);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addComponent(direEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel5)
                        .addComponent(nombreEmpleado)
                        .addComponent(apellidoEmpleado)
                        .addComponent(dniEmpleado))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(teleEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(legajoEmpleado)
                    .addComponent(fechaEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addComponent(botonCargarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(apellidoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel3))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(teleEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(legajoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(dniEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonCargarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(direEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(fechaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88))
        );

        empleadosPanel.addTab("Cargar", jPanel4);

        jLabel29.setText("Empleado");

        jLabel30.setText("Nombre");

        jLabel31.setText("Telefono");

        jLabel33.setText("Apellido");

        jLabel35.setText("Fecha Ingreso");

        jLabel36.setText("Direccion");

        actualizarEmpleado.setText("ACTUALIZAR");
        actualizarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarEmpleadoActionPerformed(evt);
            }
        });

        eliminarEmpleado.setText("ELIMINAR");
        eliminarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarEmpleadoActionPerformed(evt);
            }
        });

        boxModifEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxModifEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxModifEmpleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(413, Short.MAX_VALUE)
                .addComponent(actualizarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(eliminarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(boxModifEmpleado, javax.swing.GroupLayout.Alignment.LEADING, 0, 150, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(direEmpleado1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel33)
                                    .addComponent(nombreEmpleado1)
                                    .addComponent(apellidoEmpleado1))
                                .addComponent(jLabel36)))
                        .addGap(137, 137, 137)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel35)
                            .addComponent(jLabel31)
                            .addComponent(teleEmpleado1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(fechaEmpleado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxModifEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreEmpleado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(jLabel35))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(apellidoEmpleado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fechaEmpleado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(teleEmpleado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(157, 157, 157)
                        .addComponent(jLabel36)))
                .addGap(14, 14, 14)
                .addComponent(direEmpleado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actualizarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80))
        );

        empleadosPanel.addTab("Modificar", jPanel5);

        pintarPanel.add(empleadosPanel, "card3");

        tablaCompradores1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "DNI", "Direccion", "Telefono"
            }
        ));
        jScrollPane2.setViewportView(tablaCompradores1);

        jLabel6.setText("Nombre");

        jLabel7.setText("Apellido");

        jLabel9.setText("DNI");

        jLabel10.setText("Direccion");

        cargarCompradores.setText("CARGAR");
        cargarCompradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarCompradoresActionPerformed(evt);
            }
        });

        jLabel8.setText("Telefono");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(dniComprador)
                                .addComponent(direComprador, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nombreComprador, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(apellidoComprador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cargarCompradores, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(111, 111, 111))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 317, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(telComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreComprador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telComprador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(apellidoComprador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dniComprador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(direComprador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cargarCompradores, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        compradoresPanel.addTab("Carga", jPanel1);

        jLabel28.setText("Nombre");

        jLabel42.setText("Telefono");

        jLabel43.setText("Apellido");

        jLabel44.setText("Direccion");

        eliminarComprador.setText("ELIMINAR");
        eliminarComprador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarCompradorActionPerformed(evt);
            }
        });

        actualizarComprador.setText("ACTUALIZAR");
        actualizarComprador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarCompradorActionPerformed(evt);
            }
        });

        jLabel55.setText("Comprador");

        boxComprador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxComprador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxCompradorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(actualizarComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(eliminarComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel55)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel44)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(direComprador1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombreComprador1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(apellidoComprador1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(boxComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(162, 162, 162)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42)
                            .addComponent(telComprador1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(211, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel55)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxComprador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(jLabel42))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreComprador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(telComprador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(apellidoComprador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(direComprador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminarComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actualizarComprador, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70))
        );

        compradoresPanel.addTab("Modificar", jPanel2);

        pintarPanel.add(compradoresPanel, "card2");

        cargarProveedores.setText("CARGAR");
        cargarProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarProveedoresActionPerformed(evt);
            }
        });

        jLabel20.setText("Apellido");

        jLabel21.setText("DNI");

        jLabel22.setText("CUIT");

        jLabel23.setText("Ciudad");

        jLabel24.setText("Telefono");

        jLabel25.setText("Nombre");

        tablaProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "DNI", "Direccion", "Telefono", "Ciudad", "CUIT"
            }
        ));
        jScrollPane3.setViewportView(tablaProveedores);

        jLabel26.setText("Direccion");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel21)
                                    .addComponent(direProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel20)
                                    .addComponent(nombreProveedor)
                                    .addComponent(apellidoProveedor)
                                    .addComponent(dniProveedor))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel24)
                                    .addComponent(ciudadProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(telProveedor)
                                    .addComponent(cuitProveedor))
                                .addGap(8, 8, 8))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(cargarProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(apellidoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel21))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(telProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ciudadProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel22)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dniProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cuitProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cargarProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(direProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(88, 88, 88))
        );

        proveedoresPanel.addTab("Cargar", jPanel7);

        jLabel45.setText("Proveedor");

        jLabel46.setText("Nombre");

        jLabel47.setText("Apellido");

        jLabel48.setText("Telefono");

        jLabel49.setText("Ciudad");

        jLabel50.setText("Direccion");

        eliminarProveedor.setText("ELIMINAR");
        eliminarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarProveedorActionPerformed(evt);
            }
        });

        actualizarProveedor.setText("ACTUALIZAR");
        actualizarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarProveedorActionPerformed(evt);
            }
        });

        boxProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(eliminarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45)
                    .addComponent(jLabel50)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(actualizarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(direProveedor1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nombreProveedor1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(apellidoProveedor1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(104, 104, 104)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel49)
                                .addComponent(jLabel48)
                                .addComponent(ciudadProveedor1)
                                .addComponent(telProveedor1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(boxProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(254, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreProveedor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(apellidoProveedor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(telProveedor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ciudadProveedor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(66, 66, 66)
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(direProveedor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actualizarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(95, Short.MAX_VALUE))
        );

        proveedoresPanel.addTab("Modificar", jPanel8);

        pintarPanel.add(proveedoresPanel, "card4");

        jLabel32.setText("Fecha");

        jLabel34.setText("Cliente");

        jLabel37.setText("Estado de compra");

        jLabel27.setText("Empleado");

        cargarCompra.setText("CARGAR");
        cargarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarCompraActionPerformed(evt);
            }
        });

        jLabel51.setText("Material");

        estadoCompra.add(botonPagado);
        botonPagado.setText("Pagado");

        estadoCompra.add(botonNoPagado);
        botonNoPagado.setText("No Pagado");

        javax.swing.GroupLayout comprasPanelLayout = new javax.swing.GroupLayout(comprasPanel);
        comprasPanel.setLayout(comprasPanelLayout);
        comprasPanelLayout.setHorizontalGroup(
            comprasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, comprasPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cargarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
            .addGroup(comprasPanelLayout.createSequentialGroup()
                .addGroup(comprasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(comprasPanelLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(comprasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boxCompraClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fechaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(comprasPanelLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(comprasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(comprasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel37)
                                .addGroup(comprasPanelLayout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addComponent(jLabel34))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, comprasPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel32)
                                    .addGap(32, 32, 32)))
                            .addGroup(comprasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(botonPagado)
                                .addComponent(botonNoPagado)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 223, Short.MAX_VALUE)
                .addGroup(comprasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, comprasPanelLayout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(166, 166, 166))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, comprasPanelLayout.createSequentialGroup()
                        .addComponent(jLabel51)
                        .addGap(191, 191, 191))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, comprasPanelLayout.createSequentialGroup()
                        .addGroup(comprasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(boxMaterialCompra, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boxCompraEmpleado, 0, 200, Short.MAX_VALUE))
                        .addGap(102, 102, 102))))
        );
        comprasPanelLayout.setVerticalGroup(
            comprasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(comprasPanelLayout.createSequentialGroup()
                .addGroup(comprasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(comprasPanelLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxCompraEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(402, 402, 402))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, comprasPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addGroup(comprasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(jLabel51))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(comprasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxCompraClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boxMaterialCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonPagado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonNoPagado)
                        .addGap(164, 164, 164)))
                .addComponent(cargarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pintarPanel.add(comprasPanel, "card7");

        jLabel38.setText("Proveedor");

        jLabel39.setText("Fecha");

        jLabel40.setText("Material");

        jLabel41.setText("Estado de venta");

        estadoVenta.add(ventaDespachada);
        ventaDespachada.setText("Despachado");

        estadoVenta.add(ventaNoDespachada);
        ventaNoDespachada.setText("No despachado");

        cargarVenta.setText("CARGAR");
        cargarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarVentaActionPerformed(evt);
            }
        });

        jLabel57.setText("Cantidad de materiales");

        javax.swing.GroupLayout ventasPanelLayout = new javax.swing.GroupLayout(ventasPanel);
        ventasPanel.setLayout(ventasPanelLayout);
        ventasPanelLayout.setHorizontalGroup(
            ventasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventasPanelLayout.createSequentialGroup()
                .addGroup(ventasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ventasPanelLayout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jLabel41))
                    .addGroup(ventasPanelLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(ventasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ventaNoDespachada)
                            .addComponent(ventaDespachada))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventasPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(ventasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventasPanelLayout.createSequentialGroup()
                        .addComponent(cargarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventasPanelLayout.createSequentialGroup()
                        .addGroup(ventasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cantidadMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boxMaterialVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(159, 159, 159))))
            .addGroup(ventasPanelLayout.createSequentialGroup()
                .addGroup(ventasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ventasPanelLayout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jLabel38))
                    .addGroup(ventasPanelLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(ventasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fechaVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boxProveedorVenta, 0, 200, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addComponent(jLabel40)
                .addGap(235, 235, 235))
            .addGroup(ventasPanelLayout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 219, Short.MAX_VALUE)
                .addComponent(jLabel57)
                .addGap(192, 192, 192))
        );
        ventasPanelLayout.setVerticalGroup(
            ventasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventasPanelLayout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addGroup(ventasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ventasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxMaterialVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxProveedorVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(ventasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel39)
                    .addComponent(jLabel57))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ventasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidadMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ventaDespachada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ventaNoDespachada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addComponent(cargarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );

        pintarPanel.add(ventasPanel, "card6");

        jLabel14.setText("Nombre");

        jLabel15.setText("Descripcion");

        jLabel16.setText("Precio Compra");

        jLabel17.setText("Tipo de medida");

        jLabel18.setText("Stock");

        jLabel19.setText("Precio Venta");

        cargarMateriales.setText("CARGAR");
        cargarMateriales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarMaterialesActionPerformed(evt);
            }
        });

        tablaMateriales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Medida", "Stock", "Precio Compra", "Precio Venta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tablaMateriales);

        boxMaterialMedida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kilogramos", "Gramos", "Unidad" }));

        javax.swing.GroupLayout materialesPanelLayout = new javax.swing.GroupLayout(materialesPanel);
        materialesPanel.setLayout(materialesPanelLayout);
        materialesPanelLayout.setHorizontalGroup(
            materialesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(materialesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
            .addGroup(materialesPanelLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(materialesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(materialesPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cargarMateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85))
                    .addGroup(materialesPanelLayout.createSequentialGroup()
                        .addGroup(materialesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(materialesPanelLayout.createSequentialGroup()
                                .addGroup(materialesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(nombreMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(desMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel15))
                                .addGap(92, 92, 92)
                                .addGroup(materialesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel19)
                                    .addComponent(stockMaterial)
                                    .addComponent(compraMaterial)
                                    .addComponent(ventaMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(boxMaterialMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(195, Short.MAX_VALUE))))
        );
        materialesPanelLayout.setVerticalGroup(
            materialesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, materialesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addGroup(materialesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(materialesPanelLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(desMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel17))
                    .addGroup(materialesPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stockMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(compraMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ventaMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxMaterialMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(cargarMateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1194, 1194, 1194))
        );

        pintarPanel.add(materialesPanel, "card5");

        tablaListarEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "DNI", "Direccion", "Telefono", "Nro. Legajo"
            }
        ));
        jScrollPane5.setViewportView(tablaListarEmpleados);

        tablaListarClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "DNI", "Cantidad Compras"
            }
        ));
        jScrollPane6.setViewportView(tablaListarClientes);
        if (tablaListarClientes.getColumnModel().getColumnCount() > 0) {
            tablaListarClientes.getColumnModel().getColumn(2).setHeaderValue("DNI");
        }

        listarEmpleados.setText("Listar empleados en orden alfabetico");
        listarEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarEmpleadosActionPerformed(evt);
            }
        });

        listarClientes.setText("Listar clientes en orden alfabetico");
        listarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarClientesActionPerformed(evt);
            }
        });

        jButton2.setText("Listar clientes por cantidad de compras");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tablaListarClientesAlf.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "DNI"
            }
        ));
        jScrollPane7.setViewportView(tablaListarClientesAlf);
        if (tablaListarClientesAlf.getColumnModel().getColumnCount() > 0) {
            tablaListarClientesAlf.getColumnModel().getColumn(2).setHeaderValue("DNI");
        }

        jButton3.setText("Listar ventas");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tablaListarVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cliente", "Material", "Cantidad Materiales", "Fecha", "Estado"
            }
        ));
        jScrollPane8.setViewportView(tablaListarVentas);
        if (tablaListarVentas.getColumnModel().getColumnCount() > 0) {
            tablaListarVentas.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel52.setText("Desde:");

        jLabel53.setText("Hasta:");

        jLabel54.setText("Listar ventas en un determinado tiempo");

        jLabel56.setText("Total:");

        javax.swing.GroupLayout listarPanelLayout = new javax.swing.GroupLayout(listarPanel);
        listarPanel.setLayout(listarPanelLayout);
        listarPanelLayout.setHorizontalGroup(
            listarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listarPanelLayout.createSequentialGroup()
                .addGroup(listarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(listarPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(listarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5)
                            .addComponent(jScrollPane6)
                            .addGroup(listarPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel52)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(listarFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jLabel53)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(listarFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(jLabel56)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mostrarTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane8)))
                    .addGroup(listarPanelLayout.createSequentialGroup()
                        .addGroup(listarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(listarPanelLayout.createSequentialGroup()
                                .addGap(282, 282, 282)
                                .addComponent(listarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(listarPanelLayout.createSequentialGroup()
                                .addGap(270, 270, 270)
                                .addComponent(listarEmpleados)))
                        .addGap(0, 276, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listarPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel54)
                .addGap(275, 275, 275))
            .addGroup(listarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(listarPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane7)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listarPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(listarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listarPanelLayout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(269, 269, 269))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listarPanelLayout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(340, 340, 340))))))
        );
        listarPanelLayout.setVerticalGroup(
            listarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listarPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(listarEmpleados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(listarClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jLabel54)
                .addGap(18, 18, 18)
                .addGroup(listarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(listarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(mostrarTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel56))
                    .addGroup(listarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(listarFecha1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(listarFecha2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel53)
                    .addComponent(jLabel52))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(45, 45, 45))
        );

        pintarPanel.add(listarPanel, "card8");

        bg.add(pintarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 770, 690));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1078, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void headerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseClicked
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMouseClicked

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseClicked
        panel1.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_salirMouseClicked

    private void extBttnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_extBttnMouseEntered
        panelExit.setBackground(new Color(255,0,0));
    }//GEN-LAST:event_extBttnMouseEntered

    private void extBttnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_extBttnMouseExited
        panelExit.setBackground(new Color (51, 51, 51));
    }//GEN-LAST:event_extBttnMouseExited

    private void extBttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_extBttnMouseClicked
        System.exit(0);
    }//GEN-LAST:event_extBttnMouseClicked

    private void botonEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEmpleadosActionPerformed
        ShowTabbedPanel(empleadosPanel);
    }//GEN-LAST:event_botonEmpleadosActionPerformed

    private void cargarCompradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarCompradoresActionPerformed
        if (nombreComprador.getText().equals("") || 
            apellidoComprador.getText().equals("") || 
            (int)dniComprador.getValue() <= 0 || 
            direComprador.getText().equals("") || 
            (int)telComprador.getValue() <= 0){
            
            JOptionPane.showMessageDialog(pintarPanel, "Se cargaron mal los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            ClienteComprador aux = new ClienteComprador((int)dniComprador.getValue(), nombreComprador.getText(), apellidoComprador.getText(), direComprador.getText(), (int)telComprador.getValue() );
            listaPersonas.add(aux);
            nombreComprador.setText("");
            apellidoComprador.setText("");
            dniComprador.setValue(0);
            telComprador.setValue(0);
            direComprador.setText("");
            llenarDatosCompra();
            boxComprador.setModel(defaul);
            for (Persona clientes : listaPersonas){
                if (clientes instanceof ClienteComprador){
                 boxComprador.addItem(clientes.getNombre());
                
            }
            
        }
            actualizarTablaCompradores();
        
            cargarArchivo();
        }
        
    }//GEN-LAST:event_cargarCompradoresActionPerformed

    private void botonCargarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCargarEmpleadoActionPerformed
        if (nombreEmpleado.getText().equals("") || apellidoEmpleado.getText().equals("") || 
            (int)dniEmpleado.getValue() <= 0 || (int)teleEmpleado.getValue() <= 0 || 
            direEmpleado.getText().equals("") || 
            (int)legajoEmpleado.getValue() <= 0 || 
            fechaEmpleado.getDate() == null ){
             
            JOptionPane.showMessageDialog(pintarPanel, "Se cargaron mal los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            Empleado aux = new Empleado((int)dniEmpleado.getValue(), nombreEmpleado.getText(), apellidoEmpleado.getText(), direEmpleado.getText(), (int)teleEmpleado.getValue(),(int)legajoEmpleado.getValue() , fechaEmpleado.getDateFormatString());
            listaEmpleados.add(aux);
            nombreEmpleado.setText("");
            apellidoEmpleado.setText("");
            dniEmpleado.setValue(0);
            teleEmpleado.setValue(0);
            direEmpleado.setText("");
            legajoEmpleado.setValue(0);
            fechaEmpleado.setDate(null);

            
            llenarDatosCompra();
            actualizarTabla();
            boxModifEmpleado.setModel(defaul);
            for(Empleado empleado : listaEmpleados ){
                boxModifEmpleado.addItem(empleado.getNombre());
            }
            
            
            cargarArchivo();
        }
    }//GEN-LAST:event_botonCargarEmpleadoActionPerformed

    private void cargarProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarProveedoresActionPerformed
        if (nombreProveedor.getText().equals("") || 
        apellidoProveedor.getText().equals("") || 
        direProveedor.getText().equals("") || 
        ciudadProveedor.getText().equals("") || 
        (int)dniProveedor.getValue() <= 0 || 
        (int)cuitProveedor.getValue() <= 0 || 
        (int)telProveedor.getValue() <= 0) {
        
        JOptionPane.showMessageDialog(pintarPanel, "Se cargaron mal los datos", "Error", JOptionPane.ERROR_MESSAGE); 
    } else {
        ClienteProveedor aux = new ClienteProveedor((int)dniProveedor.getValue(), nombreProveedor.getText(), 
                                                     apellidoProveedor.getText(), ciudadProveedor.getText(), 
                                                     (int)cuitProveedor.getValue(), (int)telProveedor.getValue(), 
                                                     direProveedor.getText());
        listaPersonas.add(aux);
        nombreProveedor.setText("");
        apellidoProveedor.setText("");
        dniProveedor.setValue(0);
        telProveedor.setValue(0);
        direProveedor.setText("");
        cuitProveedor.setValue(0); 
        ciudadProveedor.setText("");
    }
        cargarArchivo();
        llenarDatosCompra();
        actualizarTablaProveedores();

        DefaultComboBoxModel<String> modeloProveedor = new DefaultComboBoxModel<>();
        for (Persona proveedor : listaPersonas) {
            if (proveedor instanceof ClienteProveedor) {
                modeloProveedor.addElement(proveedor.getNombre());
            }
        }
        boxProveedor.setModel(modeloProveedor);

    }//GEN-LAST:event_cargarProveedoresActionPerformed

    private void cargarMaterialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarMaterialesActionPerformed
        // Verificación de campos vacíos o valores no válidos
    if (nombreMaterial.getText().equals("") || 
        desMaterial.getText().equals("") || 
        boxMaterialMedida.getSelectedItem() == null || 
        (int)stockMaterial.getValue() <= 0 || 
        ((Number)ventaMaterial.getValue()).doubleValue() <= 0 || 
        ((Number)compraMaterial.getValue()).doubleValue() <= 0) {
        
        JOptionPane.showMessageDialog(pintarPanel, "Se cargaron mal los datos", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        // Creación del objeto Material con conversiones correctas
        Material aux = new Material(
            nombreMaterial.getText(), 
            desMaterial.getText(), 
            (String)boxMaterialMedida.getSelectedItem(), 
            (int)stockMaterial.getValue(), 
            ((Number)ventaMaterial.getValue()).doubleValue(), 
            ((Number)compraMaterial.getValue()).doubleValue()
        );
        listaMateriales.add(aux);
        llenarDatosCompra();
        llenarDatosVenta();
        cargarArchivo();
        
        // Limpieza de los campos después de añadir el material
        nombreMaterial.setText("");
        desMaterial.setText("");
        boxMaterialMedida.setSelectedIndex(0);
        stockMaterial.setValue(0);
        ventaMaterial.setValue(0); 
        compraMaterial.setValue(0);
    }
    
    actualizarTablaMateriales();
    }//GEN-LAST:event_cargarMaterialesActionPerformed

    private void botonCompradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCompradoresActionPerformed
        ShowTabbedPanel(compradoresPanel);
    }//GEN-LAST:event_botonCompradoresActionPerformed

    private void botonProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonProveedoresActionPerformed
        ShowTabbedPanel(proveedoresPanel);
    }//GEN-LAST:event_botonProveedoresActionPerformed

    private void botonComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonComprasActionPerformed
        ShowPanel(comprasPanel);
    }//GEN-LAST:event_botonComprasActionPerformed

    private void botonVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVentasActionPerformed
        ShowPanel(ventasPanel);
    }//GEN-LAST:event_botonVentasActionPerformed

    private void botonMaterialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMaterialesActionPerformed
        ShowPanel(materialesPanel);
    }//GEN-LAST:event_botonMaterialesActionPerformed

    private void actualizarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarEmpleadoActionPerformed
        Iterator<Empleado> iterator = listaEmpleados.iterator();
        while (iterator.hasNext()){
            Empleado empleado = iterator.next();
            if (empleado.getNombre() == boxModifEmpleado.getSelectedItem()){
                empleado.setNombre(nombreEmpleado1.getText());
                empleado.setApellido(apellidoEmpleado1.getText());
                empleado.setDireccion(direEmpleado1.getText());
                empleado.setTelefono((int) teleEmpleado1.getValue());
                empleado.setFecha(fechaEmpleado1.getDateFormatString());
            }
    }
        boxModifEmpleado.setSelectedIndex(-1);
        nombreEmpleado1.setText("");
        apellidoEmpleado1.setText("");
        direEmpleado1.setText("");
        teleEmpleado1.setValue(0);
        fechaEmpleado1.setDate(null);
        actualizarTabla();
        cargarArchivo();
    }//GEN-LAST:event_actualizarEmpleadoActionPerformed

    private void eliminarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarEmpleadoActionPerformed
        Empleado aux = new Empleado();
        for (int i=0; i<listaEmpleados.size(); i++){
            if (listaEmpleados.get(i).getNroDeLegajo() == (Integer.parseInt(String.valueOf(boxModifEmpleado.getSelectedItem())))){
                listaEmpleados.remove(i);
            }
        }
        listaEmpleados.remove(aux);
        nombreEmpleado1.setText("");
        apellidoEmpleado1.setText("");
        teleEmpleado1.setValue(0);
        direEmpleado1.setText("");
        int filaSeleccionada = tablaEmpleados.getSelectedRow();
        if (filaSeleccionada != -1) {
            listaEmpleados.remove(filaSeleccionada);   
        }
        actualizarTabla();
        DefaultComboBoxModel defaul = new DefaultComboBoxModel();
        boxModifEmpleado.setModel(defaul);
        
    }//GEN-LAST:event_eliminarEmpleadoActionPerformed

    private void eliminarCompradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarCompradorActionPerformed
        Iterator<Persona> iterator = listaPersonas.iterator();
        while (iterator.hasNext()) {
            Persona cliente = iterator.next();
            if (cliente instanceof ClienteComprador && cliente.getDni() == Integer.parseInt(String.valueOf(boxComprador.getSelectedItem()))) {
                iterator.remove();
                break;
            }
        }
        nombreComprador1.setText("");
        apellidoComprador1.setText("");
        direComprador1.setText("");
        telComprador1.setValue(0);
        int filaSeleccionada = tablaCompradores1.getSelectedRow();
        if (filaSeleccionada != -1) {
            listaPersonas.remove(filaSeleccionada);   
        }
        actualizarTablaCompradores();
        DefaultComboBoxModel defaul = new DefaultComboBoxModel();
        boxComprador.setModel(defaul);
        
        
    }//GEN-LAST:event_eliminarCompradorActionPerformed

    private void actualizarCompradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarCompradorActionPerformed
        Iterator<Persona> iterator = listaPersonas.iterator();
    
        while (iterator.hasNext()) {
            Persona persona = iterator.next();

            if (persona instanceof ClienteComprador) {
                ClienteComprador comprador = (ClienteComprador) persona;
                if(comprador.getNombre() == boxComprador.getSelectedItem()){
                    comprador.setNombre(nombreComprador1.getText());
                    comprador.setApellido(apellidoComprador1.getText());
                    comprador.setDireccion(direComprador1.getText());
                    comprador.setTelefono((int) telComprador1.getValue());
                }
            }
        }
        nombreComprador1.setText("");
        apellidoComprador1.setText("");
        direComprador1.setText("");
        telComprador1.setValue(0);
        boxComprador.setSelectedIndex(-1);
        cargarArchivo();
        actualizarTablaCompradores();
    
    }//GEN-LAST:event_actualizarCompradorActionPerformed

    private void eliminarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarProveedorActionPerformed
        Iterator<Persona> iterator = listaPersonas.iterator();
        while (iterator.hasNext()) {
            Persona cliente = iterator.next();
            if (cliente instanceof ClienteProveedor && ((ClienteProveedor)cliente).getCuit() == Integer.parseInt(String.valueOf(boxProveedor.getSelectedItem()))) {
                iterator.remove();
                break;
            }
        }
        nombreProveedor1.setText("");
        apellidoProveedor1.setText("");
        telProveedor1.setValue(0);
        direProveedor1.setText("");
        ciudadProveedor1.setText("");
        int filaSeleccionada = tablaProveedores.getSelectedRow();
        if (filaSeleccionada != -1) {
            listaPersonas.remove(filaSeleccionada);   
        }
        actualizarTablaProveedores();
        DefaultComboBoxModel defaul = new DefaultComboBoxModel();
        boxProveedor.setModel(defaul);
        cargarArchivo();
    }//GEN-LAST:event_eliminarProveedorActionPerformed

    private void actualizarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarProveedorActionPerformed
        Iterator<Persona> iterator = listaPersonas.iterator();
    
        while (iterator.hasNext()) {
            Persona persona = iterator.next();

            if (persona instanceof ClienteProveedor) {
                ClienteProveedor proveedor = (ClienteProveedor) persona;
                if(proveedor.getNombre() == boxProveedor.getSelectedItem()){
                    proveedor.setNombre(nombreProveedor1.getText());
                    proveedor.setApellido(apellidoProveedor1.getText());
                    proveedor.setDireccion(direProveedor1.getText());
                    proveedor.setTelefono((int) telProveedor1.getValue());
                    proveedor.setCiudad(ciudadProveedor1.getText());
                }
            }
        }
        nombreProveedor1.setText("");
        apellidoProveedor1.setText("");
        direProveedor1.setText("");
        telProveedor1.setValue(0);
        ciudadProveedor1.setText("");
        boxProveedor.setSelectedIndex(-1);
        cargarArchivo();
        actualizarTablaProveedores();
    }//GEN-LAST:event_actualizarProveedorActionPerformed

    private void boxProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxProveedorActionPerformed
        ClienteProveedor aux = new ClienteProveedor();
        for (Persona cliente : listaPersonas) {
            if (cliente instanceof ClienteProveedor && cliente.getNombre() == boxProveedor.getSelectedItem()){
                ClienteProveedor clienteProveedor = (ClienteProveedor) cliente;
                aux = new ClienteProveedor (clienteProveedor.getDni(), clienteProveedor.getNombre(), clienteProveedor.getApellido(), clienteProveedor.getDireccion(), clienteProveedor.getTelefono(), clienteProveedor.getCuit(), clienteProveedor.getCiudad());
            }
        }
        nombreProveedor1.setText(aux.getNombre());
        apellidoProveedor1.setText(aux.getApellido());
        telProveedor1.setValue(aux.getTelefono());
        direProveedor1.setText(aux.getDireccion());
        ciudadProveedor1.setText(aux.getCiudad());
    }//GEN-LAST:event_boxProveedorActionPerformed

    private void cargarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarCompraActionPerformed
        Date fechaDate = fechaCompra.getDate();
        String fecha = sdf.format(fechaDate);
        ClienteComprador cliente = (ClienteComprador) boxCompraClientes.getSelectedItem();
        cliente.setCant(cliente.getCant()+1);
        
        
        String estado;
        
        if (botonPagado.isSelected()) {
            estado = "Pagado";
        } else{
            estado = "No Pagado";
        } 
        Empleado empleado = (Empleado) boxCompraEmpleado.getSelectedItem();
        Material material = (Material) boxMaterialCompra.getSelectedItem();

        Compra compra = new Compra(fecha, cliente, estado, empleado, material);
        listaCompras.add(compra);
        
        fechaCompra.setDate(null);
        boxCompraClientes.setSelectedIndex(-1);
        boxCompraEmpleado.setSelectedIndex(-1);
        boxMaterialCompra.setSelectedIndex(-1);
        estadoCompra.clearSelection();
        cargarArchivo();
    }//GEN-LAST:event_cargarCompraActionPerformed

    private void cargarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarVentaActionPerformed
        Date fechaDate = fechaVenta.getDate();
        String fecha = sdf.format(fechaDate);
        ClienteProveedor cliente = (ClienteProveedor)boxProveedorVenta.getSelectedItem();
        Material material = (Material)boxMaterialVenta.getSelectedItem();
        Number value = (Number) cantidadMaterial.getValue();
        double cantidad = value.doubleValue();

        String estado;
        
        if (ventaDespachada.isSelected()) {
            estado = "Despachado";
        } else{
            estado = "No Despachado";
        }
        
        Venta venta = new Venta(cliente, material, fecha, estado, cantidad);
        listaVentas.add(venta);
        
        
        boxProveedorVenta.setSelectedIndex(-1);
        boxMaterialVenta.setSelectedIndex(-1);
        cantidadMaterial.setValue(0);
        estadoVenta.clearSelection();
        cargarArchivo();
    }//GEN-LAST:event_cargarVentaActionPerformed

    private void listarEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarEmpleadosActionPerformed
        Collections.sort(listaEmpleados, Comparator.comparing((Empleado e) -> (e.getNombre() + " " + e.getApellido()).toLowerCase()));
        DefaultTableModel modeloTabla = new DefaultTableModel();
        
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellido");
        modeloTabla.addColumn("DNI");
        modeloTabla.addColumn("Dirección");
        modeloTabla.addColumn("Teléfono");
        modeloTabla.addColumn("Legajo");
        
        for (Empleado empleado : listaEmpleados) {
        modeloTabla.addRow(new Object[]{
            empleado.getNombre(),
            empleado.getApellido(),
            empleado.getDni(),
            empleado.getDireccion(),
            empleado.getTelefono(),
            empleado.getNroDeLegajo()
        });
        }
        tablaListarEmpleados.setModel(modeloTabla);
    }//GEN-LAST:event_listarEmpleadosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ShowPanel(listarPanel);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void listarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarClientesActionPerformed
        Collections.sort(listaPersonas, (Persona c1, Persona c2) -> c1.getApellido().compareToIgnoreCase(c2.getApellido()));
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Apellido");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("DNI");
        
        for (Persona personas : listaPersonas){
            modeloTabla.addRow(new Object[]{
               personas.getApellido(),
               personas.getNombre(),
               personas.getDni(),
            });
        }
        tablaListarClientesAlf.setModel(modeloTabla);
    }//GEN-LAST:event_listarClientesActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel modeloTabla = new DefaultTableModel();
        ArrayList<ClienteComprador> listaAux = new ArrayList<>();
        for (Persona persona : listaPersonas){
            if(persona instanceof ClienteComprador){
                listaAux.add((ClienteComprador)persona);
            }
        }
        Collections.sort(listaAux, new Comparador());
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("Apellido");
        tabla.addColumn("Nombre");
        tabla.addColumn("DNI");
        tabla.addColumn("Cantidad  Compras");
        for(ClienteComprador cliente : listaAux){
            tabla.addRow (new Object[]{
               cliente.getApellido(),
               cliente.getNombre(),
               cliente.getDni(),
               cliente.getCant()
            });
        }
        tablaListarClientes.setModel(tabla);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void boxModifEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxModifEmpleadoActionPerformed
        Empleado aux = new Empleado();
        for (Empleado empleado : listaEmpleados){
            if(empleado.getNombre() == boxModifEmpleado.getSelectedItem()){
                aux = new Empleado(empleado.getDni(), empleado.getNombre(), empleado.getApellido(), empleado.getDireccion(), empleado.getTelefono(),empleado.getNroDeLegajo() , empleado.getFecha());
            }
        }
        nombreEmpleado1.setText(aux.getNombre());
        apellidoEmpleado1.setText(aux.getApellido());
        direEmpleado1.setText(aux.getDireccion());
        teleEmpleado1.setValue(aux.getTelefono());
    }//GEN-LAST:event_boxModifEmpleadoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Date fecha1 = listarFecha1.getDate();
        Date fecha2 = listarFecha2.getDate();
    
    // Verificar que ambas fechas no sean nulas
    if (fecha1 == null || fecha2 == null) {
        JOptionPane.showMessageDialog(null, "Por favor selecciona ambas fechas", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Verificar que la fecha de inicio sea anterior o igual a la fecha de fin
    if (fecha1.after(fecha2)) {
        JOptionPane.showMessageDialog(null, "La fecha de inicio no puede ser posterior a la fecha de fin", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    double totalVentas = 0.0;
    ArrayList<Venta> ventaAux = new ArrayList<>();
    
    for (Venta venta : listaVentas) {
        // Obtener la fecha de la venta
        Date fechaVenta;
        try {
            fechaVenta = sdf.parse(venta.getFecha());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al analizar la fecha de una venta", "Error", JOptionPane.ERROR_MESSAGE);
            continue;
        }
        
        // Verificar si la fecha de la venta está dentro del rango seleccionado
        if (!fechaVenta.before(fecha1) && !fechaVenta.after(fecha2)) {
            ventaAux.add(venta);
            totalVentas += venta.getMaterial().getPrecioVenta() * venta.getCantidad();
        }
    }
    
    DefaultTableModel tabla = new DefaultTableModel();
    tabla.addColumn("Cliente");
    tabla.addColumn("Material");
    tabla.addColumn("Cantidad de materiales");
    tabla.addColumn("Fecha");
    tabla.addColumn("Estado");
    
    for (Venta venta : ventaAux) {
        tabla.addRow(new Object[]{
           venta.getProveedor().getNombre(), // Asumiendo que quieres el nombre del proveedor
           venta.getMaterial().getNombre(), // Asumiendo que quieres el nombre del material
           venta.getCantidad(),
           venta.getFecha(),
           venta.getEstado()
        });
    }
    
    tablaListarVentas.setModel(tabla);
    mostrarTotal.setText(String.format("%,.2f", totalVentas));
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void boxCompradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxCompradorActionPerformed
        ClienteComprador aux = new ClienteComprador();
        for (Persona persona : listaPersonas){
           if(persona instanceof ClienteComprador && persona.getNombre() == boxComprador.getSelectedItem()){
               ClienteComprador cliente = (ClienteComprador) persona;
               aux = new ClienteComprador(cliente.getDni(), cliente.getNombre(), cliente.getApellido(), cliente.getDireccion(), cliente.getTelefono());
           }
        }
        nombreComprador1.setText(aux.getNombre());
        apellidoComprador1.setText(aux.getApellido());
        direComprador1.setText(aux.getDireccion());
        telComprador1.setValue(aux.getTelefono());
    }//GEN-LAST:event_boxCompradorActionPerformed
     
  
    
    
    private void llenarDatosCompra(){
        for (Persona comprador : listaPersonas){
            if (comprador instanceof ClienteComprador){
                boxCompraClientes.addItem(comprador);
        }
}
        for (Material material : listaMateriales){
            boxMaterialCompra.addItem(material);
        }
        for (Empleado empleado : listaEmpleados){
            boxCompraEmpleado.addItem(empleado);
            }
        }
    
    
    private void llenarDatosVenta(){
        for (Persona proveedor : listaPersonas){
            if (proveedor instanceof ClienteProveedor){
                boxProveedorVenta.addItem(proveedor);
            }
        }
         for (Material material : listaMateriales){
            boxMaterialVenta.addItem(material);
        }
    }
    
    private void ShowTabbedPanel(JTabbedPane p){
        p.setSize(770, 690);
        p.setLocation(0, 0);
        
        pintarPanel.removeAll();
        pintarPanel.add(p, BorderLayout.CENTER);
        pintarPanel.revalidate();
        pintarPanel.repaint();
        
    }
    
    
    
    private void actualizarTabla(){
        // Limpiar el modelo de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla = (DefaultTableModel) tablaEmpleados.getModel();
        modeloTabla.setRowCount(0);

        // Agregar los datos de los empleados al modelo de la tabla
        for (Empleado empleado : listaEmpleados) {
            modeloTabla.addRow(new Object[]{
                    empleado.getNombre(),
                    empleado.getApellido(),
                    empleado.getDni(),
                    empleado.getDireccion(),
                    empleado.getTelefono(),
                    empleado.getNroDeLegajo()
            });
        }
    }
    
    
    
    private void actualizarTablaCompradores(){
        // Limpiar el modelo de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla = (DefaultTableModel) tablaCompradores1.getModel();
        modeloTabla.setRowCount(0);

        // Agregar los datos de los empleados al modelo de la tabla
        for (Persona clientes : listaPersonas) {
            if (clientes instanceof ClienteComprador){
            modeloTabla.addRow(new Object[]{
                ((ClienteComprador)clientes).getNombre(),
                ((ClienteComprador)clientes).getApellido(),
                ((ClienteComprador)clientes).getDni(),
                ((ClienteComprador) clientes).getDireccion(),
                ((ClienteComprador)clientes).getTelefono(),
                });
            }
        }
    }
    
   
    
    private void actualizarTablaMateriales(){
        // Limpiar el modelo de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla = (DefaultTableModel) tablaMateriales.getModel();
        modeloTabla.setRowCount(0);
        
        // Agregar los datos de los empleados al modelo de la tabla
        for (Material material : listaMateriales) {
            modeloTabla.addRow(new Object[]{
               material.getNombre(),
               material.getMedida(),
               material.getStock(),
               material.getPrecioVenta(),
               material.getPrecioCompra(),
               
        });
        }
    }
    
    private void actualizarTablaProveedores(){
        // Limpiar el modelo de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla = (DefaultTableModel) tablaProveedores.getModel();
        modeloTabla.setRowCount(0);

        // Agregar los datos de los empleados al modelo de la tabla
        for (Persona clientes : listaPersonas) {
            if (clientes instanceof ClienteProveedor){
            modeloTabla.addRow(new Object[]{
                ((ClienteProveedor)clientes).getNombre(),
                ((ClienteProveedor)clientes).getApellido(),
                ((ClienteProveedor)clientes).getDni(),
                ((ClienteProveedor) clientes).getDireccion(),
                ((ClienteProveedor)clientes).getTelefono(),
                ((ClienteProveedor)clientes).getCiudad(),
                ((ClienteProveedor)clientes).getCuit(),
                });
            }
        }
    }
    
    
    private void ShowPanel(JPanel p){
        p.setSize(770, 690);
        p.setLocation(0, 0);
        
        pintarPanel.removeAll();
        pintarPanel.add(p, BorderLayout.CENTER);
        pintarPanel.revalidate();
        pintarPanel.repaint();
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarComprador;
    private javax.swing.JButton actualizarEmpleado;
    private javax.swing.JButton actualizarProveedor;
    private javax.swing.JTextField apellidoComprador;
    private javax.swing.JTextField apellidoComprador1;
    private javax.swing.JTextField apellidoEmpleado;
    private javax.swing.JTextField apellidoEmpleado1;
    private javax.swing.JTextField apellidoProveedor;
    private javax.swing.JTextField apellidoProveedor1;
    private javax.swing.JPanel bg;
    private javax.swing.JButton botonCargarEmpleado;
    private javax.swing.JButton botonCompradores;
    private javax.swing.JButton botonCompras;
    private javax.swing.JButton botonEmpleados;
    private javax.swing.JButton botonMateriales;
    private javax.swing.JRadioButton botonNoPagado;
    private javax.swing.JRadioButton botonPagado;
    private javax.swing.JButton botonProveedores;
    private javax.swing.JButton botonVentas;
    private javax.swing.JComboBox<Persona> boxCompraClientes;
    private javax.swing.JComboBox<Empleado> boxCompraEmpleado;
    private javax.swing.JComboBox<String> boxComprador;
    private javax.swing.JComboBox<Material> boxMaterialCompra;
    private javax.swing.JComboBox<String> boxMaterialMedida;
    private javax.swing.JComboBox<Material> boxMaterialVenta;
    private javax.swing.JComboBox<String> boxModifEmpleado;
    private javax.swing.JComboBox<String> boxProveedor;
    private javax.swing.JComboBox<Persona> boxProveedorVenta;
    private javax.swing.JSpinner cantidadMaterial;
    private javax.swing.JButton cargarCompra;
    private javax.swing.JButton cargarCompradores;
    private javax.swing.JButton cargarMateriales;
    private javax.swing.JButton cargarProveedores;
    private javax.swing.JButton cargarVenta;
    private javax.swing.JTextField ciudadProveedor;
    private javax.swing.JTextField ciudadProveedor1;
    private javax.swing.JSpinner compraMaterial;
    private javax.swing.JTabbedPane compradoresPanel;
    private javax.swing.JPanel comprasPanel;
    private javax.swing.JSpinner cuitProveedor;
    private javax.swing.JTextField desMaterial;
    private javax.swing.JTextField direComprador;
    private javax.swing.JTextField direComprador1;
    private javax.swing.JTextField direEmpleado;
    private javax.swing.JTextField direEmpleado1;
    private javax.swing.JTextField direProveedor;
    private javax.swing.JTextField direProveedor1;
    private javax.swing.JSpinner dniComprador;
    private javax.swing.JSpinner dniEmpleado;
    private javax.swing.JSpinner dniProveedor;
    private javax.swing.JButton eliminarComprador;
    private javax.swing.JButton eliminarEmpleado;
    private javax.swing.JButton eliminarProveedor;
    private javax.swing.JTabbedPane empleadosPanel;
    private javax.swing.ButtonGroup estadoCompra;
    private javax.swing.ButtonGroup estadoVenta;
    private javax.swing.JLabel extBttn;
    private com.toedter.calendar.JDateChooser fechaCompra;
    private com.toedter.calendar.JDateChooser fechaEmpleado;
    private com.toedter.calendar.JDateChooser fechaEmpleado1;
    private com.toedter.calendar.JDateChooser fechaVenta;
    private javax.swing.JPanel header;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSpinner legajoEmpleado;
    private javax.swing.JButton listarClientes;
    private javax.swing.JButton listarEmpleados;
    private com.toedter.calendar.JDateChooser listarFecha1;
    private com.toedter.calendar.JDateChooser listarFecha2;
    private javax.swing.JPanel listarPanel;
    private javax.swing.JPanel materialesPanel;
    private javax.swing.JPanel menu;
    private javax.swing.JTextField mostrarTotal;
    private javax.swing.JTextField nombreComprador;
    private javax.swing.JTextField nombreComprador1;
    private javax.swing.JTextField nombreEmpleado;
    private javax.swing.JTextField nombreEmpleado1;
    private javax.swing.JTextField nombreMaterial;
    private javax.swing.JTextField nombreProveedor;
    private javax.swing.JTextField nombreProveedor1;
    private javax.swing.JPanel panelExit;
    private javax.swing.JPanel panelSalir;
    private javax.swing.JPanel pintarPanel;
    private javax.swing.JTabbedPane proveedoresPanel;
    private javax.swing.JLabel salir;
    private javax.swing.JSpinner stockMaterial;
    private javax.swing.JTable tablaCompradores1;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JTable tablaListarClientes;
    private javax.swing.JTable tablaListarClientesAlf;
    private javax.swing.JTable tablaListarEmpleados;
    private javax.swing.JTable tablaListarVentas;
    private javax.swing.JTable tablaMateriales;
    private javax.swing.JTable tablaProveedores;
    private javax.swing.JSpinner telComprador;
    private javax.swing.JSpinner telComprador1;
    private javax.swing.JSpinner telProveedor;
    private javax.swing.JSpinner telProveedor1;
    private javax.swing.JSpinner teleEmpleado;
    private javax.swing.JSpinner teleEmpleado1;
    private javax.swing.JRadioButton ventaDespachada;
    private javax.swing.JSpinner ventaMaterial;
    private javax.swing.JRadioButton ventaNoDespachada;
    private javax.swing.JPanel ventasPanel;
    // End of variables declaration//GEN-END:variables
}
