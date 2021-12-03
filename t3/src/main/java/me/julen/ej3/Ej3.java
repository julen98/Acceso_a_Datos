package me.julen.ej3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.opencsv.CSVWriter;

public class Ej3 {
	public static void main(String[] args) {
		try {
			Scanner teclado = new Scanner(System.in);
			String csv = "src/ej3/Restaurants.csv";
			CSVWriter writer = new CSVWriter(new FileWriter(csv, true));
			String s, nombre, direccion, ciudad, estado, postal;
			
			System.out.println("Introduce el nombre del restaurante: ");
			nombre = teclado.nextLine();
			System.out.println("Introduce la direccion: ");
			direccion = teclado.nextLine();
			System.out.println("Introduce la ciudad: ");
			ciudad = teclado.nextLine();
			System.out.println("Introduce el estado: ");
			estado = teclado.nextLine();
			System.out.println("Introduce el codigo postal: ");
			postal = teclado.nextLine();
			
			s = nombre + "," + direccion + "," + ciudad + "," + estado + "," + postal;
			
			String[] insertarLinea = s.split(",");
			writer.writeNext(insertarLinea);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
