package proyectoveterinaria;

import GUI.Frm_Menu_administrador;
import conexion.Conexion;

public class ProyectoVeterinaria {

    public static void main(String[] args) {
        
        //IniciarConexion();
        
        Frm_Menu_administrador menu_admin = new Frm_Menu_administrador();
    }

    static void IniciarConexionPrueba() {
        Conexion c = new Conexion();

        c.Conectar();

        c.SelectDePrueba();

        c.Desconectar();
    }
}