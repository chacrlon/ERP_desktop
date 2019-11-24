/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.awt.Image;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.text.DecimalFormat; 
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.JTable;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Materiales extends javax.swing.JInternalFrame {

    conectar cc=new conectar();
    Connection cn=cc.conexion();


    
    TextFieldEvent evento= new TextFieldEvent();
    int contador=1;
    DefaultTableModel m;   

    static double total;
    double sub_total;
    double igv;
    public Materiales() {
        initComponents();
        parametros();
        total=0;
        sub_total=0;
        igv=0; 
        encargado.setText(p1.getText());
        encargado.setEnabled(false);
        encargado.setVisible(false);
        dolar.setText(dolar.getText()); 
        dolar.setEnabled(false); 
        precio2.setEnabled(false);  
    }
  
    void parametros(){ 
             String sql="";
        sql="select * from parametros_adicionales where id_parametros_adicionales=1";
        try {
        java.sql.Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        if(rs.first()){
        dolar.setText(rs.getString("dolar"));
        }
        }
        catch(SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al realizar la consulta");
        
         }}
    
    
    
    void calcular()
    {
        DecimalFormat RedondearADos = new DecimalFormat("####.##");
        
        float bolivares,dolares,finall;
        bolivares= Float.parseFloat(this.precio.getText());
        dolares= Float.parseFloat(this.dolar.getText());
        finall=  (float) (bolivares/dolares);
        this.precio2.setText(String.valueOf(finall)); 
       
    }
    
     void bitacorainsertar(){ 
        try{
            String descripcion="Registro un nuevo material";
            PreparedStatement pst=cn.prepareStatement("INSERT INTO bitacora (usuario,descripcion,fecha,hora) VALUES (?,?,?,?)");           
            pst.setString(1, encargado.getText());
            pst.setString(2, descripcion);
            pst.setString(3, Principal.Fecha.getText());
            pst.setString(4, Principal.Hora.getText());
            pst.executeUpdate();           
        }
        catch(SQLException ex){
            Logger.getLogger(Materiales.class.getName()).log(Level.SEVERE, null, ex);
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
            String descripcion="Modifico los datos de un material";
            PreparedStatement pst=cn.prepareStatement("INSERT INTO bitacora (usuario,descripcion,fecha,hora) VALUES (?,?,?,?)");           
            pst.setString(1, encargado.getText());
            pst.setString(2, descripcion);
            pst.setString(3, Principal.Fecha.getText());
            pst.setString(4, Principal.Hora.getText());
            pst.executeUpdate();           
        }
        catch(SQLException ex){
            Logger.getLogger(Materiales.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }
         
         void bitacoraeliminar(){ 
        try{
            String descripcion="Elimino un material";
            PreparedStatement pst=cn.prepareStatement("INSERT INTO bitacora (usuario,descripcion,fecha,hora) VALUES (?,?,?,?)");           
            pst.setString(1, encargado.getText());
            pst.setString(2, descripcion);
            pst.setString(3, Principal.Fecha.getText());
            pst.setString(4, Principal.Hora.getText());
            pst.executeUpdate();           
        }
        catch(SQLException ex){
            Logger.getLogger(Materiales.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }
         
 public void mostrar(String valor){ 
   
        try {
            DefaultTableModel modelo=new DefaultTableModel();
        modelo.addColumn("Codigo del material");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Stock");
        modelo.addColumn("Bolivares");
        modelo.addColumn("Dolares");
        modelo.addColumn("Imagen");
        tabla40.setModel(modelo);
            
             
    
       String sql="";
       if(valor.equals(sql)){ 
            sql="SELECT codigo_material,nombre_material,descripcion_material,stock,precio_material,dolar_material,nomimagen,imagen FROM materiales ORDER BY nombre_material ASC";             
        }
        else { 
           sql="SELECT codigo_material,nombre_material,descripcion_material,stock,precio_material,dolar_material,nomimagen,imagen FROM materiales WHERE codigo_material='"+valor+"'";
                   
        }
       
       String []datos= new String[8];
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                
                modelo.addRow(datos);
            }
          //  tbpro.setModel(model);
            
        } catch (SQLException ex) {
            Logger.getLogger(Materiales.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
  public void limpiar(){ 
      codigo.setText(null);
      nombre.setText(null);
      descripcion.setText(null);
      stock.setText(null);
      precio.setText(null);
      precio2.setText(null);
      fotop.setText(null);
      labelfoto1.setIcon(null);
  }
 
 public void mostrar2(Object fecha){ 
    
     
     
     DefaultTableModel modelo=new DefaultTableModel();       
        modelo.addColumn("Codigo del material");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Stock");
        modelo.addColumn("Bolivares");
        modelo.addColumn("Dolares");
        modelo.addColumn("Imagen");
        tabla40.setModel(modelo);
        String sql= "";
     
        if(fecha.equals(sql)){ 
            sql="SELECT codigo_material,nombre_material,descripcion_material,stock,precio_material,dolar_material,nomimagen,imagen FROM materiales ORDER BY nombre_material ASC";             
        }
        else { 
            sql="SELECT codigo_material,nombre_material,descripcion_material,stock,precio_material,dolar_material,nomimagen,imagen FROM materiales WHERE codigo_material lIKE '%"+fecha+"%'"
                    + "or nombre_material lIKE '%"+fecha+"%' "
                    + "or descripcion_material lIKE '%"+fecha+"%' "
                    + "or stock lIKE '%"+fecha+"%' "
                    + "or precio_material lIKE '%"+fecha+"%'"
                    + "or dolar_material lIKE '%"+fecha+"%'";
                   
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
            
                modelo.addRow(datos);
            }
            tabla40.setModel(modelo);
        }
        catch(SQLException ex){ 
            Logger.getLogger(Materiales.class.getName()).log(Level.SEVERE,null,ex);
        }
     
    }
 
 
 
 String comparar(String cod)
    {
        String cant="";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM materiales WHERE codigo_material='"+cod+"'");
            while(rs.next())
            {
                cant=rs.getString(8);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Materiales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;
        
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
        jLabel3 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        descripcion = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        stock = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        precio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnimagen = new javax.swing.JButton();
        fotop = new javax.swing.JTextField();
        encargado = new javax.swing.JTextField();
        labelfoto1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        precio2 = new javax.swing.JTextField();
        dolar = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        buscarp = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
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

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel3.setText("Codigo del material");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(70, 70, 200, 30);

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

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel10.setText("Nombre");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(280, 70, 90, 30);

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
        nombre.setBounds(280, 100, 150, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel14.setText("Descripcion");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(70, 170, 150, 30);

        descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descripcionActionPerformed(evt);
            }
        });
        descripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                descripcionKeyTyped(evt);
            }
        });
        jPanel2.add(descripcion);
        descripcion.setBounds(70, 200, 150, 30);

        jLabel18.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel18.setText("Stock");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(280, 170, 120, 30);

        stock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stockKeyTyped(evt);
            }
        });
        jPanel2.add(stock);
        stock.setBounds(280, 200, 150, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel13.setText("Precio en Bolivares");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(70, 270, 180, 30);

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
        precio.setBounds(70, 300, 150, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Formulario productos");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(310, 20, 270, 29);

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel5.setText("Imagen");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(500, 70, 140, 30);

        btnimagen.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        btnimagen.setText("Seleccionar");
        btnimagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimagenActionPerformed(evt);
            }
        });
        jPanel2.add(btnimagen);
        btnimagen.setBounds(490, 100, 150, 30);
        jPanel2.add(fotop);
        fotop.setBounds(490, 130, 150, 30);
        jPanel2.add(encargado);
        encargado.setBounds(750, 70, 70, 30);

        labelfoto1.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 51, 51)));
        jPanel2.add(labelfoto1);
        labelfoto1.setBounds(670, 100, 240, 240);

        jLabel15.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel15.setText("Valor del dolar");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(490, 170, 140, 30);

        precio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precio2ActionPerformed(evt);
            }
        });
        precio2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precio2KeyTyped(evt);
            }
        });
        jPanel2.add(precio2);
        precio2.setBounds(410, 300, 150, 30);

        dolar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dolarActionPerformed(evt);
            }
        });
        dolar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dolarKeyTyped(evt);
            }
        });
        jPanel2.add(dolar);
        dolar.setBounds(510, 200, 90, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel16.setText("Precio en Dolares");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(410, 270, 170, 30);

        jButton2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton2.setText("Calcular");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(300, 300, 110, 30);

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
        jPanel1.add(buscarp);
        buscarp.setBounds(40, 130, 150, 40);

        jButton13.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/excel.png"))); // NOI18N
        jButton13.setText("Excel");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton13);
        jButton13.setBounds(190, 170, 190, 40);

        jButton1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton1.setText("Actualizar precios");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(120, 280, 200, 50);

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

    private void descripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descripcionActionPerformed

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int fila=tabla40.getSelectedRow();

        if(fila>=0)
        {

            String cod=tabla40.getValueAt(fila, 0).toString();
            String nom=tabla40.getValueAt(fila, 1).toString();
            String des=tabla40.getValueAt(fila, 2).toString();           
            String stoc=tabla40.getValueAt(fila, 3).toString();
            String pre=tabla40.getValueAt(fila, 4).toString();
            String pre2=tabla40.getValueAt(fila, 5).toString();
            String fot=tabla40.getValueAt(fila, 6).toString();

            codigo.setText(cod);
            nombre.setText(nom);
            descripcion.setText(des);
            stock.setText(stoc);
            precio.setText(pre);
            precio2.setText(pre2);
            fotop.setText(fot);

            Image fotoc = getToolkit().getImage(fot);
            fotoc= fotoc.getScaledInstance(240, 240, 1);
            labelfoto1.setIcon(new ImageIcon(fotoc));

        }
        else
        {
            JOptionPane.showMessageDialog(null, "Elija una fila...llene la Tabla");
        }
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
        FileInputStream  archivofoto;
        File nombrefoto= new File(fotop.getText());
        archivofoto = new FileInputStream(nombrefoto);
        String sql="UPDATE materiales SET codigo_material = ?, nombre_material = ?, descripcion_material = ?, stock = ?, precio_material = ?, dolar_material = ?, nomimagen = ?, imagen=? WHERE codigo_material = '"+codigo.getText()+"'"; 

            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, codigo.getText());
            pst.setString(2, nombre.getText());
            pst.setString(3, descripcion.getText());
            pst.setString(4, stock.getText());
            pst.setString(5, precio.getText());
            pst.setString(6, precio2.getText());
            pst.setString(7, fotop.getText());
            archivofoto = new FileInputStream(fotop.getText());
            pst.setBinaryStream(8, archivofoto);

            int n= pst.executeUpdate();
            mostrar("");
            limpiar();
           
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        bitacoraactualizar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        int fila= tabla40.getSelectedRow();
        String cod4="";

        cod4=tabla40.getValueAt(fila, 0).toString();
        try {

            PreparedStatement pst=cn.prepareStatement("DELETE FROM materiales WHERE codigo_material='"+cod4+"' LIMIT 1");
            pst.executeUpdate();
            mostrar("");

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        bitacoraeliminar();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed

        mostrar2(buscarp.getText());
 

    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        mostrar("");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        try{
            FileInputStream archivofoto;
            PreparedStatement pst=cn.prepareStatement
            ("INSERT INTO materiales (codigo_material,nombre_material,descripcion_material,stock,precio_material,dolar_material,nomimagen,imagen) VALUES (?,?,?,?,?,?,?,?)");
            pst.setString(1, codigo.getText());
            pst.setString(2, nombre.getText());
            pst.setString(3, descripcion.getText());
            pst.setString(4, stock.getText());
            pst.setString(5, precio.getText());
            pst.setString(6, precio2.getText());
            pst.setString(7, fotop.getText());
            archivofoto=null;
            pst.setBinaryStream(8, archivofoto);
            pst.executeUpdate();
            mostrar("");         
         } catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
         bitacorainsertar();
         limpiar();
         
         
    }//GEN-LAST:event_jButton11ActionPerformed

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyTyped
        
    }//GEN-LAST:event_nombreKeyTyped

    private void descripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descripcionKeyTyped
        
    }//GEN-LAST:event_descripcionKeyTyped

    private void stockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stockKeyTyped
        evento.numberKeyPress(evt);
    }//GEN-LAST:event_stockKeyTyped

    private void precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioKeyTyped
        
    }//GEN-LAST:event_precioKeyTyped

    private void codigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoKeyTyped
        
    }//GEN-LAST:event_codigoKeyTyped

    private void codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoActionPerformed

    private void btnimagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimagenActionPerformed
        FileNameExtensionFilter filtro= new FileNameExtensionFilter
        ("Formatos de archivos JPEG(*.JPG;*.JPEG)","jpg","jpeg");
        JFileChooser archivo= new JFileChooser();
        archivo.addChoosableFileFilter(filtro);
        archivo.setDialogTitle("Abrir archivo");
        File ruta=new File("D:/productos");
        archivo.setCurrentDirectory(ruta);
        int ventana = archivo.showOpenDialog(null);
        if (ventana == JFileChooser.APPROVE_OPTION)
        {
            File file=archivo.getSelectedFile();
            fotop.setText(String.valueOf(file));
            Image fotoc=getToolkit().getImage(fotop.getText());
            fotoc=fotoc.getScaledInstance(240, 240, Image.SCALE_DEFAULT);
            labelfoto1.setIcon(new ImageIcon(fotoc));
        }
    }//GEN-LAST:event_btnimagenActionPerformed

    private void precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        try {
            exportarExcel(tabla40);
        } catch (IOException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        bitacoraexcel();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void precio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precio2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precio2ActionPerformed

    private void precio2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precio2KeyTyped
        
    }//GEN-LAST:event_precio2KeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
        String sql="UPDATE materiales SET precio_material=dolar_material*'"+dolar.getText()+"'"; 
            PreparedStatement pst = cn.prepareStatement(sql);
          //pst.setString(5, precio.getText());
            pst.executeUpdate();
            mostrar("");          
        } catch (SQLException ex) {
            Logger.getLogger(Materiales.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void dolarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dolarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dolarActionPerformed

    private void dolarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dolarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_dolarKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        calcular();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FONDO;
    private javax.swing.JButton btnimagen;
    private javax.swing.JTextField buscarp;
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField descripcion;
    private javax.swing.JTextField dolar;
    private javax.swing.JTextField encargado;
    private javax.swing.JTextField fotop;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelfoto1;
    private javax.swing.JTextField nombre;
    public static javax.swing.JTextField p2;
    private javax.swing.JTextField precio;
    private javax.swing.JTextField precio2;
    private javax.swing.JTextField stock;
    private javax.swing.JTable tabla40;
    // End of variables declaration//GEN-END:variables
}
