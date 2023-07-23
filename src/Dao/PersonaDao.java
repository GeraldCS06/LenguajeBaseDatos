/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Entidad.Persona;
//import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;


/**
 *
 * @author fidelitas
 */
public class PersonaDao {
    
    private String mensaje = "";
    
    
    public String agregarPersona(Connection con, Persona per) throws SQLException {
        String sql = "{ call insertar_persona(?, ?, ?, ?, ?, ?) }";
        try {
            PreparedStatement pstmt = con.prepareCall(sql);
            pstmt.setString(1, per.getNombre());
            pstmt.setString(2, per.getPrimer_apellido());
            pstmt.setString(3, per.getSegundo_apellido());
            pstmt.setString(4, per.getTelefono());
            pstmt.setString(5, per.getCorreo());
            pstmt.setInt(6, per.getId_rol());

            pstmt.execute();
            pstmt.close();

            con.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar la persona en la base de datos.");
            e.printStackTrace();
        }
        return mensaje;
    }
    
    public String eliminarPersona(Connection con, int id_persona) throws SQLException {

        String sql = "{CALL eliminar_persona(?)}";

        PreparedStatement pstmt = con.prepareCall(sql);

        try {

            pstmt.setInt(1, id_persona);
            pstmt.execute();
            pstmt.close();
            con.close();

            mensaje = "Eliminado de manera correcta";

        } catch (SQLException e) {

            mensaje = "No se pudo realizar \n" + e.getMessage();

        }
        return mensaje;
    }
    
}
