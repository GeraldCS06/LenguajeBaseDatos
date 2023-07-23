/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bo;

import Dao.PersonaDao;
import Entidad.Persona;
import conexion.Conexion;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author fidelitas
 */
public class PersonaBo {
    private String mensaje = "";
    PersonaDao perBo = new PersonaDao();
    
    public String agregarPersona(Persona per) throws SQLException {

 

        String sql = "{CALL insertar_persona(?, ?, ?, ?, ?, ?)}";
        
        Connection con = Conexion.Conectar();

        PreparedStatement pstmt = con.prepareCall(sql);


        try {

            pstmt.setString(1, per.getNombre());
            pstmt.setString(2, per.getPrimer_apellido());
            pstmt.setString(3, per.getSegundo_apellido());
            pstmt.setString(4, per.getTelefono());
            pstmt.setString(5, per.getCorreo());
            pstmt.setInt(6, per.getId_rol());

 

            mensaje = "Agregado de manera correcta";
            pstmt.execute();
            pstmt.close();
            con.close();

 

        } catch (SQLException e) {

 

            mensaje = "No se pudo realizar \n" + e.getMessage();

 

        }

 

        return mensaje;
    }
    
    
    public String eliminarPersona(int id_persona) throws SQLException {
        Connection con = Conexion.Conectar();

        try {

            mensaje = perBo.eliminarPersona(con, id_persona);
            con.rollback();
            
        } catch (Exception e) {

            mensaje = mensaje + " " + e.getMessage();
        } finally {

            try {

                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {

                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }
    
}
