package me.julen.ej3;

import java.io.File;
import java.util.Scanner;

public class Ej1 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String ruta = "";
		System.out.println("Introduce una ruta: ");
		ruta = teclado.nextLine();
		File f = new File(ruta);
		
		try {
			if(f.exists()) {
				System.out.println("El fichero existe.");
				if(f.isDirectory()) {
					System.out.println("Es un directorio.");
				} else {
					System.out.println("Es un fichero.");
					System.out.print("Nombre: " + f.getName() + "\nTamaño: " + (f.length()/1000000) + " MB\nPermisos: ");
					
					if(f.canRead()) {
						System.out.print("r");
					} else {
						System.out.print("-");
					} if(f.canWrite()) {
						System.out.print("w");
					} else {
						System.out.print("-");
					} if(f.canExecute()) {
						System.out.print("x");
						
					} else {
						System.out.print("-");
					}
				}
			} else {
				System.out.println("El fichero no existe");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
