/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Validaciones.Consult;
import Modelo.Compras;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AARON ROMAN
 */
public class Compras2 extends Consult{
     
    
    private DefaultTableModel modelo;
    private List<Compras> compra,compraFilter;
    private String codigop;
    private String sql;
    private String Id;
    private Object[] obect;
    
    
    
    
    public List<Compras> getCompras(){ 
        return compras();
    }
    
    
    public void searchCliente(JTable table, String campo, int num_registro, int reg_por_pagina){ 
        String[] registros=new String[10];
        String[] titulos={"Numero",
            "ID",
            "Nombre",
            "Apellido",
            "Direccion",
            "Telefono"};
        modelo =new DefaultTableModel(null, titulos);
        compra=compras();
        if(campo.equals("")){ 
            compraFilter=compra.stream().skip(num_registro).limit(reg_por_pagina).collect(Collectors.toList());
        }
        else{ 
            compraFilter=compra.stream().filter(C -> C.getCodigop().startsWith(campo)
                    ||C.getNombrep().startsWith(campo))
                    .skip(num_registro).limit(reg_por_pagina)
                    .collect(Collectors.toList());
        }
        compraFilter.forEach(item -> { 
        registros[0]=String.valueOf(item.getId_proveedor());
        registros[1]=item.getNombrep();
        registros[2]=item.getPreciop();
        registros[3]=item.getCantidadp();
        registros[4]=item.getFechap();
        registros[5]=item.getPreciopt();
        registros[6]=item.getSubtotal();
        registros[7]=item.getIva();
        registros[8]=item.getDescuento();
        modelo.addRow(registros);
        });
        table.setModel(modelo);
        table.setRowHeight(30);
    
    }
    
}
