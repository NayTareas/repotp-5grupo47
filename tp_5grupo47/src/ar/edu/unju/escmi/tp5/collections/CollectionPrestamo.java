package ar.edu.unju.escmi.tp5.collections;

import ar.edu.unju.escmi.tp5.dominio.Prestamo;

import java.util.ArrayList;
import java.util.List;

public class CollectionPrestamo {
    public static List<Prestamo> prestamos = new ArrayList<>();

    // agregar un préstamo
    public static void agregarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }
    // obtener la lista de préstamos
    public static List<Prestamo> obtenerPrestamos() {
        return prestamos;
    }
}
