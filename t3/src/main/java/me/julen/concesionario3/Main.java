package me.julen.concesionario3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class Main {
    Document doc;
    Element concesionario, coches, coche;
    XMLOutputter xml = new XMLOutputter();
    String s_matricula, s_marca, s_precio, seguir;
    static boolean seguirIntroduciendo = true;

    public Main() {
        try {
            concesionario = new Element("concesionario");
            doc = new Document(concesionario);
            coches = new Element("coches");
            concesionario.addContent(coches);

            Scanner teclado = new Scanner(System.in);
            do {
                //Pedir por teclado
                System.out.println("Introduce la matricula:");
                s_matricula = teclado.nextLine();
                
                System.out.println("Introduce la marca:");
                s_marca = teclado.nextLine();
                
                System.out.println("Introduce el precio:");
                s_precio = teclado.nextLine();

                System.out.println("Quieres seguir introduciendo elementos? (S/N)");
                seguir = teclado.nextLine().toLowerCase();

                if (seguir.equals("n"))
                    seguirIntroduciendo = false;

                //Crear jerarquia
                coche = new Element("coche").setAttribute("matricula", s_matricula);
                coches.addContent(coche);
                coche.addContent(new Element("marca").setText(s_marca));
                coche.addContent(new Element("precio").setText(s_precio));
                
            } while(seguirIntroduciendo == true);

            xml.setFormat(Format.getPrettyFormat());
            xml.output(doc, new FileWriter("t3\\src\\main\\java\\me\\julen\\concesionario3\\concesionario3.xml"));
            teclado.close();
        } catch (IOException e) {
            System.out.println("Fichero no valido");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
