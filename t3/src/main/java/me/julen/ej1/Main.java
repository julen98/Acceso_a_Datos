package me.julen.ej1;

import java.io.File;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try {
			String[] array = new String[100];
			Scanner teclado = new Scanner(new File("src/ej1/ejercicio1.txt"));
			while(teclado.hasNextLine()) {
				for(int i = 0; i < array.length; i++) {
					array[i] = teclado.nextLine();
					if(array[i].matches("[A-Za-z]*")) {
						System.out.println("Texto: " + array[i]);
					} else {
						System.out.println("Número: " + array[i]);
					}
				}
			}
			
		} catch (Exception e) {
		}
	}
}
