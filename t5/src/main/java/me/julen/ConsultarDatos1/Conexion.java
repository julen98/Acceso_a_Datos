package me.julen.ConsultarDatos1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

    public PreparedStatement prepareStatement(String sql) throws SQLException {
        PreparedStatement pS = conexion.prepareStatement(sql);
        return pS;
    }

    public void rollback() {
        try {
            conexion.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void commit() {
        try {
            conexion.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setAutoCommit(boolean b) {
        try {
            conexion.setAutoCommit(b);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}