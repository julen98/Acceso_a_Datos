package me.julen.ej3;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class Ej4 {
	public static void main(String[] args) {
		try {
			String csv = "src\\main\\java\\me\\julen\\ej3\\Restaurants.csv";
			File newCSV = new File("src\\main\\java\\me\\julen\\ej3\\Restaurants2.csv");
			
			// Comprobamos si el fichero existe, y si no existe lo creamos
			if(!newCSV.exists()) {
				newCSV.createNewFile();
			}
			
			CSVWriter writer = new CSVWriter(new FileWriter(newCSV, true));
			CSVReader reader = new CSVReader(new FileReader(csv));
			String[] fila = null;
			
			// Leemos fila por fila y luego lo introducimos en el nuevo archivo
			while((fila = reader.readNext()) != null) {
				if(!fila[4].matches("^[6][0-9]*$")) {
					writer.writeNext(fila);
					System.out.println("Insertando la fila: " + Arrays.toString(fila));
				}
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvValidationException e) {
			e.printStackTrace();
		}
	}
}
