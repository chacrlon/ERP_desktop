/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.conectar;
import Validaciones.TextFieldEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.sql.DriverManager;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static org.apache.poi.hssf.usermodel.HeaderFooter.tab;
import java.io.*;
import javax.swing.*;
import jxl.write.*;
import jxl.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


import Validaciones.TextFieldEvent;

import Modelo.Compras2;
import Modelo.ExportarExcel;
import static Vistas.Principal.p1;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.util.List;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Clientes extends javax.swing.JInternalFrame {

    conectar cc=new conectar();
    Connection cn=cc.conexion();
    

    
    TextFieldEvent evento= new TextFieldEvent();

    public Clientes() {
        initComponents();
     
        encargado.setText(p1.getText());
        encargado.setEnabled(false);
        encargado.setVisible(false);

   
    }
    
    



/**
 *
 * @author RUBEN
 */

   void bitacorainsertar(){ 
        try{
            String descripcion="Registro un cliente";
            PreparedStatement pst=cn.prepareStatement("INSERT INTO bitacora (usuario,descripcion,fecha,hora) VALUES (?,?,?,?)");           
            pst.setString(1, encargado.getText());
            pst.setString(2, descripcion);
            pst.setString(3, Principal.Fecha.getText());
            pst.setString(4, Principal.Hora.getText());
            pst.executeUpdate();           
        }
        catch(SQLException ex){
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }
   
   void bitacoraexcel(){ 
        try{
            String descripcion="Exporto la tabla Clientes a Excel";
            PreparedStatement pst=cn.prepareStatement("INSERT INTO bitacora (usuario,descripcion,fecha,hora) VALUES (?,?,?,?)");           
            pst.setString(1, encargado.getText());
            pst.setString(2, descripcion);
            pst.setString(3, Principal.Fecha.getText());
            pst.setString(4, Principal.Hora.getText());
            pst.executeUpdate();           
        }
        catch(SQLException ex){
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }
   
         void bitacoraactualizar(){ 
        try{
            String descripcion="Modifico los datos de un cliente";
            PreparedStatement pst=cn.prepareStatement("INSERT INTO bitacora (usuario,descripcion,fecha,hora) VALUES (?,?,?,?)");           
            pst.setString(1, encargado.getText());
            pst.setString(2, descripcion);
            pst.setString(3, Principal.Fecha.getText());
            pst.setString(4, Principal.Hora.getText());
            pst.executeUpdate();           
        }
        catch(SQLException ex){
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }
         
         void bitacoraeliminar(){ 
        try{
            String descripcion="Elimino a un cliente";
            PreparedStatement pst=cn.prepareStatement("INSERT INTO bitacora (usuario,descripcion,fecha,hora) VALUES (?,?,?,?)");           
            pst.setString(1, encargado.getText());
            pst.setString(2, descripcion);
            pst.setString(3, Principal.Fecha.getText());
            pst.setString(4, Principal.Hora.getText());
            pst.executeUpdate();           
        }
        catch(SQLException ex){
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }
/*    
    public void SelectProveedor(){
    String sql="Select * from proveedor";
        try{ 
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            { 
             comboux.addItem(rs.getString("status_proveedor"));   
            }

        }
        catch(SQLException ex){ 
            Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE,null,ex);
        }
}
*/
    
 public void mostrar(Object fecha){ 
       
     DefaultTableModel modelo3=new DefaultTableModel();       
        modelo3.addColumn("Primer nombre");
        modelo3.addColumn("Segundo nombre");
        modelo3.addColumn("Primer apellido");
        modelo3.addColumn("Segundo apellido");
        modelo3.addColumn("Cedula");
        modelo3.addColumn("Telefono");
        modelo3.addColumn("Correo");
        modelo3.addColumn("Direccion");
        modelo3.addColumn("Status");

    
        tabla40.setModel(modelo3);
        String sql= "";
     
        if(fecha.equals(sql)){ 
            sql="SELECT nombre1_cliente,nombre2_cliente,apellido1_cliente,apellido2_cliente,cedula_cliente,telefono_cliente,correo_cliente,direccion_cliente,status_cliente FROM clientes";             
        }
        else { 
            sql="SELECT nombre1_cliente,nombre2_cliente,apellido1_cliente,apellido2_cliente,cedula_cliente,telefono_cliente,correo_cliente,direccion_cliente,status_cliente FROM clientes WHERE cedula_cliente='"+fecha+"'";
                   
        }
       
        
        String []datos=new String[30];
        try{ 
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){ 
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                datos[7]=rs.getString(8);
                datos[8]=rs.getString(9);
            
                modelo3.addRow(datos);
            }
            tabla40.setModel(modelo3);
        }
        catch(SQLException ex){ 
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE,null,ex);
        }
     
    }
 
 public void mostrar2(Object fecha){ 
     
     DefaultTableModel modelo3=new DefaultTableModel();       
        modelo3.addColumn("Primer nombre");
        modelo3.addColumn("Segundo nombre");
        modelo3.addColumn("Primer apellido");
        modelo3.addColumn("Segundo apellido");
        modelo3.addColumn("Cedula");
        modelo3.addColumn("Telefono");
        modelo3.addColumn("Correo");
        modelo3.addColumn("Direccion");
        modelo3.addColumn("Status");

    
        tabla40.setModel(modelo3);
        String sql= "";
     
        if(fecha.equals(sql)){ 
            sql="SELECT nombre1_cliente,nombre2_cliente,apellido1_cliente,apellido2_cliente,cedula_cliente,telefono_cliente,correo_cliente,direccion_cliente,status_cliente FROM clientes";             
        }
        else { 
            sql="SELECT nombre1_cliente,nombre2_cliente,apellido1_cliente,apellido2_cliente,cedula_cliente,telefono_cliente,correo_cliente,direccion_cliente,status_cliente FROM clientes WHERE cedula_cliente lIKE '%"+fecha+"%' "
                    + "or nombre1_cliente lIKE '%"+fecha+"%' "
                    + "or nombre2_cliente lIKE '%"+fecha+"%' "
                    + "or apellido1_cliente lIKE '%"+fecha+"%' "
                    + "or apellido2_cliente lIKE '%"+fecha+"%' "
                    + "or telefono_cliente lIKE '%"+fecha+"%' "
                    + "or correo_cliente lIKE '%"+fecha+"%' "
                    + "or direccion_cliente lIKE '%"+fecha+"%'";         
        }
       
        
        String []datos=new String[30];
        try{ 
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){ 
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                datos[7]=rs.getString(8);
                datos[8]=rs.getString(9);
            
                modelo3.addRow(datos);
            }
            tabla40.setModel(modelo3);
        }
        catch(SQLException ex){ 
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

 
 public void exportarExcel(JTable tabla40) throws IOException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString().concat(".xls");
            try {
                File archivoXLS = new File(ruta);
                if (archivoXLS.exists()) {
                    archivoXLS.delete();
                }
                archivoXLS.createNewFile();
                Workbook libro = new HSSFWorkbook();
                FileOutputStream archivo = new FileOutputStream(archivoXLS);
                Sheet hoja = libro.createSheet("Mi hoja de trabajo 1");
                hoja.setDisplayGridlines(false);
                for (int f = 0; f < tabla40.getRowCount(); f++) {
                    Row fila = hoja.createRow(f);
                    for (int c = 0; c < tabla40.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (f == 0) {
                            celda.setCellValue(tabla40.getColumnName(c));
                        }
                    }
                }
                int filaInicio = 1;
                for (int f = 0; f < tabla40.getRowCount(); f++) {
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int c = 0; c < tabla40.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (tabla40.getValueAt(f, c) instanceof Double) {
                            celda.setCellValue(Double.parseDouble(tabla40.getValueAt(f, c).toString()));
                        } else if (tabla40.getValueAt(f, c) instanceof Float) {
                            celda.setCellValue(Float.parseFloat((String) tabla40.getValueAt(f, c)));
                        } else {
                            celda.setCellValue(String.valueOf(tabla40.getValueAt(f, c)));
                        }
                    }
                }
                libro.write(archivo);
                archivo.close();
                Desktop.getDesktop().open(archivoXLS);
            } catch (IOException | NumberFormatException e) {
                throw e;
            }
        }
    }
 
         
         
         
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p2 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla40 = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        comboux = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        nombre1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nombre2 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        apellido1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        apellido2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        correo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        direccion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cedula = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        encargado = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        buscarp = new javax.swing.JTextField();
        FONDO = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        p2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p2ActionPerformed(evt);
            }
        });
        getContentPane().add(p2);
        p2.setBounds(1330, 540, 70, 30);

        jButton6.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/seleccionar.png"))); // NOI18N
        jButton6.setText("Seleccionar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(190, 540, 190, 50);

        jButton4.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        jButton4.setText("Actualizar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(380, 540, 190, 50);

        jButton7.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        jButton7.setText("Eliminar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(760, 540, 190, 50);

        tabla40.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla40);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 340, 1360, 200);

        jButton8.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mostrar.png"))); // NOI18N
        jButton8.setText("Mostrar todo");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(570, 540, 190, 50);

        jButton11.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/insertar.png"))); // NOI18N
        jButton11.setText("Insertar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11);
        jButton11.setBounds(0, 540, 190, 50);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 204)));
        jPanel2.setLayout(null);

        comboux.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        jPanel2.add(comboux);
        comboux.setBounds(70, 280, 200, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel3.setText("Primer nombre");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(70, 70, 200, 30);

        nombre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre1ActionPerformed(evt);
            }
        });
        nombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombre1KeyTyped(evt);
            }
        });
        jPanel2.add(nombre1);
        nombre1.setBounds(70, 100, 150, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel5.setText("Estatus Actual");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(70, 250, 140, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel10.setText("Segundo nombre");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(270, 70, 160, 30);

        nombre2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre2ActionPerformed(evt);
            }
        });
        nombre2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombre2KeyTyped(evt);
            }
        });
        jPanel2.add(nombre2);
        nombre2.setBounds(270, 100, 150, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel14.setText("Primer apellido");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(470, 70, 150, 30);

        apellido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellido1ActionPerformed(evt);
            }
        });
        apellido1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apellido1KeyTyped(evt);
            }
        });
        jPanel2.add(apellido1);
        apellido1.setBounds(470, 100, 150, 30);

        jLabel18.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel18.setText("Segundo apellido");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(670, 70, 160, 30);

        apellido2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apellido2KeyTyped(evt);
            }
        });
        jPanel2.add(apellido2);
        apellido2.setBounds(670, 100, 150, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel13.setText("Correo ");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(470, 160, 120, 30);

        correo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                correoKeyTyped(evt);
            }
        });
        jPanel2.add(correo);
        correo.setBounds(470, 190, 150, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel16.setText("Direccion");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(670, 160, 120, 30);

        direccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                direccionKeyTyped(evt);
            }
        });
        jPanel2.add(direccion);
        direccion.setBounds(670, 190, 150, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Formulario clientes");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(310, 20, 270, 29);

        jLabel15.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel15.setText("Cedula");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(70, 160, 120, 30);

        cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cedulaKeyTyped(evt);
            }
        });
        jPanel2.add(cedula);
        cedula.setBounds(70, 190, 150, 30);

        jLabel17.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel17.setText("Telefono");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(270, 160, 120, 30);

        telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefonoKeyTyped(evt);
            }
        });
        jPanel2.add(telefono);
        telefono.setBounds(270, 190, 150, 30);
        jPanel2.add(encargado);
        encargado.setBounds(470, 220, 70, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 910, 340);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 204)));
        jPanel1.setLayout(null);

        jButton10.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/excel.png"))); // NOI18N
        jButton10.setText("Excel");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10);
        jButton10.setBounds(190, 170, 190, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Consultas");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(150, 20, 130, 29);

        jButton12.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        jButton12.setText("Palabra clave");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton12);
        jButton12.setBounds(190, 130, 190, 40);
        jPanel1.add(buscarp);
        buscarp.setBounds(40, 130, 150, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(910, 0, 450, 340);

        FONDO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo.JPG"))); // NOI18N
        getContentPane().add(FONDO);
        FONDO.setBounds(0, 0, 1420, 660);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void p2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_p2ActionPerformed

    private void apellido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellido1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellido1ActionPerformed

    private void nombre2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int fila=tabla40.getSelectedRow();

        if(fila>=0){
            
            nombre1.setText(tabla40.getValueAt(fila, 0).toString());         
            nombre2.setText(tabla40.getValueAt(fila, 1).toString());
            apellido1.setText(tabla40.getValueAt(fila, 2).toString());
            apellido2.setText(tabla40.getValueAt(fila, 3).toString());
            cedula.setText(tabla40.getValueAt(fila, 4).toString());
            telefono.setText(tabla40.getValueAt(fila, 5).toString());
            correo.setText(tabla40.getValueAt(fila, 6).toString());
            direccion.setText(tabla40.getValueAt(fila, 7).toString());
            comboux.getModel().setSelectedItem(String.valueOf(tabla40.getModel().getValueAt(fila, 8)));
        }else {
            JOptionPane.showMessageDialog(null, "No selecciono fila");
        }
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try{
            PreparedStatement pst=cn.prepareStatement("UPDATE clientes "
                + "SET nombre1_cliente='"+nombre1.getText()
                +"',nombre2_cliente='"+nombre2.getText()  
                +"',apellido1_cliente='"+apellido1.getText()
                +"',apellido2_cliente='"+apellido2.getText()
                +"',cedula_cliente='"+cedula.getText()
                +"',telefono_cliente='"+telefono.getText()
                +"',correo_cliente='"+correo.getText()
                +"',direccion_cliente='"+direccion.getText()
                +"',status_cliente='"+comboux.getSelectedItem()
                +"' WHERE cedula_cliente='"+cedula.getText()+"'"
                // +"' WHERE proveedor='"+proveedor1.getText()+"'"
            );
            pst.executeUpdate();
            mostrar("");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        int fila= tabla40.getSelectedRow();
        String cod4="";

        cod4=tabla40.getValueAt(fila, 0).toString();
        try {

            PreparedStatement pst=cn.prepareStatement("DELETE FROM clientes WHERE nombre1_cliente='"+cod4+"' LIMIT 1");
            pst.executeUpdate();
            mostrar("");
            bitacoraeliminar();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed

        mostrar2(buscarp.getText());
 

    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        try {
            exportarExcel(tabla40);
        } catch (IOException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        bitacoraexcel();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        mostrar("");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
         try{

            PreparedStatement pst=cn.prepareStatement("INSERT INTO clientes (nombre1_cliente,nombre2_cliente,apellido1_cliente,apellido2_cliente,cedula_cliente,telefono_cliente,correo_cliente,direccion_cliente,status_cliente) VALUES (?,?,?,?,?,?,?,?,?)");           
            pst.setString(1, nombre1.getText());
            pst.setString(2, nombre2.getText());
            pst.setString(3, apellido1.getText());         
            pst.setString(4, apellido2.getText());
            pst.setString(5, cedula.getText());         
            pst.setString(6, telefono.getText());
            pst.setString(7, correo.getText());
            pst.setString(8, direccion.getText());
            pst.setString(9, (String) comboux.getSelectedItem());
            int n= pst.executeUpdate();
            if (n>0) 
            {
             JOptionPane.showMessageDialog(null, "Cliente registrado satisfactoriamente");
             bitacorainsertar();
            }
            mostrar("");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void nombre2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombre2KeyTyped
        evento.textKeyPress(evt);
    }//GEN-LAST:event_nombre2KeyTyped

    private void apellido1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellido1KeyTyped
        evento.textKeyPress(evt);
    }//GEN-LAST:event_apellido1KeyTyped

    private void apellido2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellido2KeyTyped
        evento.textKeyPress(evt);
    }//GEN-LAST:event_apellido2KeyTyped

    private void correoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correoKeyTyped
        
    }//GEN-LAST:event_correoKeyTyped

    private void direccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_direccionKeyTyped
        
    }//GEN-LAST:event_direccionKeyTyped

    private void nombre1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombre1KeyTyped
        evento.textKeyPress(evt);
    }//GEN-LAST:event_nombre1KeyTyped

    private void nombre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre1ActionPerformed

    private void cedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cedulaKeyTyped
        evento.numberKeyPress(evt);
    }//GEN-LAST:event_cedulaKeyTyped

    private void telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoKeyTyped
        evento.numberKeyPress(evt);
    }//GEN-LAST:event_telefonoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FONDO;
    private javax.swing.JTextField apellido1;
    private javax.swing.JTextField apellido2;
    private javax.swing.JTextField buscarp;
    private javax.swing.JTextField cedula;
    private javax.swing.JComboBox<String> comboux;
    private javax.swing.JTextField correo;
    private javax.swing.JTextField direccion;
    private javax.swing.JTextField encargado;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombre1;
    private javax.swing.JTextField nombre2;
    public static javax.swing.JTextField p2;
    private javax.swing.JTable tabla40;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
