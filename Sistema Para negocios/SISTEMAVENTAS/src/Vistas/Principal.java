
package Vistas;



import Modelo.conectar;
import static java.awt.Frame.MAXIMIZED_BOTH;

import java.awt.Graphics;
import java.sql.Connection;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicDesktopPaneUI;
import javax.swing.plaf.basic.BasicMenuBarUI;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;



/**
 *
 * @author AARON ROMAN
 */
public class Principal extends javax.swing.JFrame implements Runnable{

    conectar cc=new conectar();
    Connection cn=cc.conexion();
    ImageIcon imagen[]= new ImageIcon[20];
    int contador=1;
    Date now = new Date(System.currentTimeMillis());
    
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");

        //converti los valores date y hour a String por el asunto de pst.setSTRING
        String date2=date.format(now);
        String hour2=hour.format(now);
        
        
        String hora,minutos,segundos,ampm;
        Calendar calendario;    
        Thread h1;
        
    public Principal() {
        initComponents();
        this.setTitle("Empresa de Materiales");
        for(int i=1; i<4;i++){ 
            imagen[i]=new ImageIcon(getClass().getResource("/newpackage/Imagenes/foto"+i+".JPG"));
        
        }
        
        jLabel2.setIcon(imagen[1]);
        // jmIVenta.setMnemonic(KeyEvent.VK_V);
        this.setLocationRelativeTo(null);
        Hora.setVisible(false);        
        p1.setVisible(false);
        this.setExtendedState(MAXIMIZED_BOTH);
        menuBar.setOpaque(true);
        menuBar.setUI(new BasicMenuBarUI() {
            public void paint(Graphics g, JComponent c) {
                g.setColor(new java.awt.Color(255, 0, 0));
                g.fillRect(0, 0, c.getWidth(), c.getHeight());
            }
        });
        
        Fecha.setText(date2);
        Hora.setText(hour2);
        
        h1 = new Thread(this);
        h1.start();
        setLocationRelativeTo(null);//para centrar la ventana
        setVisible(true);
    }
    
