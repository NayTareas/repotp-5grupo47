package ar.edu.unju.escmi.tp5.collections;

import ar.edu.unju.escmi.tp5.dominio.Libro;
import ar.edu.unju.escmi.tp5.exceptions.LibroNoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class CollectionLibro {
    public static List<Libro> libros = new ArrayList<>();

    // agregar un libro
    public static void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    // obtener un libro por título
    public static Libro obtenerLibros(String titulo) throws LibroNoEncontradoException {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
            
        }
        throw new LibroNoEncontradoException("Libro no encontrado: " + titulo);
    }
    
    public static List<Libro> obtenerTodosLosLibros() {
        return libros;
    }
}
