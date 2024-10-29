package ar.edu.unju.escmi.tp5.exceptions;

public class LibroNoEncontradoException extends Exception {
    
    private static final long serialVersionUID = 1L;

    public LibroNoEncontradoException(String errorMessage) {
        super(errorMessage);
    }
}