        public void run(){
 Thread ct = Thread.currentThread();
 while(ct == h1) {   
  calcula();
  Hora2.setText(hora + ":" + minutos + ":" + segundos + " ");
  try {
   Thread.sleep(1000);
  }catch(InterruptedException e) {}
 }
}
    
public void calcula () {        
Calendar calendario = new GregorianCalendar();
Date fechaHoraActual = new Date();


calendario.setTime(fechaHoraActual);
ampm = calendario.get(Calendar.AM_PM)==Calendar.AM?"AM":"PM";

if(ampm.equals("PM")){
 int h = calendario.get(Calendar.HOUR_OF_DAY);
 hora = h>9?""+h:"0"+h;
}else{
 hora = calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY);            
}
minutos = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
segundos = calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND); 
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deskPricipal = new javax.swing.JDesktopPane();
        p1 = new javax.swing.JTextField();
        Fecha = new javax.swing.JTextField();
        Hora = new javax.swing.JTextField();
        Hora2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        Compras = new javax.swing.JMenu();
        Proveedores = new javax.swing.JMenu();
        Materiales = new javax.swing.JMenu();
        Clientes = new javax.swing.JMenu();
        Usuarios = new javax.swing.JMenu();
        Ventas = new javax.swing.JMenu();
        Parametros = new javax.swing.JMenu();
        Bitacora = new javax.swing.JMenu();
        Salir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        deskPricipal.setBackground(new java.awt.Color(36, 33, 33));
        deskPricipal.setToolTipText("");
        deskPricipal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        deskPricipal.setOpaque(true
        );
        deskPricipal.add(p1);
        p1.setBounds(0, 170, 120, 30);
        deskPricipal.add(Fecha);
        Fecha.setBounds(0, 0, 120, 30);
        deskPricipal.add(Hora);
        Hora.setBounds(0, 140, 120, 30);
        deskPricipal.add(Hora2);
        Hora2.setBounds(120, 0, 120, 30);

        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(6, 6, 6, 6, new java.awt.Color(255, 0, 0)));
        deskPricipal.add(jLabel2);
        jLabel2.setBounds(260, 30, 820, 420);

        jButton2.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jButton2.setText("ANTERIOR");
        jButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(6, 6, 6, 6, new java.awt.Color(255, 0, 0)));
        jButton2.setPreferredSize(new java.awt.Dimension(250, 150));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        deskPricipal.add(jButton2);
        jButton2.setBounds(260, 450, 330, 130);

        jButton1.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jButton1.setText("SIGUIENTE");
        jButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(6, 6, 6, 6, new java.awt.Color(255, 0, 0)));
        jButton1.setPreferredSize(new java.awt.Dimension(250, 150));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        deskPricipal.add(jButton1);
        jButton1.setBounds(750, 450, 330, 130);

        menuBar.setBackground(new java.awt.Color(255, 0, 0));
        menuBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menuBar.setToolTipText("");
        menuBar.setAlignmentX(0.2F);
        menuBar.setAlignmentY(0.2F);
        menuBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuBar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        menuBar.setOpaque(true);

        Compras.setBackground(new java.awt.Color(255, 0, 0));
        Compras.setForeground(new java.awt.Color(245, 245, 245));
        Compras.setText("Compras");
        Compras.setToolTipText("");
        Compras.setAlignmentX(0.0F);
        Compras.setAlignmentY(0.0F);
        Compras.setBorderPainted(true);
        Compras.setFont(new java.awt.Font("Arial", 2, 24));
        Compras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Compras.setOpaque(true
        );
        Compras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComprasMouseClicked(evt);
            }
        });
        Compras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComprasActionPerformed(evt);
            }
        });
        menuBar.add(Compras);

        Proveedores.setBackground(new java.awt.Color(255, 0, 0));
        Proveedores.setForeground(new java.awt.Color(245, 245, 245));
        Proveedores.setText("Proveedores");
        Proveedores.setToolTipText("");
        Proveedores.setAlignmentX(0.0F);
        Proveedores.setAlignmentY(0.0F);
        Proveedores.setBorderPainted(true);
        Proveedores.setFont(new java.awt.Font("Arial", 2, 24));
        Proveedores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Proveedores.setOpaque(true
        );
        Proveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProveedoresMouseClicked(evt);
            }
        });
        Proveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProveedoresActionPerformed(evt);
            }
        });
        menuBar.add(Proveedores);

        Materiales.setBackground(new java.awt.Color(255, 0, 0));
        Materiales.setForeground(new java.awt.Color(245, 245, 245));
        Materiales.setText("Materiales");
        Materiales.setToolTipText("");
        Materiales.setAlignmentX(0.0F);
        Materiales.setAlignmentY(0.0F);
        Materiales.setBorderPainted(true);
        Materiales.setFont(new java.awt.Font("Arial", 2, 24));
        Materiales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Materiales.setOpaque(true
        );
        Materiales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MaterialesMouseClicked(evt);
            }
        });
        Materiales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaterialesActionPerformed(evt);
            }
        });
        menuBar.add(Materiales);

        Clientes.setBackground(new java.awt.Color(255, 0, 0));
        Clientes.setForeground(new java.awt.Color(245, 245, 245));
        Clientes.setText("Clientes");
        Clientes.setToolTipText("");
        Clientes.setAlignmentX(0.0F);
        Clientes.setAlignmentY(0.0F);
        Clientes.setBorderPainted(true);
        Clientes.setFont(new java.awt.Font("Arial", 2, 24));
        Clientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Clientes.setOpaque(true
        );
        Clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClientesMouseClicked(evt);
            }
        });
        Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientesActionPerformed(evt);
            }
        });
        menuBar.add(Clientes);

        Usuarios.setBackground(new java.awt.Color(255, 0, 0));
        Usuarios.setForeground(new java.awt.Color(245, 245, 245));
        Usuarios.setText("Usuarios");
        Usuarios.setToolTipText("");
        Usuarios.setAlignmentX(0.0F);
        Usuarios.setAlignmentY(0.0F);
        Usuarios.setBorderPainted(true);
        Usuarios.setFont(new java.awt.Font("Arial", 2, 24));
        Usuarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Usuarios.setOpaque(true
        );
        Usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UsuariosMouseClicked(evt);
            }
        });
        Usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuariosActionPerformed(evt);
            }
        });
        menuBar.add(Usuarios);

        Ventas.setBackground(new java.awt.Color(255, 0, 0));
        Ventas.setForeground(new java.awt.Color(245, 245, 245));
        Ventas.setText("Ventas");
        Ventas.setToolTipText("");
        Ventas.setAlignmentX(0.0F);
        Ventas.setAlignmentY(0.0F);
        Ventas.setBorderPainted(true);
        Ventas.setFont(new java.awt.Font("Arial", 2, 24));
        Ventas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Ventas.setOpaque(true
        );
        Ventas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VentasMouseClicked(evt);
            }
        });
        Ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentasActionPerformed(evt);
            }
        });
        menuBar.add(Ventas);

        Parametros.setBackground(new java.awt.Color(255, 0, 0));
        Parametros.setForeground(new java.awt.Color(245, 245, 245));
        Parametros.setText("Parametros Adicionales");
        Parametros.setToolTipText("");
        Parametros.setAlignmentX(0.0F);
        Parametros.setAlignmentY(0.0F);
        Parametros.setBorderPainted(true);
        Parametros.setFont(new java.awt.Font("Arial", 2, 24));
        Parametros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Parametros.setOpaque(true
        );
        Parametros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ParametrosMouseClicked(evt);
            }
        });
        Parametros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParametrosActionPerformed(evt);
            }
        });
        menuBar.add(Parametros);

        Bitacora.setBackground(new java.awt.Color(255, 0, 0));
        Bitacora.setForeground(new java.awt.Color(245, 245, 245));
        Bitacora.setText("Bitacora");
        Bitacora.setToolTipText("");
        Bitacora.setAlignmentX(0.0F);
        Bitacora.setAlignmentY(0.0F);
        Bitacora.setBorderPainted(true);
        Bitacora.setFont(new java.awt.Font("Arial", 2, 24));
        Bitacora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Bitacora.setOpaque(true
        );
        Bitacora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BitacoraMouseClicked(evt);
            }
        });
        Bitacora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BitacoraActionPerformed(evt);
            }
        });
        menuBar.add(Bitacora);

        Salir.setBackground(new java.awt.Color(255, 0, 0));
        Salir.setForeground(new java.awt.Color(245, 245, 245));
        Salir.setText("Salir");
        Salir.setAutoscrolls(true);
        Salir.setFont(new java.awt.Font("Arial", 2, 24));
        Salir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Salir.setOpaque(true);
        Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalirMouseClicked(evt);
            }
        });
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        menuBar.add(Salir);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(deskPricipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1314, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(deskPricipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_SalirMouseClicked

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
     System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

    private void ComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComprasActionPerformed
         Compras form = new Compras();
        deskPricipal.add(form);
      
        form.setClosable(true);
        form.setIconifiable(true);
        try {
            form.setMaximum(true);
        } catch (Exception e) {
        }

        form.toFront();
        form.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
    }//GEN-LAST:event_ComprasActionPerformed

    private void ComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComprasMouseClicked
         Compras form = new Compras();
        deskPricipal.add(form);
      
        form.setClosable(true);
        form.setIconifiable(true);
        try {
            form.setMaximum(true);
        } catch (Exception e) {
        }

        form.toFront();
        form.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
    }//GEN-LAST:event_ComprasMouseClicked

    private void ProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProveedoresMouseClicked
        Proveedor form = new Proveedor();
        deskPricipal.add(form);
      
        form.setClosable(true);
        form.setIconifiable(true);
        try {
            form.setMaximum(true);
        } catch (Exception e) {
        }

        form.toFront();
        form.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
    }//GEN-LAST:event_ProveedoresMouseClicked

    private void ProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProveedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProveedoresActionPerformed

    private void MaterialesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaterialesMouseClicked
        Materiales form = new Materiales();
        deskPricipal.add(form);
      
        form.setClosable(true);
        form.setIconifiable(true);
        try {
            form.setMaximum(true);
        } catch (Exception e) {
        }

        form.toFront();
        form.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
    }//GEN-LAST:event_MaterialesMouseClicked

    private void MaterialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaterialesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaterialesActionPerformed

    private void ClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClientesMouseClicked
        Clientes form = new Clientes();
        deskPricipal.add(form);
      
        form.setClosable(true);
        form.setIconifiable(true);
        try {
            form.setMaximum(true);
        } catch (Exception e) {
        }

        form.toFront();
        form.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
    }//GEN-LAST:event_ClientesMouseClicked

    private void ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClientesActionPerformed

    private void UsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UsuariosMouseClicked
        Usuarios form = new Usuarios();
        deskPricipal.add(form);
      
        form.setClosable(true);
        form.setIconifiable(true);
        try {
            form.setMaximum(true);
        } catch (Exception e) {
        }

        form.toFront();
        form.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
    }//GEN-LAST:event_UsuariosMouseClicked

    private void UsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuariosActionPerformed

    private void VentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VentasMouseClicked
        Ventas form = new Ventas();
        deskPricipal.add(form);
      
        form.setClosable(true);
        form.setIconifiable(true);
        try {
            form.setMaximum(true);
        } catch (Exception e) {
        }

        form.toFront();
        form.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        
    }//GEN-LAST:event_VentasMouseClicked

    private void VentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VentasActionPerformed

    private void ParametrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ParametrosMouseClicked
        Parametros form = new Parametros();
        deskPricipal.add(form);
      
        form.setClosable(true);
        form.setIconifiable(true);
        try {
            form.setMaximum(true);
        } catch (Exception e) {
        }

        form.toFront();
        form.setVisible(true);
        this.setExtendedState(200);

    }//GEN-LAST:event_ParametrosMouseClicked

    private void ParametrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParametrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ParametrosActionPerformed

    private void BitacoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BitacoraMouseClicked
        Bitacora form = new Bitacora();
        deskPricipal.add(form);
      
        form.setClosable(true);
        form.setIconifiable(true);
        try {
            form.setMaximum(true);
        } catch (Exception e) {
        }

        form.toFront();
        form.setVisible(true);
        this.setExtendedState(200);
    }//GEN-LAST:event_BitacoraMouseClicked

    private void BitacoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BitacoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BitacoraActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (contador==1){
            contador=4;
        }
        contador--;
        jLabel2.setIcon(imagen[contador]);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (contador==3){
            contador=0;
        }
        contador++;
        jLabel2.setIcon(imagen[contador]);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenu Bitacora;
    public static javax.swing.JMenu Clientes;
    public static javax.swing.JMenu Compras;
    public static javax.swing.JTextField Fecha;
    public static javax.swing.JTextField Hora;
    public static javax.swing.JTextField Hora2;
    public static javax.swing.JMenu Materiales;
    public static javax.swing.JMenu Parametros;
    public static javax.swing.JMenu Proveedores;
    public static javax.swing.JMenu Salir;
    public static javax.swing.JMenu Usuarios;
    public static javax.swing.JMenu Ventas;
    public static javax.swing.JDesktopPane deskPricipal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JMenuBar menuBar;
    public static javax.swing.JTextField p1;
    // End of variables declaration//GEN-END:variables
}