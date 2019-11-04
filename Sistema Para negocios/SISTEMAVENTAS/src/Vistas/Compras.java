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

import Modelo.Compras2;
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

public class Compras extends javax.swing.JInternalFrame {

    conectar cc=new conectar();
    Connection cn=cc.conexion();


    
    TextFieldEvent evento= new TextFieldEvent();

    public Compras() {
        initComponents();

        
        Calendar c2 = new GregorianCalendar();
        dcFecha_venta.setCalendar(c2);
        
        SelectProveedor();
        SelectMaterial();
        ID.setVisible(false);
        
        encargado.setText(p1.getText());
        encargado.setEnabled(false);
        encargado.setVisible(false);
    }
    
    void bitacorainsertar(){ 
        try{
            String descripcion="Registro una compra";
            PreparedStatement pst=cn.prepareStatement("INSERT INTO bitacora (usuario,descripcion,fecha,hora) VALUES (?,?,?,?)");           
            pst.setString(1, encargado.getText());
            pst.setString(2, descripcion);
            pst.setString(3, Principal.Fecha.getText());
            pst.setString(4, Principal.Hora.getText());
            pst.executeUpdate();           
        }
        catch(SQLException ex){
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }
         void bitacoraactualizar(){ 
        try{
            String descripcion="Modifico los valores de una compra";
            PreparedStatement pst=cn.prepareStatement("INSERT INTO bitacora (usuario,descripcion,fecha,hora) VALUES (?,?,?,?)");           
            pst.setString(1, encargado.getText());
            pst.setString(2, descripcion);
            pst.setString(3, Principal.Fecha.getText());
            pst.setString(4, Principal.Hora.getText());
            pst.executeUpdate();           
        }
        catch(SQLException ex){
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }
         
         void bitacoraeliminar(){ 
        try{
            String descripcion="Elimino una compra";
            PreparedStatement pst=cn.prepareStatement("INSERT INTO bitacora (usuario,descripcion,fecha,hora) VALUES (?,?,?,?)");           
            pst.setString(1, encargado.getText());
            pst.setString(2, descripcion);
            pst.setString(3, Principal.Fecha.getText());
            pst.setString(4, Principal.Hora.getText());
            pst.executeUpdate();           
        }
        catch(SQLException ex){
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }
    
    public void SelectProveedor(){
    String sql="Select * from proveedor where status_proveedor='Activo' ";
        try{ 
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            { 
             comboux.addItem(rs.getString("nombre_proveedor"));   
            }

        }
        catch(SQLException ex){ 
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE,null,ex);
        }
}
    public void SelectMaterial(){
    String sql="Select * from materiales";
        try{ 
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            { 
             comboux2.addItem(rs.getString("nombre_material"));   
            }

        }
        catch(SQLException ex){ 
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE,null,ex);
        }
}
    /*
 public void mostrar(Object fecha){ 
    
     
     
     DefaultTableModel modelo3=new DefaultTableModel();
        modelo3.addColumn("Codigo de la compra");
        modelo3.addColumn("Material");     
        modelo3.addColumn("cantidad");  
        modelo3.addColumn("Precio unitario");
        modelo3.addColumn("Fecha");
        modelo3.addColumn("Subtotal");
        modelo3.addColumn("Iva");
        modelo3.addColumn("Descuento");
        modelo3.addColumn("Pago Total");
        modelo3.addColumn("Proveedor");;
    
        tabla40.setModel(modelo3);
        String sql= "";
        if(fecha.equals("")){ 
            sql="SELECT compras.num_factura, detalle_compra.id_material, detalle_compra.cantidad, detalle_compra.valor_unitario, compras.fecha, compras.subtotal, compras.iva, compras.descuento, compras.total, compras.id_proveedor FROM compras LEFT JOIN detalle_compra ON detalle_compra.id_compra = compras.id_compra";
        }
        else { 
            sql="SELECT compras.num_factura, detalle_compra.id_material, detalle_compra.cantidad, detalle_compra.valor_unitario, compras.fecha, compras.subtotal, compras.iva, compras.descuento, compras.total, compras.id_proveedor FROM compras,proveedor,materiales LEFT JOIN detalle_compra ON detalle_compra.id_compra = compras.id_compra WHERE compras.id_proveedor=proveedor.id_proveedor && detalle_compra.id_material=materiales.id_material";
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
                datos[9]=rs.getString(10);
            
                modelo3.addRow(datos);
            }
            tabla40.setModel(modelo3);
        }
        catch(SQLException ex){ 
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE,null,ex);
        }
     
    }
 */
    
    public void mostrar(Object fecha){ 
    
     
     
     DefaultTableModel modelo3=new DefaultTableModel();       
        modelo3.addColumn("Codigo");
        modelo3.addColumn("Proveedor");
        modelo3.addColumn("Nombre del material");
        modelo3.addColumn("Precio unitario");
        modelo3.addColumn("cantidad");              
        modelo3.addColumn("Subtotal");
        modelo3.addColumn("Iva");
        modelo3.addColumn("Descuento");
        modelo3.addColumn("Pago Total");
        modelo3.addColumn("fecha de la compra");
        modelo3.addColumn("Indice");
    
        tabla40.setModel(modelo3);
        String sql= "";
     
        if(fecha.equals(sql)){ 
            sql="SELECT * FROM compras2,proveedor,materiales WHERE compras2.id_proveedor=proveedor.id_proveedor && compras2.id_material=materiales.id_material";             
        }
        else { 
            sql="SELECT * FROM compras2,proveedor,materiales WHERE compras2.id_proveedor=proveedor.id_proveedor && compras2.id_material=materiales.id_material";             
        }
       
        
        String []datos=new String[30];
        try{ 
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){ 
                datos[0]=rs.getString(1);
                datos[1]=rs.getString("nombre_proveedor");
                datos[2]=rs.getString("nombre_material");
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                datos[7]=rs.getString(8);
                datos[8]=rs.getString(9);
                datos[9]=rs.getString(10);
                datos[10]=rs.getString(11);
            
                modelo3.addRow(datos);
            }
            tabla40.setModel(modelo3);
        }
        catch(SQLException ex){ 
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE,null,ex);
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
 public void mostrar2(Object fecha){ 
    
     
     
     DefaultTableModel modelo3=new DefaultTableModel();       
        modelo3.addColumn("Codigo");
        modelo3.addColumn("Proveedor");
        modelo3.addColumn("Nombre del material");
        modelo3.addColumn("Precio unitario");
        modelo3.addColumn("cantidad");              
        modelo3.addColumn("Subtotal");
        modelo3.addColumn("Iva");
        modelo3.addColumn("Descuento");
        modelo3.addColumn("Pago Total");
        modelo3.addColumn("fecha de la compra");
        modelo3.addColumn("Indice");
    
        tabla40.setModel(modelo3);
        String sql= "";
     
        if(fecha.equals(sql)){ 
            sql="SELECT * FROM compras2,proveedor,materiales WHERE compras2.id_proveedor=proveedor.id_proveedor && compras2.id_material=materiales.id_material";             
        }
        else { 
            sql="SELECT * FROM compras2,proveedor,materiales WHERE compras2.id_proveedor=proveedor.id_proveedor && compras2.id_material=materiales.id_material && codigo lIKE '%"+fecha+"%'"
                    + "or compras2.id_proveedor=proveedor.id_proveedor && compras2.id_material=materiales.id_material && nombre_proveedor lIKE '%"+fecha+"%' "
                    + "or compras2.id_proveedor=proveedor.id_proveedor && compras2.id_material=materiales.id_material && nombre_material lIKE '%"+fecha+"%' "
                    + "or compras2.id_proveedor=proveedor.id_proveedor && compras2.id_material=materiales.id_material && precio lIKE '%"+fecha+"%' "
                    + "or compras2.id_proveedor=proveedor.id_proveedor && compras2.id_material=materiales.id_material && cantidad lIKE '%"+fecha+"%' "
                    + "or compras2.id_proveedor=proveedor.id_proveedor && compras2.id_material=materiales.id_material && subtotal lIKE '%"+fecha+"%' "
                    + "or compras2.id_proveedor=proveedor.id_proveedor && compras2.id_material=materiales.id_material && iva lIKE '%"+fecha+"%' "
                    + "or compras2.id_proveedor=proveedor.id_proveedor && compras2.id_material=materiales.id_material && descuento lIKE '%"+fecha+"%' "
                    + "or compras2.id_proveedor=proveedor.id_proveedor && compras2.id_material=materiales.id_material && total lIKE '%"+fecha+"%' "
                    + "or compras2.id_proveedor=proveedor.id_proveedor && compras2.id_material=materiales.id_material && fecha lIKE '%"+fecha+"%' ";
        }
       
        
        String []datos=new String[30];
        try{ 
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){ 
                datos[0]=rs.getString(1);
                datos[1]=rs.getString("nombre_proveedor");
                datos[2]=rs.getString("nombre_material");
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                datos[7]=rs.getString(8);
                datos[8]=rs.getString(9);
                datos[9]=rs.getString(10);
                datos[10]=rs.getString(11);
            
                modelo3.addRow(datos);
            }
            tabla40.setModel(modelo3);
        }
        catch(SQLException ex){ 
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE,null,ex);
        }
     
    }
 
 
 public void mostrarFecha(Object fecha){ 
      
   DefaultTableModel modelo3=new DefaultTableModel();       
        modelo3.addColumn("Codigo");
        modelo3.addColumn("Proveedor");
        modelo3.addColumn("Nombre del material");
        modelo3.addColumn("Precio unitario");
        modelo3.addColumn("cantidad");              
        modelo3.addColumn("Subtotal");
        modelo3.addColumn("Iva");
        modelo3.addColumn("Descuento");
        modelo3.addColumn("Pago Total");
        modelo3.addColumn("fecha de la compra");
        modelo3.addColumn("Indice");
    
        tabla40.setModel(modelo3);
        String sql= "";
     
        if(fecha.equals(sql)){ 
            sql="SELECT * FROM compras2,proveedor,materiales WHERE compras2.id_proveedor=proveedor.id_proveedor && compras2.id_material=materiales.id_material && fecha='"+fecha+"'";             
        }
        else { 
            sql="SELECT * FROM compras2,proveedor,materiales WHERE compras2.id_proveedor=proveedor.id_proveedor && compras2.id_material=materiales.id_material && fecha='"+fecha+"'"; 
        }
       
        
        String []datos=new String[30];
        try{ 
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){ 
                datos[0]=rs.getString(1);
                datos[1]=rs.getString("nombre_proveedor");
                datos[2]=rs.getString("nombre_material");
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                datos[7]=rs.getString(8);
                datos[8]=rs.getString(9);
                datos[9]=rs.getString(10);
                datos[10]=rs.getString(11);
            
                modelo3.addRow(datos);
            }
            tabla40.setModel(modelo3);
        }
        catch(SQLException ex){ 
            Logger.getLogger(Compras.class.getName()).log(Level.SEVERE,null,ex);
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
        codigoc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        dcFecha_venta = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        cantidadp = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        preciop = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        subtotal = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        iva = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        descuento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
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

        comboux2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el material" }));
        jPanel2.add(comboux2);
        comboux2.setBounds(600, 100, 200, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel7.setText("Proveedor");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(310, 70, 110, 30);

        comboux.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione al proveedor" }));
        jPanel2.add(comboux);
        comboux.setBounds(310, 100, 200, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel3.setText("Numero de factura");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(70, 70, 180, 30);

        codigoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigocActionPerformed(evt);
            }
        });
        codigoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codigocKeyTyped(evt);
            }
        });
        jPanel2.add(codigoc);
        codigoc.setBounds(70, 100, 150, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel5.setText("Material");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(600, 70, 90, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel9.setText("Fecha de la compra");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(660, 250, 190, 30);

        dcFecha_venta.setBackground(new java.awt.Color(36, 33, 33));
        dcFecha_venta.setForeground(new java.awt.Color(207, 207, 207));
        dcFecha_venta.setDateFormatString("yyyy/MM/dd ");
        dcFecha_venta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(dcFecha_venta);
        dcFecha_venta.setBounds(660, 280, 150, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel10.setText("Cantidad ");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(70, 170, 90, 30);

        cantidadp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadpActionPerformed(evt);
            }
        });
        cantidadp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadpKeyTyped(evt);
            }
        });
        jPanel2.add(cantidadp);
        cantidadp.setBounds(70, 200, 150, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel14.setText("Precio Unitario");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(260, 170, 150, 30);

        preciop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preciopActionPerformed(evt);
            }
        });
        preciop.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                preciopKeyTyped(evt);
            }
        });
        jPanel2.add(preciop);
        preciop.setBounds(260, 200, 150, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel15.setText("Precio Total");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(460, 250, 120, 30);

        total.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                totalKeyTyped(evt);
            }
        });
        jPanel2.add(total);
        total.setBounds(460, 280, 150, 30);

        jLabel18.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel18.setText("Subtotal");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(460, 170, 120, 30);

        subtotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                subtotalKeyTyped(evt);
            }
        });
        jPanel2.add(subtotal);
        subtotal.setBounds(460, 200, 150, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel13.setText("IVA");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(70, 250, 120, 30);

        iva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ivaKeyTyped(evt);
            }
        });
        jPanel2.add(iva);
        iva.setBounds(70, 280, 150, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel16.setText("Descuento");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(260, 250, 120, 30);

        descuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                descuentoKeyTyped(evt);
            }
        });
        jPanel2.add(descuento);
        descuento.setBounds(260, 280, 150, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Registrar compra");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(310, 20, 210, 29);
        jPanel2.add(ID);
        ID.setBounds(620, 180, 100, 20);
        jPanel2.add(encargado);
        encargado.setBounds(730, 70, 70, 30);

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

    private void preciopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preciopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preciopActionPerformed

    private void cantidadpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadpActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        /*
        int fila=tabla40.getSelectedRow();

        if(fila>=0){
            
            codigoc.setText(tabla40.getValueAt(fila, 0).toString());
            comboux2.getModel().setSelectedItem(String.valueOf(tabla40.getModel().getValueAt(fila, 1)));           
            cantidadp.setText(tabla40.getValueAt(fila, 2).toString());
            preciop.setText(tabla40.getValueAt(fila, 3).toString());
            dcFecha_venta.setDate(Date.valueOf(tabla40.getValueAt(fila, 4).toString()));
            subtotal.setText(tabla40.getValueAt(fila, 5).toString());
            iva.setText(tabla40.getValueAt(fila, 6).toString());
            descuento.setText(tabla40.getValueAt(fila, 7).toString());
            total.setText(tabla40.getValueAt(fila, 8).toString());     
            comboux.getModel().setSelectedItem(String.valueOf(tabla40.getModel().getValueAt(fila, 9))); 
        }else {
            JOptionPane.showMessageDialog(null, "No selecciono fila");
        }
       */
        int fila=tabla40.getSelectedRow();

        if(fila>=0){
            
            codigoc.setText(tabla40.getValueAt(fila, 0).toString());
            comboux.getModel().setSelectedItem(String.valueOf(tabla40.getModel().getValueAt(fila, 1)));
            comboux2.getModel().setSelectedItem(String.valueOf(tabla40.getModel().getValueAt(fila, 2))); 
            preciop.setText(tabla40.getValueAt(fila, 3).toString());
            cantidadp.setText(tabla40.getValueAt(fila, 4).toString());                       
            subtotal.setText(tabla40.getValueAt(fila, 5).toString());
            iva.setText(tabla40.getValueAt(fila, 6).toString());
            descuento.setText(tabla40.getValueAt(fila, 7).toString());
            total.setText(tabla40.getValueAt(fila, 8).toString());
            dcFecha_venta.setDate(Date.valueOf(tabla40.getValueAt(fila, 9).toString()));
            ID.setText(tabla40.getValueAt(fila, 10).toString());
        }else {
            JOptionPane.showMessageDialog(null, "No selecciono fila");
        }
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       
        try{
            PreparedStatement pst=cn.prepareStatement("UPDATE compras2 "
                + "SET codigo='"+codigoc.getText()
                +"',id_proveedor='"+comboux.getSelectedIndex()
                +"',id_material='"+comboux2.getSelectedIndex()
                +"',precio='"+preciop.getText()
                +"',cantidad='"+cantidadp.getText()                             
                +"',subtotal='"+subtotal.getText()
                +"',iva='"+iva.getText()
                +"',descuento='"+descuento.getText()
                +"',total='"+total.getText()
                +"',fecha='"+new java.sql.Date(dcFecha_venta.getDate().getTime())
                +"' WHERE id_compras='"+ID.getText()+"'"
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
/*
        int fila= tabla40.getSelectedRow();
        String cod4="";

        cod4=tabla40.getValueAt(fila, 0).toString();
        try {

            PreparedStatement pst=cn.prepareStatement("DELETE FROM compras LIMIT 1");
            pst.executeUpdate();
            PreparedStatement pst2=cn.prepareStatement("DELETE FROM detalle_compra LIMIT 1");
            pst2.executeUpdate();
            mostrar("");

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        */
int fila= tabla40.getSelectedRow();
        String filaa="";

        filaa=tabla40.getValueAt(fila, 0).toString();
        try {

            PreparedStatement pst=cn.prepareStatement("DELETE FROM compras2 WHERE codigo='"+filaa+"' LIMIT 1");
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
         
        
      /*  
String ultimoValor = null;

try {
    
     PreparedStatement pst1=cn.prepareStatement("INSERT INTO compras (num_factura,fecha,subtotal,iva,descuento,total,id_proveedor) VALUES (?,?,?,?,?,?,?)");           
            pst1.setString(1, codigoc.getText());
            pst1.setDate(2, new java.sql.Date(dcFecha_venta.getDate().getTime()));
            pst1.setString(3, subtotal.getText());
            pst1.setString(4, iva.getText());
            pst1.setString(5, descuento.getText());
            pst1.setString(6, total.getText());
            pst1.setInt(7, comboux.getSelectedIndex());          
            int n1= pst1.executeUpdate();
            
    PreparedStatement stmtr = cn.prepareStatement("SELECT * FROM compras ORDER BY id_compra DESC");
    ResultSet rsr = stmtr.executeQuery();
    if(rsr.next()){
        ultimoValor = rsr.getString("id_compra");
    }
    int id = Integer.parseInt(ultimoValor);
    ID.setText(ultimoValor);
    
    
    PreparedStatement pst=cn.prepareStatement("INSERT INTO detalle_compra (id_compra,id_material,cantidad,valor_unitario,total) VALUES (?,?,?,?,?)");  
            int affectedRows = pst.executeUpdate();
if (affectedRows == 0) {
        throw new SQLException("No se pudo guardar");
}
            pst.setInt(1, id);
            pst.setInt(2, comboux2.getSelectedIndex());           
            pst.setString(3, cantidadp.getText()); 
            pst.setString(4, preciop.getText());          
            pst.setString(5, total.getText());      
            int n= pst.executeUpdate();
            if (n>0) 
            {
             JOptionPane.showMessageDialog(null, "Compra registrada satisfactoriamente");
            }
            
        
    stmtr.close();
    rsr.close();
    cn.close();
} catch (Exception e) {
        e.printStackTrace();
}
  */
     
     try{

            PreparedStatement pst=cn.prepareStatement("INSERT INTO compras2 (codigo,id_proveedor,id_material,precio,cantidad,subtotal,iva,descuento,total,fecha) VALUES (?,?,?,?,?,?,?,?,?,?)");           
            pst.setString(1, codigoc.getText());
            pst.setInt(2, comboux.getSelectedIndex());
            pst.setInt(3, comboux2.getSelectedIndex());
            pst.setString(4, preciop.getText());
            pst.setString(5, cantidadp.getText());
            pst.setString(6, subtotal.getText());
            pst.setString(7, iva.getText());
            pst.setString(8, descuento.getText());
            pst.setString(9, total.getText());
            pst.setDate(10, new java.sql.Date(dcFecha_venta.getDate().getTime()));

            int n= pst.executeUpdate();
            if (n>0) 
            {
             JOptionPane.showMessageDialog(null, "Compra registrada satisfactoriamente");
            }
            mostrar("");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());

        }     
         bitacorainsertar();
         
    }//GEN-LAST:event_jButton11ActionPerformed

    private void cantidadpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadpKeyTyped
        evento.numberKeyPress(evt);
    }//GEN-LAST:event_cantidadpKeyTyped

    private void preciopKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_preciopKeyTyped
        evento.numberDecimalKeyPress(evt, preciop);
    }//GEN-LAST:event_preciopKeyTyped

    private void totalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_totalKeyTyped
        evento.numberDecimalKeyPress(evt, total);
    }//GEN-LAST:event_totalKeyTyped

    private void subtotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_subtotalKeyTyped
        evento.numberDecimalKeyPress(evt, subtotal);
    }//GEN-LAST:event_subtotalKeyTyped

    private void ivaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ivaKeyTyped
        evento.numberDecimalKeyPress(evt, iva);
    }//GEN-LAST:event_ivaKeyTyped

    private void descuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descuentoKeyTyped
        evento.numberDecimalKeyPress(evt, descuento);
    }//GEN-LAST:event_descuentoKeyTyped

    private void codigocKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigocKeyTyped
        evento.numberKeyPress(evt);
    }//GEN-LAST:event_codigocKeyTyped

    private void codigocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigocActionPerformed

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
    private javax.swing.JTextField ID;
    private javax.swing.JTextField buscarp;
    private javax.swing.JTextField cantidadp;
    private javax.swing.JTextField codigoc;
    private javax.swing.JComboBox<String> comboux;
    private javax.swing.JComboBox<String> comboux2;
    private com.toedter.calendar.JDateChooser dcFecha_venta;
    private javax.swing.JTextField descuento;
    private javax.swing.JTextField encargado;
    private javax.swing.JTextField iva;
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
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField p2;
    private javax.swing.JTextField preciop;
    private javax.swing.JTextField subtotal;
    private javax.swing.JTable tabla40;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
