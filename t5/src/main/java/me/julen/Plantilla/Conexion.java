package me.julen.Plantilla;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    static Connection conexion;

    // Donde se localiza la BD
    final String url = "jdbc:postgresql://localhost:5432/lineas";

    // Credenciales de la BD
    final String user = "postgres";
    final String pwd = "postgres";

    public Conexion() {}

    public void conectarseBBDD() {
        // Establece la conexión con la BD
        try {
            conexion = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void desconectarBBDD() {
        // Cierra la conexión con la BD
        try {
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}