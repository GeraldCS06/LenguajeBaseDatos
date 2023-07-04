
package proyectoveterinaria;

import conexion.Conexion;

public class ProyectoVeterinaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IniciarConexion();
    }
    
    static void IniciarConexion(){
        Conexion c= new Conexion();
        
        c.Conectar();
        
        c.Desconectar();
    }
}
