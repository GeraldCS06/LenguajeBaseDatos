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
            usuario = "HR";
            pass = "123";

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

    public void Select() {
        try {
            Statement sa = conexion.createStatement();
            String consulta = "SELECT EMPLOYEE_ID, FIRST_NAME, EMAIL FROM HR.EMPLOYEES";
            ResultSet rs = sa.executeQuery(consulta);

            while (rs.next()) {
                Integer id = rs.getInt("EMPLOYEE_ID");
                String firstName = rs.getString("FIRST_NAME");
                String email = rs.getString("EMAIL");

                System.out.println("ID: " + id + "NAme: " + firstName + " EMAIL: " + email);
            }

            sa.close();

        } catch (Exception e) {
            System.out.println("Error en el select " + e);
        }
    }
}
