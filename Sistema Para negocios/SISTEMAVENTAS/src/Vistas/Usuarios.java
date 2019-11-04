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


import Validaciones.TextFieldEvent;
import static Vistas.Principal.p1;


import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Usuarios extends javax.swing.JInternalFrame {

    conectar cc=new conectar();
    Connection cn=cc.conexion();

    TextFieldEvent evento= new TextFieldEvent();
    public Usuarios() {
        initComponents();
        String Contraseña1 = contraseña.getText();
        String Contraseña2 = contraseña2.getText();
        encargado.setText(p1.getText());
        encargado.setEnabled(false);
        encargado.setVisible(false);
        
    }
   
    
 
    
 public void mostrar(Object fecha){ 
    
     
     
     DefaultTableModel modelo3=new DefaultTableModel();
        modelo3.addColumn("Nombre");
        modelo3.addColumn("Apellido");
        modelo3.addColumn("Correo");
        modelo3.addColumn("Clave");
        modelo3.addColumn("Tipo de Usuario");              
        modelo3.addColumn("Pregunta de seguridad");
        modelo3.addColumn("Respuesta a la pregunta");
        modelo3.addColumn("Estatus");
    
        tabla40.setModel(modelo3);
        String sql= "";
        if(fecha.equals("")){ 
            sql="SELECT nombre1_usuario, apellido1_usuario, correo, clave, tipo_usuario, pregunta_seguridad, respuesta_seguridad, status_usuario FROM usuario";
        }
        else { 
            sql="SELECT nombre1_usuario, apellido1_usuario, correo, clave, tipo_usuario, pregunta_seguridad, respuesta_seguridad, status_usuario FROM usuario WHERE nombre1_usuario='"+fecha+"'";
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
            
                modelo3.addRow(datos);
            }
            tabla40.setModel(modelo3);
        }
        catch(SQLException ex){ 
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE,null,ex);
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
 
 public void mostrar2(Object fecha){ 
    
     
     
     DefaultTableModel modelo3=new DefaultTableModel();       
        modelo3.addColumn("Nombre");
        modelo3.addColumn("Apellido");
        modelo3.addColumn("Correo");
        modelo3.addColumn("Clave");
        modelo3.addColumn("Tipo de Usuario");              
        modelo3.addColumn("Pregunta de seguridad");
        modelo3.addColumn("Respuesta a la pregunta");
        modelo3.addColumn("Estatus");

    
        tabla40.setModel(modelo3);
        String sql= "";
     
        if(fecha.equals("")){ 
            sql="SELECT nombre1_usuario, apellido1_usuario, correo, clave, tipo_usuario, pregunta_seguridad, respuesta_seguridad, status_usuario FROM usuario";
        }
        else { 
            sql="SELECT nombre1_usuario, apellido1_usuario, correo, clave, tipo_usuario, pregunta_seguridad, respuesta_seguridad, status_usuario FROM usuario WHERE nombre1_usuario LIKE '"+fecha+"'"
                    + "or apellido1_usuario LIKE '"+fecha+"'"
                    + "or correo LIKE '"+fecha+"'"
                    + "or clave LIKE '"+fecha+"'"
                    + "or tipo_usuario LIKE '"+fecha+"'"
                    + "or pregunta_seguridad LIKE '"+fecha+"'"
                    + "or respuesta_seguridad LIKE '"+fecha+"'"
                    + "or status_usuario LIKE '"+fecha+"'";
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
            
                modelo3.addRow(datos);
            }
            tabla40.setModel(modelo3);
        }
        catch(SQLException ex){ 
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE,null,ex);
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
 
 public void mostrarFecha(Object fecha){ 
      
  DefaultTableModel modelo3=new DefaultTableModel();
        modelo3.addColumn("Codigo de la compra");
        modelo3.addColumn("Nombre del proveedor");
        modelo3.addColumn("Nombre del producto");
        modelo3.addColumn("Precio unitario");
        modelo3.addColumn("cantidad");              
        modelo3.addColumn("Subtotal");
        modelo3.addColumn("Iva");
        modelo3.addColumn("Descuento");
        modelo3.addColumn("Pago Total");
        modelo3.addColumn("fecha de la compra");
    
        tabla40.setModel(modelo3);
        String sql= "";
    
        if(fecha.equals("")){ 
            sql="SELECT * FROM compras,proveedor,productos WHERE compras.id_proveedor=proveedor.id_proveedor && compras.id_producto=productos.id_producto";             
        }
        else { 
            sql="SELECT * FROM compras,proveedor,productos WHERE compras.id_proveedor=proveedor.id_proveedor && compras.id_producto=productos.id_producto && fecha='"+fecha+"'";
        }  
        String []datos=new String[30];
        try{ 
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){ 
                datos[0]=rs.getString(1);
                datos[1]=rs.getString("nombre_proveedor");
                datos[2]=rs.getString("nombre");
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                datos[7]=rs.getString(8);
                datos[8]=rs.getString(9);
                datos[9]=rs.getString(10);
            
                modelo3.addRow(datos);
            }
            tabla40.setModel(modelo3);
        }
        catch(SQLException ex){ 
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE,null,ex);
        }
     
     
    }
 
     void bitacorainsertar(){ 
        try{
            String descripcion="Registro un usuario";
            PreparedStatement pst=cn.prepareStatement("INSERT INTO bitacora (usuario,descripcion,fecha,hora) VALUES (?,?,?,?)");           
            pst.setString(1, encargado.getText());
            pst.setString(2, descripcion);
            pst.setString(3, Principal.Fecha.getText());
            pst.setString(4, Principal.Hora.getText());
            pst.executeUpdate();           
        }
        catch(SQLException ex){
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }
         void bitacoraactualizar(){ 
        try{
            String descripcion="Modifico los datos de un usuario";
            PreparedStatement pst=cn.prepareStatement("INSERT INTO bitacora (usuario,descripcion,fecha,hora) VALUES (?,?,?,?)");           
            pst.setString(1, encargado.getText());
            pst.setString(2, descripcion);
            pst.setString(3, Principal.Fecha.getText());
            pst.setString(4, Principal.Hora.getText());
            pst.executeUpdate();           
        }
        catch(SQLException ex){
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }
         
         void bitacoraeliminar(){ 
        try{
            String descripcion="Elimino a un usuario";
            PreparedStatement pst=cn.prepareStatement("INSERT INTO bitacora (usuario,descripcion,fecha,hora) VALUES (?,?,?,?)");           
            pst.setString(1, encargado.getText());
            pst.setString(2, descripcion);
            pst.setString(3, Principal.Fecha.getText());
            pst.setString(4, Principal.Hora.getText());
            pst.executeUpdate();           
        }
        catch(SQLException ex){
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());

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
        jButton9 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        comboux2 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        comboux = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        apellido = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        correo = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        contraseña = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        pregunta = new javax.swing.JTextField();
        respuesta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        contraseña2 = new javax.swing.JTextField();
        encargado = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        buscarp = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
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

        jButton9.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        jButton9.setText("Fecha");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9);
        jButton9.setBounds(1100, 90, 190, 40);

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

        comboux2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        jPanel2.add(comboux2);
        comboux2.setBounds(560, 190, 200, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel7.setText("Tipo de usuario");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(560, 240, 150, 30);

        comboux.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Encargado(a)", "Vendedor(a)" }));
        jPanel2.add(comboux);
        comboux.setBounds(560, 270, 200, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel3.setText("Primer nombre");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(70, 70, 180, 30);

        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreKeyTyped(evt);
            }
        });
        jPanel2.add(nombre);
        nombre.setBounds(70, 100, 150, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel5.setText("Status");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(560, 160, 70, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel10.setText("Primer apellido");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(300, 70, 140, 30);

        apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidoActionPerformed(evt);
            }
        });
        apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apellidoKeyTyped(evt);
            }
        });
        jPanel2.add(apellido);
        apellido.setBounds(300, 100, 150, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel14.setText("Correo electronico");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(560, 70, 180, 30);

        correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correoActionPerformed(evt);
            }
        });
        correo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                correoKeyTyped(evt);
            }
        });
        jPanel2.add(correo);
        correo.setBounds(560, 100, 150, 30);

        jLabel18.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel18.setText("Contraseña");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(70, 160, 210, 30);

        contraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contraseñaKeyTyped(evt);
            }
        });
        jPanel2.add(contraseña);
        contraseña.setBounds(70, 190, 150, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel13.setText("Respuesta de la pregunta");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(300, 250, 240, 30);

        jLabel19.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel19.setText("Pregunta de seguridad");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(70, 250, 210, 30);

        pregunta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                preguntaKeyTyped(evt);
            }
        });
        jPanel2.add(pregunta);
        pregunta.setBounds(70, 280, 150, 30);

        respuesta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                respuestaKeyTyped(evt);
            }
        });
        jPanel2.add(respuesta);
        respuesta.setBounds(300, 280, 150, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Registrar Usuario");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(310, 20, 210, 29);

        jLabel20.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel20.setText("Repita contraseña");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(300, 160, 210, 30);

        contraseña2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contraseña2KeyTyped(evt);
            }
        });
        jPanel2.add(contraseña2);
        contraseña2.setBounds(300, 190, 150, 30);
        jPanel2.add(encargado);
        encargado.setBounds(760, 190, 70, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 910, 340);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 204)));
        jPanel1.setLayout(null);

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
        jPanel1.add(jDateChooser2);
        jDateChooser2.setBounds(40, 90, 150, 40);
        jPanel1.add(buscarp);
        buscarp.setBounds(40, 130, 150, 40);

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

    private void correoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_correoActionPerformed

    private void apellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidoActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int fila=tabla40.getSelectedRow();

        if(fila>=0){
            
            nombre.setText(tabla40.getValueAt(fila, 0).toString());
            apellido.setText(tabla40.getValueAt(fila, 1).toString());
            correo.setText(tabla40.getValueAt(fila, 2).toString());
            contraseña.setText(tabla40.getValueAt(fila, 3).toString());
            comboux.getModel().setSelectedItem(String.valueOf(tabla40.getModel().getValueAt(fila, 4)));           
            pregunta.setText(tabla40.getValueAt(fila, 5).toString());
            respuesta.setText(tabla40.getValueAt(fila, 6).toString());
            comboux2.getModel().setSelectedItem(String.valueOf(tabla40.getModel().getValueAt(fila, 7)));

        }else {
            JOptionPane.showMessageDialog(null, "No selecciono fila");
        }
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try{
            PreparedStatement pst=cn.prepareStatement("UPDATE usuario "
                + "SET nombre1_usuario='"+nombre.getText()
                +"',apellido1_usuario='"+apellido.getText()
                +"',correo='"+correo.getText()
                +"',clave='"+contraseña.getText()
                +"',tipo_usuario='"+comboux.getSelectedItem()                             
                +"',pregunta_seguridad='"+pregunta.getText()
                +"',respuesta_seguridad='"+respuesta.getText()
                +"',status_usuario='"+comboux2.getSelectedItem()

                +"' WHERE nombre1_usuario='"+nombre.getText()+"'"
                // +"' WHERE proveedor='"+proveedor1.getText()+"'"
            );
            pst.executeUpdate();
            mostrar("");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        bitacoraactualizar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        int fila= tabla40.getSelectedRow();
        String cod4="";

        cod4=tabla40.getValueAt(fila, 2).toString();
        try {

            PreparedStatement pst=cn.prepareStatement("DELETE FROM usuario WHERE correo='"+cod4+"' LIMIT 1");
            pst.executeUpdate();
            mostrar("");

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        bitacoraeliminar();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        java.util.Date fec= new java.util.Date();
    fec= jDateChooser2.getDate();
    java.util.Date fecha=new java.sql.Date(fec.getTime());
    mostrarFecha(fecha);

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed

        mostrar2(buscarp.getText());
 

    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        mostrar("");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        
         
        if(contraseña.getText().equals(contraseña2.getText())){ 
           try{

            PreparedStatement pst=cn.prepareStatement("INSERT INTO usuario (nombre1_usuario,apellido1_usuario,correo,clave,tipo_usuario,pregunta_seguridad,respuesta_seguridad,status_usuario) VALUES (?,?,?,?,?,?,?,?)");           
            pst.setString(1, nombre.getText());
            pst.setString(2, apellido.getText());
            pst.setString(3, correo.getText());
            pst.setString(4, contraseña.getText());
            pst.setString(5, (String) comboux.getSelectedItem());
            pst.setString(6, pregunta.getText());
            pst.setString(7, respuesta.getText());
            pst.setString(8, (String) comboux2.getSelectedItem());         

            int n= pst.executeUpdate();
            if (n>0) 
            {
             JOptionPane.showMessageDialog(null, "Usuario registrado satisfactoriamente");
            }
            mostrar("");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());

        } 
           bitacorainsertar();
        }
        else{ 
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
        }
        
    }//GEN-LAST:event_jButton11ActionPerformed

    private void apellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidoKeyTyped
        evento.textKeyPress(evt);
    }//GEN-LAST:event_apellidoKeyTyped

    private void correoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correoKeyTyped
    
    }//GEN-LAST:event_correoKeyTyped

    private void contraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contraseñaKeyTyped
    
    }//GEN-LAST:event_contraseñaKeyTyped

    private void respuestaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_respuestaKeyTyped
    
    }//GEN-LAST:event_respuestaKeyTyped

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyTyped
        evento.textKeyPress(evt);
    }//GEN-LAST:event_nombreKeyTyped

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void preguntaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_preguntaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_preguntaKeyTyped

    private void contraseña2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contraseña2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_contraseña2KeyTyped

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        try {
            exportarExcel(tabla40);
        } catch (IOException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        bitacoraexcel();
    }//GEN-LAST:event_jButton10ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FONDO;
    private javax.swing.JTextField apellido;
    private javax.swing.JTextField buscarp;
    private javax.swing.JComboBox<String> comboux;
    private javax.swing.JComboBox<String> comboux2;
    private javax.swing.JTextField contraseña;
    private javax.swing.JTextField contraseña2;
    private javax.swing.JTextField correo;
    private javax.swing.JTextField encargado;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombre;
    public static javax.swing.JTextField p2;
    private javax.swing.JTextField pregunta;
    private javax.swing.JTextField respuesta;
    private javax.swing.JTable tabla40;
    // End of variables declaration//GEN-END:variables
}
