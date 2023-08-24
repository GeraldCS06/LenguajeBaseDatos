package Bo;

import Entidad.Cita;
import conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleTypes;


public class CitaBo {

    private String mensaje = "";

    public String agregarCita(Cita cita) throws SQLException {

        String sql = "{CALL PKG_CITA.insertar_cita(?, ?, ?, ?, ?, ?)}";

        Connection con = Conexion.Conectar();

        PreparedStatement pstmt = con.prepareCall(sql);

        try {

            pstmt.setInt(1, cita.getFecha());
            pstmt.setInt(2, cita.getHora());
            pstmt.setInt(3, cita.getPersona());
            pstmt.setInt(4, cita.getMascota());

            mensaje = "Cita agregada de manera correcta";
            pstmt.execute();
            pstmt.close();
            con.close();

        } catch (SQLException e) {

            mensaje = "No se pudo agregar la cita \n" + e.getMessage();

        }

        return mensaje;
    }

    public ArrayList buscarCitaId(int idConsulta) {

        ArrayList<Cita> Citas = new ArrayList<>();

        try {
            Connection con = Conexion.Conectar();

            String callProcedure = "{call PKG_CITA.buscar_cita_id(?, ?)}";
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
                    int id_c = rs.getInt("ID");
                    int fecha = rs.getInt("Fecha");
                    int hora = rs.getInt("Hora");
                    int persona = rs.getInt("Persona");
                    int mascota = rs.getInt("Mascota");

                    // Agregar los datos a la lista de personas
                    Citas.add(new Cita(id_c, fecha, hora, persona, mascota));
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron coincidencias.");
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al obtener el id de la cita: " + e);
        }

        return Citas;
    }

    public ArrayList buscarCitaPersona(String p_nombre) {
        ArrayList<Cita> Citas = new ArrayList<>();

        try {
            Connection con = Conexion.Conectar();

            String callProcedure = "{call PKG_CITA.buscar_cita_persona(?, ?)}";
            CallableStatement stmt = con.prepareCall(callProcedure);

            // Establecer el parámetro de entrada del procedimiento
            stmt.setString(1, p_nombre);

            // Establecer el parámetro de salida del procedimiento
            stmt.registerOutParameter(2, OracleTypes.CURSOR);

            // Ejecutar el procedimiento
            stmt.execute();

            // Obtener el cursor como un ResultSet
            ResultSet rs = (ResultSet) stmt.getObject(2);

            if (rs != null && rs.next()) {
                do {
                    int id_c = rs.getInt("ID");
                    int fecha = rs.getInt("Fecha");
                    int hora = rs.getInt("Hora");
                    int persona = rs.getInt("Persona");
                    int mascota = rs.getInt("Mascota");

                    // Agregar los datos a la lista de personas
                    Citas.add(new Cita(id_c, fecha, hora, persona, mascota));
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron coincidencias.");
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al obtener la cita de la persona: " + e);
        }

        return Citas;
    }

    public String actualizarCita(Cita cita) throws SQLException {

        String sql = "{CALL PKG_CITA.actualizar_cita(?, ?, ?, ?, ?, ?, ?)}";
        Connection con = Conexion.Conectar();
        PreparedStatement pstmt = con.prepareCall(sql);

        try {
            pstmt.setInt(1, cita.getFecha());
            pstmt.setInt(2, cita.getHora());
            pstmt.setInt(3, cita.getPersona());
            pstmt.setInt(4, cita.getMascota());

            mensaje = "Cita actualizada exitosamente";
            pstmt.execute();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            mensaje = "No se pudo realizar la actualizacion de la Cita: \n" + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarCita(int id_cita) throws SQLException {
        Connection con = Conexion.Conectar();
        String procedureCall = "{ call PKG_CITA.eliminar_cita(?) }";

        try (CallableStatement cs = con.prepareCall(procedureCall)) {
            cs.setInt(1, id_cita);
            cs.execute();
            mensaje = "Cita eliminada exitosamente.";
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
