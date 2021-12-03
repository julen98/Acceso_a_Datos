package me.julen.ej2;

import java.io.File;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try {
			// Creo el scanner con el file instanciado para que lo lea directamente
			Scanner teclado = new Scanner(new File("src/ej2/ejercicio2.txt"));
			
			while(teclado.hasNextLine()) {
				// Separo por espacios el archivo guardandolo en un array de strings
				String[] trozosLinea = (teclado.nextLine()).split(" ");
				
				for(int i = 0; i < trozosLinea.length; i++) {
					
					// Compruebo con un regex cada string del array
					if(trozosLinea[i].matches("[A-Za-z]*"))
						System.out.println("Palabra: " + trozosLinea[i]);
					else
						System.out.println("Numero: " + trozosLinea[i]);
				}
			}
			
			
		} catch (Exception e) {
		}
	}
}
