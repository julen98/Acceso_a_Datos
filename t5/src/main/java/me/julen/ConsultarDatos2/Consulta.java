package me.julen.ConsultarDatos2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Consulta {
    Statement s;
    ResultSet rs;
    PreparedStatement ps;

    public Consulta(){}

    public void crearTabla(String sql) {
        try {
            s = Conexion.conexion.createStatement();
            s.execute(sql);
            System.out.println("Tabla creada correctamente.");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void insertar(String sql) {
        try {
            s = Conexion.conexion.createStatement();
            int nFil = s.executeUpdate(sql);
            System.out.println(nFil + " filas insertadas.");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void ejecutarSQL(String sql) {
        try {    
            ps = Conexion.conexion.prepareStatement(sql);
            ps.execute();
            System.out.println("Sentencia SQL ejecutada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void consulta(String sql, ArrayList<String> campos) {
        try {
            s = Conexion.conexion.createStatement();
            rs = s.executeQuery(sql);

            while(rs.next()) {
                System.out.println(campos.get(0) + ": " + rs.getString(1));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
