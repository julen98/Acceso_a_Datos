package me.julen.concesionario2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class Main {
    private File archivo = new File("t3\\src\\main\\java\\me\\julen\\concesionario\\concesionario.xml");
    private Document doc;
    private Element concesionario, coches, coche, marca, precio;
    private SAXBuilder constructorSAX = new SAXBuilder();
    private XMLOutputter xml = new XMLOutputter();

    public Main() {
        try {
            doc = (Document)constructorSAX.build(archivo);
            
            //Declarar elementos
            concesionario = new Element("concesionario");
            coches = new Element("coches");
            coche = new Element("coche");
            marca = new Element("marca");
            precio = new Element("precio");

            //Crear jerarquia
            concesionario.addContent(coches);
            coches.addContent(coche);
            
            marca.setText("AUDI");
            precio.setText("30000");
            coche.setAttribute("matricula", "1111AAA");
            
            coche.addContent(precio);
            coche.addContent(marca);

            marca.setText("SEAT");
            precio.setText("10000");
            coche.setAttribute("matricula", "2222BBB");
            
            marca.setText("BMW");
            precio.setText("20000");
            coche.setAttribute("matricula", "3333CCC");
            
            marca.setText("TOYOTA");
            precio.setText("10000");
            coche.setAttribute("matricula", "4444DDD");
            
            xml.setFormat(Format.getPrettyFormat());
            xml.output(doc, new FileWriter("t3\\src\\main\\java\\me\\julen\\concesionario2\\concesionario2.xml"));

        } catch (JDOMException ex) {
            System.out.println("Fichero XML no valido");
            ex.printStackTrace();
        } catch (IOException e) {
            System.out.println("Fichero no valido");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}