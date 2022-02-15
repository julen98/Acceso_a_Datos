package me.julen.InsertarDatos;

public class Main {
    public static void main(String[] args) {
        // Datos para hacer consultas
        Conexion conexion = new Conexion();
        Consulta consulta = new Consulta();
        
        // Conexion a la BBDD
        conexion.conectarseBBDD();

        // Realizar consulta / insert
        consulta.insertar("INSERT INTO Bonos (ID_bono, Tipo, Duracion)" +
        "VALUES (1, 'todo incluido', 1)," + 
        "(2, 'todo incluido', 7)," + 
        "(3, 'todo incluido', 30)," + 
        "(4, '50%', 1)," + 
        "(5, '50%', 7)," + 
        "(6, '50%', 30);");

        consulta.insertar("INSERT INTO Usuarios (DNI, Nombre, F_nacimiento, Ciudad)" +
        "VALUES ('11222333A', 'Patricia Pérez', '10/12/1990', 'Burriana')," +
        "('22333444B', 'Lia Lorca', '31/01/2002', 'Castellón')," +
        "('33444555C', 'Nela Núñez', '28/03/2008', 'Almazora')," +
        "('44555666D', 'Jose Jiménez', '15/12/2001', 'Nules')," +
        "('55666777E', 'Antonio Aranda', '09/09/1989', 'Mascarell');");

        consulta.insertar("INSERT INTO Bonos_Activos (ID_bono, DNI_Usuario, ID_linea, Caducidad)" +
        "VALUES (2, '11222333A', 11, '22/02/22')," +
        "(5, '11222333A', 31, '15/03/22')," +
        "(1, '22333444B', 41, '16/02/22')," +
        "(4, '33444555C', 21, '16/02/22')," +
        "(6, '44555666D', 51, '15/03/22')," +
        "(3, '44555666D', 21, '01/03/22');");

        // Desconexion BBDD
        conexion.desconectarBBDD();
    }
}