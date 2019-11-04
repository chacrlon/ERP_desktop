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

public class Ventas extends javax.swing.JInternalFrame {

    conectar cc=new conectar();
    Connection cn=cc.conexion();

    TextFieldEvent evento= new TextFieldEvent();

    public Ventas() {
        initComponents();

        
        Calendar c2 = new GregorianCalendar();
        dcFecha_venta.setCalendar(c2);
        
        SelectCliente();
        SelectMaterial();
        parametros();
        encargado.setText(p1.getText());
        encargado.setEnabled(false);
        encargado.setVisible(false);
        ID.setVisible(false);
        vendedor.setText(p1.getText());
        vendedor.setEnabled(false);
        subtotal.setEnabled(false);
        iva.setEnabled(false);
        descuento.setEnabled(false);
        total.setEnabled(false);
        
        
    }
   
    void parametros(){ 
             String sql="";
        sql="select * from parametros_adicionales where id_parametros_adicionales=1";
        try {
        java.sql.Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        if(rs.first()){
        iva.setText(rs.getString("porcentaje_iva_v"));
        descuento.setText(rs.getString("porcentaje_descuento"));

        }
        }
        catch(SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al realizar la consulta");
        
         }}
    
    public void SelectCliente(){
    String sql="Select * from clientes where status_cliente='Activo' ";
        try{ 
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            { 
             comboux.addItem(rs.getString("cedula_cliente"));  
             
            }

        }
        catch(SQLException ex){ 
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE,null,ex);
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
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE,null,ex);
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
        modelo3.addColumn("Encargado");
        modelo3.addColumn("Cedula cliente");
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
            sql="SELECT * FROM ventas2,clientes,materiales WHERE ventas2.id_cliente=clientes.id_cliente && ventas2.id_material=materiales.id_material";             
        }
        else { 
            sql="SELECT * FROM ventas2,clientes,materiales WHERE ventas2.id_cliente=clientes.id_cliente && ventas2.id_material=materiales.id_material";             
        }
       
        
        String []datos=new String[30];
        try{ 
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){ 
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString("cedula_cliente");
                datos[3]=rs.getString("nombre_material");
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                datos[7]=rs.getString(8);
                datos[8]=rs.getString(9);
                datos[9]=rs.getString(10);
                datos[10]=rs.getString(11);
                datos[11]=rs.getString(12);
            
                modelo3.addRow(datos);
            }
            tabla40.setModel(modelo3);
        }
        catch(SQLException ex){ 
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE,null,ex);
        }
     
    }
    
 public void mostrar2(Object fecha){ 
    
     
     
     DefaultTableModel modelo3=new DefaultTableModel();       
        modelo3.addColumn("Codigo");
        modelo3.addColumn("Encargado");
        modelo3.addColumn("Cedula cliente");
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
            sql="SELECT * FROM ventas2,clientes,materiales WHERE ventas2.id_cliente=clientes.id_cliente && ventas2.id_material=materiales.id_material";             
        }
        else { 
            sql="SELECT * FROM ventas2,clientes,materiales WHERE ventas2.id_cliente=clientes.id_cliente && ventas2.id_material=materiales.id_material && codigo lIKE '%"+fecha+"%'"
                    + "or ventas2.id_cliente=clientes.id_cliente && ventas2.id_material=materiales.id_material && vendedor lIKE '%"+fecha+"%' "
                    + "or ventas2.id_cliente=clientes.id_cliente && ventas2.id_material=materiales.id_material && nombre1_cliente lIKE '%"+fecha+"%' "
                    + "or ventas2.id_cliente=clientes.id_cliente && ventas2.id_material=materiales.id_material && nombre_material lIKE '%"+fecha+"%' "
                    + "or ventas2.id_cliente=clientes.id_cliente && ventas2.id_material=materiales.id_material && precio lIKE '%"+fecha+"%' "
                    + "or ventas2.id_cliente=clientes.id_cliente && ventas2.id_material=materiales.id_material && cantidad lIKE '%"+fecha+"%' "
                    + "or ventas2.id_cliente=clientes.id_cliente && ventas2.id_material=materiales.id_material && subtotal lIKE '%"+fecha+"%' "
                    + "or ventas2.id_cliente=clientes.id_cliente && ventas2.id_material=materiales.id_material && iva lIKE '%"+fecha+"%' "
                    + "or ventas2.id_cliente=clientes.id_cliente && ventas2.id_material=materiales.id_material && descuento lIKE '%"+fecha+"%' "
                    + "or ventas2.id_cliente=clientes.id_cliente && ventas2.id_material=materiales.id_material && total lIKE '%"+fecha+"%' "
                    + "or ventas2.id_cliente=clientes.id_cliente && ventas2.id_material=materiales.id_material && fecha lIKE '%"+fecha+"%' ";
        }
       
        
        String []datos=new String[30];
        try{ 
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){ 
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString("cedula_cliente");
                datos[3]=rs.getString("nombre_material");
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                datos[7]=rs.getString(8);
                datos[8]=rs.getString(9);
                datos[9]=rs.getString(10);
                datos[10]=rs.getString(11);
                datos[11]=rs.getString(12);
            
                modelo3.addRow(datos);
            }
            tabla40.setModel(modelo3);
        }
        catch(SQLException ex){ 
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE,null,ex);
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
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE,null,ex);
        }
     
     
    }
 
 
         void descontarstock(String codi,String can)
    {
       int des = Integer.parseInt(can);
       String sql="";
       int desfinal;
       String consul="SELECT * FROM materiales WHERE  codigo_material='"+codi+"'";
        try {
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(consul);
            while(rs.next())
            {
                sql= rs.getString(5);
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        desfinal=Integer.parseInt(sql)-des;
        String modi="UPDATE materiales SET stock='"+desfinal+"' WHERE codigo_material = '"+codi+"'";
        try {
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
   
    }
         
         void calcular()
    {
        
        
        
        double preciox=0;
        int cantidadx=0;  
        double subtotalx=0;
        double ivax=0;
        double descuentox=0;
        double totalx=0;
        
        String precioxx;
        String cantidadxx;
        String ivaxx;
        String descuentoxx;
        
        precioxx=precio.getText();
        preciox=Double.parseDouble(precioxx);
        cantidadxx=cantidad.getText();
        cantidadx=Integer.parseInt(cantidadxx);
        
        
        ivaxx=iva.getText();
        ivax=Double.parseDouble(ivaxx);
        descuentoxx=descuento.getText();
        descuentox=Double.parseDouble(descuentoxx);

        
                
        subtotalx=preciox*cantidadx;
        ivax=(ivax*subtotalx)/100;
        descuentox=(descuentox*subtotalx)/100;
        totalx=subtotalx-(ivax+descuentox);
 
        

        subtotal.setText(""+Math.rint(subtotalx));

        total.setText(""+Math.rint(totalx));
        
        
            
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
         
         void insertar(){ 
              try{
            PreparedStatement pst=cn.prepareStatement("INSERT INTO ventas2 (codigo,vendedor,id_cliente,id_material,precio,cantidad,subtotal,iva,descuento,total,fecha) VALUES (?,?,?,?,?,?,?,?,?,?,?)");           
            pst.setString(1, codigo.getText());
            pst.setString(2, vendedor.getText());
            pst.setInt(3, comboux.getSelectedIndex());
            pst.setInt(4, comboux2.getSelectedIndex());
            pst.setString(5, precio.getText());
            pst.setString(6, cantidad.getText());
            pst.setString(7, subtotal.getText());
            pst.setString(8, iva.getText());
            pst.setString(9, descuento.getText());
            pst.setString(10, total.getText());
            pst.setDate(11, new java.sql.Date(dcFecha_venta.getDate().getTime()));

            int n= pst.executeUpdate();
            if (n>0) 
            {
             JOptionPane.showMessageDialog(null, "Venta registrada satisfactoriamente");
            }
            mostrar("");
        }
        catch(SQLException ex){
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }     
                          
         }
         
          void actualizarStock(){ 
             try{
            PreparedStatement pst=cn.prepareStatement("UPDATE materiales "
                + "SET stock= stock-'"+cantidad.getText()+"' WHERE id_material='"+comboux2.getSelectedIndex()+"'"
                // +"' WHERE proveedor='"+proveedor1.getText()+"'"
            );
            pst.executeUpdate();
            mostrar("");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        } }     
         
         
         void bitacorainsertar(){ 
        try{
            String descripcion="Realizo una venta";
            PreparedStatement pst=cn.prepareStatement("INSERT INTO bitacora (usuario,descripcion,fecha,hora) VALUES (?,?,?,?)");           
            pst.setString(1, encargado.getText());
            pst.setString(2, descripcion);
            pst.setString(3, Principal.Fecha.getText());
            pst.setString(4, Principal.Hora.getText());
            pst.executeUpdate();           
        }
        catch(SQLException ex){
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }
         void bitacoraactualizar(){ 
        try{
            String descripcion="Modifico los valores de la venta";
            PreparedStatement pst=cn.prepareStatement("INSERT INTO bitacora (usuario,descripcion,fecha,hora) VALUES (?,?,?,?)");           
            pst.setString(1, encargado.getText());
            pst.setString(2, descripcion);
            pst.setString(3, Principal.Fecha.getText());
            pst.setString(4, Principal.Hora.getText());
            pst.executeUpdate();           
        }
        catch(SQLException ex){
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }
         
         void bitacoraeliminar(){ 
        try{
            String descripcion="Elimino un registro de venta";
            PreparedStatement pst=cn.prepareStatement("INSERT INTO bitacora (usuario,descripcion,fecha,hora) VALUES (?,?,?,?)");           
            pst.setString(1, encargado.getText());
            pst.setString(2, descripcion);
            pst.setString(3, Principal.Fecha.getText());
            pst.setString(4, Principal.Hora2.getText());
            pst.executeUpdate();           
        }
        catch(SQLException ex){
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel3 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        dcFecha_venta = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        cantidad = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        precio = new javax.swing.JTextField();
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
        jLabel6 = new javax.swing.JLabel();
        comboux = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        vendedor = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
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
        comboux2.setBounds(670, 100, 170, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel3.setText("Numero de factura");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(70, 70, 180, 30);

        codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoActionPerformed(evt);
            }
        });
        codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codigoKeyTyped(evt);
            }
        });
        jPanel2.add(codigo);
        codigo.setBounds(70, 100, 150, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel5.setText("Material");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(670, 70, 90, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel9.setText("Fecha de la venta");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(670, 250, 190, 30);

        dcFecha_venta.setBackground(new java.awt.Color(36, 33, 33));
        dcFecha_venta.setForeground(new java.awt.Color(207, 207, 207));
        dcFecha_venta.setDateFormatString("yyyy/MM/dd ");
        dcFecha_venta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(dcFecha_venta);
        dcFecha_venta.setBounds(670, 280, 150, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel10.setText("Cantidad ");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(260, 160, 90, 30);

        cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadActionPerformed(evt);
            }
        });
        cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadKeyTyped(evt);
            }
        });
        jPanel2.add(cantidad);
        cantidad.setBounds(260, 190, 150, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel14.setText("Precio Unitario");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(70, 160, 150, 30);

        precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioActionPerformed(evt);
            }
        });
        precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioKeyTyped(evt);
            }
        });
        jPanel2.add(precio);
        precio.setBounds(70, 190, 150, 30);

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
        jLabel18.setBounds(460, 160, 120, 30);

        subtotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                subtotalKeyTyped(evt);
            }
        });
        jPanel2.add(subtotal);
        subtotal.setBounds(460, 190, 150, 30);

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
        jLabel2.setText("Realizar venta");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(350, 20, 210, 29);
        jPanel2.add(ID);
        ID.setBounds(800, 310, 100, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel6.setText("Cliente");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(460, 70, 90, 30);

        comboux.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el cliente", " " }));
        jPanel2.add(comboux);
        comboux.setBounds(460, 100, 170, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel4.setText("Vendedor");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(260, 70, 180, 30);

        vendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendedorActionPerformed(evt);
            }
        });
        vendedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                vendedorKeyTyped(evt);
            }
        });
        jPanel2.add(vendedor);
        vendedor.setBounds(260, 100, 150, 30);

        jButton1.setText("Calcular");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(610, 190, 110, 40);
        jPanel2.add(encargado);
        encargado.setBounds(720, 190, 70, 30);

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

    private void precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioActionPerformed

    private void cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadActionPerformed

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
            
            codigo.setText(tabla40.getValueAt(fila, 0).toString());
            vendedor.setText(tabla40.getValueAt(fila, 1).toString());
            comboux.getModel().setSelectedItem(String.valueOf(tabla40.getModel().getValueAt(fila, 2)));
            comboux2.getModel().setSelectedItem(String.valueOf(tabla40.getModel().getValueAt(fila, 3))); 
            precio.setText(tabla40.getValueAt(fila, 4).toString());
            cantidad.setText(tabla40.getValueAt(fila, 5).toString());                       
            subtotal.setText(tabla40.getValueAt(fila, 6).toString());
            iva.setText(tabla40.getValueAt(fila, 7).toString());
            descuento.setText(tabla40.getValueAt(fila, 8).toString());
            total.setText(tabla40.getValueAt(fila, 9).toString());
            dcFecha_venta.setDate(Date.valueOf(tabla40.getValueAt(fila, 10).toString()));
            ID.setText(tabla40.getValueAt(fila, 11).toString());
            
        }else {
            JOptionPane.showMessageDialog(null, "No selecciono fila");
        }
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       
        try{
            parametros();
            calcular();
            PreparedStatement pst=cn.prepareStatement("UPDATE ventas2 "
                + "SET codigo='"+codigo.getText()
                +"',vendedor='"+vendedor.getText()
                +"',id_cliente='"+comboux.getSelectedIndex()
                +"',id_material='"+comboux2.getSelectedIndex()
                +"',precio='"+precio.getText()
                +"',cantidad='"+cantidad.getText()                             
                +"',subtotal='"+subtotal.getText()
                +"',iva='"+iva.getText()
                +"',descuento='"+descuento.getText()
                +"',total='"+total.getText()
                +"',fecha='"+new java.sql.Date(dcFecha_venta.getDate().getTime())
                +"' WHERE id_venta='"+ID.getText()+"'"
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

            PreparedStatement pst=cn.prepareStatement("DELETE FROM ventas2 WHERE codigo='"+filaa+"' LIMIT 1");
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
     calcular();
     insertar();
     actualizarStock();
     bitacorainsertar();                
         
         
    }//GEN-LAST:event_jButton11ActionPerformed

    private void cantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadKeyTyped
        
    }//GEN-LAST:event_cantidadKeyTyped

    private void precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioKeyTyped
        
    }//GEN-LAST:event_precioKeyTyped

    private void totalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_totalKeyTyped
      
    }//GEN-LAST:event_totalKeyTyped

    private void subtotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_subtotalKeyTyped
       
    }//GEN-LAST:event_subtotalKeyTyped

    private void ivaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ivaKeyTyped
       
    }//GEN-LAST:event_ivaKeyTyped

    private void descuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descuentoKeyTyped
        
    }//GEN-LAST:event_descuentoKeyTyped

    private void codigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoKeyTyped
        
    }//GEN-LAST:event_codigoKeyTyped

    private void codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoActionPerformed

    private void vendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vendedorActionPerformed

    private void vendedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vendedorKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_vendedorKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        calcular();
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JTextField cantidad;
    private javax.swing.JTextField codigo;
    private javax.swing.JComboBox<String> comboux;
    private javax.swing.JComboBox<String> comboux2;
    private com.toedter.calendar.JDateChooser dcFecha_venta;
    private javax.swing.JTextField descuento;
    private javax.swing.JTextField encargado;
    private javax.swing.JTextField iva;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField p2;
    private javax.swing.JTextField precio;
    private javax.swing.JTextField subtotal;
    private javax.swing.JTable tabla40;
    private javax.swing.JTextField total;
    private javax.swing.JTextField vendedor;
    // End of variables declaration//GEN-END:variables
}
