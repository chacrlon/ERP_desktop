
package Modelo;



public class Compras {
   private int id_proveedor;
   private String codigop;
   private String nombrep;
   private String preciop;
   private String cantidadp;
   private String fechap;
   private String preciopt;
   private String subtotal;
   private String iva;
   private String descuento;
   
   
   
   public Compras(){ 
       
   }

    /**
     * @return the id_proveedor
     */
    public int getId_proveedor() {
        return id_proveedor;
    }

    /**
     * @param id_proveedor the id_proveedor to set
     */
    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    /**
     * @return the codigop
     */
    public String getCodigop() {
        return codigop;
    }

    /**
     * @param codigop the codigop to set
     */
    public void setCodigop(String codigop) {
        this.codigop = codigop;
    }

    /**
     * @return the nombrep
     */
    public String getNombrep() {
        return nombrep;
    }

    /**
     * @param nombrep the nombrep to set
     */
    public void setNombrep(String nombrep) {
        this.nombrep = nombrep;
    }

    /**
     * @return the preciop
     */
    public String getPreciop() {
        return preciop;
    }

    /**
     * @param preciop the preciop to set
     */
    public void setPreciop(String preciop) {
        this.preciop = preciop;
    }

    /**
     * @return the cantidadp
     */
    public String getCantidadp() {
        return cantidadp;
    }

    /**
     * @param cantidadp the cantidadp to set
     */
    public void setCantidadp(String cantidadp) {
        this.cantidadp = cantidadp;
    }

    /**
     * @return the fechap
     */
    public String getFechap() {
        return fechap;
    }

    /**
     * @param fechap the fechap to set
     */
    public void setFechap(String fechap) {
        this.fechap = fechap;
    }

    /**
     * @return the preciopt
     */
    public String getPreciopt() {
        return preciopt;
    }

    /**
     * @param preciopt the preciopt to set
     */
    public void setPreciopt(String preciopt) {
        this.preciopt = preciopt;
    }

    /**
     * @return the subtotal
     */
    public String getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @return the iva
     */
    public String getIva() {
        return iva;
    }

    /**
     * @param iva the iva to set
     */
    public void setIva(String iva) {
        this.iva = iva;
    }

    /**
     * @return the descuento
     */
    public String getDescuento() {
        return descuento;
    }

    /**
     * @param descuento the descuento to set
     */
    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }
}
