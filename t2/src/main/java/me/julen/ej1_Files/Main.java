package me.julen.ej1_Files;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduce la ruta del directorio: ");
		String path = teclado.nextLine();
		System.out.println("Introduce el nombre del archivo: ");
		String s = "/" + teclado.nextLine();
		
		File ruta = new File(path);
		File f = new File(ruta, s);
		
		if (!ruta.exists()) {
			if (ruta.mkdirs()) {
				System.out.println("Directorio creado con el nombre " + ruta.getName() + ".");
			} else {
				System.out.println("Error al crear el directorio.");
			}
		} else {
			System.out.println("El directorio ya existe.");
		}
		if (!f.exists()) {
			if (f.createNewFile()) {
				System.out.println("Archivo creado con el nombre " + f.getName() + ".");
			} else {
				System.out.println("Error al crear el archivo.");
			}
		} else {
			System.out.println("El archivo ya existe con un tamaño de " + f.length() + ".");
		}
		teclado.close();
	}
}
