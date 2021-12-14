package me.julen.concesionario;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class Main {
    private File archivo = new File("t3\\src\\main\\java\\me\\julen\\concesionario\\concesionario.xml");
    private Document documento;
    private Element nodoRaiz;
    SAXBuilder constructorSAX = new SAXBuilder();
    

    public Main() {
        try {
            documento = (Document)constructorSAX.build(archivo);
        } catch (JDOMException ex) {
            System.out.println("Fichero XML no valido");
            ex.printStackTrace();
        } catch (IOException e) {
            System.out.println("Fichero no valido");
            e.printStackTrace();
        }
        nodoRaiz = documento.getRootElement().getChild("coches");

        List listaAplicaciones = nodoRaiz.getChildren("coche");
        for (int i = 0; i < listaAplicaciones.size(); i++) {
            Element nodo = (Element)listaAplicaciones.get(i);
            System.out.println("Con matricula: " + nodo.getAttributeValue("matricula"));
            System.out.println("Marca del vehiculo: " + nodo.getChild("marca").getValue());
            System.out.println("Precio del vehiculo: " + nodo.getChild("precio").getValue());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}