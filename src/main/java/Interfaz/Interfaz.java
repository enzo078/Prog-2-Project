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
import com.mycompany.proyecto.Compra;
import com.mycompany.proyecto.Venta;
import com.mycompany.proyecto.Material;
import com.mycompany.proyecto.Persona;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TableView;

/**
 *
 * @author enzor
 */
public class Interfaz extends javax.swing.JFrame {

    private InicioSesion panel1;
    int xMouse, yMouse;
    
    public Interfaz() {
        initComponents();
        
        
    }
    
    public void setPanel1(InicioSesion panel1){
        this.panel1 = panel1;
    }
    
    ArrayList <Empleado> listaEmpleados = new ArrayList<>();
    ArrayList <Persona> listaPersonas = new ArrayList<>();
    ArrayList <Material> listaMateriales = new ArrayList<>();
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        fechaEmpleado = new javax.swing.JTextField();
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
        jPanel5 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        nombreEmpleado1 = new javax.swing.JTextField();
        teleEmpleado1 = new javax.swing.JSpinner();
        jLabel31 = new javax.swing.JLabel();
        apellidoEmpleado1 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        fechaEmpleado1 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        direEmpleado1 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        actualizarEmpleado = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
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
        jPanel3 = new javax.swing.JPanel();
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
        jPanel9 = new javax.swing.JPanel();
        comprasPanel = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        fechaCompra = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        boxCompraClientes = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        boxCompraEmpleado = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        compraPagado = new javax.swing.JCheckBox();
        compraNoPagado = new javax.swing.JCheckBox();
        cargarCompra = new javax.swing.JButton();
        ventasPanel = new javax.swing.JPanel();
        boxMaterialVenta = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        boxProveedorVenta = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        ventaDespachada = new javax.swing.JRadioButton();
        ventaNoDespachada = new javax.swing.JRadioButton();
        cargarVenta = new javax.swing.JButton();
        materialesPanel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        nombreMaterial = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        desMaterial = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        medidaMaterial = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cargarMateriales = new javax.swing.JButton();
        stockMaterial = new javax.swing.JSpinner();
        compraMaterial = new javax.swing.JSpinner();
        ventaMaterial = new javax.swing.JSpinner();

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

