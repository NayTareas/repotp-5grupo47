package ar.edu.unju.escmi.tp5.exceptions;

public class UsuarioNoRegistradoException extends Exception {
    
    private static final long serialVersionUID = 1L;

    public UsuarioNoRegistradoException(String errorMessage) {
        super(errorMessage);
    }
}
