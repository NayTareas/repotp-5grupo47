package ar.edu.unju.escmi.tp5.dominio;

public class Bibliotecario extends Usuario {

    public Bibliotecario(String nombre) {
        super(nombre);
    }

    @Override
    public String toString() {
        return "Bibliotecario: " + nombre;
    }
}