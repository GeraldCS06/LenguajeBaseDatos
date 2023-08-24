package Entidad;

public class Facturacion {
private int Num_Factura;
private String Fecha;
private int Cliente;
private int Producto;
private String Cedula;
private String Cantida;
private String SubTotal;
private String Impuesto;
private String MontoTotal;

    public Facturacion() {
    }

    public Facturacion(int Num_Factura, String Fecha, int Cliente, int Producto, String Cedula, String Cantida, String SubTotal, String Impuesto, String MontoTotal) {
        this.Num_Factura = Num_Factura;
        this.Fecha = Fecha;
        this.Cliente = Cliente;
        this.Producto = Producto;
        this.Cedula = Cedula;
        this.Cantida = Cantida;
        this.SubTotal = SubTotal;
        this.Impuesto = Impuesto;
        this.MontoTotal = MontoTotal;
    }

    public int getNum_Factura() {
        return Num_Factura;
    }

    public void setNum_Factura(int Num_Factura) {
        this.Num_Factura = Num_Factura;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public int getCliente() {
        return Cliente;
    }

    public void setCliente(int Cliente) {
        this.Cliente = Cliente;
    }

    public int getProducto() {
        return Producto;
    }

    public void setProducto(int Producto) {
        this.Producto = Producto;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getCantida() {
        return Cantida;
    }

    public void setCantida(String Cantida) {
        this.Cantida = Cantida;
    }

    public String getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(String SubTotal) {
        this.SubTotal = SubTotal;
    }

    public String getImpuesto() {
        return Impuesto;
    }

    public void setImpuesto(String Impuesto) {
        this.Impuesto = Impuesto;
    }

    public String getMontoTotal() {
        return MontoTotal;
    }

    public void setMontoTotal(String MontoTotal) {
        this.MontoTotal = MontoTotal;
    }
}
