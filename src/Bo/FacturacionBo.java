package Bo;

import Entidad.Facturacion;
import conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FacturacionBo {

    private String mensaje = "";

    public String agregarFactura(Facturacion Factura) throws SQLException {

        String sql = "{CALL PKG_FACTURACION.insertar_factura(?, ?, ?, ?, ?, ?)}";

        Connection con = Conexion.Conectar();

        PreparedStatement pstmt = con.prepareCall(sql);

        try {
            pstmt.setInt(1, Factura.getNum_Factura());
            pstmt.setString(2, Factura.getFecha());
            pstmt.setInt(3, Factura.getCliente());
            pstmt.setInt(4, Factura.getProducto());
            pstmt.setString(5, Factura.getCedula());
            pstmt.setString(6, Factura.getCantida());
            pstmt.setString(7, Factura.getSubTotal());
            pstmt.setString(8, Factura.getImpuesto());
            pstmt.setString(9, Factura.getMontoTotal());

            mensaje = " Factura agregada de manera correcta";
            pstmt.execute();
            pstmt.close();
            con.close();

        } catch (SQLException e) {

            mensaje = "No se pudo Facturar \n" + e.getMessage();

        }

        return mensaje;
    }

    public String eliminarFactura(int factura) throws SQLException {
        Connection con = Conexion.Conectar();
        String procedureCall = "{ call PKG_FACTURA.eliminar_factura(?) }";

        try (CallableStatement cs = con.prepareCall(procedureCall)) {
            cs.setInt(1, factura);
            cs.execute();
            mensaje = "Factura eliminada exitosamente.";
        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Ocurrio un error.";
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " Ocurrio un error al cerrar la conexion" + e.getMessage();
            }
        }
        return mensaje;
    }

    public String actualizaFactura(Facturacion factura) throws SQLException { 
        String sql = "{CALL PKG_FACTURA.actualizar_factura(?, ?, ?, ?, ?, ?, ?)}";
        Connection con = Conexion.Conectar();
        PreparedStatement pstmt = con.prepareCall(sql);

        try {
            pstmt.setInt(1, factura.getNum_Factura());
            pstmt.setString(2, factura.getFecha());
            pstmt.setInt(3, factura.getCliente());
            pstmt.setInt(4, factura.getProducto());
            pstmt.setString(5, factura.getCedula());
            pstmt.setString(6, factura.getCantida());
            pstmt.setString(7, factura.getSubTotal());
            pstmt.setString(8, factura.getImpuesto());
            pstmt.setString(9, factura.getMontoTotal());

            mensaje = "Factura actualizada exitosamente";
            pstmt.execute();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            mensaje = "No se pudo realizar la actualizacion de la Cita: \n" + e.getMessage();
        }
        return mensaje;
    }

}
