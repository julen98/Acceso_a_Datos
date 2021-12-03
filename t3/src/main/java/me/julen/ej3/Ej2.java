package me.julen.ej3;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class Ej2 {
	public static void main(String[] args) {
		try {
			String csv = "src/ej3/Restaurants.csv";
			CSVReader reader = new CSVReader(new FileReader(csv));
			String[] fila = null;
			while((fila = reader.readNext()) != null) {
			    if (fila[4].matches("^[6][0-9]*$")) {
				System.out.println(fila[0]
			    		 + " | " + fila[1]
			    		 + " | " + fila[2]
			             + " | " + fila[3]
			             + " | " + fila[4]);
			    }
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvValidationException e) {
			e.printStackTrace();
		}
	}
}