        salir.setBackground(new java.awt.Color(0, 0, 0));
        salir.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        salir.setForeground(new java.awt.Color(0, 0, 0));
        salir.setText("              SALIR");
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

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\enzor\\Downloads\\Logo (1).png")); // NOI18N
        menu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 170, 130));

        botonMateriales.setText("Materiales");
        botonMateriales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMaterialesActionPerformed(evt);
            }
        });
        menu.add(botonMateriales, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 310, 30));

        botonProveedores.setText("Proveedores");
        botonProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonProveedoresActionPerformed(evt);
            }
        });
        menu.add(botonProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 310, 30));

        botonEmpleados.setText("Empleados");
        botonEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEmpleadosActionPerformed(evt);
            }
        });
        menu.add(botonEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 310, 30));

        botonCompradores.setText("Compradores");
        botonCompradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCompradoresActionPerformed(evt);
            }
        });
        menu.add(botonCompradores, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 310, 30));

        botonCompras.setText("Compras");
        botonCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonComprasActionPerformed(evt);
            }
        });
        menu.add(botonCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 310, 30));

        botonVentas.setText("Ventas");
        botonVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVentasActionPerformed(evt);
            }
        });
        menu.add(botonVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 310, 30));

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
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(direEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(nombreEmpleado)
                            .addComponent(apellidoEmpleado)
                            .addComponent(dniEmpleado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(fechaEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(teleEmpleado)
                            .addComponent(legajoEmpleado))
                        .addGap(8, 8, 8)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(dniEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonCargarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(direEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(88, 88, 88))
        );

        empleadosPanel.addTab("Cargar", jPanel4);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel29.setText("Empleado");

        jLabel30.setText("Nombre");

        jLabel31.setText("Telefono");

        jLabel33.setText("Apellido");

        jLabel35.setText("Fecha Ingreso");

        jLabel36.setText("Direccion");

        actualizarEmpleado.setText("Actualizar");
        actualizarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarEmpleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(direEmpleado1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(jLabel30)
                                .addComponent(jLabel33)
                                .addComponent(nombreEmpleado1)
                                .addComponent(apellidoEmpleado1))
                            .addComponent(jLabel36)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(137, 137, 137)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel35)
                            .addComponent(jLabel31)
                            .addComponent(fechaEmpleado1)
                            .addComponent(teleEmpleado1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))
                .addContainerGap(270, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(actualizarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                .addComponent(actualizarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );

        empleadosPanel.addTab("Modificar", jPanel5);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(541, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(566, Short.MAX_VALUE))
        );

        empleadosPanel.addTab("Eliminar", jPanel6);

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
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cargarCompradores, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(111, 111, 111))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(dniComprador)
                                    .addComponent(direComprador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombreComprador, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(apellidoComprador, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(198, 198, 198)
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 664, Short.MAX_VALUE)
        );

        compradoresPanel.addTab("Modificar", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 664, Short.MAX_VALUE)
        );

        compradoresPanel.addTab("Eliminar", jPanel3);

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

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 664, Short.MAX_VALUE)
        );

        proveedoresPanel.addTab("Modificar", jPanel8);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 664, Short.MAX_VALUE)
        );

        proveedoresPanel.addTab("Eliminar", jPanel9);

        pintarPanel.add(proveedoresPanel, "card4");

        jLabel32.setText("Fecha");

        jLabel34.setText("Cliente");

        boxCompraClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel37.setText("Estado de compra");

        boxCompraEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel27.setText("Empleado");

        compraPagado.setText("Pagado");

        compraNoPagado.setText("No pagado");

        cargarCompra.setText("CARGAR");

        javax.swing.GroupLayout comprasPanelLayout = new javax.swing.GroupLayout(comprasPanel);
        comprasPanel.setLayout(comprasPanelLayout);
        comprasPanelLayout.setHorizontalGroup(
            comprasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(comprasPanelLayout.createSequentialGroup()
                .addGroup(comprasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(comprasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(comprasPanelLayout.createSequentialGroup()
                            .addGap(309, 309, 309)
                            .addGroup(comprasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel37)
                                .addGroup(comprasPanelLayout.createSequentialGroup()
                                    .addGap(21, 21, 21)
                                    .addComponent(jLabel27))
                                .addGroup(comprasPanelLayout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addComponent(jLabel34))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, comprasPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel32)
                                    .addGap(32, 32, 32))))
                        .addGroup(comprasPanelLayout.createSequentialGroup()
                            .addGap(259, 259, 259)
                            .addComponent(boxCompraEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(comprasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(compraPagado)
                        .addGroup(comprasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fechaCompra, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(boxCompraClientes, javax.swing.GroupLayout.Alignment.TRAILING, 0, 200, Short.MAX_VALUE))
                        .addComponent(compraNoPagado)))
                .addContainerGap(311, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, comprasPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cargarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
        comprasPanelLayout.setVerticalGroup(
            comprasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(comprasPanelLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxCompraClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(compraPagado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(compraNoPagado)
                .addGap(33, 33, 33)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxCompraEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(cargarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pintarPanel.add(comprasPanel, "card7");

        boxMaterialVenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel38.setText("Proveedor");

        jLabel39.setText("Fecha");

        jLabel40.setText("Material");

        boxProveedorVenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel41.setText("Estado de venta");

        ventaDespachada.setText("Despachado");

        ventaNoDespachada.setText("No despachado");

        cargarVenta.setText("CARGAR");

        javax.swing.GroupLayout ventasPanelLayout = new javax.swing.GroupLayout(ventasPanel);
        ventasPanel.setLayout(ventasPanelLayout);
        ventasPanelLayout.setHorizontalGroup(
            ventasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ventasPanelLayout.createSequentialGroup()
                .addGroup(ventasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ventasPanelLayout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jLabel38))
                    .addGroup(ventasPanelLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(ventasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(boxProveedorVenta, 0, 200, Short.MAX_VALUE)
                            .addComponent(jTextField1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addComponent(jLabel40)
                .addGap(235, 235, 235))
            .addGroup(ventasPanelLayout.createSequentialGroup()
                .addGroup(ventasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ventasPanelLayout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jLabel39))
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
                        .addComponent(boxMaterialVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ventasPanelLayout.createSequentialGroup()
                        .addComponent(cargarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106))))
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
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ventaDespachada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ventaNoDespachada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
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

        javax.swing.GroupLayout materialesPanelLayout = new javax.swing.GroupLayout(materialesPanel);
        materialesPanel.setLayout(materialesPanelLayout);
        materialesPanelLayout.setHorizontalGroup(
            materialesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(materialesPanelLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(materialesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(materialesPanelLayout.createSequentialGroup()
                        .addGroup(materialesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(materialesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(medidaMaterial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nombreMaterial, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(desMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(93, 93, 93)
                        .addGroup(materialesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18)
                            .addComponent(jLabel16)
                            .addComponent(jLabel19)
                            .addComponent(stockMaterial, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(compraMaterial)
                            .addComponent(ventaMaterial)))
                    .addComponent(jLabel17))
                .addContainerGap(193, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, materialesPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cargarMateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        materialesPanelLayout.setVerticalGroup(
            materialesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(materialesPanelLayout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addGroup(materialesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(materialesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nombreMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stockMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(materialesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(materialesPanelLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(compraMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ventaMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(materialesPanelLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(desMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(medidaMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(cargarMateriales, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );

        pintarPanel.add(materialesPanel, "card5");

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
        if (nombreComprador.getText().equals("") || apellidoComprador.getText().equals("") || (int)dniComprador.getValue() <= 0 || direComprador.getText().equals("") || (int)telComprador.getValue() <= 0){
            JOptionPane.showMessageDialog(pintarPanel, "Se cargaron mal los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            ClienteComprador aux = new ClienteComprador((int)dniComprador.getValue(), nombreComprador.getText(), apellidoComprador.getText(), direComprador.getText(), (int)telComprador.getValue());
            listaPersonas.add(aux);
            nombreComprador.setText("");
            apellidoComprador.setText("");
            dniComprador.setValue(0);
            telComprador.setValue(0);
            direComprador.setText("");
        }
    }//GEN-LAST:event_cargarCompradoresActionPerformed

    private void botonCargarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCargarEmpleadoActionPerformed
        if (nombreEmpleado.getText().equals("") || apellidoEmpleado.getText().equals("") || (int)dniEmpleado.getValue() <= 0 || (int)teleEmpleado.getValue() <= 0 || direEmpleado.getText().equals("") || (int)legajoEmpleado.getValue() <= 0 ){
            JOptionPane.showMessageDialog(pintarPanel, "Se cargaron mal los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            Empleado aux = new Empleado((int)dniEmpleado.getValue(), nombreEmpleado.getText(), apellidoEmpleado.getText(), direEmpleado.getText(), (int)teleEmpleado.getValue(),(int)legajoEmpleado.getValue() , fechaEmpleado.getText());
            listaEmpleados.add(aux);
            nombreEmpleado.setText("");
            apellidoEmpleado.setText("");
            dniEmpleado.setValue(0);
            teleEmpleado.setValue(0);
            direEmpleado.setText("");
            legajoEmpleado.setValue(0);
            
             DefaultTableModel model = (DefaultTableModel) tablaEmpleados.getModel();
        model.addRow(new Object[]{
            aux.getDni(), 
            aux.getNombre(), 
            aux.getApellido(), 
            aux.getDireccion(), 
            aux.getTelefono(), 
            aux.getNroDeLegajo(), 
            aux.getFecha()
        });
        int lastRow = model.getRowCount() - 1;
        tablaEmpleados.scrollRectToVisible(tablaEmpleados.getCellRect(lastRow, 0, true));
        }
        
        
    }//GEN-LAST:event_botonCargarEmpleadoActionPerformed

    private void cargarProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarProveedoresActionPerformed
        if (nombreProveedor.getText().equals("") || apellidoProveedor.getText().equals("") || direProveedor.getText().equals("") || ciudadProveedor.getText().equals("") || (int)dniProveedor.getValue() <= 0 || (int)cuitProveedor.getValue() <= 0 || (int)telProveedor.getValue() <= 0){
           JOptionPane.showMessageDialog(pintarPanel, "Se cargaron mal los datos", "Error", JOptionPane.ERROR_MESSAGE); 
        }else{
            ClienteProveedor aux = new ClienteProveedor((int)dniProveedor.getValue(), nombreProveedor.getText() , apellidoProveedor.getText(), ciudadProveedor.getText(), (int)cuitProveedor.getValue(), (int)telProveedor.getValue(), direProveedor.getText());
            listaPersonas.add(aux);
            nombreProveedor.setText("");
            apellidoProveedor.setText("");
            dniProveedor.setValue(0);
            telProveedor.setValue(0);
            direProveedor.setText("");
            cuitProveedor.setValue(0); 
        }
    }//GEN-LAST:event_cargarProveedoresActionPerformed

    private void cargarMaterialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarMaterialesActionPerformed
        if (nombreMaterial.getText().equals("") || desMaterial.getText().equals("") || medidaMaterial.getText().equals("") || (int)stockMaterial.getValue() <= 0 || (double)ventaMaterial.getValue() <= 0 || (double)compraMaterial.getValue() <= 0){
            JOptionPane.showMessageDialog(pintarPanel, "Se cargaron mal los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            Material aux = new Material(nombreMaterial.getText(), desMaterial.getText(), medidaMaterial.getText(), (int)stockMaterial.getValue(), (double)ventaMaterial.getValue(), (double)compraMaterial.getValue());
            listaMateriales.add(aux);
            nombreMaterial.setText("");
            desMaterial.setText("");
            medidaMaterial.setText("");
            stockMaterial.setValue(0);
            compraMaterial.setValue(0);
            ventaMaterial.setValue(0);
        }
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
        // TODO add your handling code here:
    }//GEN-LAST:event_actualizarEmpleadoActionPerformed

    private void ShowTabbedPanel(JTabbedPane p){
        p.setSize(770, 690);
        p.setLocation(0, 0);
        
        pintarPanel.removeAll();
        pintarPanel.add(p, BorderLayout.CENTER);
        pintarPanel.revalidate();
        pintarPanel.repaint();
        
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
    private javax.swing.JButton actualizarEmpleado;
    private javax.swing.JTextField apellidoComprador;
    private javax.swing.JTextField apellidoEmpleado;
    private javax.swing.JTextField apellidoEmpleado1;
    private javax.swing.JTextField apellidoProveedor;
    private javax.swing.JPanel bg;
    private javax.swing.JButton botonCargarEmpleado;
    private javax.swing.JButton botonCompradores;
    private javax.swing.JButton botonCompras;
    private javax.swing.JButton botonEmpleados;
    private javax.swing.JButton botonMateriales;
    private javax.swing.JButton botonProveedores;
    private javax.swing.JButton botonVentas;
    private javax.swing.JComboBox<String> boxCompraClientes;
    private javax.swing.JComboBox<String> boxCompraEmpleado;
    private javax.swing.JComboBox<String> boxMaterialVenta;
    private javax.swing.JComboBox<String> boxProveedorVenta;
    private javax.swing.JButton cargarCompra;
    private javax.swing.JButton cargarCompradores;
    private javax.swing.JButton cargarMateriales;
    private javax.swing.JButton cargarProveedores;
    private javax.swing.JButton cargarVenta;
    private javax.swing.JTextField ciudadProveedor;
    private javax.swing.JSpinner compraMaterial;
    private javax.swing.JCheckBox compraNoPagado;
    private javax.swing.JCheckBox compraPagado;
    private javax.swing.JTabbedPane compradoresPanel;
    private javax.swing.JPanel comprasPanel;
    private javax.swing.JSpinner cuitProveedor;
    private javax.swing.JTextField desMaterial;
    private javax.swing.JTextField direComprador;
    private javax.swing.JTextField direEmpleado;
    private javax.swing.JTextField direEmpleado1;
    private javax.swing.JTextField direProveedor;
    private javax.swing.JSpinner dniComprador;
    private javax.swing.JSpinner dniEmpleado;
    private javax.swing.JSpinner dniProveedor;
    private javax.swing.JTabbedPane empleadosPanel;
    private javax.swing.JLabel extBttn;
    private javax.swing.JTextField fechaCompra;
    private javax.swing.JTextField fechaEmpleado;
    private javax.swing.JTextField fechaEmpleado1;
    private javax.swing.JPanel header;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JSpinner legajoEmpleado;
    private javax.swing.JPanel materialesPanel;
    private javax.swing.JTextField medidaMaterial;
    private javax.swing.JPanel menu;
    private javax.swing.JTextField nombreComprador;
    private javax.swing.JTextField nombreEmpleado;
    private javax.swing.JTextField nombreEmpleado1;
    private javax.swing.JTextField nombreMaterial;
    private javax.swing.JTextField nombreProveedor;
    private javax.swing.JPanel panelExit;
    private javax.swing.JPanel panelSalir;
    private javax.swing.JPanel pintarPanel;
    private javax.swing.JTabbedPane proveedoresPanel;
    private javax.swing.JLabel salir;
    private javax.swing.JSpinner stockMaterial;
    private javax.swing.JTable tablaCompradores1;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JTable tablaProveedores;
    private javax.swing.JSpinner telComprador;
    private javax.swing.JSpinner telProveedor;
    private javax.swing.JSpinner teleEmpleado;
    private javax.swing.JSpinner teleEmpleado1;
    private javax.swing.JRadioButton ventaDespachada;
    private javax.swing.JSpinner ventaMaterial;
    private javax.swing.JRadioButton ventaNoDespachada;
    private javax.swing.JPanel ventasPanel;
    // End of variables declaration//GEN-END:variables
}
