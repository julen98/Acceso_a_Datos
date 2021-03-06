package me.julen.ConsultarDatos3;

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
        campos.add("Edad");

        // Conexion a la BBDD
        conexion.conectarseBBDD();

        // Realizar consulta / insert
        sql = "SELECT U.nombre, date_part('year', age(U.f_nacimiento)) As Edad FROM usuarios U INNER JOIN bonos_activos BA ON U.dni = BA.dni_usuario INNER JOIN bonos B ON BA.id_bono = B.id_bono WHERE B.duracion = 1 GROUP BY U.nombre, Edad;";

        consulta.consulta(sql, campos);
        

        // Desconexion BBDD
        conexion.desconectarBBDD();
    }
}