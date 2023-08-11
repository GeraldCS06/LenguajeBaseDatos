/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bo;

import Entidad.Empleado;
import conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author fidelitas
 */
public class EmpleadoBo {

    private String mensaje = "";

    public String agregarEmpleado(Empleado emp) throws SQLException {

        String sql = "{CALL PKG_EMPLEADO.insertar_empleado(?, ?, ?, ?, ?, ?)}";

        Connection con = Conexion.Conectar();

        PreparedStatement pstmt = con.prepareCall(sql);

        try {

            pstmt.setString(1, emp.getCarnet());
            pstmt.setString(2, emp.getContrasenna());
            pstmt.setInt(3, emp.getId_persona());
            pstmt.setString(4, emp.getEstado());
            pstmt.setInt(5, emp.getId_servicio());

            mensaje = "Empleado agregado de manera correcta";
            pstmt.execute();
            pstmt.close();
            con.close();

        } catch (SQLException e) {

            mensaje = "No se pudo agregar al empleado \n" + e.getMessage();

        }

        return mensaje;
    }

    public ArrayList buscarEmpleadoId(int idConsulta) {

        ArrayList<Empleado> empleados = new ArrayList<>();

        try {
            Connection con = Conexion.Conectar();

            String callProcedure = "{call PKG_EMPLEADO.buscar_empleado_id(?, ?)}";
            CallableStatement stmt = con.prepareCall(callProcedure);

            // Establecer el parámetro de entrada del procedimiento
            stmt.setInt(1, idConsulta);

            // Establecer el parámetro de salida del procedimiento
            stmt.registerOutParameter(2, OracleTypes.CURSOR);

            // Ejecutar el procedimiento
            stmt.execute();

            // Obtener el cursor como un ResultSet
            ResultSet rs = (ResultSet) stmt.getObject(2);

            if (rs != null && rs.next()) {
                do {
                    int id_e = rs.getInt("ID");
                    String carnet = rs.getString("Carnet");
                    String contrasenna = rs.getString("Contraseña");
                    int id_persona = rs.getInt("Id_Persona");
                    String estado = rs.getString("estado");
                    int id_servicio = rs.getInt("Servicio");

                    // Agregar los datos a la lista de personas
                    empleados.add(new Empleado(id_e, carnet, contrasenna, id_persona, estado,id_servicio));
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron coincidencias.");
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al obtener el id del empleado: " + e);
        }

        return empleados;
    }

    public ArrayList buscarPersonaNombre(String p_carnet) {
        ArrayList<Empleado> empleados = new ArrayList<>();

        try {
            Connection con = Conexion.Conectar();

            String callProcedure = "{call PKG_EMPLEADO.buscar_empleado_nombre(?, ?)}";
            CallableStatement stmt = con.prepareCall(callProcedure);

            // Establecer el parámetro de entrada del procedimiento
            stmt.setString(1, p_carnet);

            // Establecer el parámetro de salida del procedimiento
            stmt.registerOutParameter(2, OracleTypes.CURSOR);

            // Ejecutar el procedimiento
            stmt.execute();

            // Obtener el cursor como un ResultSet
            ResultSet rs = (ResultSet) stmt.getObject(2);

            if (rs != null && rs.next()) {
                do {
                    int id_e = rs.getInt("ID");
                    String carnet = rs.getString("carnet");
                    String contrasenna = rs.getString("Contraseña");
                    int id_persona = rs.getInt("Id_Persona");
                    String estado = rs.getString("estado");
                    int id_servicio = rs.getInt("Servicio");

                    // Agregar los datos a la lista de personas
                    empleados.add(new Empleado(id_e, carnet, contrasenna, id_persona, estado,id_servicio));
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron coincidencias.");
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al obtener el nombre del empleado: " + e);
        }

        return empleados;
    }

    public String actualizarEmpleado(Empleado emp) throws SQLException {

        String sql = "{CALL PKG_EMPLEADO.actualizar_empleado(?, ?, ?, ?, ?, ?, ?)}";
        Connection con = Conexion.Conectar();
        PreparedStatement pstmt = con.prepareCall(sql);

        try {
            pstmt.setInt(1, emp.getId_empleado());
            pstmt.setString(2, emp.getCarnet());
            pstmt.setString(3, emp.getContrasenna());
            pstmt.setInt(4, emp.getId_persona());
            pstmt.setString(5, emp.getEstado());
            pstmt.setInt(6, emp.getId_servicio());

            mensaje = "Empleado actualizado exitosamente";
            pstmt.execute();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            mensaje = "No se pudo realizar la actualizacion del Empleado: \n" + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarEmpleado(int id_empleado) throws SQLException {
        Connection con = Conexion.Conectar();
        String procedureCall = "{ call PKG_EMPLEADO.eliminar_empleado(?) }";

        try (CallableStatement cs = con.prepareCall(procedureCall)) {
            cs.setInt(1, id_empleado);
            cs.execute();
            mensaje = "Empleado eliminado exitosamente.";
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
}
