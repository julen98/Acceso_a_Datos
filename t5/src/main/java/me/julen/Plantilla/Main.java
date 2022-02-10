package me.julen.Plantilla;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

public class Main {
    public static void main(String[] args) {
        // Datos para hacer consultas
        String sql;
        Conexion conexion = new Conexion();
        Consulta consulta = new Consulta();
        ArrayList<String> campos = new ArrayList<String>();

        // Anadir campos al array
        campos.add("ID_Ciudad");
        campos.add("Nombre");

        // Escribir sql
        sql = "SELECT " + StringUtils.join(campos, ", ") + " FROM Ciudades";

        // Conectarse a BBDD, hacer consulta y desconectarse
        conexion.conectarseBBDD();
        consulta.consulta(sql, campos);
        conexion.desconectarBBDD();
    }
}