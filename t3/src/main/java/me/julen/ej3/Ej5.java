package me.julen.ej3;

import java.io.File;
import java.util.Scanner;

public class Ej5 {
	public static void main(String[] args) {
		try {
			Scanner teclado = new Scanner(System.in);
			String ruta = "";
			
			System.out.println("Introduce la ruta del archivo: ");
			ruta = teclado.nextLine();
			
			File f = new File(ruta);
			if(!f.exists())
				System.out.println("El archivo no existe.");
			else {
				f.delete();
				System.out.println("El archivo ha sido borrado correctamente.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
