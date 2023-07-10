package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion {

    private Connection conexion = null;

    private String url, usuario, pass;

    public void Conectar() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            url = "jdbc:oracle:thin:@//localhost:1521/orcl";
            usuario = "PROYECTO";
            pass = "12345";

            conexion = DriverManager.getConnection(url, usuario, pass);
            System.out.println("Conecion exitosa");
            
        } catch (Exception e) {
            System.out.println("Error al conectar: " + e);
        }
    }

    public void Desconectar() {
        try {
            conexion.close();
            System.out.println("Conexion cerrada");
        } catch (Exception e) {
            System.out.println("Error al desconectar");
        }
    }

    public void SelectDePrueba() {
        try {
            Statement sa = conexion.createStatement();
            String consulta = "SELECT * FROM PROYECTO.CATEGORIA";
            ResultSet rs = sa.executeQuery(consulta);

            while (rs.next()) {
                Integer id = rs.getInt("ID_CATEGORIA");
                String categoria = rs.getString("NOMBRE_CATEGORIA");
             
                System.out.println("ID: " + id + " || NOMBRE CATEGORIA: " + categoria);
            }

            sa.close();

        } catch (Exception e) {
            System.out.println("Error en el select o no hay datos" + e);
        }
    }
}