package me.julen.ejFrutas;

public class Frutas {
    String id, nombre, temporada, precio;
    
    public Frutas() {}
    public Frutas(String id, String nombre, String temporada, String precio) {
        this.id = id;
        this.nombre = nombre;
        this.temporada = temporada;
        this.precio = precio;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return id + ", " + nombre + ", " + precio + ", " + temporada + "\n";
    }
    public String getTemporada() {
        return temporada;
    }
    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }
    public String getPrecio() {
        return precio;
    }
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    
}
