package me.julen.ejFrutas2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class Main {
	public static void main(String[] args) {
		try {
			String csv = "t3\\src\\main\\java\\me\\julen\\ejFrutas2\\frutas.csv";
			File newCSV = new File("t3\\src\\main\\java\\me\\julen\\ejFrutas2\\frutas2.csv");
			
			// Comprobamos si el fichero existe, y si no existe lo creamos
			if(!newCSV.exists()) {
				newCSV.createNewFile();
			}
			
			CSVWriter writer = new CSVWriter(new FileWriter(newCSV), CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.RFC4180_LINE_END);
			CSVReader reader = new CSVReader(new FileReader(csv));
			String[] fila = null;

			// Leemos fila por fila y luego lo introducimos en el nuevo archivo
			while((fila = reader.readNext()) != null) {
                if(!fila[3].equals(" No")) {
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
