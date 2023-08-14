
package Bo;

import Entidad.Mascota;
import conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author kyran
 */
public class MascotaBo {
    private String mensaje = "";

    public String agregarMascota(Mascota mac) throws SQLException {

        String sql = "{CALL PKG_MASCOTA.insertar_mascota(?, ?, ?, ?, ?, ?, ?, ?)}";

        Connection con = Conexion.Conectar();

        PreparedStatement mstmt = con.prepareCall(sql);

        try {

            mstmt.setString(1, mac.getDueño());
            mstmt.setString(2, mac.getEspecie());
            mstmt.setInt(3, mac.getEdad());
            mstmt.setString(4, mac.getGenero());
            mstmt.setString(5, mac.getNombre_mascota());
            mstmt.setString(6, mac.getRaza());
            mstmt.setInt(7, mac.getPeso());
            mstmt.setString(8, mac.getEsterilizada());

            mensaje = "Mascota agregada de manera correcta";
            mstmt.execute();
            mstmt.close();
            con.close();

        } catch (SQLException e) {

            mensaje = "No se pudo agregar la mascota \n" + e.getMessage();

        }

        return mensaje;
    }

    public ArrayList buscarMascotaId(int idConsulta) {

        ArrayList<Mascota> mascotas = new ArrayList<>();

        try {
            Connection con = Conexion.Conectar();

            String callProcedure = "{call PKG_MASCOTA.buscar_mascota_id(?, ?)}";
            CallableStatement mstmt = con.prepareCall(callProcedure);

            // Establecer el parámetro de entrada del procedimiento
            mstmt.setInt(1, idConsulta);

            // Establecer el parámetro de salida del procedimiento
            mstmt.registerOutParameter(2, OracleTypes.CURSOR);

            // Ejecutar el procedimiento
            mstmt.execute();

            // Obtener el cursor como un ResultSet
            ResultSet rs = (ResultSet) mstmt.getObject(2);

            if (rs != null && rs.next()) {
                do {
                    int id_m = rs.getInt("ID");
                    String dueño = rs.getString("Dueño");
                    String especie = rs.getString("Especie");
                    int edad = rs.getInt("Edad");
                    String genero = rs.getString("Genero");
                    String nombre_mascota = rs.getString("Nombre Mascota");
                    String raza = rs.getString("Raza");
                    int peso = rs.getInt("Peso");
                    String esterilizada = rs.getString("Esterilizada");

                    // Agregar los datos a la lista de personas
                    mascotas.add(new Mascota(id_m, dueño,especie,edad,genero,nombre_mascota,raza,peso,esterilizada));
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron coincidencias.");
            }

            rs.close();
            mstmt.close();
            con.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al obtener el id de la mascota: " + e);
        }

        return mascotas;
    }

    public ArrayList buscarMascotaNombre(String p_nombre) {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        try {
            Connection con = Conexion.Conectar();

            String callProcedure = "{call PKG_MASCOTA.buscar_mascota_nombre(?, ?)}";
            CallableStatement mstmt = con.prepareCall(callProcedure);

            // Establecer el parámetro de entrada del procedimiento
            mstmt.setString(1, p_nombre);

            // Establecer el parámetro de salida del procedimiento
            mstmt.registerOutParameter(2, OracleTypes.CURSOR);

            // Ejecutar el procedimiento
            mstmt.execute();

            // Obtener el cursor como un ResultSet
            ResultSet rs = (ResultSet) mstmt.getObject(2);

            if (rs != null && rs.next()) {
                do {
                    int id_m = rs.getInt("ID");
                    String dueño = rs.getString("Dueño");
                    String especie = rs.getString("Especie");
                    int edad = rs.getInt("Edad");
                    String genero = rs.getString("Genero");
                    String nombre_mascota = rs.getString("Nombre Mascota");
                    String raza = rs.getString("Raza");
                    int peso = rs.getInt("Peso");
                    String esterilizada = rs.getString("Esterilizada");

                    // Agregar los datos a la lista de personas
                    mascotas.add(new Mascota(id_m, dueño, especie, edad, genero, nombre_mascota, raza, peso,esterilizada));
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron coincidencias.");
            }

            rs.close();
            mstmt.close();
            con.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al obtener el nombre de la mascota: " + e);
        }

        return mascotas;
    }

    public String actualizarMascota(Mascota mac) throws SQLException {

        String sql = "{CALL PKG_MASCOTA.actualizar_mascota(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        Connection con = Conexion.Conectar();
        PreparedStatement mstmt = con.prepareCall(sql);

        try {
            mstmt.setInt(1, mac.getId_mascota());
            mstmt.setString(2, mac.getDueño());
            mstmt.setString(3, mac.getEspecie());
            mstmt.setInt(4, mac.getEdad());
            mstmt.setString(5, mac.getGenero());
            mstmt.setString(6, mac.getNombre_mascota());
            mstmt.setString(7, mac.getRaza());
            mstmt.setInt(8, mac.getPeso());
            mstmt.setString(9, mac.getEsterilizada());

            mensaje = "Mascota actualizada exitosamente";
            mstmt.execute();
            mstmt.close();
            con.close();
        } catch (SQLException e) {
            mensaje = "No se pudo realizar la actualizacion de la Mascota: \n" + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarMascota(int id_mascota) throws SQLException {
        Connection con = Conexion.Conectar();
        String procedureCall = "{ call PKG_MASCOTA.eliminar_mascota(?) }";

        try (CallableStatement cs = con.prepareCall(procedureCall)) {
            cs.setInt(1, id_mascota);
            cs.execute();
            mensaje = "Mascota eliminada exitosamente.";
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
