package ar.edu.unju.escmi.tp5.main;
//c

import ar.edu.unju.escmi.tp5.collections.CollectionLibro;
import ar.edu.unju.escmi.tp5.collections.CollectionUsuario;
import ar.edu.unju.escmi.tp5.collections.CollectionPrestamo;
import ar.edu.unju.escmi.tp5.dominio.Libro;
import ar.edu.unju.escmi.tp5.dominio.Alumno;
import ar.edu.unju.escmi.tp5.dominio.Bibliotecario;
import ar.edu.unju.escmi.tp5.dominio.Usuario;
import ar.edu.unju.escmi.tp5.dominio.Prestamo;
import ar.edu.unju.escmi.tp5.exceptions.*;
import ar.edu.unju.escmi.tp5.utils.FechaUtil;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Menu de opciones:");
            System.out.println("1 - Registrar libro");
            System.out.println("2 - Registrar usuario");
            System.out.println("3 - Préstamo de libro");
            System.out.println("4 - Devolución de libro");
            System.out.println("5 - Listar libros");
            System.out.println("6 - Listar préstamos"); // Nueva opción
            System.out.println("7 - Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarLibro(scanner);
                    break;
                case 2:
                    registrarUsuario(scanner);
                    break;
                case 3:
                    realizarPrestamo(scanner);
                    break;
                case 4:
                    devolverLibro(scanner);
                    break;
                case 5:
                    listarLibros();
                    break;
                
                case 6:
                    listarPrestamos(); // Llamar al nuevo método
                    break;
                case 7:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
                    break;
            }
        }
    }

    private static void registrarLibro(Scanner scanner) {
        System.out.println("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.println("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();
       
        // Crear y agregar libro a la colección
        Libro libro = new Libro(titulo, autor);
        CollectionLibro.agregarLibro(libro); // Verificar si este método existe
        System.out.println("Libro registrado correctamente.");
    }

    private static void registrarUsuario(Scanner scanner) {
        System.out.println("Ingrese el nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.println("Es bibliotecario (si/no): ");
        String tipoUsuario = scanner.nextLine();

        Usuario usuario;
        if (tipoUsuario.equalsIgnoreCase("si")) {
            usuario = new Bibliotecario(nombre);
        } else {
            usuario = new Alumno(nombre);
        }

        CollectionUsuario.agregarUsuario(usuario); // Verificar si este método existe
        System.out.println("Usuario registrado correctamente.");
    }

    private static void realizarPrestamo(Scanner scanner) {
        System.out.println("Ingrese el nombre del usuario: ");
        String nombreUsuario = scanner.nextLine();

        try {
            Usuario usuario = CollectionUsuario.obtenerUsuario(nombreUsuario);
            System.out.println("Ingrese el título del libro: ");
            String tituloLibro = scanner.nextLine();
            Libro libro = CollectionLibro.obtenerLibros(tituloLibro);

            if (!libro.isDisponible()) {
                throw new LibroNoDisponibleException("El libro no está disponible para préstamo.");
            }

            // Registrar préstamo
            Prestamo prestamo = new Prestamo(usuario, libro);
            CollectionPrestamo.agregarPrestamo(prestamo);
            libro.setDisponible(false);
            System.out.println("Préstamo registrado correctamente.");
        } catch (UsuarioNoRegistradoException | LibroNoEncontradoException | LibroNoDisponibleException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void devolverLibro(Scanner scanner) {
        System.out.println("Ingrese el título del libro a devolver: ");
        String tituloLibro = scanner.nextLine();

        try {
            Libro libro = CollectionLibro.obtenerLibros(tituloLibro);
            if (libro.isDisponible()) {
                System.out.println("El libro ya está disponible en la biblioteca.");
                return;
            }

            System.out.println("Ingrese la fecha de devolución (dd/MM/yyyy): ");
            String fechaDevolucionStr = scanner.nextLine();
            libro.setDisponible(true);

            System.out.println("Devolución registrada correctamente.");
        } catch (LibroNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void listarLibros() {
        System.out.println("Lista de libros disponibles:");
        for (Libro libro : CollectionLibro.obtenerTodosLosLibros()) {
            System.out.println(libro);
        }

    }
    // Método para listar préstamos
    private static void listarPrestamos() {
        System.out.println("Lista de préstamos realizados:");
        for (Prestamo prestamo : CollectionPrestamo.obtenerPrestamos()) {
            System.out.println(prestamo);
        }
    }
}