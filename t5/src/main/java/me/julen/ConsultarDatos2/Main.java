package me.julen.ConsultarDatos2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Datos para hacer consultas
        String sql;
        Conexion conexion = new Conexion();
        Consulta consulta = new Consulta();
        ArrayList<String> campos = new ArrayList<String>();
        
        // Añadir campos al array
        campos.add("Nombre");

        // Conexion a la BBDD
        conexion.conectarseBBDD();

        // Realizar consulta / insert
        sql = "SELECT C.nombre FROM conductores C INNER JOIN lineas L ON C.id_conductor = L.id_conductor INNER JOIN bonos_activos BA ON L.id_linea = BA.id_linea GROUP BY C.nombre;";

        consulta.consulta(sql, campos);
        

        // Desconexion BBDD
        conexion.desconectarBBDD();
    }
}