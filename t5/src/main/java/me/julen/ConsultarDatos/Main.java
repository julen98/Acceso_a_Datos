package me.julen.ConsultarDatos;

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
        campos.add("Nombre");
        campos.add("Nombre");
        campos.add("Nombre");

        // Conexion a la BBDD
        conexion.conectarseBBDD();

        // Realizar consulta / insert
        sql = "";
        consulta.consulta(sql, campos);
        

        // Desconexion BBDD
        conexion.desconectarBBDD();
    }
}