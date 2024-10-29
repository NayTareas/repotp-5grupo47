package ar.edu.unju.escmi.tp5.exceptions;

public class LibroNoDisponibleException extends Exception {

    private static final long serialVersionUID = 1L;

    public LibroNoDisponibleException(String errorMessage) {
        super(errorMessage);
    }
}

