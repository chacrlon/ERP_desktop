
package Validaciones;

import Modelo.conectar;
import Modelo.Compras;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;


public class Consult extends conectar {
   
    private QueryRunner QR = new QueryRunner();
    private List<Compras> compra;
    
    public List<Compras> compras(){ 
        try {
            compra= (List<Compras>) QR.query(getCon(), "SELECT * FROM compras", new BeanListHandler(Compras.class));
        } catch (SQLException ex) {
            Logger.getLogger(Consult.class.getName()).log(Level.SEVERE, null, ex);
        }
        return compra;
    }
    
    public void insert(String sql, Object[]data){ 
        final QueryRunner qr= new QueryRunner(true);
        try {
            qr.insert(getCon(),sql,new ColumnListHandler(),data);
                    } catch (SQLException ex) {
            Logger.getLogger(Consult.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
