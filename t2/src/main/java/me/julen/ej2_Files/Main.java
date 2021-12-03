package me.julen.ej2_Files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Thread t = new Thread();
		t.start();
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		String ruta = "";
		int n = 0;
		do {
			File cambiar = new File("/" + ruta);
			String[] listado = cambiar.list();
			System.out.println("Lista de ficheros y directorios del directorio " + cambiar.getPath() + "\n------------------------------------------------");
			for (int i = 0; i < listado.length; i++) {
		        File comprobar = new File(cambiar + "/" + listado[i]);
		        if(comprobar.isDirectory()) {
		        	System.out.println((i+1) + ".- " + listado[i] + "\t<Directorio>");
		        } else {
		        	System.out.println((i+1) + ".- " + listado[i] + "\t" + cambiar.length());
		        }
			}
			
			System.out.println("Introduce un numero (-1 para acabar): ");
			n = teclado.nextInt();
			
			ArrayList<File> listFile = new ArrayList<File>();
			for(int i = 0; i < listado.length; i++) {
				listFile.add(new File("/" + listado[i]));
			}
			try {
				if (n >= 0 && n <= listado.length) {
					if (n == 0) {
						if (cambiar.getParent() == null) {
						} else {
							ruta = cambiar.getParent();
							System.out.println(listFile.get(n).getParent());
						}
					} else {
						if(listFile.get(n-1).canRead() && listFile.get(n-1).canExecute()) {
							if(listFile.get(n-1).isDirectory()) {
								ruta = listado[n-1];
							} else {
							}
						} else {
							System.err.println("No tienes permiso para leer " + listFile.get(n-1));
							Thread.sleep(3000);
						}
					}
				} else {
					if (n != -1) {
						System.err.println("El numero introducido debe estar entre 0 y " + listado.length);
						Thread.sleep(3000);
					} else {
						System.exit(1);
					}
				}
			} catch (Exception e){
			}
		} while (n != -1);
	}
}
