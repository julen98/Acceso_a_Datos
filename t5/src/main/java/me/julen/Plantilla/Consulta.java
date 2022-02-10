package me.julen.Plantilla;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Consulta {
    Statement s;
    ResultSet rs;

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

    public void consulta(String sql, ArrayList<String> campos) {
        try {
            s = Conexion.conexion.createStatement();
            rs = s.executeQuery(sql);

            while(rs.next()) {
                System.out.println(campos.get(0) + ": " + rs.getInt(1) + " " + campos.get(1) + ": " + rs.getString(2));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}