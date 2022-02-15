package me.julen.ModificarBBDD;

public class Main {
    public static void main(String[] args) {
        // Datos para hacer consultas
        Conexion conexion = new Conexion();
        Consulta consulta = new Consulta();
        
        // Conexion a la BBDD
        conexion.conectarseBBDD();
        
        // Realizar consulta / insert
        consulta.crearTabla("CREATE TABLE IF NOT EXISTS Bonos(" +
        "ID_bono Dom_ID PRIMARY KEY, Tipo varchar(20), Duracion smallint);");
        
        consulta.ejecutarSQL("CREATE DOMAIN Dom_DNI AS varchar(9) CONSTRAINT comprobarDNI CHECK (VALUE ~ '^[0-9]{8}[A-Z]$');");

        consulta.crearTabla("CREATE TABLE IF NOT EXISTS Usuarios(" +
        "DNI Dom_DNI PRIMARY KEY, Nombre varchar(20), F_nacimiento Date, Ciudad varchar(15));");
        
        consulta.crearTabla("CREATE TABLE IF NOT EXISTS Bonos_Activos(" + 
        "ID_bono Dom_ID, DNI_usuario Dom_DNI, ID_linea Dom_ID, Caducidad Date, PRIMARY KEY (ID_bono, DNI_usuario, ID_linea)," + 
        "CONSTRAINT bonact_fkey_bono FOREIGN KEY(ID_bono) REFERENCES Bonos(ID_bono)," +
        "CONSTRAINT bonact_fkey_user FOREIGN KEY(DNI_usuario) REFERENCES Usuarios(DNI)," +
        "CONSTRAINT bonact_fkey_linea FOREIGN KEY(ID_linea) REFERENCES Lineas(ID_linea)" +
        ");");

        consulta.ejecutarSQL("SET DATESTYLE TO 'European';");

        // Desconexion BBDD
        conexion.desconectarBBDD();
    }
}