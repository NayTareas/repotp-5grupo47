package ar.edu.unju.escmi.tp5.collections;

import ar.edu.unju.escmi.tp5.dominio.Usuario;
import ar.edu.unju.escmi.tp5.exceptions.UsuarioNoRegistradoException;

import java.util.ArrayList;
import java.util.List;

public class CollectionUsuario {
    public static List<Usuario> usuarios = new ArrayList<>();

    // agregar un usuario
    public static void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // obtener un usuario por su nombre
    public static Usuario obtenerUsuario(String nombre) throws UsuarioNoRegistradoException {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equalsIgnoreCase(nombre)) {
                return usuario;
            }
        }
        throw new UsuarioNoRegistradoException("Usuario no registrado: " +nombre);
    }
    
}