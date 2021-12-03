package me.julen.ejFrutas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<String> lineasArchivo = Files.readAllLines(Paths.get("t3\\src\\main\\java\\me\\julen\\ejFrutas\\frutas.txt"), StandardCharsets.UTF_8);
            File file = new File("t3\\src\\main\\java\\me\\julen\\ejFrutas\\frutas.csv");
            
            //Comprobar que el archivo esta creado ya
            if(!file.exists()) {
                file.createNewFile();
            }
            
            FileWriter writer = new FileWriter(file);

            //Introduzco en el writer el header
            writer.write("ID, Nombre, Precio, Esta en temporada?\n");

            for (String linea : lineasArchivo) {
                Frutas f = new Frutas();
                
                //Cambio las comas por puntos
                String temp = linea.replaceAll(",", ".");
                
                //Hago un split para poder meter en cada campo de mi objeto el valor que toca
                String partes[] = temp.split(" ");
                
                //Los meto con los setters
                f.setId(partes[0]);
                f.setNombre(partes[1]);
                f.setPrecio(partes[2]);
                f.setTemporada(partes[3]);    
                
                //Con el metodo toString() ya formateado para que el CSV lo pueda leer, voy metiendo cada linea con el writer
                writer.write(f.toString());
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}