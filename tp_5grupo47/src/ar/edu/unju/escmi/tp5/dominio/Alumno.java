package ar.edu.unju.escmi.tp5.dominio;

public class Alumno extends Usuario {

    public Alumno(String nombre) {
        super(nombre);
    }

    @Override
    public String toString() {
        return "Alumno: " + nombre;
    }
}
