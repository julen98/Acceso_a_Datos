package me.julen.BorrarDatos;

public class Main {
    public static void main(String[] args) {
        // Datos para hacer consultas
        Conexion conexion = new Conexion();
        Consulta consulta = new Consulta();
        
        // Conexion a la BBDD
        conexion.conectarseBBDD();

        // Realizar consulta / insert
        consulta.borrar("DELETE FROM bonos_activos WHERE dni_usuario IN (SELECT dni FROM usuarios WHERE date_part('year', age(f_nacimiento)) < 18);\n" + 
        "DELETE FROM usuarios WHERE date_part('year', age(f_nacimiento)) < 18;");
        consulta.borrar("DELETE FROM bonos WHERE tipo LIKE '%50%%' AND duracion = 30;");

        // Desconexion BBDD
        conexion.desconectarBBDD();
    }
}